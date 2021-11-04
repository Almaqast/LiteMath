package hoki.pam.litemath.levels;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import hoki.pam.litemath.ArrayLvl;
import hoki.pam.litemath.MainActivity;
import hoki.pam.litemath.R;
import hoki.pam.litemath.SpecialLvlMenu;

public class SpecialLevel2Task1 extends AppCompatActivity {

    Dialog dialogEnd;
    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием
    Random random = new Random();
    ArrayLvl arrayLvl_special_lvl = new ArrayLvl();
    public int numLeft;
    public int numRight;
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__special_lvl2_task1);

        TextView txt_special_task_lvl1 = (TextView)findViewById(R.id.txt_special_task_lvl2);
        txt_special_task_lvl1.setText(R.string.lvl1_special);

        Button btn_back_special_task_lvl1 = (Button)findViewById(R.id.btn_back_special_task_lvl2);

        btn_back_special_task_lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2Task1.this, SpecialLevel2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        //массив прогресса
        final int[] pointLvl ={
                R.id.point1_special_task,
                R.id.point2_special_task,
                R.id.point3_special_task,
                R.id.point4_special_task,
                R.id.point5_special_task,
                R.id.point6_special_task,
                R.id.point7_special_task,
                R.id.point8_special_task,
                R.id.point9_special_task,
                R.id.point10_special_task,
        };


        ////////////////вызов д.о в конце игры при прохождении//////////////////////////////////////
        //вызов диалогового окна в конце уровня при прохождениичё
        dialogEnd = new Dialog(this); //создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end);
        TextView txt_end_descripton_win = (TextView) dialogEnd.findViewById(R.id.txt_end_descripton_win);
        txt_end_descripton_win.setText(R.string.description_special);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон за диалоговым окном
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); //делаем д.о во весь экран

        dialogEnd.setCancelable(false); // нельзя использовать системную кнопку Назад
        //кнопка закрыть д.о
        TextView btn_close_end_lvl = (TextView)dialogEnd.findViewById(R.id.btn_close_win);
        btn_close_end_lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2Task1.this, SpecialLvlMenu.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogEnd.dismiss();// закрываем д.о
            }
        });

        //кнопка продолжить
        Button btn_continue_end_lvl = (Button)dialogEnd.findViewById(R.id.btn_continue_win);
        btn_continue_end_lvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2Task1.this, SpecialLvlMenu.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////




        //подключение анимации
        final Animation animation = AnimationUtils.loadAnimation(SpecialLevel2Task1.this, R.anim.alpha);

        final ImageView imgTask_left_special_lvl1 = (ImageView)findViewById(R.id.imgTask_top_special_task_lvl2);
        final ImageView imgTask_right_special_lvl1 = (ImageView)findViewById(R.id.imgTask_bot_special_task_lvl2);
        imgTask_left_special_lvl1.setClipToOutline(true);
        imgTask_right_special_lvl1.setClipToOutline(true);


        numLeft = random.nextInt(6);
        imgTask_left_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numLeft]);

        numRight = random.nextInt(6);
        while(numLeft == numRight){
            numRight = random.nextInt(6);
        }

        imgTask_right_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numRight]);


        imgTask_left_special_lvl1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    imgTask_right_special_lvl1.setEnabled(false);
                    if(numLeft > numRight){
                        imgTask_left_special_lvl1.setImageResource(R.drawable.green_true);

                    }else{
                        imgTask_left_special_lvl1.setImageResource(R.drawable.red_false);
                    }

                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(numLeft > numRight){
                        if(count < 10){
                            count++;
                        }
                        for(int i = 0; i < 10; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i = 0; i < count; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else{
                        if(numLeft < numRight){
                            if(count > 0){
                                if(count == 0){
                                    count = 0;
                                }
                                else{
                                    count -=2;
                                }
                            }
                            for(int i = 0; i < 9; i++){
                                TextView textViewPoint = findViewById(pointLvl[i]);
                                textViewPoint.setBackgroundResource(R.drawable.style_points);
                            }
                            for(int i = 0; i < count; i++){
                                TextView textViewPoint = findViewById(pointLvl[i]);
                                textViewPoint.setBackgroundResource(R.drawable.style_points_green);
                            }
                        }
                    }
                    if(count == 10){
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(6);
                        imgTask_left_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numLeft]);
                        imgTask_left_special_lvl1.startAnimation(animation);

                        numRight = random.nextInt(6);
                        while(numLeft == numRight){
                            numRight = random.nextInt(6);
                        }

                        imgTask_right_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numRight]);
                        imgTask_right_special_lvl1.startAnimation(animation);

                        imgTask_right_special_lvl1.setEnabled(true);
                    }
                }
                return true;
            }
        });

        imgTask_right_special_lvl1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    imgTask_left_special_lvl1.setEnabled(false);
                    if(numLeft < numRight){
                        imgTask_right_special_lvl1.setImageResource(R.drawable.green_true);

                    }else{
                        imgTask_right_special_lvl1.setImageResource(R.drawable.red_false);
                    }

                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(numLeft < numRight){
                        if(count < 10){
                            count++;
                        }
                        for(int i = 0; i < 10; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i = 0; i < count; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else{
                        if(count > 0){
                            if(count == 0){
                                count = 0;
                            }
                            else{
                                count -=2;
                            }
                        }
                        for(int i = 0; i < 9; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i = 0; i < count; i++){
                            TextView textViewPoint = findViewById(pointLvl[i]);
                            textViewPoint.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if(count == 10){
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(6);
                        imgTask_left_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numLeft]);
                        imgTask_left_special_lvl1.startAnimation(animation);

                        numRight = random.nextInt(6);
                        while(numLeft == numRight){
                            numRight = random.nextInt(6);
                        }

                        imgTask_right_special_lvl1.setImageResource(arrayLvl_special_lvl.img_sp_task_lvl2[numRight]);
                        imgTask_right_special_lvl1.startAnimation(animation);

                        imgTask_left_special_lvl1.setEnabled(true);
                    }
                }
                return true;
            }
        });



        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)
    }

    //Измененние системной кнопки "назад"
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(SpecialLevel2Task1.this, SpecialLvlMenu.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}
