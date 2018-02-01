package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * from user")
    List<UserModel> getAllUsers();

    @Query("SELECT * FROM user where id = :id")
    UserModel getUser(int id);

    @Insert
    void insertUser(UserModel user);

    @Delete
    void deleteUser(UserModel user);
}
