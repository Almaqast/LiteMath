package hoki.pam.litemath;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hoki.pam.litemath.levels.Level2;
import hoki.pam.litemath.levels.SpecialLevel1;
import hoki.pam.litemath.levels.SpecialLevel2;

public class SpecialLvlMenu extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_special_lvls);

        Button btnBack = (Button)findViewById(R.id.btnBack);
        TextView txtSpecialLvl1 = (TextView)findViewById(R.id.txtSpecialLvl1);
        TextView txtSpecialLvl2 = (TextView)findViewById(R.id.txtSpecialLvl2);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLvlMenu.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        txtSpecialLvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLvlMenu.this, SpecialLevel1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });
        txtSpecialLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLvlMenu.this, SpecialLevel2.class);
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
            Intent intent = new Intent(SpecialLvlMenu.this, MainActivity.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}
