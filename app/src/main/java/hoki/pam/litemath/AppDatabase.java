package hoki.pam.litemath;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {User.class}, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
         public  abstract UserDao getUserDao();
    //создание экземпляра бд

}
