package com.subptz.ken.hdwallpager.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.subptz.ken.hdwallpager.ACDetail;
import com.subptz.ken.hdwallpager.R;
import com.subptz.ken.hdwallpager.model.latest.category.HDWALLPAPER;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHoder> {
    private List<HDWALLPAPER> hdwallpaperList;
    private Context context;

    public CategoryAdapter(List<HDWALLPAPER> hdwallpaperList, Context context) {
        this.hdwallpaperList = hdwallpaperList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        final HDWALLPAPER hdwallpaper = hdwallpaperList.get(position);
        holder.name.setText(hdwallpaper.getCategoryName());
        Picasso.with(context).load(hdwallpaper.getCategoryImageThumb())
                .placeholder(R.drawable.error_images)
                .placeholder(R.drawable.error)
                .into(holder.imgLatest);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ACDetail.class);
                intent.putExtra("img", hdwallpaper.getCategoryImageThumb());
                context.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return hdwallpaperList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {


        final private ImageView imgLatest;
        final private TextView name;


        public ViewHoder(View itemView) {


            super(itemView);
            imgLatest = itemView.findViewById(R.id.imgCategory);
            name = itemView.findViewById(R.id.name);
        }
    }
}
