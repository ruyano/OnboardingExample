package br.com.ruyano.onboardingexample.util

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validate(validator: (String) -> Boolean, message: String) {
    this.editText?.afterTextChanged {
        this.error = if (validator(it)) null else message
    }
}

fun TextInputLayout.addEmailValidation() {
    validate({s -> s.isValidEmail()}, "Email incorreto")
}

fun TextInputLayout.validateEmail() : Boolean  = this.editText?.text.toString().isValidEmail()

fun TextInputLayout.addPasswordValidation() {
    validate({s -> s.length > 5}, "Senha muito curta")
}