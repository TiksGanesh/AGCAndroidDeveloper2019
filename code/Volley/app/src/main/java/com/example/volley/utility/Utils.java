package com.example.volley.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Utils class will have all utility function
 */
public class Utils {

    /**
     * TO check internet is present
     * @param context Application Context
     * @return true if connected else false
     */
    public static boolean isInternetConnectivity(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (null == networkInfo){
            return false;
        }

        return networkInfo.isConnected();
    }
}
