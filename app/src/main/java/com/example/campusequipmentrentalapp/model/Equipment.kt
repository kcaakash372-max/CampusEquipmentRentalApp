package com.example.campusequipmentrentalapp.model;

data class Equipment(
    val id: Int,
    val name: String,
    val category: String,
    val icon: String,
    val status: RentalStatus,
    val maxRentalDays: Int,
    val location: String,
    val description: String
)

enum class RentalStatus(
    val label: String,
    val isAvailable: Boolean
) {
    AVAILABLE("Available", true),
    RENTED("Rented", false),
    MAINTENANCE("Under Maintenance", false)
}