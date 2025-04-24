package com.steveng9.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentProfileBinding

/**
 * Fragment for displaying user profile and security settings
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Add click listeners to profile buttons
        binding.changePassword.setOnClickListener {
            Snackbar.make(view, "Change password dialog would appear", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.setupBiometrics.setOnClickListener {
            Snackbar.make(view, "Biometric setup would begin", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.loginSettings.setOnClickListener {
            Snackbar.make(view, "Login settings screen would open", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}