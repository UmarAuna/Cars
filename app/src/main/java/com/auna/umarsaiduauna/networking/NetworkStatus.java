package com.auna.umarsaiduauna.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.spec.ECField;
import java.util.Objects;


public class NetworkStatus {

    public boolean isOnline(Context contextValue) {
        try{
            ConnectivityManager cm = (ConnectivityManager) contextValue.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = Objects.requireNonNull(cm).getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }

        }catch (Exception e){

        }
        return false;
    }
}
