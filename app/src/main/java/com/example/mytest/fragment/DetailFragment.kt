package com.example.mytest.fragment

import com.bumptech.glide.Glide
import com.example.mytest.base.BaseFragment
import com.example.mytest.databinding.FragmentDetailBinding
import com.example.mytest.model.Model


@Suppress("DEPRECATION")
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    override fun setubIU() {
        val Item = arguments?.getParcelable<Model>("Item")
        Item?.let {
            binding.textView.text = it.name
            binding.textView2.text = it.year.toString()
            Glide.with(requireContext())
                .load(it.image)
                .into(binding.imageView)
        }
    }
}