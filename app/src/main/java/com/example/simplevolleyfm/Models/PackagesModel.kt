package com.example.simplevolleyfm.Models

import org.json.JSONArray

data class PackagesModel (val name:String,
                          val desc:String,
                          val subscriptionType:String,
                          val didUseBefore:Boolean,
                          val benefits:Any,
                          val price:Double,
                          val tariff:Any,
                          val availableUntil:Long)