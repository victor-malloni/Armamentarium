package br.com.tatudobom.armamentarium.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.tatudobom.armamentarium.model.Obra
import br.com.tatudobom.armamentarium.util.DATABASE_NAME

@Database(entities = arrayOf(Obra::class), version = 4, exportSchema = false)
abstract class ObraDatabase : RoomDatabase() {
    abstract fun getObraDao(): ObraDao

    companion object {
        @Volatile
        private var INSTANCE: ObraDatabase? = null

        fun getDatabase(context: Context): ObraDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ObraDatabase::class.java, DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }


    }

}
