package com.cv.cv2p3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cv.cv2p3.databinding.ExpItemBinding

class CompanyAdapter(
    val onItemClicked: (Company) -> Unit,
) : RecyclerView.Adapter<CompanyAdapter.MyViewHolder>() {

    private var list: MutableList<Company> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            ExpItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class MyViewHolder(private val binding: ExpItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Company) {
            binding.img.setImageResource(item.image)
            binding.startDate.text = item.startDate
            binding.endDate.text = item.endDate
            binding.compName.text = item.name
            binding.compAdress.text = item.address
            binding.description.text = item.description
            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}