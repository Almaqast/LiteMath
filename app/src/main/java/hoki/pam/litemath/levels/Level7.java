package hoki.pam.litemath.levels;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import hoki.pam.litemath.ArrayLvl;
import hoki.pam.litemath.LvlMenu;
import hoki.pam.litemath.R;

public class Level7 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    Dialog dialogEndLosing;

    public int taskImg;
    ArrayLvl arrayLvl = new ArrayLvl(); //создание нового объекта из класса ArrayLvl
    Random random = new Random();
    public int count = 0; //счетчик правильных ответов
    public int flagAnswer = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7);

        TextView txt_lvls = findViewById(R.id.txt_lvls);
        txt_lvls.setText(R.string.Level7); // установили текст

        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)

        final Button btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level7.this, LvlMenu.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
            }
        });

        //подключение анимации
        final Animation animation = AnimationUtils.loadAnimation(Level7.this, R.anim.alpha);


        final ImageView imgTask = (ImageView)findViewById(R.id.imgTask);
        //скругляем углы загруженного изображения
        imgTask.setClipToOutline(true);

        //вызов диалогового окна при запуске уроня
        dialog = new Dialog(this); //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон за диалоговым окном
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false); // нельзя использовать системную кнопку Назад
        //кнопка закрыть д.о
        TextView btn_close = (TextView)dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level7.this, LvlMenu.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialog.dismiss();// закрываем д.о
            }
        });

        //кнопка продолжить
        Button btn_continue = (Button)dialog.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show(); //показать диалоговое окно

        ////////////////вызов д.о в конце игры при прохождении//////////////////////////////////////
        //вызов диалогового окна в конце уровня при прохождениичё
        dialogEnd = new Dialog(this); //создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.dialog_end);
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
                    Intent intent = new Intent(Level7.this, LvlMenu.class);
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
                    Intent intent = new Intent(Level7.this, Level8.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

        ////////////////вызов д.о в конце игры при пропровале//////////////////////////////////////
        //вызов диалогового окна в конце уровня при провале
        dialogEndLosing = new Dialog(this); //создаем новое диалоговое окно
        dialogEndLosing.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEndLosing.setContentView(R.layout.dialog_end_losing);
        dialogEndLosing.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон за диалоговым окном
        dialogEndLosing.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); //делаем д.о во весь экран
        dialogEndLosing.setCancelable(false); // нельзя использовать системную кнопку Назад
        //кнопка закрыть д.о
        TextView btn_close_end_losing = (TextView)dialogEndLosing.findViewById(R.id.btn_close_losing);
        btn_close_end_losing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level7.this, LvlMenu.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogEndLosing.dismiss();// закрываем д.о
            }
        });

        //кнопка продолжить
        Button btn_continue_end_losing = (Button)dialogEndLosing.findViewById(R.id.btn_continue_losing);
        btn_continue_end_losing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Level7.this, Level7.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogEndLosing.dismiss();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

        //делаем рандомный показ заданий
        taskImg = random.nextInt(5); //0-4
        flagAnswer = taskImg;
        imgTask.setImageResource(arrayLvl.task_lvl7[taskImg]); //добавляю картинку

        //кнопки с ответами
        final Button btn_left = (Button)findViewById(R.id.btn_left);
        final Button btn_right = (Button)findViewById(R.id.btn_right);

        btn_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //условие касания кнопки
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_right.setEnabled(false); //блок правой картинки
                    if ((flagAnswer == 0) || (flagAnswer == 1) || (flagAnswer == 2)){
                        btn_left.setBackgroundResource(R.drawable.green_true);
                    }
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if((flagAnswer == 0) || (flagAnswer == 1) || (flagAnswer == 2)){
                        count++;
                        btn_left.setBackgroundResource(R.drawable.style_points_green);
                        if (count == 1) {
                            //сохранение результата после выхода
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level", 1); //Level запоминает цифру и передает ее в level
                            if(level > 7){
                                //ничего
                            }else{
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level", 8); //пишем цифру след уровня
                                editor.commit();
                            }
                            dialogEnd.show(); //показ д.о в конце уровня при прохождении
                        }
                    }else if ((flagAnswer != 0) || (flagAnswer != 1) || (flagAnswer != 2)){
                        count = 0;
                        btn_left.setBackgroundResource(R.drawable.style_points_red);
                        if(count == 0){
                            dialogEndLosing.show();
                        }
                    }
                }
                btn_right.setEnabled(true); //снятие блока
                return true;
            }
        });

        btn_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //условие касания кнопки
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btn_left.setEnabled(false); //блок правой картинки
                    if ((flagAnswer == 3) || (flagAnswer == 4)){
                        btn_right.setBackgroundResource(R.drawable.green_true);
                    }
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if ((flagAnswer == 3) || (flagAnswer == 4)){
                        count++;
                        btn_right.setBackgroundResource(R.drawable.style_points_green);
                        if (count == 1) {
                            //сохранение результата после выхода
                            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                            final int level = save.getInt("Level", 1); //Level запоминает цифру и передает ее в level
                            if(level > 7){
                                //ничего
                            }else{
                                SharedPreferences.Editor editor = save.edit();
                                editor.putInt("Level", 8); //пишем цифру след уровня
                                editor.commit();
                            }
                            dialogEnd.show(); //показ д.о в конце уровня при прохождении
                        }
                    }else if ((flagAnswer != 3) || (flagAnswer != 4)){
                        count = 0;
                        btn_right.setBackgroundResource(R.drawable.style_points_red);
                        if(count == 0){
                            dialogEndLosing.show();
                        }
                    }
                }
                btn_left.setEnabled(true); //снятие блока
                return true;
            }
        });
    }

    //системная кнопка назад
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Level7.this, LvlMenu.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}