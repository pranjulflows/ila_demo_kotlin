package com.macamps.demotest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.macamps.demotest.databinding.ListItemBinding
import com.macamps.demotest.model.DataModel

class RecyclerListAdapter(var list: ArrayList<DataModel>) :
    RecyclerView.Adapter<RecyclerListAdapter.RecyclerHolder>() {
    inner class RecyclerHolder(private var binding: ListItemBinding) : ViewHolder(binding.root) {
        fun bind(data: DataModel) {
            binding.apply {
                title.text = data.labelText
                description.text = data.description
                image.setImageResource(data.imageUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder =
        RecyclerHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = list.size

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<DataModel>) {
        // below line is to add our filtered
        list = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(list[position])
    }
}