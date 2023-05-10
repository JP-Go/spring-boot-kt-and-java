package app.creditme.dto

import java.math.BigDecimal
import app.creditme.domain.Customer
import app.creditme.domain.Address

data class CustomerDto(
  val firstName: String,
  val lastName: String,
  val cpf: String,
  val income: BigDecimal,
  val email: String,
  val password: String,
  val zipCode: String,
  val street: String
) {
  
 fun toEntity(): Customer = Customer(
    firstName = this.firstName,
    lastName = this.lastName,
    cpf = this.cpf,
    email = this.email,
    password = this.password,
    income = this.income,
    address = Address(zipCode = this.zipCode, street = this.street)
  )
}
