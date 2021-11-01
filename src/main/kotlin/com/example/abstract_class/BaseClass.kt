package com.example.abstract_class

open abstract class BaseClass {
    var value = 0
    fun a()
    {
        value++
        print("VALUE: $value")
    }
    abstract fun minus()
}