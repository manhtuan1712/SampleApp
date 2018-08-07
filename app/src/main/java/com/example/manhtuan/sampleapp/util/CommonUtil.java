package com.example.manhtuan.sampleapp.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class CommonUtil {

    /**
     * Method help to replace Fragment to Activity.
     * @param fragmentManager
     * @param fragment
     * @param frameId
     * @param tag
     */
    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId, String tag) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commit();
    }
}
