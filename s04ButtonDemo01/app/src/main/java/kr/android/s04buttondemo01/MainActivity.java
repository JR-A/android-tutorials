package kr.android.s04buttondemo01;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

//View.onClickListener 인터페이스 implements
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button);
        //이벤트 소스와 이벤트 리스너 연결
        btn.setOnClickListener(this);

        //초기 시간 표시
        updateTime();
    }

    //이벤트 핸들러
    @Override
    public void onClick(View v) {
        updateTime();
    }

    //버튼에 시간을 표시하는 메서드
    private void updateTime(){
        btn.setText(DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()));
    }
}