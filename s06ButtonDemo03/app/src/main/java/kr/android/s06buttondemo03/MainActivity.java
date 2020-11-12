package kr.android.s06buttondemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);

        //초기시간 표기
        updateTime();
    }

    //이벤트 핸들러 - activity_main.xml에서 버튼태그에 이벤트 연결해주었음
    //속성으로 android:onClick="onClick" 메서드 지정
    public void onClick(View view) {
        updateTime();
    }

    //Button에 시간을 표시하는 메서드
    private void updateTime(){
        btn.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()));
    }
}