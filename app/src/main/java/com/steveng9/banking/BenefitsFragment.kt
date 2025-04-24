package com.steveng9.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentBenefitsBinding

/**
 * Fragment for displaying account benefits
 */
class BenefitsFragment : Fragment() {

    private var _binding: FragmentBenefitsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBenefitsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Add click listeners to benefit cards
        binding.cashbackCard.setOnClickListener {
            Snackbar.make(view, "Cashback details would open here", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.travelCard.setOnClickListener {
            Snackbar.make(view, "Travel insurance details would open here", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = BenefitsFragment()
    }
}