package id.smaraputra.tugasroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import id.smaraputra.tugasroom.dao.MahasiswaDao;
import id.smaraputra.tugasroom.model.MahasiswaModel;

@Database(entities = {MahasiswaModel.class}, version  = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getDbInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "mahasiswadb")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}