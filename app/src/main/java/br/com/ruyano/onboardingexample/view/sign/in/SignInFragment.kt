package br.com.ruyano.onboardingexample.view.sign.`in`

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.ruyano.onboardingexample.R
import br.com.ruyano.onboardingexample.databinding.FragmentSignInBinding
import br.com.ruyano.onboardingexample.util.addEmailValidation
import br.com.ruyano.onboardingexample.util.initToolbar
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {

    private lateinit var mViewModel: SignInViewModel
    private lateinit var mFragmentBinding: FragmentSignInBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mFragmentBinding = inflate(inflater, R.layout.fragment_sign_in, container, false)
        mViewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        mFragmentBinding.viewModel = mViewModel
        return mFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar(R.string.sign_in, true)
        setupClicks()
    }

    private fun setupClicks() {
        tilEmail.addEmailValidation()

        tvSingUp.setOnClickListener { findNavController().navigate(R.id.actionSignUp) }
        tvForgotPassword.setOnClickListener { findNavController().navigate(R.id.actionForgotPassword) }
        btnSignIn.setOnClickListener {
            requestSignIn(etEmail.text.toString(), etPassword.text.toString())
        }
    }

    private fun requestSignIn(userName: String?, password: String?) {
        btnSignIn.startAnimation()
        mViewModel.doLogin().observe(
            this,
            Observer { done ->
                if (done) {
                    val successIcon = BitmapFactory.decodeResource(resources, R.drawable.ic_done_white_48dp)
                    btnSignIn.doneLoadingAnimation(R.color.colorPrimary, successIcon)
                    findNavController().navigate(R.id.actionGoToHome)
                } else {
                    Toast.makeText(context, "Login Error", Toast.LENGTH_SHORT).show()
                    btnSignIn.revertAnimation()
                }
            }
        )
    }

}
