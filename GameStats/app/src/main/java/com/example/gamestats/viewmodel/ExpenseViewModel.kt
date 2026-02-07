package com.example.gamestats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamestats.model.CategoryModel
import com.example.gamestats.model.TransactionModel
import com.example.gamestats.repository.ExpenseRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repo: ExpenseRepo) : ViewModel() {
    private val _transactions = MutableStateFlow<List<TransactionModel>>(emptyList())
    val transactions: StateFlow<List<TransactionModel>> = _transactions

    private val _categories = MutableStateFlow<List<CategoryModel>>(emptyList())
    val categories: StateFlow<List<CategoryModel>> = _categories

    fun fetchTransactions(userId: String) {
        repo.getTransactions(userId) { success, list ->
            if (success) _transactions.value = list
        }
    }

    fun fetchCategories(userId: String) {
        repo.getCategories(userId) { success, list ->
            if (success) _categories.value = list
        }
    }

    fun addTransaction(transaction: TransactionModel) {
        repo.addTransaction(transaction) { success, _ ->
            // Data will refresh automatically due to ValueEventListener in Repo
        }
    }

    fun addCategory(category: CategoryModel) {
        repo.addCategory(category) { success, _ ->
            // Data will refresh automatically
        }
    }
}
