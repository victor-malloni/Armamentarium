package br.com.tatudobom.armamentarium

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.tatudobom.armamentarium.databinding.ActivityNewConstructionsBinding
import br.com.tatudobom.armamentarium.databinding.ActivitySignUpBinding
import com.androidtasks.mainactivity.util.navTo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private var db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCreateAccount.setOnClickListener {
            val password = binding.ETPassword.text.toString()
            val confirmPassword = binding.ETConfirmPassword.text.toString()
            if (password == confirmPassword) {
                funSignUp()
                funSaveData()
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_LONG).show()
            }

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
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
                Toast.makeText(this,"error db", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun funSignUp() {
        val email = binding.ETBuyersEmail.text.toString()
        val password = binding.ETPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { register->
            if(register.isSuccessful){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener { val message = when(it) {
                is FirebaseAuthWeakPasswordException -> "At least have a 6 digit password"
                is FirebaseAuthUserCollisionException -> "Ur account has already been created"
                else -> "error please try again"
            }
                Toast.makeText(this, "${message}", Toast.LENGTH_LONG).show() }

    }
}