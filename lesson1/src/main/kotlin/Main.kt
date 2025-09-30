package me.hal8



fun fib(n: Int): Int{
    if(n<1) throw IllegalArgumentException("n must be greater than zero")
    if(n<3) return 1
    return fib(n-1)+fib(n-2)
}

fun sum(a: Int?, b: Int?):Int{
    return when{
        a==null&&b==null -> 0
        a==null&&b!=null -> b
        b==null&&a!=null -> a
        a!=null && b!=null -> a+b
        else -> 0
    }
}

fun main() {
    val names = listOf("A", "B", "C")
    for(name in names){
        println(name)
    }
    println(when{
        names.size>2 -> "hi"
        else -> "hello"
    })

    println(sum(null,123))
    println(sum(321,123))
    var price = Money(100,12)
    var inMyWallet = Money(100,0)

    if(price>inMyWallet){
        println("I cannot afford this thing")
    }
    else{
        println("I can afford")
    }

    var sum = price+inMyWallet
    println(sum)
    println(println("unit"))
    var inMyWalletGBP = inMyWallet.convertTo{
        var total = (it.amount+(it.fraction/Math.pow(10.0,it.precesion.toDouble()))) * 1.71
        var newAmount = Math.floor(total).toInt()
        var newFrac = (total - newAmount).toInt()
         Money(newAmount,newFrac,Currency.GBP)
    }

    println(inMyWalletGBP)

}