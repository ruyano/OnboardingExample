package br.com.ruyano.onboardingexample.view.forgot.password

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
import br.com.ruyano.onboardingexample.util.initToolbar
import br.com.ruyano.onboardingexample.view.sign.up.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_forgot_password.*
import kotlinx.android.synthetic.main.fragment_forgot_password.tilEmail
import kotlinx.android.synthetic.main.fragment_sign_up.*

class ForgotPasswordFragment : Fragment() {

    private lateinit var viewModel: ForgotPasswordViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forgot_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar(R.string.forgot_password, true)
        viewModel = ViewModelProviders.of(this).get(ForgotPasswordViewModel::class.java)

        tilEmail.addEmailValidation()
        btnRecoverPassword.setOnClickListener { recoverPassword() }
    }

    private fun recoverPassword() {
        btnRecoverPassword.startAnimation()
        viewModel.resetPassword().observe(this, Observer { done ->
            if (done) {
                val successIcon = BitmapFactory.decodeResource(resources, R.drawable.ic_done_white_48dp)
                btnRecoverPassword.doneLoadingAnimation(R.color.colorPrimary, successIcon)
                Toast.makeText(context, "Register success", Toast.LENGTH_SHORT).show()
            } else {
                btnRecoverPassword.revertAnimation()
                Toast.makeText(context, "Login Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
