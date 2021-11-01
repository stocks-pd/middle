package com.example.sealed_class

fun main()
{
    var v1 = Exp.const(2)
    var v2 = Exp.const(3)

    var sum = Exp.sum(v1, v2)
    print(eval(sum))

}
fun eval(x:Exp) :Int  = when(x)
{
    is Exp.const -> x.number
    is Exp.sum -> eval(x.e1) + eval(x.e2)

}