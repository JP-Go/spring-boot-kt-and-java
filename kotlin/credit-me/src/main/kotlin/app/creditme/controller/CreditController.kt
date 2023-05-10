package app.creditme.controller

import app.creditme.dto.CreditDto
import app.creditme.dto.CreditView
import app.creditme.dto.CreditViewList
import app.creditme.service.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@RestController
@RequestMapping("/api/v1/credit")
class CreditController(
    private val creditService: CreditService,
) {

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
        this.creditService.save(creditDto.toEntity()).run {
            return "Credit ${this.creditCode} created for customer ${this.customer?.firstName}"
        }
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customer") customerId: Long): List<CreditViewList> {
        this.creditService.findAllByCustomer(customerId)
            .map { CreditViewList(it) }
            .also { return it }
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam("customer") customerId: Long,
        @PathVariable("creditCode") creditCode: UUID,
    ): CreditView {
        val credit = this.creditService.findByCreditCode(creditCode, customerId)
        return CreditView(credit)
    }
}
