package pt.andreiaribeiro.com.andreiaribeiro.repositories;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalDao;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.Professional;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.Services;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ServicesDao;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.User;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserDao;

@Database(entities = {Professional.class, Services.class, User.class}, version = 1)
public abstract class LiberiixDatabase extends RoomDatabase {

    private static LiberiixDatabase INSTANCE;

    public static LiberiixDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), LiberiixDatabase.class, "liberiix-db")
                            .build();
        }
        return INSTANCE;
    }

    public void destroyInstance() {
        INSTANCE = null;
    }

    public abstract ProfessionalDao professionalDao();

    public abstract ServicesDao servicesDao();

    public abstract UserDao userDao();

}
