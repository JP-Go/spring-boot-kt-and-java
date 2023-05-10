package app.creditme.dto

import app.creditme.domain.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        this.run {
            customer.firstName = firstName
            customer.firstName = firstName
            customer.lastName = lastName
            customer.income = income
            customer.address.zipCode = zipCode
            customer.address.street = street
        }
        return customer
    }
}
