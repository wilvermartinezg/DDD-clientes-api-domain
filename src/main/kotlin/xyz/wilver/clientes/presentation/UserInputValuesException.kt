package xyz.wilver.clientes.presentation

class UserInputValuesException(val errors: List<UserInputValueError>) : Exception("Error en entradas de usuario")
