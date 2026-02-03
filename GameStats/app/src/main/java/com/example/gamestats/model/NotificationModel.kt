package com.example.gamestats.model

data class NotificationModel(
    val id: String = "",
    val title: String = "",
    val message: String = "",
    val timestamp: Long = System.currentTimeMillis(),
    val type: String = "INFO", // INFO, WARNING, ALERT
    val userId: String = "",
    val isRead: Boolean = false
)
