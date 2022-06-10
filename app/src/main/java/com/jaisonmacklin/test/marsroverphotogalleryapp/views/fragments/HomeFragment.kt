package com.jaisonmacklin.test.marsroverphotogalleryapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaisonmacklin.test.marsroverphotogalleryapp.adapters.PhotosAdapter
import com.jaisonmacklin.test.marsroverphotogalleryapp.databinding.FragmentHomeBinding
import com.jaisonmacklin.test.marsroverphotogalleryapp.models.Photo
import com.jaisonmacklin.test.marsroverphotogalleryapp.models.PhotoResponse
import com.jaisonmacklin.test.marsroverphotogalleryapp.viewModels.PhotosViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[PhotosViewModel::class.java]
        GlobalScope.launch { viewModel.getPhotosFromApi() }

        viewModel.getPhotos().observe(viewLifecycleOwner, Observer<PhotoResponse?> {
            it?.let { value ->
                binding.recyclerView.adapter = PhotosAdapter(value.photos)
                binding.recyclerView.layoutManager = LinearLayoutManager(context)
            }
        })
    }
}
