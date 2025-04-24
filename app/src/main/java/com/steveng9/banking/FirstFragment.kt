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
            // Simple mock login validation
            val username = binding.usernameInput.text.toString()
            val password = binding.passwordInput.text.toString()
            
            if (username.isBlank() || password.isBlank()) {
                Snackbar.make(view, "Please enter both username and password", Snackbar.LENGTH_SHORT).show()
            } else {
                // Navigate to the banking dashboard
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
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