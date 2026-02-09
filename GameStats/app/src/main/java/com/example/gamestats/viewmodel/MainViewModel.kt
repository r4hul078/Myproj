
package com.example.gamestats.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.gamestats.data.WishlistManager
import com.example.gamestats.model.Product

class MainViewModel(private val wishlistManager: WishlistManager) : ViewModel() {

    val products = mutableStateOf<List<Product>>(emptyList())
    val wishlist = mutableStateOf<List<Product>>(emptyList())

    init {
        loadProducts()
        loadWishlist()
    }

    private fun loadProducts() {
        // Sample product data
        products.value = listOf(
            Product(1, "Product 1", 19.99),
            Product(2, "Product 2", 29.99),
            Product(3, "Product 3", 39.99),
            Product(4, "Product 4", 49.99),
            Product(5, "Product 5", 59.99)
        )
    }

    private fun loadWishlist() {
        wishlist.value = wishlistManager.getWishlist()
    }

    fun addToWishlist(product: Product) {
        val updatedWishlist = wishlist.value.toMutableList().apply {
            add(product)
        }
        wishlist.value = updatedWishlist
        wishlistManager.saveWishlist(updatedWishlist)
    }

    fun removeFromWishlist(product: Product) {
        val updatedWishlist = wishlist.value.toMutableList().apply {
            remove(product)
        }
        wishlist.value = updatedWishlist
        wishlistManager.saveWishlist(updatedWishlist)
    }

    fun clearWishlist() {
        wishlist.value = emptyList()
        wishlistManager.saveWishlist(emptyList())
    }
}
