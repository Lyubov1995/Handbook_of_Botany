package com.example.handbook_of_botany.utils

sealed class DrawerEvents
{
    data class OnItemClick(val title: String, val index: Int): DrawerEvents()
}
