/*
package hoki.pam.litemath;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import hoki.pam.litemath.levels.InfoAuthor;

public class Setting extends AppCompatActivity {

    public Boolean flagBack = true;
    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием
    public int count = 0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        final ImageView background = (ImageView)findViewById(R.id.background);
        final ImageView back_one = (ImageView)findViewById(R.id.back_one);
        final ImageView back_two = (ImageView)findViewById(R.id.back_two);
        Button btn_back = (Button)findViewById(R.id.btn_back);



        back_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(count >= 1){
                    background.setImageResource(R.drawable.backgraund);
                }
            }
        });

        back_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                if(count == 0){
                    background.setImageResource(R.drawable.backgraund2);
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Setting.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });





        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)
    }

    public boolean flag_background_true(){
        return true;
    }

    public boolean flag_background_flase(){
        return false;
    }


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
*/
