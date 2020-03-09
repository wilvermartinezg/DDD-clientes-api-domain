package xyz.wilver.clientes.domain.services

import xyz.wilver.clientes.domain.entities.Customer
import xyz.wilver.clientes.domain.validators.CustomerValidator
import xyz.wilver.clientes.domain.valueObjects.Address
import xyz.wilver.clientes.domain.valueObjects.Document
import xyz.wilver.clientes.domain.valueObjects.Person
import xyz.wilver.clientes.domain.valueObjects.PersonGender
import xyz.wilver.clientes.infrastructure.repository.CustomerRepository
import xyz.wilver.clientes.presentation.CustomerCreationRequest

class CustomerService(private val customerRepository: CustomerRepository) {

    fun createCustomer(request: CustomerCreationRequest): Long {
        CustomerValidator(request).validate()

        // Datos del cliente
        val person = Person(request.customerName, request.customerLastName).apply {
            this.email = request.customerEmail
            this.birthdate = request.customerBirthdate
            this.gender = PersonGender.valueOf(request.customerGender)
        }

        // Direcciones
        val address = Address().apply {
            this.fullAddress = request.customerFullAddress
        }

        val addresses = listOf(address)

        // Documentos
        val document = Document("DPI", request.customerDocumentNumber)

        val documents = listOf(document)

        val customer = Customer(person, request.companyId).apply {
            this.addresses = addresses
            this.documents = documents
        }

        customerRepository.create(customer)

        return customer.id
    }

}
