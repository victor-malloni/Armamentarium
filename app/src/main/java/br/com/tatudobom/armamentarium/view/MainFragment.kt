package br.com.tatudobom.armamentarium.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.databinding.FragmentMainBinding
import com.androidtasks.mainactivity.util.navTo
import com.google.firebase.auth.FirebaseAuth

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val auth= FirebaseAuth.getInstance()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        binding.btnSignup.setOnClickListener{navTo(R.id.signup)}

        binding.btnLogin.setOnClickListener{
            val email = binding.ETEmailAddress.text.toString()
            val password = binding.ETPassword.text.toString()

            funSignIn(email,password)

        }
    }

    private fun funSignIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                findNavController().navigate(R.id.constructions)
            }
            else{
                Toast.makeText(context,"error autentication", Toast.LENGTH_SHORT).show()
            }
        }
    }


}

