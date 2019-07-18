package com.example.simplevolleyfm.Requests

import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.simplevolleyfm.Controller
import org.json.JSONObject

class PackagesRequest(val params: HashMap<String, String>, val url: String)  {


    fun req(onResponse:(JSONObject)->Unit) {
        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url,
            JSONObject(params as Map<String, String>),
            Response.Listener { response ->
                onResponse(response)
            }, Response.ErrorListener {
                // Error in request
                println("Volley error: $it")
            })

        jsonObjectRequest.retryPolicy =
            DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )
        Controller.getInstance().addToRequestQueue(jsonObjectRequest)


    }
}