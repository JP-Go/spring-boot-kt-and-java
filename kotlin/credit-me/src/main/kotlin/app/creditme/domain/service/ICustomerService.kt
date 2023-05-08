package app.creditme.domain.service

import app.creditme.domain.Customer

interface ICustomerService{

    fun save(customer: Customer): Customer
    fun findById(customerId: Long): Customer?
    fun delete(customerId:Long): Customer
  }
