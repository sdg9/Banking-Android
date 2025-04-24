package com.steveng9.banking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.steveng9.banking.databinding.FragmentAccountDetailsBinding

/**
 * Fragment for the account details screen with bottom navigation
 */
class AccountDetailsFragment : Fragment() {

    private var _binding: FragmentAccountDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var account: BankAccount

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Get the account ID from arguments directly
        val accountId = arguments?.getString("accountId") ?: "1"
        
        // Find the account in our sample data
        account = BankAccount.getSampleAccounts().find { it.id == accountId }
            ?: BankAccount.getSampleAccounts().first()  // Fallback to first account if not found
        
        setupViewPager()
        setupBottomNavigation()
    }
    
    private fun setupViewPager() {
        binding.viewPager.adapter = AccountPagerAdapter(this)
        
        // Disable swiping between tabs (let user use bottom nav instead)
        binding.viewPager.isUserInputEnabled = false
    }
    
    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    binding.viewPager.currentItem = 0
                    true
                }
                R.id.navigation_benefits -> {
                    binding.viewPager.currentItem = 1
                    true
                }
                R.id.navigation_help -> {
                    binding.viewPager.currentItem = 2
                    true
                }
                R.id.navigation_offers -> {
                    binding.viewPager.currentItem = 3
                    true
                }
                R.id.navigation_profile -> {
                    binding.viewPager.currentItem = 4
                    true
                }
                else -> false
            }
        }
    }
    
    /**
     * ViewPager adapter for account tabs
     */
    inner class AccountPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        
        override fun getItemCount(): Int = 5
        
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> AccountHomeFragment.newInstance(account.id)
                1 -> BenefitsFragment.newInstance()
                2 -> HelpFragment.newInstance()
                3 -> OffersFragment.newInstance()
                4 -> ProfileFragment.newInstance()
                else -> AccountHomeFragment.newInstance(account.id)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    companion object {
        fun newInstance() = AccountDetailsFragment()
    }
}