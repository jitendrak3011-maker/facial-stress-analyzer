import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StressData::class], version = 1)
abstract class StressDatabase : RoomDatabase() {
    abstract fun stressDao(): StressDao

    companion object {
        @Volatile
        private var INSTANCE: StressDatabase? = null

        fun getDatabase(context: Context): StressDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StressDatabase::class.java,
                    "stress_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}