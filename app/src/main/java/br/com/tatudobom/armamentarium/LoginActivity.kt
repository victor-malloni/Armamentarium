package br.com.tatudobom.armamentarium

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.tatudobom.armamentarium.databinding.ActivityLoginBinding
import br.com.tatudobom.armamentarium.databinding.ActivityRecyclerTestBinding
import com.androidtasks.mainactivity.util.navTo
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val auth= FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.ETEmailAddress.text.toString()
            val password = binding.ETPassword.text.toString()

            funSignIn(email,password)

        }







    }

    private fun funSignIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                val intent = Intent(this, RecyclerTestActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"error autentication", Toast.LENGTH_SHORT).show()
            }
        }
    }
}