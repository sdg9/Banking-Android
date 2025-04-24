package com.steveng9.banking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentFirstBinding

/**
 * Login screen fragment
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            // Modified for faster testing: No validation, just navigate to dashboard
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            
            // Show a toast indicating test mode
            // Snackbar.make(view, "Test mode: Bypassing login validation", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.forgotPassword.setOnClickListener {
            Snackbar.make(view, "Password reset functionality would go here", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}