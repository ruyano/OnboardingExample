package br.com.ruyano.onboardingexample.view.forgot.password

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepository
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepositoryImpl

class ForgotPasswordViewModel : ViewModel() {

    private var userRepository: UserManagementRepository = UserManagementRepositoryImpl()

    fun resetPassword() : MutableLiveData<Boolean> {
        return userRepository.resetPassword("ruyano@gmail.com")
    }
}