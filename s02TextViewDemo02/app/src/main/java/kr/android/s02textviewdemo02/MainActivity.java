package kr.android.s02textviewdemo02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    //안드로이드의 Main 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //AppCompatActivity의 onCreate메서드 수행하여 기본세팅

        setContentView(R.layout.activity_main);  //activity_main.xml을 읽어들여 activity_main.xml에 명시되어있는 태그를 객체로 생성하여 화면의 View들을 구성함

        //activity_main.xml의 TextView 태그에 명시한 ID를 통해 TextView 객체 호출
        TextView text = (TextView)findViewById(R.id.textView);
        //배경색 지정
        text.setBackgroundColor(Color.BLUE);
        //글자색 지정
        text.setTextColor(Color.WHITE);

    }
}