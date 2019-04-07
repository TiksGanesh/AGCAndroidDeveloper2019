package com.example.volley.core;

import com.android.volley.VolleyError;
import com.example.volley.model.ContactsItem;

import java.util.List;

/**
 * Response Interface
 */
public interface ResponseInterface {


    interface OnContactResponseListener {
        void onContactResponse(boolean isSuccess, List<ContactsItem> contactList, VolleyError error);
    }
}
