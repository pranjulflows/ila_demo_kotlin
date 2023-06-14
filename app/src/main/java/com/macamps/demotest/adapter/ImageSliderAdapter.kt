package com.macamps.demotest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.macamps.demotest.databinding.ImageSliderItemBinding

class ImageSliderAdapter(private val images: List<Int>) :
    RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ImageSliderItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(image = images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ViewHolder(private var binding: ImageSliderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Int) {
            binding.ivImage.setImageResource(image)
        }
    }
}