package br.com.tatudobom.armamentarium.view

import android.app.Application
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.adapter.ObraAdapter
import br.com.tatudobom.armamentarium.databinding.FragmentConstructionsBinding
import br.com.tatudobom.armamentarium.model.Obra
import br.com.tatudobom.armamentarium.repositories.ObraDatabase
import br.com.tatudobom.armamentarium.repositories.ObraRepository
import br.com.tatudobom.armamentarium.viewModel.ObraViewModel
import com.androidtasks.mainactivity.util.navTo
import kotlinx.android.synthetic.main.fragment_constructions.*

class Constructions : Fragment(R.layout.fragment_constructions),ObraAdapter.ObraClickListener {

    private lateinit var binding: FragmentConstructionsBinding
    private lateinit var database: ObraDatabase
    lateinit var viewModel: ObraViewModel
    lateinit var adapter: ObraAdapter
    lateinit var selectedObra: Obra



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConstructionsBinding.bind(view)
        initUI()
        /*initRecyclerView()*/

    }

    private fun initUI() {
        binding.RecyclerView.setHasFixedSize(true)
        binding.RecyclerView.layoutManager=StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        //binding.RecyclerView.adapter=adapter

        binding.BtnAddTools.setOnClickListener { navTo(R.id.newConstructions) }
    }

    override fun onItemClicked(obra: Obra) {
    navTo(R.id.detalhesObra)
    }

    override fun onLongItemClicked(obra: Obra, cardView: CardView) {
    selectedObra = obra
    }



    /*  private fun initRecyclerView() {
          RecyclerObra.layoutManager = LinearLayoutManager(context)
          RecyclerObra.adapter = this.obraAdapter

      }*/

}