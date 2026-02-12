
package com.example.gamestats.data

import android.content.Context
import android.content.SharedPreferences
import com.example.gamestats.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// Manages persistence of the wishlist using SharedPreferences
class WishlistManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("wishlist", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun getWishlist(): MutableList<Product> {
        val json = prefs.getString("wishlist_items", null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<Product>>() {}.type
            gson.fromJson(json, type)
        } else {
            mutableListOf()
        }
    }

    fun saveWishlist(wishlist: List<Product>) {
        val json = gson.toJson(wishlist)
        prefs.edit().putString("wishlist_items", json).apply()
    }
}
