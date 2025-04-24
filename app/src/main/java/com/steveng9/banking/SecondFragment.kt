package com.steveng9.banking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.steveng9.banking.databinding.FragmentSecondBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Banking dashboard fragment displaying account information
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val accounts = BankAccount.getSampleAccounts()

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set welcome message
        binding.welcomeUser.text = "Welcome, John Doe"
        
        // Set current date
        val dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
        binding.dateText.text = dateFormat.format(Date())
        
        // Set account information using our model class
        displayAccountInformation()

        // Set up click listeners for account cards to navigate to details
        setupAccountCardListeners()

        // Set up the logout button
        binding.buttonSecond.setOnClickListener {
            // Navigate back to the login screen
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
    
    /**
     * Display account information using our model class
     */
    private fun displayAccountInformation() {
        // Find checking account
        val checkingAccount = accounts.find { it.accountType == BankAccount.AccountType.CHECKING }
        checkingAccount?.let {
            binding.checkingNumber.text = it.maskedAccountNumber
            binding.checkingBalance.text = it.getFormattedBalance()
        }
        
        // Find savings account
        val savingsAccount = accounts.find { it.accountType == BankAccount.AccountType.SAVINGS }
        savingsAccount?.let {
            binding.savingsNumber.text = it.maskedAccountNumber
            binding.savingsBalance.text = it.getFormattedBalance()
        }
    }
    
    /**
     * Set up click listeners for account cards to navigate to account details screen
     */
    private fun setupAccountCardListeners() {
        // Set up click listener for checking account card
        binding.checkingAccountCard.setOnClickListener {
            val checkingAccount = accounts.find { it.accountType == BankAccount.AccountType.CHECKING }
            checkingAccount?.let {
                // Create a Bundle with the account ID
                val bundle = Bundle().apply {
                    putString("accountId", it.id)
                }
                // Navigate using the action ID and bundle
                findNavController().navigate(R.id.action_SecondFragment_to_AccountDetailsFragment, bundle)
            }
        }
        
        // Set up click listener for savings account card
        binding.savingsAccountCard.setOnClickListener {
            val savingsAccount = accounts.find { it.accountType == BankAccount.AccountType.SAVINGS }
            savingsAccount?.let {
                // Create a Bundle with the account ID
                val bundle = Bundle().apply {
                    putString("accountId", it.id)
                }
                // Navigate using the action ID and bundle
                findNavController().navigate(R.id.action_SecondFragment_to_AccountDetailsFragment, bundle)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}