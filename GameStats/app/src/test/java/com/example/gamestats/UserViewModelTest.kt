package com.example.gamestats

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gamestats.repository.UserRepo
import com.example.gamestats.viewmodel.UserViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var userViewModel: UserViewModel
    private val repo: UserRepo = mockk()

    @Before
    fun setUp() {
        userViewModel = UserViewModel(repo)
    }

    @Test
    fun `login calls repository login`() {
        val email = "test@example.com"
        val password = "password"
        val callback: (Boolean, String) -> Unit = { _, _ -> }

        every { repo.login(email, password, any()) } returns Unit

        userViewModel.login(email, password, callback)

        verify { repo.login(email, password, any()) }
    }
}
