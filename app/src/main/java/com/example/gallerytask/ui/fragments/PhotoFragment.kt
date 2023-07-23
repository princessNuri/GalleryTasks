package com.example.gallerytask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gallerytask.data.models.PhotoDbEntity
import com.example.gallerytask.databinding.FragmentPhotoBinding
import com.example.gallerytask.ui.adapters.PhotoAdapter

class PhotoFragment : Fragment() {
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var binding: FragmentPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupAdapter()
    }

    private fun setupAdapter() {
        photoAdapter = PhotoAdapter(requireContext())

        binding.rvPhotos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhotos.adapter = photoAdapter

        val photoList = listOf<PhotoDbEntity>()
        photoAdapter.submitList(photoList)
    }
}