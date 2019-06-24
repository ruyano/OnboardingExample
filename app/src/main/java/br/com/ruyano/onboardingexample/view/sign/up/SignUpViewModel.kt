package br.com.ruyano.onboardingexample.view.sign.up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepository
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepositoryImpl

class SignUpViewModel: ViewModel() {

    private var userRepository: UserManagementRepository = UserManagementRepositoryImpl()

    fun doSignUp() : MutableLiveData<Boolean> {
        return userRepository.signUp("teste@teste.com", "ps654321")
    }

}