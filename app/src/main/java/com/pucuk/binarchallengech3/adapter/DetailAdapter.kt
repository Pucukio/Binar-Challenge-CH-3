package com.pucuk.binarchallengech3.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pucuk.binarchallengech3.databinding.ItemListBinding
import com.pucuk.binarchallengech3.databinding.ItemListBinding.inflate


class DetailAdapter(private val letter: List<String>) :
    RecyclerView.Adapter<DetailAdapter.WordViewHolder>() {

    inner class WordViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: String) {
            binding.btn.text = word

            binding.btn.setOnClickListener {
                val uri = Uri.parse("https://www.google.com/search?q=${word}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) =
        holder.bind(letter[position])

    override fun getItemCount(): Int = letter.size


}