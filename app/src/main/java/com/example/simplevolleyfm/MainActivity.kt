package com.example.simplevolleyfm

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplevolleyfm.Adapter.PackagesAdapter
import com.example.simplevolleyfm.Models.PackagesModel
import com.example.simplevolleyfm.Requests.PackagesRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val packagesModelList: ArrayList<PackagesModel> by lazy { ArrayList<PackagesModel>() }

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url = "http://www.harunkor.com/packageList.json"
        val params = HashMap<String, String>()
        val packagesRequest = PackagesRequest(params, url)

        packagesRequest.req {
            val packages = it.getJSONArray("packages")
            for (a in 0 until packages.length()) {
                val obj = packages.get(a) as JSONObject
                packagesModelList.add(
                    PackagesModel(
                        obj.getString("name"),
                        obj.getString("desc"),
                        obj.getString("subscriptionType"),
                        obj.getBoolean("didUseBefore"),
                        obj.get("benefits"),
                        obj.getDouble("price"),
                        obj.get("tariff"),
                        obj.getLong("availableUntil")
                    )
                )
            }

            recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recyclerview.adapter=PackagesAdapter(packagesModelList)

        }
    }
}
