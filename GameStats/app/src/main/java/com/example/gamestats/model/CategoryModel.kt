package com.example.gamestats.model

// Represents a spending category in the expense tracker
data class CategoryModel(
    val id: String = "",
    val name: String = "",
    val iconName: String = "Category",
    val colorHex: String = "#FF9800",
    val userId: String = ""
) {
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "name" to name,
            "iconName" to iconName,
            "colorHex" to colorHex,
            "userId" to userId
        )
    }
}
