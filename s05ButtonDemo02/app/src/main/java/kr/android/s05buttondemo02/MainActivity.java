package kr.android.s05buttondemo02;

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

        //부여한 아이디를 통해서 생선된 Button 객체를 호출
        btn = (Button)findViewById(R.id.button);
        //이벤트 소스와 이벤트 리스너가 구현된 객체를 연결(익명 내부클래스 형태로 객체 생성)
        btn.setOnClickListener(new View.OnClickListener(){
            //이벤트 핸들러
            @Override
            public void onClick(View v) {
                updateTime();
            }
        });

        //초기 시간 표시
        updateTime();
    }

    //Button에 시간을 표시하는 메서드
    private void updateTime(){
        btn.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()));
    }
}