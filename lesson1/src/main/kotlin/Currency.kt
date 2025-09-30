package me.hal8

enum class Currency {
    USD, EUR, GBP;
    fun getSymbol(): String {
        return when{
            this == USD -> "$"
            this == EUR -> "€"
            this == GBP -> "£"
            else -> this.name
        }
    }
}