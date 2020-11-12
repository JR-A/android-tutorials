package kr.android.s25intentmsgdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_second); //UI를 만들기 위해 명시

        text = (TextView)findViewById(R.id.text_second);

        //SecondActivity를 호출한 Intent를 구함
        Intent i = getIntent();
        if(i.getExtras()==null) { //전달된 데이터가 없을 경우
            //기존 데이터 뒤에 붙이려면
            text.append("\n전달된 데이터가 없음");
        } else{ //전달된 데이터가 있음
            String str = i.getStringExtra("msg"); //key를 넣어서 data를 뽑아냄
            if("".equals(str)){
                text.append("\n입력한 데이터가 없습니다.");
            }else{
                text.append("\n" + str );
            }
        }



    }
}