package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProfessionalDao {

    @Query("SELECT * from professional")
    List<Professional> getAllProfessionals();

    @Query("SELECT * FROM professional where id = :id")
    User getProfessional(int id);

    @Insert
    void insertProfessional(Professional professional);

    @Delete
    void deleteProfessional(Professional professional);
}