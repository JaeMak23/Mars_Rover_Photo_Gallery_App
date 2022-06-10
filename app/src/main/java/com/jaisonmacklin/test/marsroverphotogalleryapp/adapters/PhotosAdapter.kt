package com.jaisonmacklin.test.marsroverphotogalleryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.jaisonmacklin.test.marsroverphotogalleryapp.databinding.RecyclerPhotoHomeBinding
import com.jaisonmacklin.test.marsroverphotogalleryapp.models.Photo
import com.jaisonmacklin.test.marsroverphotogalleryapp.utils.Helper

class PhotosAdapter(var photos: List<Photo>) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    private lateinit var binding: RecyclerPhotoHomeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        binding =
            RecyclerPhotoHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class PhotosViewHolder(private val binding: RecyclerPhotoHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {

            val url = Helper.httpToHttps(photo.imgSrc)

            Glide.with(binding.root.context)
                .load(url)
                .apply(RequestOptions().fitCenter())
                .into(binding.photoImageView)

            binding.photoIdTextView.text = photo.id.toString()
            binding.cameraNameTextView.text = photo.camera.name
            binding.roverNameTextView.text = photo.rover.name

            binding.cameraImageView.setOnClickListener {
                Toast.makeText(binding.root.context, "Clicked on CAMERA", Toast.LENGTH_LONG).show()
            }

            binding.roverImageView.setOnClickListener {
                Toast.makeText(binding.root.context, "Clicked on ROVER", Toast.LENGTH_LONG).show()
            }

            binding.photoImageView.setOnClickListener {
                Toast.makeText(binding.root.context, "Clicked on Photo", Toast.LENGTH_LONG).show()
            }
        }
    }
}

@GlideModule
class AppNameGlideModule : AppGlideModule() {

}