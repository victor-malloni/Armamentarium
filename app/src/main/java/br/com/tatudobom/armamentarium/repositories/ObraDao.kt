package br.com.tatudobom.armamentarium.repositories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.tatudobom.armamentarium.model.Obra

@Dao
interface ObraDao {
    @Insert//(onConflict = onConflictStrategy.REPLACE)
    suspend fun insert(obra: Obra)
    @Delete
    suspend fun delete(obra: Obra)
    @Query("SELECT * FROM ObrasTable ORDER BY id ASC")
    fun getAllObras():LiveData<List<Obra>>
}