package com.example.simplevolleyfm;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Controller extends Application {
    public static final String TAG = Controller.class.getSimpleName();
    private RequestQueue requestQueue;
    private static Controller controller;

    @Override
    public void onCreate() {
        super.onCreate();
        controller = this;
    }

    public static synchronized Controller getInstance() {
        return controller;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(this);

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
}

