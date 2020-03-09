package xyz.wilver.clientes.api

import xyz.wilver.clientes.domain.services.CustomerBalanceService
import xyz.wilver.clientes.domain.services.CustomerService
import xyz.wilver.clientes.infrastructure.services.EmailService
import xyz.wilver.clientes.presentation.CustomerCreationRequest
import java.math.BigDecimal

class CustomerApi(
    private val customerService: CustomerService,
    private val customerBalanceService: CustomerBalanceService,
    private val emailService: EmailService
) {

    /**
     * Crea un nuevo cliente y le acredita 50 puntos de bienvenida
     * @param request Datos para la solicitud de creacion de nuevo cliente
     * @return Retorna el ID del cliente creado
     */
    fun createCustomer(request: CustomerCreationRequest): Long {
        // 1. Crea el cliente
        val customerId = customerService.createCustomer(request)

        // 2. Acredita los puntos
        customerBalanceService.accredit(customerId, BigDecimal(50))

        // 3. Envia email al cliente para confirmar su registro
        sendConfirmationEmail(request.customerEmail, request.customerName)

        return customerId
    }

    private fun sendConfirmationEmail(customerEmail: String, customerName: String) {
        val from = "no-responder@wilver.xyz"
        val body = "Estimado $customerName " +
                " te informamos que tu registro a nuestro programa " +
                " de clientes frecuentes se ha completado exitosamente "

        emailService.sendEmail(from, customerEmail, body)
    }

}
