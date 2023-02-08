package com.example.notebook.note_features.domainLayer.utils

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
