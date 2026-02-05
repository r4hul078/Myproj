package com.example.gamestats.repository

import com.example.gamestats.model.CategoryModel
import com.example.gamestats.model.TransactionModel

interface ExpenseRepo {
    fun addTransaction(transaction: TransactionModel, callback: (Boolean, String) -> Unit)
    fun getTransactions(userId: String, callback: (Boolean, List<TransactionModel>) -> Unit)
    fun addCategory(category: CategoryModel, callback: (Boolean, String) -> Unit)
    fun getCategories(userId: String, callback: (Boolean, List<CategoryModel>) -> Unit)
}
