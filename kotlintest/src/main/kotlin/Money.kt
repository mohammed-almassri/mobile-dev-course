package me.hal8

import java.util.function.Function

class Money(val amount: Int, val fraction:Int, val currency: Currency=Currency.USD,val precesion: Int = 2) : Comparable<Money> {
    override fun compareTo(other: Money): Int = when {
            amount != other.amount-> amount.compareTo(other.amount)
            else -> fraction.compareTo(other.fraction)
        }


    fun addAmount(amount: Int): Money {
        return Money(this.amount+amount, fraction,currency)
    }

    fun addFraction(fraction: Int): Money {
        return Money(amount, this.fraction+fraction,currency)
    }

    operator fun plus(other: Money): Money  = Money(this.amount+other.amount, this.fraction+other.fraction,currency)

    override fun toString(): String {
        return "${currency.getSymbol()}$amount.$fraction"
    }

    fun convertTo(converter: Function<Money,Money>):Money{
        return converter.apply(this)
    }
}