package com.steveng9.banking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.steveng9.banking.databinding.FragmentAccountHomeBinding
import com.steveng9.banking.databinding.ItemTransactionBinding

/**
 * Fragment for displaying account details and transactions
 */
class AccountHomeFragment : Fragment() {

    private var _binding: FragmentAccountHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var account: BankAccount
    private val mockTransactions = mutableListOf<Transaction>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Get accountId from arguments
        val accountId = requireArguments().getString(ARG_ACCOUNT_ID, "1")
        
        // Find account from sample data
        account = BankAccount.getSampleAccounts().find { it.id == accountId }
            ?: BankAccount.getSampleAccounts().first()
        
        // Setup mock transactions
        setupMockTransactions()
        
        // Display account info
        displayAccountInfo()
        
        // Setup transactions recyclerview
        setupTransactionsList()
    }
    
    private fun setupMockTransactions() {
        mockTransactions.apply {
            add(Transaction("1", "Grocery Store", "Debit Card Purchase", "Apr 22, 2025", -78.45))
            add(Transaction("2", "Direct Deposit - Employer", "Deposit", "Apr 21, 2025", 2400.00))
            add(Transaction("3", "Coffee Shop", "Debit Card Purchase", "Apr 20, 2025", -5.25))
            add(Transaction("4", "Gas Station", "Debit Card Purchase", "Apr 19, 2025", -45.00))
            add(Transaction("5", "Online Shopping", "Debit Card Purchase", "Apr 18, 2025", -124.99))
        }
    }
    
    private fun displayAccountInfo() {
        binding.accountNameTitle.text = when(account.accountType) {
            BankAccount.AccountType.CHECKING -> "Checking Account"
            BankAccount.AccountType.SAVINGS -> "Savings Account"
            else -> "Account"
        }
        
        binding.accountNumber.text = account.maskedAccountNumber
        binding.balanceAmount.text = account.getFormattedBalance()
        binding.availableAmount.text = account.getFormattedBalance()
    }
    
    private fun setupTransactionsList() {
        binding.transactionsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TransactionsAdapter(mockTransactions)
        }
    }
    
    inner class TransactionsAdapter(private val transactions: List<Transaction>) :
        RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {
        
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
            val binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TransactionViewHolder(binding)
        }
        
        override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
            holder.bind(transactions[position])
        }
        
        override fun getItemCount() = transactions.size
        
        inner class TransactionViewHolder(private val binding: ItemTransactionBinding) :
            RecyclerView.ViewHolder(binding.root) {
            
            fun bind(transaction: Transaction) {
                binding.transactionDate.text = transaction.date
                binding.transactionDescription.text = transaction.description
                binding.transactionType.text = transaction.type
                binding.transactionAmount.text = transaction.getFormattedAmount()
                binding.transactionAmount.setTextColor(
                    resources.getColor(
                        if (transaction.amount < 0) android.R.color.holo_red_dark
                        else android.R.color.holo_green_dark,
                        null
                    )
                )
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    companion object {
        private const val ARG_ACCOUNT_ID = "account_id"
        
        fun newInstance(accountId: String) = AccountHomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_ACCOUNT_ID, accountId)
            }
        }
    }
}

/**
 * Model class for transactions
 */
data class Transaction(
    val id: String,
    val description: String,
    val type: String,
    val date: String,
    val amount: Double
) {
    fun getFormattedAmount(): String {
        val prefix = if (amount >= 0) "+" else ""
        return prefix + "$" + String.format("%,.2f", amount)
    }
}