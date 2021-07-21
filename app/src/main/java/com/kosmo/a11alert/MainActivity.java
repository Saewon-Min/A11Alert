package com.kosmo.a11alert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 대화창1 : 기본형(타이틀+내용)
    public void onBtn1Clicked(View v){
        MyAlert.AlertShow(MainActivity.this,"아이디를 입력해 주세요",
                "알림");
    }

    // 대화창2 : 상단 타이틀 없이 내용 부분만 출력됨
    public void onBtn2Clicked(View v){
        MyAlert.AlertShow(MainActivity.this,"패스워드를 입력해주세요");
    }

    /*
     대화창3 : 확인, 취소 버튼에 리스너 부착 후 동작할 내용 정의
     AlertDialog 창을 띄우는 절차
         1. AlertDialog.Builder 객체 생성0
         2. 생성자 함수를 통한 설정(타이틀, 메세지, 아이콘 등)
         3. 2에서 생성한 객체를 통해 create() 메소드 호출
         4. show() 호출을 통해 경고창을 띄움
     */
    public void onBtn3Clicked(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("앱을 종료하시겠습니까?")
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("알림")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    // Yes 버튼을 누르면 매개변수 i로 -1이 전달된다.
                    Toast.makeText(getApplicationContext(),
                            "Yes is "+Integer.toString(id),
                            Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    // No 버튼을 누르면 매개변수 i로 -2이 전달된다.
                    Toast.makeText(getApplicationContext(),
                            "No is "+Integer.toString(id),
                            Toast.LENGTH_SHORT).show();
                    //dialog.cancel();
                }
            });

        AlertDialog alert = builder.create();
        alert.show();

    }


}//// MainActivity