package com.example.jefferson.pvolley;

import android.app.Application;
import android.app.DownloadManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jefferson on 7/04/2016.
 */
public class Pvolley extends Application{
    private static final int TIME_OUT=10000;
    private static final int NUM_RETRY=3;
    private static final String TAG =Pvolley.class.getName();
    private RequestQueue requestQueue;
    private static Pvolley instance;

    public  static synchronized  Pvolley getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        requestQueue= Volley.newRequestQueue(getApplicationContext());

    }

    public RequestQueue getRequestQueue()
    {
        return requestQueue;
    }
    public <I> void add(Request<I> request)
    {
        request.setTag(TAG);
        request.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT, NUM_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(request);
    }

    public void cancel()
    {
        requestQueue.cancelAll(TAG);
    }
}
