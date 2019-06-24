package br.com.ruyano.onboardingexample.repositories.user

import androidx.lifecycle.MutableLiveData

interface UserManagementRepository {

    fun signIn(email: String, password: String) : MutableLiveData<Boolean>

    fun signUp(email: String, password: String) : MutableLiveData<Boolean>

    fun resetPassword(email: String) : MutableLiveData<Boolean>

}