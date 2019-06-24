package br.com.ruyano.onboardingexample.repositories.user

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth

class UserManagementRepositoryImpl : UserManagementRepository {

    private var mSignInLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private var mSignUpLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private var mResetPasswordLiveData: MutableLiveData<Boolean> = MutableLiveData()

    override fun signIn(email: String, password: String) : MutableLiveData<Boolean> {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            task -> mSignInLiveData.value = task.isSuccessful
        }
        return mSignInLiveData
    }

    override fun signUp(email: String, password: String): MutableLiveData<Boolean> {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password). addOnCompleteListener {
            task -> mSignUpLiveData.value = task.isSuccessful
        }
        return mSignUpLiveData
    }

    override fun resetPassword(email: String): MutableLiveData<Boolean> {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
            task -> mResetPasswordLiveData.value = task.isSuccessful
        }
        return mResetPasswordLiveData
    }

}