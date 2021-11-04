package hoki.pam.litemath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import hoki.pam.litemath.levels.InfoAuthor;
import hoki.pam.litemath.levels.Level2;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLvlMenu = (Button)findViewById(R.id.btnLvlMenu);
        Button btnArcana = (Button)findViewById(R.id.btnArcana);
        Button btnAuthor = (Button)findViewById(R.id.btnAuthor);
       // Button btnSetting = (Button)findViewById(R.id.btnSetting);

        //создаем действие при нажатии кнопки
        btnLvlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //переход на другой активити + проверка что бы не вылетело
                try {
                    Intent intent = new Intent(MainActivity.this, LvlMenu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });
        btnArcana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //переход на другой активити + проверка что бы не вылетело
                try {
                    Intent intent = new Intent(MainActivity.this, SpecialLvlMenu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });
        btnAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, InfoAuthor.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });





        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)
    }
    //Измененние системной кнопки "назад"
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(MainActivity.this, Authorization.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
    }
}
