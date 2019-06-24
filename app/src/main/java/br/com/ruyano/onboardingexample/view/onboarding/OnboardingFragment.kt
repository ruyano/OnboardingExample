package br.com.ruyano.onboardingexample.view.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.ruyano.onboardingexample.R
import br.com.ruyano.onboardingexample.util.initToolbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_onboarding.view.*

class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_onboarding, container, false)

        rootView.btnSignIn.setOnClickListener { findNavController().navigate(R.id.actionSignIn) }
        rootView.btnSignUp.setOnClickListener { findNavController().navigate(R.id.actionSignUp) }

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initToolbar(R.string.app_name, false)

        if (FirebaseAuth.getInstance().currentUser != null) {
            findNavController().navigate(R.id.actionGoToHome)
        }
    }

}
