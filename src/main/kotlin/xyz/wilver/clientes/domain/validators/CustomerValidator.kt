package xyz.wilver.clientes.domain.validators

import xyz.wilver.clientes.domain.valueObjects.PersonGender
import xyz.wilver.clientes.presentation.CustomerCreationRequest
import xyz.wilver.clientes.presentation.UserInputValueError
import xyz.wilver.clientes.presentation.UserInputValuesException

class CustomerValidator(private val request: CustomerCreationRequest) {
    private val errors = mutableListOf<UserInputValueError>()

    fun validate() {
        validatePersonData()
        validateGenderFormat()
        validateAdditionalInfo()

        if (errors.isNotEmpty()) {
            throw UserInputValuesException(errors)
        }
    }

    private fun validatePersonData() {
        if (request.customerName.isEmpty()) {
            val description = "La propiedad customerName es obligatoria"
            val error = UserInputValueError("01", "customerName", description)
            errors.add(error)
        }

        if (request.customerLastName.isEmpty()) {
            val description = "La propiedad customerLastName es obligatoria"
            val error = UserInputValueError("02", "customerLastName", description)
            errors.add(error)
        }
    }

    private fun validateGenderFormat() {
        val customerGender = request.customerGender

        if (customerGender != PersonGender.MALE.description && customerGender != PersonGender.FEMALE.description) {
            val description = "Los valores permitidos para la propiedad customerGender son MALE o FEMALE"
            val error = UserInputValueError("03", "customerGender", description)
            errors.add(error)
        }
    }

    private fun validateAdditionalInfo() {
        if (request.companyId <= 0) {
            val description = "La propiedad companyId debe ser mayor a cero"
            val error = UserInputValueError("04", "companyId", description)
            errors.add(error)
        }

        if(request.customerFullAddress.isEmpty()) {
            val description = "La propiedad customerFullAddress es obligatoria"
            val error = UserInputValueError("05", "customerFullAddress", description)
            errors.add(error)
        }

    }


}
