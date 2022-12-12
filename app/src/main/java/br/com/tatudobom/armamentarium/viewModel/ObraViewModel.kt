package br.com.tatudobom.armamentarium.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.tatudobom.armamentarium.model.Obra
import br.com.tatudobom.armamentarium.repositories.ObraDatabase
import br.com.tatudobom.armamentarium.repositories.ObraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ObraViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ObraRepository
    val allObras: LiveData<List<Obra>>

    init {
        val dao = ObraDatabase.getDatabase(application).getObraDao()
        repository = ObraRepository(dao)
        allObras = repository.allObras
    }

    fun insertObra(obra: Obra) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(obra)
    }

    fun deleteObra(obra: Obra) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(obra)
    }

    /*fun updateObra(obra: Obra) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(obra)
    }*/


}