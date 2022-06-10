package com.jaisonmacklin.test.marsroverphotogalleryapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaisonmacklin.test.marsroverphotogalleryapp.databinding.FragmentCameraInfoBinding


class CameraInfoFragment : Fragment() {
    private lateinit var bindding: FragmentCameraInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentCameraInfoBinding.inflate(layoutInflater)
        return bindding.root
    }
}