package app.creditme.domain

data class Customer(
    var id: Long? = null,
    var firstName: String = "",
    var LastName: String = "",
    val cpf: String,
    var email: String = "",
    var password: String = "",
    var address: Address = Address(),
    var credits: List<Credit> = mutableListOf(),
)
