package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.FragmentFriendsBinding

class FriendsFragment: Fragment(R.layout.fragment_friends) {

    private var binding: FragmentFriendsBinding? = null
    private var adapter: FriendsAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFriendsBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = FriendsAdapter(FriendsRepository.sets,
                glide = Glide.with(this@FriendsFragment),
                onClick = {
                    val bundle = Bundle()
                    bundle.putString("ARG", "${it.name} \nfrom ${it.city}")
                    bundle.putString("ARG1","${it.dopInfo}")
                    bundle.putString("ARG2","${it.url}")
                    findNavController().navigate(
                        R.id.action_friendsFragment_to_screenFragment,
                        args = bundle,
                        )
                }
            )
            allSets.adapter = adapter
            allSets.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}