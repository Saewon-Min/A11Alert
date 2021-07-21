package com.kosmo.a11alert;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

public class MyAlert {


    // 1번 경고창 : 타이틀, 내용, 확인 버튼 있음
    public static void AlertShow(Context context, String msg, String title){
        // 경고창을 띄우기 위한 객체 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 아이콘 설정(기본 이미지 사용)
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        // 제목 설정
        builder.setTitle(title);
        // 안드로이드의 물리적 Back버튼에 대한 동작 방식 설정
        /*
            FALSE로 설정하면 AlertDialog를 띄운 상태에서 BACK 버튼을 눌렀을때
            대화창이 닫히지 않게 해준다.
            TRUE로 지정한 경우에는 닫히게 된다. 또한 여백을 눌러도 닫히게 된다.
         */
        builder.setCancelable(false);
        builder.setMessage("\n"+msg+"\n");
        // 확인버튼
        builder.setPositiveButton("확인",null);

        // 위에서 설정한 내용으로 대화창을 생성하고 화면에 표시한다.
        AlertDialog alert = builder.create();
        alert.show();

        /*
        아래 부분은 메세지를 가운데 정렬하기 위한 설정이다.
        주석처리하면 좌측 정렬됨
         */
        /*TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);*/


    }

    // 2번 경고창 : 내용만 있음. 오버로딩 해서 메소드 정의함
    public static void AlertShow(Context context, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // TRUE일 경우 back버튼을 눌렀을때 대화창이 닫힘. 여백을 눌러도 닫힘
        builder.setCancelable(true);
        // 메세지 설정
        builder.setMessage("\n"+msg+"\n");
        // 확인 버튼
        builder.setPositiveButton("확인",null);

        AlertDialog alert = builder.create();
        alert.show();

        // Alert
        TextView messageView = (TextView)alert.findViewById(android.R.id.message);
        messageView.setGravity(Gravity.CENTER);

    }
}
