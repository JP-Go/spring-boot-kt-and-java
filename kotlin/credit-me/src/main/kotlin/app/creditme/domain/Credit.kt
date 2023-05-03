package app.creditme.domain

import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
import app.creditme.enummeration.Status

data class Credit(
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal = BigDecimal.ZERO,
    val dayFisrtInstallment: LocalDate
    val numberOfInstallments: Int  = 0,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer?
    val id: Long? = null
)
