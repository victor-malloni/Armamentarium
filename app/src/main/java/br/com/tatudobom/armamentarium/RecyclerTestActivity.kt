package br.com.tatudobom.armamentarium

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.tatudobom.armamentarium.adapter.ObraAdapter
import br.com.tatudobom.armamentarium.databinding.ActivityRecyclerTestBinding
import br.com.tatudobom.armamentarium.model.Obra
import br.com.tatudobom.armamentarium.repositories.ObraDatabase
import br.com.tatudobom.armamentarium.viewModel.ObraViewModel

class RecyclerTestActivity : AppCompatActivity(), ObraAdapter.ObraClickListener {

    private lateinit var binding: ActivityRecyclerTestBinding
    private lateinit var database: ObraDatabase
    lateinit var viewModel: ObraViewModel
    lateinit var adapter: ObraAdapter
    lateinit var selectedObra: Obra
    private val updateObra =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK){
                val obra = result.data?.getSerializableExtra("obra") as? Obra
                if (obra != null) {
                    viewModel.updateObra(obra)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(ObraViewModel::class.java)

        viewModel.allObras.observe(this){list ->
            list?.let {

                adapter.updateList(list)
            }
        }
        database = ObraDatabase.getDatabase(this)



    }

    private fun initUI() {
        binding.RecyclerView.setHasFixedSize(true)
        binding.RecyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        adapter = ObraAdapter(this, this)
        binding.RecyclerView.adapter = adapter

        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val obra = result.data?.getSerializableExtra("obra") as? Obra
                    if (obra != null) {
                        viewModel.insertObra(obra)
                    }
                }
            }

        binding.BtnAddTools.setOnClickListener {
            val intent = Intent(this, ObraSingleActivity::class.java)
            getContent.launch(intent)
        }



    }

    override fun onItemClicked(obra: Obra) {

        val intent = Intent(this@RecyclerTestActivity, ObraSingleActivity::class.java)
        //intent.putExtra("currentObra", obra)
        updateObra.launch(intent)


    }

    override fun onLongItemClicked(obra: Obra, cardView: CardView) {

        selectedObra = obra
        //popUpDisplay(cardView)

    }
}