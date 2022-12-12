package br.com.tatudobom.armamentarium.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.databinding.FragmentCreateNewToolBinding
import br.com.tatudobom.armamentarium.databinding.FragmentDetalhesObraBinding

class DetalhesObra : Fragment(R.layout.fragment_detalhes_obra) {

    private lateinit var binding: FragmentDetalhesObraBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetalhesObraBinding.bind(view)
    }
}
