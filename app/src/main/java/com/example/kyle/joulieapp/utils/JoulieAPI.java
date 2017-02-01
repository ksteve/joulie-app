package com.example.kyle.joulieapp.utils;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.kyle.joulieapp.helpers.URLHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kyle on 2017-01-20.
 */
public class JoulieAPI {

    private ResponseListener mListener;

    private static JoulieAPI ourInstance = new JoulieAPI();

    public static JoulieAPI getInstance() {
        return ourInstance;
    }

    private JoulieAPI() {
    }

    public void restRequest(final RequestQueue queue, final String idToken){
        try {

            final String url = "http://192.168.2.14:3500/devices/add"; //URLHelper.buildUrl();
            final JSONObject jsonBody = new JSONObject();
            jsonBody.put("name", "test");


            JsonObjectRequest jaRequest = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Display the first 500 characters of the response string.
//                            try {

                                mListener.onResSuccess(response.toString());

//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String message = null;
                    if (error instanceof NetworkError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (error instanceof ServerError) {
                        message = "The server could not be found. Please try again after some time!!";
                    } else if (error instanceof AuthFailureError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (error instanceof ParseError) {
                        message = "Parsing error! Please try again after some time!!";
                    } else if (error instanceof NoConnectionError) {
                        message = "Cannot connect to Internet...Please check your connection!";
                    } else if (error instanceof TimeoutError) {
                        message = "Connection TimeOut! Please check your internet connection.";
                    }

                    mListener.onResError(message);
                    //listener.onError(message);
                   // Log.v("", "error");
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    // Basic Authentication
                    //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);

                    headers.put("Authorization", "Bearer " + idToken);
                    return headers;
                }
            };
            // Add the request to the RequestQueue.
            queue.add(jaRequest);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void registerListener(ResponseListener listener){
        mListener = listener;
    }

    public interface ResponseListener {
        void onResSuccess(String response);
        void onResError(String errorMessage);
    }

}
