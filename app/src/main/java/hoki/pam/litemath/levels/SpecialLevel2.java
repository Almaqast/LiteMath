package hoki.pam.litemath.levels;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hoki.pam.litemath.ArrayLvl;
import hoki.pam.litemath.MainActivity;
import hoki.pam.litemath.R;
import hoki.pam.litemath.SpecialLvlMenu;

public class SpecialLevel2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogJumpLvl;
    Dialog dialogFake;
    private long backPressedTime;
    private Toast backToast; //нужна для того что бы сообщение о выходе пропадало сразу с закрытием
    ArrayLvl img_special_task = new ArrayLvl();
    public int NumberArray = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_lvl2);

        Window winUp = getWindow();
        winUp.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //убираем строку состояния(верх)

        //вызов диалогового окна при запуске уроня
        dialog = new Dialog(this); //создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog);
        ImageView preview_img = (ImageView) dialog.findViewById(R.id.preview_img);
        preview_img.setImageResource(R.drawable.preview_special_lvl_img);
        TextView txt_description = (TextView) dialog.findViewById(R.id.txt_description);
        txt_description.setText(R.string.description_special_all_lvl);
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
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLvlMenu.class);
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

        ////////////////вызов д.о в конце игры при пропровале//////////////////////////////////////
        //вызов диалогового окна в конце уровня при провале
        dialogFake = new Dialog(this); //создаем новое диалоговое окно
        dialogFake.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogFake.setContentView(R.layout.dialog_end_losing);
        dialogFake.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон за диалоговым окном
        dialogFake.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT); //делаем д.о во весь экран
        dialogFake.setCancelable(false); // нельзя использовать системную кнопку Назад
        //кнопка закрыть д.о
        TextView btn_close_end_losing = (TextView)dialogFake.findViewById(R.id.btn_close_losing);
        btn_close_end_losing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLevel2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogFake.dismiss();// закрываем д.о
            }
        });

        //кнопка продолжить
        Button btn_continue_end_losing = (Button)dialogFake.findViewById(R.id.btn_continue_losing);
        btn_continue_end_losing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLevel2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogFake.dismiss();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////


        //////////////////////д.о после нахождения замка////////////////////////////////////////////
        dialogJumpLvl = new Dialog(this); //создаем новое диалоговое окно
        dialogJumpLvl.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogJumpLvl.setContentView(R.layout.dialog_special_lvl_task);
        dialogJumpLvl.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон за диалоговым окном
        dialogJumpLvl.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogJumpLvl.setCancelable(false); // нельзя использовать системную кнопку Назад
        dialogJumpLvl.findViewById(R.id.txt_description_special_task);
        TextView txt_description_special_task = (TextView)dialogJumpLvl.findViewById(R.id.txt_description_special_task);
        txt_description_special_task.setText(R.string.task_special_lvl1);
        //кнопка закрыть д.о
        TextView btn_close_special_task = (TextView)dialogJumpLvl.findViewById(R.id.btn_close_special_task);
        btn_close_special_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLevel2.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }
                dialogJumpLvl.dismiss();// закрываем д.о
            }
        });

        //кнопка продолжить
        Button btn_continue_special_task = (Button)dialogJumpLvl.findViewById(R.id.btn_continue_special_task);
        btn_continue_special_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLevel2Task1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogJumpLvl.dismiss();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////


        TextView txt_name_lvl = (TextView)findViewById(R.id.txt_name_lvl);
        txt_name_lvl.setText(R.string.name_special_lvl1);

        Button btn_back = (Button)findViewById(R.id.btn_back);
        Button btn_special_inv_lvl1 = (Button)findViewById(R.id.btn_special_inv_lvl2);
        Button fake1 = (Button)findViewById(R.id.fake1);
        Button fake2 = (Button)findViewById(R.id.fake2);
        Button fake3 = (Button)findViewById(R.id.fake3);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(SpecialLevel2.this, SpecialLvlMenu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        fake1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFake.show();
            }
        });
        fake2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFake.show();
            }
        });
        fake3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFake.show();
            }
        });

        btn_special_inv_lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogJumpLvl.show();
            }
        });



    }


    //Измененние системной кнопки "назад"
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(SpecialLevel2.this, SpecialLvlMenu.class);
            startActivity(intent);
            finish();

        }catch (Exception e){

        }
    }
}
