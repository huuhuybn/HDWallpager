package com.subptz.ken.hdwallpager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.subptz.ken.hdwallpager.common.ACBase;

public class ACDetail extends ACBase {
    private String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detaill);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView imgDisplay = (ImageView) findViewById(R.id.imgDisplay);

        Bundle b = new Bundle();
        b = getIntent().getExtras();
        image = b.getString("img");
        Picasso.with(this).load(image)
                .placeholder(R.drawable.error_images)
                .placeholder(R.drawable.error)
                .into(imgDisplay);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
