package br.com.tatudobom.armamentarium.view

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.adapter.ObraAdapter
import br.com.tatudobom.armamentarium.databinding.FragmentConstructionsBinding
import br.com.tatudobom.armamentarium.repositories.ObraRepository
import br.com.tatudobom.armamentarium.viewModel.ObraViewModel
import com.androidtasks.mainactivity.util.navTo
import kotlinx.android.synthetic.main.fragment_constructions.*

class Constructions : Fragment(R.layout.fragment_constructions) {

    private lateinit var obraAdapter: ObraAdapter
    private val viewModel = ObraViewModel(application = Application())

    private lateinit var binding: FragmentConstructionsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentConstructionsBinding.bind(view)
        binding.BtnAddTools.setOnClickListener { navTo(R.id.newConstructions) }

        initRecyclerView()

    }

    private fun initRecyclerView() {

        RecyclerObra.layoutManager = LinearLayoutManager(context)
        RecyclerObra.adapter = this.obraAdapter

    }

}