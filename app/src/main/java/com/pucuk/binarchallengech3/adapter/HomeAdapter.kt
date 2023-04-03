package com.pucuk.binarchallengech3.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.pucuk.binarchallengech3.fragment.DetailFragment
import com.pucuk.binarchallengech3.R
import com.pucuk.binarchallengech3.databinding.ItemListBinding
import com.pucuk.binarchallengech3.databinding.ItemListBinding.inflate


class HomeAdapter(private val list: List<Char>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Char) {
            binding.btn.text = list.toString()

            binding.btn.setOnClickListener {
                val appCompatActivity = it.context as AppCompatActivity
                val fragmentManager = appCompatActivity.supportFragmentManager
                val detailFragment = DetailFragment()
                val fragment =
                    fragmentManager.findFragmentByTag(DetailFragment::class.java.simpleName)

                if (fragment !is DetailFragment) {
                    val bundle = Bundle()
                    bundle.putString("EXTRA_WORD", list.toString())
                    detailFragment.arguments = bundle

                    fragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.frameContainer,
                            detailFragment,
                            DetailFragment::class.java.simpleName
                        )
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}