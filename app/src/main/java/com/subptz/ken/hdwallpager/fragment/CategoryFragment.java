package com.subptz.ken.hdwallpager.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.subptz.ken.hdwallpager.adapter.CategoryAdapter;
import com.subptz.ken.hdwallpager.R;
import com.subptz.ken.hdwallpager.common.MFragment;
import com.subptz.ken.hdwallpager.model.latest.category.Categories;
import com.subptz.ken.hdwallpager.model.latest.category.HDWALLPAPER;
import com.subptz.ken.hdwallpager.retrofit.Apilnterface;
import com.subptz.ken.hdwallpager.retrofit.RetroClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends MFragment {

    private List<HDWALLPAPER> hdwallpaperList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_category, container, false);
        pDialog = new ProgressDialog(getActivity());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        Apilnterface apilnterface = RetroClient.getApiService();
        retrofit2.Call<Categories> call = apilnterface.getCategories();
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                pDialog.dismiss();
                if (response.isSuccessful()){
                    hdwallpaperList = response.body().getHDWALLPAPER();
                    recyclerView = view.findViewById(R.id.recycler_category);
                    categoryAdapter = new CategoryAdapter(hdwallpaperList,getActivity());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(categoryAdapter);

                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });

        return view;
    }

}
