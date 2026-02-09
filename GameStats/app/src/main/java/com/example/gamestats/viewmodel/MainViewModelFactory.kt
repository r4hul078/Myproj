
package com.example.gamestats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gamestats.data.WishlistManager

class MainViewModelFactory(private val wishlistManager: WishlistManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(wishlistManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
