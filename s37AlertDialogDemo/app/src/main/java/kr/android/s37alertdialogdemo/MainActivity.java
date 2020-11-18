package kr.android.s37alertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //이벤트 핸들러
    public void onClick(View view) {
        new AlertDialog.Builder(this)
                       .setTitle("대화 상자")
                       .setMessage("안녕하세요")
                       .setCancelable(false)    //back버튼 눌러도 사라지지않음
                       .setNeutralButton("닫기", new DialogInterface.OnClickListener() {  //닫기버튼의 이벤트리스너 익명객체로 등록
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               //AlertDialog가 닫힐 때 호출됨 - 이 경우엔 창 닫힐 때 추가 작업이 없으므로 명시할 코드가 없음
                           }
                       })
                       .show();  //AlertDialog 객체 생성후 show 해야 보임!

    }
}