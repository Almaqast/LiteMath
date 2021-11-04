package hoki.pam.litemath.levels;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hoki.pam.litemath.LvlMenu;
import hoki.pam.litemath.MainActivity;
import hoki.pam.litemath.R;
//import hoki.pam.litemath.Setting;
import hoki.pam.litemath.SpecialLvlMenu;

public class InfoAuthor extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_author);

        Button btn_back = (Button)findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(InfoAuthor.this, MainActivity.class);
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
            Intent intent = new Intent(InfoAuthor.this, MainActivity.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}
