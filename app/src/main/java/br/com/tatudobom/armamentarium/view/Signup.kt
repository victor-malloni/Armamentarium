package br.com.tatudobom.armamentarium.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.databinding.FragmentSignupBinding
import com.androidtasks.mainactivity.util.navTo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class Signup: Fragment(R.layout.fragment_signup) {

    private lateinit var binding: FragmentSignupBinding
    private var db = FirebaseFirestore.getInstance()
    private val auth= FirebaseAuth.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupBinding.bind(view)
        binding.btnCreateAccount.setOnClickListener{navTo(R.id.mainFragment)}

        binding.btnCreateAccount.setOnClickListener{
            val password = binding.ETPassword.text.toString()
            val confirmPassword = binding.ETConfirmPassword.text.toString()
            if (password == confirmPassword){
                funSignUp()
                funSaveData()
            } else{Toast.makeText(context,"Passwords do not match", Toast.LENGTH_LONG).show()}
        }
    }

    private fun funSaveData() {
        val email = binding.ETBuyersEmail.text.toString()
        val cellPhone = binding.ETCellPhoneNumber.text.toString()
        val buyersName = binding.ETBuyersName.text.toString()
        val companyName= binding.ETCompanyName.text.toString()

        val map = hashMapOf (
            "email" to email,
            "cellPhone" to cellPhone,
            "buyersName" to buyersName,
            "companyName" to companyName,
        )

        db.collection("accounts").document("user ${email}").set(map).addOnCompleteListener {
            if(it.isSuccessful){ }
            else{
                Toast.makeText(context,"error db", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun funSignUp() {
        val email = binding.ETBuyersEmail.text.toString()
        val password = binding.ETPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { register->
            if(register.isSuccessful){
                navTo(R.id.mainFragment)
            }
            else{
                Toast.makeText(context,"error", Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener { val message = when(it) {
                is FirebaseAuthWeakPasswordException -> "At least have a 6 digit password"
                is FirebaseAuthUserCollisionException -> "Ur account has already been created"
                else -> "error please try again"
            }
                Toast.makeText(context, "${message}", Toast.LENGTH_LONG).show() }
    }


}
