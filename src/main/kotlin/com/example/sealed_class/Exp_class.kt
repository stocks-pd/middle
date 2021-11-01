package com.example.sealed_class

sealed class Exp
{
    class const(val number :Int): Exp()
    class sum(val e1: Exp,val e2: Exp) : Exp()
}