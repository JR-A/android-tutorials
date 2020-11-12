package kr.android.s03textviewdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

//view를 xml설정으로 생성하는 것이 아닌 MainActivity에서 직접생성해보기 - 권장하지 않음
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TextView 객체 생성
        TextView textView = new TextView(this);     //context: 는 안드로이드스튜디오에서 자동 생성되는 주석임
        //문자열 입력
        textView.setText("텍스트 직접 입력");

        setContentView(textView);   //위에 생성한 뷰 객체를 등록
    }
}