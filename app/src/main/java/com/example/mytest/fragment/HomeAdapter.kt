package com.example.mytest.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mytest.databinding.ItemHomeBinding
import com.example.mytest.model.Model

class HomeAdapter(private val itemList: List<Model>,
                  private val context: Context,
                  private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var list: ArrayList<Model> = arrayListOf()

    fun setList(list: ArrayList<Model>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick.invoke(position)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Model) {
            Glide.with(binding.imgS).load(model.image).into(binding.imgS)
            binding.tvYear.text = model.year.toString()
            binding.tvSapar.text = model.name
        }

    }
}