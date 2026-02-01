package com.example.gamestats.model

data class TransactionModel(
    val id: String = "",
    val title: String = "",
    val date: String = "",
    val amount: String = "",
    val isExpense: Boolean = true,
    val categoryName: String = "",
    val amountVal: Double = 0.0,
    val userId: String = ""
) {
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "title" to title,
            "date" to date,
            "amount" to amount,
            "isExpense" to isExpense,
            "categoryName" to categoryName,
            "amountVal" to amountVal,
            "userId" to userId
        )
    }
}
