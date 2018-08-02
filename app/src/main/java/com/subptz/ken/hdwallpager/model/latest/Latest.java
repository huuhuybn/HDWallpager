
package com.subptz.ken.hdwallpager.model.latest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Latest {
    private Integer count;
    @SerializedName("HD_WALLPAPER")
    @Expose
    private List<Hdwallpaper> hDWALLPAPER = null;

    public List<Hdwallpaper> getHDWALLPAPER() {
        return hDWALLPAPER;
    }

    public void setHDWALLPAPER(List<Hdwallpaper> hDWALLPAPER) {
        this.hDWALLPAPER = hDWALLPAPER;
    }

}
