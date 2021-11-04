package hoki.pam.litemath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hoki.pam.litemath.levels.Level1;
import hoki.pam.litemath.levels.Level10;
import hoki.pam.litemath.levels.Level2;
import hoki.pam.litemath.levels.Level3;
import hoki.pam.litemath.levels.Level4;
import hoki.pam.litemath.levels.Level5;
import hoki.pam.litemath.levels.Level6;
import hoki.pam.litemath.levels.Level7;
import hoki.pam.litemath.levels.Level8;
import hoki.pam.litemath.levels.Level9;

public class LvlMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_lvls);

        //объявление переменной лвл
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1); //level будет хранить значение последнего пройленного уровня

        //растягиваем приложение во весь экран
        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)

        //Переход назад
        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //переход в главное меню
                try {
                    Intent intent = new Intent(LvlMenu.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });

        //Переход на первый уровень
        TextView txtLvl1 = (TextView)findViewById(R.id.txtLvl1);
        TextView txtLvl2 = (TextView)findViewById(R.id.txtLvl2);
        TextView txtLvl3 = (TextView)findViewById(R.id.txtLvl3);
        TextView txtLvl4 = (TextView)findViewById(R.id.txtLvl4);
        TextView txtLvl5 = (TextView)findViewById(R.id.txtLvl5);
        TextView txtLvl6 = (TextView)findViewById(R.id.txtLvl6);
        TextView txtLvl7 = (TextView)findViewById(R.id.txtLvl7);
        TextView txtLvl8 = (TextView)findViewById(R.id.txtLvl8);
        TextView txtLvl9 = (TextView)findViewById(R.id.txtLvl9);
        TextView txtLvl10 = (TextView)findViewById(R.id.txtLvl10);

        txtLvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 1) {
                        Intent intent = new Intent(LvlMenu.this, Level1.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 2) {
                        Intent intent = new Intent(LvlMenu.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 3) {
                        Intent intent = new Intent(LvlMenu.this, Level3.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 4) {
                        Intent intent = new Intent(LvlMenu.this, Level4.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 5) {
                        Intent intent = new Intent(LvlMenu.this, Level5.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 6) {
                        Intent intent = new Intent(LvlMenu.this, Level6.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 7) {
                        Intent intent = new Intent(LvlMenu.this, Level7.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 8) {
                        Intent intent = new Intent(LvlMenu.this, Level8.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //ничего
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 9) {
                        Intent intent = new Intent(LvlMenu.this, Level9.class);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e){

                }
            }
        });

        txtLvl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (level >= 10) {
                        Intent intent = new Intent(LvlMenu.this, Level10.class);
                        startActivity(intent);
                        finish();
                    }
                }catch (Exception e){

                }
            }
        });


        // массив кнопок с уровнями
        // для того чтобы открывать уровни
        final int[] x = {
                R.id.txtLvl1,
                R.id.txtLvl2,
                R.id.txtLvl3,
                R.id.txtLvl4,
                R.id.txtLvl5,
                R.id.txtLvl6,
                R.id.txtLvl7,
                R.id.txtLvl8,
                R.id.txtLvl9,
                R.id.txtLvl10,
        };
        //расставляем цифры по порядку
        for(int i = 1; i < level; i++){
            TextView textView = findViewById(x[i]);
            textView.setText(""+(i + 1)); //i + 1 ибо массив начинается с 0
        }
    }




    //изменение системной кнопки назад, делаем такой же как и кнопка "назад" интерфейса
    @Override
    public void onBackPressed(){
        //переход в главное меню
        try {
            Intent intent = new Intent(LvlMenu.this, MainActivity.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}