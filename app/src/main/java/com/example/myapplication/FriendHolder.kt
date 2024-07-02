package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemFriendsBinding

class FriendHolder(private val binding: ItemFriendsBinding,
                   private val glide: RequestManager,
                   private val onClick: (AllFriends) -> Unit,
    ):
    ViewHolder(binding.root) {
        fun onBind(sets: AllFriends) {
            binding.run {
                set11.text = sets.name
                set1.text = sets.city
                glide
                    .load(sets.url)
                    .into(image)
                root.setOnClickListener{
                    onClick.invoke(sets)
                }
            }
        }
}