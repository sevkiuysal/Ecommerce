package com.koylumuhendis.ecommerce.Commerce.model


import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
@Entity
data class User (
@field:Id
@field:GeneratedValue (strategy = GenerationType.IDENTITY)
val id:Long,
@field:Column(unique=true)
val email:String,
val firstname:String,
val lastname:String,
val address:String
)