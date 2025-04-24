package com.steveng9.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentHelpBinding

/**
 * Fragment for displaying help and support options
 */
class HelpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Add click listeners to FAQ items
        binding.faq1Card.setOnClickListener {
            Snackbar.make(view, "Information about reporting lost/stolen cards would display", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.faq2Card.setOnClickListener {
            Snackbar.make(view, "Information about changing PIN would display", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.faq3Card.setOnClickListener {
            Snackbar.make(view, "Information about disputing transactions would display", Snackbar.LENGTH_SHORT).show()
        }
        
        // Add click listeners to support buttons
        binding.callSupport.setOnClickListener {
            Snackbar.make(view, "Would initiate call to support", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.emailSupport.setOnClickListener {
            Snackbar.make(view, "Would open email client", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = HelpFragment()
    }
}