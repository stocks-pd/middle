package com.example
import kotlinx.serialization.Serializable
import java.beans.Customizer

@Serializable
data class Customer(val id: String, val firstName: String, val lastName: String, val email: String)

val Customers1 = Customer("1","Tom", "Jack","one@ya.ru")
val Customers2 = Customer("2","Toni", "Jack","two@ya.ru")
val Customers3 = Customer("3","Tim", "Jack","3@ya.ru")
val Customers4 = Customer("4","Timophey", "Jack","4@ya.ru")
val customerStorage = mutableListOf<Customer>(
    Customer("1","Tom", "Jack","one@ya.ru"),
    Customer("2","Toni", "Jack","two@ya.ru"),
    Customer("3","Tim", "Jack","3@ya.ru"),
    Customer("4","Timophey", "Jack","4@ya.ru"),
)

