package com.example.testt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testt.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var list: MutableList<Company> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateList(list: MutableList<Company>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Company) {
            binding.img.setImageResource(item.image)
            binding.cn.text = item.name
            binding.ca.text = item.adress
            binding.startdate.text = item.sdate
            binding.enddate.text = item.edate
            binding.longtext.text = item.discription
        }
    }
}