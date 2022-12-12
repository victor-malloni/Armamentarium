package br.com.tatudobom.armamentarium

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.tatudobom.armamentarium.databinding.ActivityCreateNewToolBinding
import br.com.tatudobom.armamentarium.databinding.ActivityLoginBinding

class CreateNewToolActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNewToolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateNewToolBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelTool.setOnClickListener {
            val intent = Intent(this, NewConstructionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}