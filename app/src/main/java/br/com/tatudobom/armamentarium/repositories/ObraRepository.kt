package br.com.tatudobom.armamentarium.repositories

import androidx.lifecycle.LiveData
import br.com.tatudobom.armamentarium.model.Obra

class ObraRepository(private val obraDao: ObraDao) {

    val allObras: LiveData<List<Obra>> = obraDao.getAllObras()


    suspend fun insert(obra: Obra){
        obraDao.insert(obra)
    }
    suspend fun delete(obra: Obra){
        obraDao.delete(obra)
    }

    suspend fun update(obra: Obra) {
        obraDao.update(obra.id, obra.nomeObra, obra.endereco)
    }

}
