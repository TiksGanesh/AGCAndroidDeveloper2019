package com.example.volley.core;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.volley.model.ContactsItem;
import com.google.gson.Gson;

import java.util.List;

public class RequestContract {

    private final static String LOG_TAG = RequestContract.class.getSimpleName();

    private static RequestContract requestContract;

    private VolleyApplication instance;

    private RequestContract(){
        // Private Constructor
        instance = VolleyApplication.getInstance();
    }

    public static synchronized RequestContract getRequestContract(){
        if (null == requestContract){
            requestContract = new RequestContract();
        }
        return requestContract;
    }

    /**
     *  GET
     *  StringRequest from Volley
     *  URL: https://api.androidhive.info/contacts/
     *
     */
    public void getContactsFromServer(String activityTag, final ResponseInterface.OnContactResponseListener listener){

        StringRequest contactRequest = new StringRequest(
                Request.Method.GET,
                "https://api.androidhive.info/contacts/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e(LOG_TAG, response);
                        Gson gson = new Gson();
                        com.example.volley.model.Response serverResponse = gson.fromJson(response, com.example.volley.model.Response.class);
                        List<ContactsItem> contactsItemList = serverResponse.getContacts();
                        listener.onContactResponse(true, contactsItemList, null);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(LOG_TAG, "Error: "+ error.getMessage());
                        listener.onContactResponse(false,null,error);
                    }
                }
        );

        // Add Request to Queue
        instance.addRequestToRequestQueue(contactRequest, activityTag);
    }
}
