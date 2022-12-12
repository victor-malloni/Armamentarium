package br.com.tatudobom.armamentarium.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.databinding.FragmentCreateNewToolBinding
import com.androidtasks.mainactivity.util.navTo

class CreateNewTool : Fragment(R.layout.fragment_create_new_tool) {
    private lateinit var binding: FragmentCreateNewToolBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateNewToolBinding.bind(view)
        binding.btnCancelTool.setOnClickListener { navTo(R.id.newConstructions) }
        binding.btnCreateTool.setOnClickListener { navTo(R.id.newConstructions) }
    }
}