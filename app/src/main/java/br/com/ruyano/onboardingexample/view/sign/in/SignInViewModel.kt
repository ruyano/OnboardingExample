package br.com.ruyano.onboardingexample.view.sign.`in`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepository
import br.com.ruyano.onboardingexample.repositories.user.UserManagementRepositoryImpl

class SignInViewModel(var mModel: SignInModel = SignInModel(),
                      private var mUserRepository: UserManagementRepository = UserManagementRepositoryImpl()): ViewModel() {

    fun doLogin() : MutableLiveData<Boolean> {
        return mUserRepository.signIn(mModel.email, mModel.password)
    }

}