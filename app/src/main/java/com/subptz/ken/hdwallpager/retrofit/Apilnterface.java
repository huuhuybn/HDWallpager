package com.subptz.ken.hdwallpager.retrofit;


import com.subptz.ken.hdwallpager.model.latest.category.Categories;
import com.subptz.ken.hdwallpager.model.latest.Latest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apilnterface {
 @GET("api.php?latest")
    Call<Latest> getLatest();
    @GET("api.php?cat_list")
    Call<Categories> getCategories();

}
