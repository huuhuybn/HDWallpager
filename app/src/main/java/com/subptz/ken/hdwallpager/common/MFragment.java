package com.subptz.ken.hdwallpager.common;

import android.support.v4.app.Fragment;

public class MFragment extends Fragment {


    public void showProgress() {
        ACBase acBase = (ACBase) getActivity();
        acBase.showProgressBar();

    }

    public void hideProgressBar() {
        ACBase acBase = (ACBase) getActivity();
        acBase.hideProgressBar();
    }
}
