package br.com.tatudobom.armamentarium

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.tatudobom.armamentarium.databinding.ActivityNewConstructionsBinding
import br.com.tatudobom.armamentarium.databinding.ActivityRecyclerTestBinding
import br.com.tatudobom.armamentarium.model.Obra

class NewConstructionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewConstructionsBinding
    private lateinit var obra: Obra
    private lateinit var oldObra: Obra

    var isUpdateBoolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewConstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        try {
            oldObra = intent.getSerializableExtra("currentObra") as Obra
            binding.ETConstName.setText(oldObra.nomeObra)
            //Bellow to retrieve data from my TextView on MainActivity see more on NoteAdapter
            binding.ETConstEndereco.setText(oldObra.endereco)

            isUpdateBoolean = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.btnCreateNewTool.setOnClickListener {
            val intent = Intent(this, CreateNewToolActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnCheck.setOnClickListener {
            val nomeObra = binding.ETConstName.text.toString()
            val endereco = binding.ETConstEndereco.text.toString()
            val quantidadeChaveDeFenda = binding.ETQuantityChave.text.toString()
            val quantidadeSerraTicoTico = binding.ETQuantitySerra.text.toString()
            val quantidadeMarteloDeUnha = binding.ETQuantityMartelo.text.toString()

            if (nomeObra.isNotEmpty() || endereco.isNotEmpty()) {
                if (isUpdateBoolean) {
                    obra = Obra(
                        oldObra.id, nomeObra, endereco, quantidadeMarteloDeUnha, quantidadeSerraTicoTico, quantidadeChaveDeFenda
                    )
                } else {
                    obra = Obra(
                        null, nomeObra, endereco, quantidadeMarteloDeUnha, quantidadeSerraTicoTico, quantidadeChaveDeFenda
                    )
                }

                val intent = Intent()
                intent.putExtra("obra", obra)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                //Toast.makeText(this@AcitivtyDaObra, "We need data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
        /*binding.imgBackArrowIcon.setOnClickListener {
            onBackPressed()
        }*/





    }
}