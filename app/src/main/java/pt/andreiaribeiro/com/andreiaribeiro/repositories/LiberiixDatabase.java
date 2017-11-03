package pt.andreiaribeiro.com.andreiaribeiro.repositories;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class LiberiixDatabase extends RoomDatabase {

    private static LiberiixDatabase INSTANCE;

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    public static LiberiixDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LiberiixDatabase.class, "liberiix-db")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
