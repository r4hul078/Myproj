package com.example.gamestats.repository

import com.example.gamestats.model.CategoryModel
import com.example.gamestats.model.TransactionModel
import com.google.firebase.database.*

class ExpenseRepoImpl : ExpenseRepo {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val transactionsRef: DatabaseReference = database.getReference("Transactions")
    private val categoriesRef: DatabaseReference = database.getReference("Categories")

    override fun addTransaction(transaction: TransactionModel, callback: (Boolean, String) -> Unit) {
        val id = transactionsRef.push().key ?: return
        val newTransaction = transaction.copy(id = id)
        transactionsRef.child(id).setValue(newTransaction).addOnCompleteListener {
            if (it.isSuccessful) callback(true, "Transaction saved")
            else callback(false, it.exception?.message ?: "Error")
        }
    }

    override fun getTransactions(userId: String, callback: (Boolean, List<TransactionModel>) -> Unit) {
        transactionsRef.orderByChild("userId").equalTo(userId)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<TransactionModel>()
                    for (data in snapshot.children) {
                        data.getValue(TransactionModel::class.java)?.let { list.add(it) }
                    }
                    callback(true, list.asReversed())
                }
                override fun onCancelled(error: DatabaseError) {
                    callback(false, emptyList())
                }
            })
    }

    override fun addCategory(category: CategoryModel, callback: (Boolean, String) -> Unit) {
        val id = categoriesRef.push().key ?: return
        val newCategory = category.copy(id = id)
        categoriesRef.child(id).setValue(newCategory).addOnCompleteListener {
            if (it.isSuccessful) callback(true, "Category added")
            else callback(false, it.exception?.message ?: "Error")
        }
    }

    override fun getCategories(userId: String, callback: (Boolean, List<CategoryModel>) -> Unit) {
        categoriesRef.orderByChild("userId").equalTo(userId)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<CategoryModel>()
                    for (data in snapshot.children) {
                        data.getValue(CategoryModel::class.java)?.let { list.add(it) }
                    }
                    callback(true, list)
                }
                override fun onCancelled(error: DatabaseError) {
                    callback(false, emptyList())
                }
            })
    }
}
