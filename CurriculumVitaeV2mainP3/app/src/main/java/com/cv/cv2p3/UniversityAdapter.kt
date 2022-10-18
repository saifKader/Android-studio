package com.cv.cv2p3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cv.cv2p3.databinding.UniItemBinding

class UniversityAdapter(
    val onItemClicked: (University) -> Unit,
) : RecyclerView.Adapter<UniversityAdapter.MyViewHolder>() {

    private var list: MutableList<University> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            UniItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateList(list: MutableList<University>) {
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

    inner class MyViewHolder(private val binding: UniItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: University) {
            binding.imageView3.setImageResource(item.image)
            binding.startDate1.text = item.startDate
            binding.endDate1.text = item.endDate
            binding.name1.text = item.name
            binding.location.text = item.location
            binding.root.setOnClickListener {
                onItemClicked(item)
            }
        }
    }
}