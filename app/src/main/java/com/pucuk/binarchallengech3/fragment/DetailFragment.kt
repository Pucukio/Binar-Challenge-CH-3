package com.pucuk.binarchallengech3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pucuk.binarchallengech3.R
import com.pucuk.binarchallengech3.adapter.DetailAdapter
import com.pucuk.binarchallengech3.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = activity as AppCompatActivity
        title.supportActionBar?.title = "Words Start With ${arguments?.getString("EXTRA_WORD")}"
        val filter: List<String> =
            context?.resources?.getStringArray(R.array.data_word)?.toList()!!
                .filter { it.startsWith(arguments?.getString("EXTRA_WORD")!!, true) }
        binding.apply {
            rvDetail.adapter = DetailAdapter(filter)
            rvDetail.layoutManager = LinearLayoutManager(requireContext())
            rvDetail.setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}