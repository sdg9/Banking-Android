package com.steveng9.banking

/**
 * Model class representing a bank account
 */
data class BankAccount(
    val id: String,
    val accountNumber: String,
    val accountType: AccountType,
    val balance: Double,
    val maskedAccountNumber: String = "****" + accountNumber.takeLast(4)
) {
    enum class AccountType {
        CHECKING, SAVINGS, CREDIT
    }
    
    /**
     * Returns a formatted balance string with dollar sign and commas
     */
    fun getFormattedBalance(): String {
        return "$" + String.format("%,.2f", balance)
    }
    
    companion object {
        /**
         * Creates sample accounts for demo purposes
         */
        fun getSampleAccounts(): List<BankAccount> {
            return listOf(
                BankAccount(
                    "1",
                    "123456784567",
                    AccountType.CHECKING,
                    2456.78,
                ),
                BankAccount(
                    "2",
                    "123456787890",
                    AccountType.SAVINGS,
                    10234.56,
                )
            )
        }
    }
}