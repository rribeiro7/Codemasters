package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ProfessionalDao {

    @Query("SELECT * from professional")
    List<ProfessionalModel> getAllProfessionals();

    @Query("SELECT * FROM professional where id = :id")
    UserModel getProfessional(int id);

    @Insert
    void insertProfessional(ProfessionalModel professional);

    @Delete
    void deleteProfessional(ProfessionalModel professional);
}
