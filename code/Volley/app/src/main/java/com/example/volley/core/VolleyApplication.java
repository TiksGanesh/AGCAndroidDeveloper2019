package com.example.volley.core;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyApplication extends Application {


    /**
     * Applicaton Instance
     */
    private static VolleyApplication instance;

    /**
     * Request Queue
     */
    private RequestQueue requestQueue;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * Get VolleyApplication Instance
     * @return VolleyApplication
     */
    public static synchronized VolleyApplication getInstance(){
        return instance;
    }

    /**
     * Request Queue
     * @return RequestQueue
     */
    private RequestQueue getRequestQueue(){
        if (null == requestQueue){
            requestQueue = Volley.newRequestQueue(this);
        }

        return requestQueue;
    }


    /**
     * Add Request to Request Queue
     * @param request Volley request
     * @param tag tag
     */
    public void addRequestToRequestQueue(Request request, String tag){

        RequestQueue requestQueue = getRequestQueue();
        request.setTag(tag);
        requestQueue.add(request);
    }

    /**
     * Cancel all request with give tag
     * @param tag String Activity Name
     */
    public void cancelRequestFromRequestQueue(String tag){
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.cancelAll(tag);
    }

}
