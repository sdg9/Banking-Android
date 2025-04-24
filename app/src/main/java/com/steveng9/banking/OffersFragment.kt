package com.steveng9.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentOffersBinding

/**
 * Fragment for displaying special offers and promotions
 */
class OffersFragment : Fragment() {

    private var _binding: FragmentOffersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOffersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Add click listeners to offer cards
        binding.offerButton1.setOnClickListener {
            Snackbar.make(view, "Restaurant offer details would open", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.offerButton2.setOnClickListener {
            Snackbar.make(view, "Balance transfer application would open", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.offerCard1.setOnClickListener {
            Snackbar.make(view, "Restaurant offer details would open", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.offerCard2.setOnClickListener {
            Snackbar.make(view, "Balance transfer application would open", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = OffersFragment()
    }
}