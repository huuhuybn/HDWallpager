package com.subptz.ken.hdwallpager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.subptz.ken.hdwallpager.ACDetail;
import com.subptz.ken.hdwallpager.R;
import com.subptz.ken.hdwallpager.model.latest.Hdwallpaper;

import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.IteamViewHoder> {
    private List<Hdwallpaper> hdwallpapers;
    Context context;


    public LatestAdapter(List<Hdwallpaper> hdwallpapers, Context context) {
        this.hdwallpapers = hdwallpapers;
        this.context = context;

    }


    @NonNull
    @Override
    public IteamViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_latest, parent, false);

        return new IteamViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IteamViewHoder holder, int position) {
        final Hdwallpaper hdwallpaper = hdwallpapers.get(position);
        Picasso.with(context).load(hdwallpaper.getWallpaperImageThumb())
                .placeholder(R.drawable.error_images)
                .placeholder(R.drawable.error)
                .into(holder.imgLatest);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ACDetail.class);
                intent.putExtra("img", hdwallpaper.getWallpaperImageThumb());
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return hdwallpapers.size();
    }

    public class IteamViewHoder extends RecyclerView.ViewHolder {
        private ImageView imgLatest;


        public IteamViewHoder(View itemView) {
            super(itemView);
            imgLatest = (ImageView) itemView.findViewById(R.id.imgLatest);
        }
    }
}
