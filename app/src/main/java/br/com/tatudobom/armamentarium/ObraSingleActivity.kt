package br.com.tatudobom.armamentarium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.tatudobom.armamentarium.databinding.ActivityObraSingleBinding
import br.com.tatudobom.armamentarium.model.Obra

class ObraSingleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObraSingleBinding
    private lateinit var obra: Obra
    private lateinit var oldObra: Obra

    var isUpdateBoolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObraSingleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            oldObra = intent.getSerializableExtra("currentObra") as Obra
            binding.tvEndereco.setText(oldObra.endereco)
            //Bellow to retrieve data from my TextView on MainActivity see more on NoteAdapter
            binding.TVConstDetailName.setText(oldObra.nomeObra)
            //binding.tvRANDOM.setText(oldObra.quantidadeFerramentas)

            isUpdateBoolean = true
        }
        catch (e: Exception) {
            e.printStackTrace()
        }

    }
}