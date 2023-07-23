package com.example.gallerytask.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallerytask.data.models.PhotoDbEntity
import com.example.gallerytask.databinding.ItemPhotoBinding

class PhotoAdapter(val context: Context) :
    ListAdapter<PhotoDbEntity, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PhotoAdapter.PhotoViewHolder {
        return PhotoViewHolder(
            ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(detail: PhotoDbEntity) {
            val imageUrl = "https://cdn.pixabay.com/photo/2023/04/10/06/32/tulip-7912886_1280.jpg"

            Glide.with(context).load(imageUrl).into(binding.itemImage)

            binding.itemCreationTime.text = detail.creationTime.toString()
        }
    }


    class PhotoDiffCallback : DiffUtil.ItemCallback<PhotoDbEntity>() {
        override fun areItemsTheSame(oldItem: PhotoDbEntity, newItem: PhotoDbEntity): Boolean {
            return oldItem.id == newItem.id // Assuming you have an "id" property in PhotoDbEntity
        }

        override fun areContentsTheSame(oldItem: PhotoDbEntity, newItem: PhotoDbEntity): Boolean {
            return oldItem == newItem
        }
    }
}
