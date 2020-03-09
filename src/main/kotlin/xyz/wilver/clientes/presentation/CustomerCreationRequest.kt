package xyz.wilver.clientes.presentation

import java.time.LocalDate

class CustomerCreationRequest {
    var companyId = 0L
    var customerName = ""
    var customerLastName = ""
    var customerBirthdate: LocalDate = LocalDate.now()
    var customerEmail = ""
    var customerGender = "" // MALE OR FEMALE
    var customerFullAddress = ""
    var customerDocumentNumber = ""
    var customerDocumentType = ""
}
