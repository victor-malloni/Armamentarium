package br.com.tatudobom.armamentarium.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity (tableName = "ObrasTable")
data class Obra(
    @PrimaryKey(autoGenerate = true)val id:Int?,
    @ColumnInfo (name = "nomeObra")val nomeObra: String?,
    @ColumnInfo (name = "endereco")val endereco: String?,
    @ColumnInfo (name = "chaveDeFenda")val chaveDeFenda: Int?,
    @ColumnInfo (name = "serraTicoTico")val serraTicoTico: Int?,
    @ColumnInfo (name = "marteloDeUnha")val marteloDeUnha: Int?,
    @ColumnInfo (name = "quantidadeFerramentas")val quantidadeFerramentas: Int=chaveDeFenda!!+serraTicoTico!!+marteloDeUnha!!
)
