package app.creditme.dto

import java.math.BigDecimal
import app.creditme.domain.Customer
import app.creditme.domain.Address
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.br.CPF

data class CustomerDto(
   @field:NotEmpty(message = "FirstName missing") val firstName: String,
   @field:NotEmpty(message = "LastName missing") val lastName: String,
   @field:NotEmpty(message = "CPF missing") 
   @field:CPF(message = "Invalid CPF")
   val cpf: String,
   @field:NotEmpty(message = "Email missing") 
   @field:Email(message = "Invalid email")
   val email: String,
   @field:NotEmpty(message  = "Password missing") 
   @field:Min(6, message = "Password must have 6 characters or more")
   val password: String,
   @field:NotEmpty(message = "ZipCode missing")
   @field:Digits(message = "ZipCode must contain only digits", integer = 7,fraction = 0)
   val zipCode: String,
   @field:NotEmpty(message = "Street missing")
   val street: String,
   @field:NotNull(message = "Missing income")
   @field:PositiveOrZero(message = "Income must be positive or zero")
   val income: BigDecimal,
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
