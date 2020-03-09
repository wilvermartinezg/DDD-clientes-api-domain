package xyz.wilver.clientes.domain.entities

import xyz.wilver.clientes.domain.valueObjects.Address
import xyz.wilver.clientes.domain.valueObjects.Document
import xyz.wilver.clientes.domain.valueObjects.Person

data class Customer(val person: Person, var companyId: Long) {
    var id = 0L
    var addresses = listOf<Address>()
    var documents = listOf<Document>()
}
