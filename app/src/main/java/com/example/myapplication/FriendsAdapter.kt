package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapplication.databinding.ItemFriendsBinding

class FriendsAdapter(
    private val list: List<AllFriends>,
    private val glide: RequestManager,
    private val onClick: (AllFriends) -> Unit
): RecyclerView.Adapter<FriendHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
        return FriendHolder(
            binding = ItemFriendsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            ),
            glide = glide,
            onClick = onClick,
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FriendHolder, position: Int) {
        holder.onBind(list[position])
    }
}