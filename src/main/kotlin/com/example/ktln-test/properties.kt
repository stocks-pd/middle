package com.example.`ktln-test`

public class Address {
    public var name: String = "Name"
    public var street: String = "Street"
    public var city: String = "City"
    public var state: String? = "State"
    public var zip: String = "Zip"
}

fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street

    return result
}

fun main() {
    val Address1 = Address()
    val res = copyAddress(Address1)
    print(res.street)

}