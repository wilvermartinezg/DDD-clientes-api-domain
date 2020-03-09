package xyz.wilver.clientes.domain.valueObjects

import java.time.LocalDate

data class Person(var name: String, var lastName: String) {
    var email = ""
    var birthdate: LocalDate = LocalDate.now()
    var gender: PersonGender = PersonGender.MALE
}
