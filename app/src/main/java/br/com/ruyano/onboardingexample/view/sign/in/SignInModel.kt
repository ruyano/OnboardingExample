package br.com.ruyano.onboardingexample.view.sign.`in`

import android.R
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import br.com.ruyano.onboardingexample.util.isValidEmail


class SignInModel (
    var email: String = "",
    var password: String = "",
    val emailError: MutableLiveData<Int> = MutableLiveData(),
    val passwordError: MutableLiveData<Int> = MutableLiveData()) : BaseObservable() {

    fun isValid(): Boolean {
        val emailValid = isEmailValid(false)
        val passwordValid = isPasswordValid(false)
        return emailValid && passwordValid
    }

    fun isEmailValid(setMessage: Boolean): Boolean =
        if (email.length > 5) {
            if (email.isValidEmail()) {
                emailError.value = null
                true
            } else {
                if (setMessage)
                    emailError.value = R.string.cancel
                false
            }
        } else {
            emailError.value = R.string.cancel
            false
        }

    private fun isPasswordValid(setMessage: Boolean): Boolean =
        if (password.length > 5) {
            passwordError.value = null
            true
        } else {
            if (setMessage)
                passwordError.value = R.string.cancel
            false
        }

}