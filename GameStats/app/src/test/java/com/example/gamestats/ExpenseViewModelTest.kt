package com.example.gamestats

import com.example.gamestats.repository.ExpenseRepo
import com.example.gamestats.viewmodel.ExpenseViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class ExpenseViewModelTest {

    private lateinit var expenseViewModel: ExpenseViewModel
    private val repo: ExpenseRepo = mockk()

    @Before
    fun setUp() {
        expenseViewModel = ExpenseViewModel(repo)
    }

    @Test
    fun `fetchTransactions calls repository getTransactions`() {
        val userId = "user123"
        every { repo.getTransactions(userId, any()) } returns Unit

        expenseViewModel.fetchTransactions(userId)

        verify { repo.getTransactions(userId, any()) }
    }
}
