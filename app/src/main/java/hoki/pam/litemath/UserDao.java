package hoki.pam.litemath;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//Dao предстовляет методы, которые остальная часть приложения использует
// для взаимодействия с даннысм в user таблице
@Dao
public interface UserDao{
    @Query("SELECT * FROM User where loginU= :login and passwordU= :passwordU")
    User getUser(String login, String passwordU);

    @Insert
    void  insert(User user);

    @Delete
    void delete(User user);
}