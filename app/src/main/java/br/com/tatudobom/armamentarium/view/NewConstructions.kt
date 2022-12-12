package br.com.tatudobom.armamentarium.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.tatudobom.armamentarium.R
import br.com.tatudobom.armamentarium.databinding.FragmentNewConstructionsBinding
import com.androidtasks.mainactivity.util.navTo

class NewConstructions : Fragment(R.layout.fragment_new_constructions) {
    private lateinit var binding: FragmentNewConstructionsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewConstructionsBinding.bind(view)
        binding.btnCheck.setOnClickListener{navTo(R.id.constructions)}
        binding.btnCreateNewTool.setOnClickListener{
            navTo(R.id.createNewTool)
        }
    }
}