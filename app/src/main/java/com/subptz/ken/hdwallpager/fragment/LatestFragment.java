package com.subptz.ken.hdwallpager.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.subptz.ken.hdwallpager.adapter.LatestAdapter;
import com.subptz.ken.hdwallpager.R;
import com.subptz.ken.hdwallpager.common.MFragment;
import com.subptz.ken.hdwallpager.model.latest.Hdwallpaper;
import com.subptz.ken.hdwallpager.model.latest.Latest;
import com.subptz.ken.hdwallpager.retrofit.Apilnterface;
import com.subptz.ken.hdwallpager.retrofit.RetroClient;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends MFragment {

    private List<Hdwallpaper> hdwallpaperList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private LatestAdapter latestAdapter;

    public LatestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_latest, container, false);
        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        Apilnterface apilnterface = RetroClient.getApiService();
        retrofit2.Call<Latest> call = apilnterface.getLatest();
        call.enqueue(new Callback<Latest>() {
            @Override
            public void onResponse(retrofit2.Call<Latest> call, Response<Latest> response) {
                pDialog.dismiss();
                if (response.isSuccessful()) {
                    hdwallpaperList = response.body().getHDWALLPAPER();
                    recyclerView = view.findViewById(R.id.recycler_latest);
                    latestAdapter = new LatestAdapter(hdwallpaperList, getActivity());
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(latestAdapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Latest> call, Throwable t) {

            }
        });
        return view;
    }
}
