package com.example.mytest.fragment

import android.os.Bundle
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.mytest.R
import com.example.mytest.base.BaseFragment
import com.example.mytest.databinding.FragmentHomeBinding
import com.example.mytest.model.Model


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var list: List<Model>
    private lateinit var adapter: HomeAdapter
    override fun setubIU() {
        fun createDetailAction(model: Model): NavDirections {
            val bundle = Bundle()
            bundle.putParcelable("Item", model)

            return object : NavDirections {
                override val actionId: Int
                    get() = R.id.action_homeFragment_to_detailFragment
                override val arguments: Bundle
                    get() = bundle

            }
        }
        adapter = HomeAdapter(list, requireContext()) { position ->
            val selectedItem = list[position]
            val action = createDetailAction(selectedItem)
            findNavController().navigate(action)

        }
        binding.rvHome.adapter = adapter
        list = listOf(
            Model(
                "https://aliendesign.com.ua/wp-content/uploads/2021/02/559269284d15e_ToyotaLogo-1024x895.jpg",
                "toyota",
                2020
            ),
            Model(
                "https://aliendesign.com.ua/wp-content/uploads/2021/02/559269284d15e_ToyotaLogo-1024x895.jpg",
                "toyota",
                2020
            ),
            Model(
                "https://aliendesign.com.ua/wp-content/uploads/2021/02/559269284d15e_ToyotaLogo-1024x895.jpg",
                "toyota",
                2020
            ),
            Model(
                "https://aliendesign.com.ua/wp-content/uploads/2021/02/559269284d15e_ToyotaLogo-1024x895.jpg",
                "toyota",
                2020
            )
        )
    }
}