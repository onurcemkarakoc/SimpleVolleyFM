package com.example.simplevolleyfm.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplevolleyfm.Models.PackagesModel
import com.example.simplevolleyfm.R

class PackagesAdapter(private val list: ArrayList<PackagesModel>) :
    RecyclerView.Adapter<PackagesAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_name: TextView = itemView.findViewById(R.id.item_name)
        val item_desc: TextView = itemView.findViewById(R.id.item_desc)
        val item_tariff: TextView = itemView.findViewById(R.id.item_tariff)
        val item_price: TextView = itemView.findViewById(R.id.item_price)
        val item_didUseBefore: TextView = itemView.findViewById(R.id.item_didUseBefore)
        val item_benefits: TextView = itemView.findViewById(R.id.item_benefits)

        fun bindItems(item: PackagesModel) {
            item_name.text = "Paket ismi : ${item.name}"
            item_desc.text = "Paket Açıklaması : ${item.desc}"
            item_benefits.text = "Kullanım İçeriği : ${item.benefits}"
            item_didUseBefore.text = "Daha önce kullanıldı mı ? : ${if (item.didUseBefore) "Evet" else "Hayır"}"
            item_price.text = "Ücret ${item.price} TL"
            item_tariff.text = "Paket İçeriği : ${item.tariff}"

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
}