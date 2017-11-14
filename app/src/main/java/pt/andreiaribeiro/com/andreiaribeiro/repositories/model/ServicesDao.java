package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ServicesDao {

    @Query("SELECT * from services")
    List<Services> getAllServices();

    @Query("SELECT * FROM services where id = :id")
    Services getService(int id);

    @Insert
    void insertService(Services services);

    @Delete
    void deleteService(Services services);
}
