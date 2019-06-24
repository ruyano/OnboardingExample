package br.com.ruyano.onboardingexample.view.sign.up

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.ruyano.onboardingexample.R
import br.com.ruyano.onboardingexample.util.addEmailValidation
import br.com.ruyano.onboardingexample.util.addPasswordValidation
import br.com.ruyano.onboardingexample.util.initToolbar
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar(R.string.sign_up, true)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        tilEmail.addEmailValidation()
        tilPassword.addPasswordValidation()

        btnSignUp.setOnClickListener { signUp() }

    }

    private fun signUp() {
        btnSignUp.startAnimation()
        viewModel.doSignUp().observe(this, Observer { done ->
            if (done) {
                val successIcon = BitmapFactory.decodeResource(resources, R.drawable.ic_done_white_48dp)
                btnSignUp.doneLoadingAnimation(R.color.colorPrimary, successIcon)
                Toast.makeText(context, "Register success", Toast.LENGTH_SHORT).show()
            } else {
                btnSignUp.revertAnimation()
                Toast.makeText(context, "Login Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
