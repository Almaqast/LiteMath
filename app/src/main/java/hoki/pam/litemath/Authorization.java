package hoki.pam.litemath;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.net.Inet4Address;
import java.util.List;

public class Authorization extends AppCompatActivity {


    public static Authorization instance;
    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием*/
    private UserDao userDao;
    private EditText txtLogin;
    private EditText txtPassword;

     private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);


        //создание единого экземпрляра для бд, вместо постояной пересоздания экземпляров
        //database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        userDao = database.getUserDao();


        txtLogin = findViewById(R.id.txtLogin);
        txtPassword = findViewById(R.id.txtPassword);
        Button btn_registration = (Button)findViewById(R.id.btn_registration);
        Button btn_login = (Button)findViewById(R.id.btn_login);
        txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

//        final User user = new User();


        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEmpty()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(txtLogin.getText().toString(),
                                    txtPassword.getText().toString());
                            userDao.insert(user);
                           //startActivity(new Intent(Authorization.this, MainActivity.class));
                            Toast.makeText(Authorization.this, "Регистрация пройдена",Toast.LENGTH_SHORT).show();
                        }
                    }, 1000);
                }else{
                    Toast.makeText(Authorization.this, "Вы ввели неправильные данные или такие значения заняты",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!emptyValidation()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(txtLogin.getText().toString(),
                                    txtPassword.getText().toString());
                            if (user != null){
                                Intent intent = new Intent(Authorization.this, MainActivity.class);
                                intent.putExtra("User", user);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Authorization.this, "Логин или пароль введены неверно", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 1000);
                }else{
                    Toast.makeText(Authorization.this, "Error sing in",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)*/
    }

    private boolean isEmpty(){
        if (TextUtils.isEmpty(txtLogin.getText().toString()) ||
        TextUtils.isEmpty(txtPassword.getText().toString())){
            return true;
        }else{
            return false;
        }
    }

    private boolean emptyValidation(){
        if (TextUtils.isEmpty(txtLogin.getText().toString()) ||
        TextUtils.isEmpty(txtPassword.getText().toString())){
            return true;
        }else{
            return false;
        }
    }


//    public static Authorization getInstance(){
//        return instance;
//    }
//
//    public AppDatabase getDatabase(){
//        return database;
//    }

    //Измененние системной кнопки "назад"
    @Override
    public void onBackPressed() {

        //проверка на нажатие в течении 2сек, если нажато, то выйти
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel(); //закрываем сообщение "Нажмите еще раз"
            super.onBackPressed();
            return;
        }else{ //предепреждение о том что нужно для выхода нужно два нажатия
            backToast = Toast.makeText(getBaseContext(), "Нажмите еше раз, что бы выйти",
                    Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis(); //засекамем время нажатия на кнопку
    }
}
