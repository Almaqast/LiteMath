package hoki.pam.litemath;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.net.PasswordAuthentication;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String loginU;
    private String passwordU;

    public User(String loginU, String passwordU){
        this.loginU = loginU;
        this.passwordU = passwordU;
    }

    @NonNull
    public int getId(){
        return id;
    }
    public void setId(@NonNull int id){
        this.id = id;
    }
    public String getLoginU(){
        return loginU;
    }
    public void setLoginU(String loginU){
        this.loginU = loginU;
    }
    public String getPasswordU(){
        return passwordU;
    }
    public void setPasswordU(String Password){
        this.passwordU = passwordU;
    }
    @Override
    public String toString(){
        return "User{" +
                "id = " + id +
                ", loginU = '" + loginU + '\'' +
                ", passwordU = '" + passwordU + '\'' +
                '}';
    }
}
