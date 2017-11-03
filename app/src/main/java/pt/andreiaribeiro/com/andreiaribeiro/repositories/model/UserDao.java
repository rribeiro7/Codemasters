package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * from user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user where id = :id")
    User getUser(int id);
}
