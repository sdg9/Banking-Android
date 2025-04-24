package com.steveng9.banking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.steveng9.banking.databinding.FragmentProfileBinding

/**
 * Fragment for displaying user profile and settings
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
        
        setupClickListeners()
    }
    
    private fun setupClickListeners() {
        // Sign Out
        binding.signOutText.setOnClickListener {
            Snackbar.make(binding.root, "Signing out...", Snackbar.LENGTH_SHORT).show()
            // In a real app, we would sign out the user and navigate back to login
        }
        
        // Profile settings options
        binding.personalInfoSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Personal Information", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.securitySection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Security Settings", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.accountSettingsSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Account & Feature Settings", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.helpSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Help", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.alertsSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Alerts & Notifications", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.walletSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Digital Wallet Manager", Snackbar.LENGTH_SHORT).show()
        }
        
        binding.statementsSection.setOnClickListener {
            Snackbar.make(binding.root, "Opening Statements & Documents", Snackbar.LENGTH_SHORT).show()
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