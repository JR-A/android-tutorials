package kr.android.s31spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView textView;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    String[] items = {"대한민국", "미국", "중국", "러시아", "일본", "프랑스", "영국", "네덜란드", "스위스", "독일", "멕시코", "호주", "캐나다", "노르웨이", "이탈리아"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        spinner = (Spinner)findViewById(R.id.spinner);
        //이벤트 연결
        spinner.setOnItemSelectedListener(this);

        //어댑터 생성
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        //드롭다운 화면에 표시할 리소스 지정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //어댑터 등록
        spinner.setAdapter(adapter);
    }
    
    //이벤트 핸들러
    //Spinner의 아이템이 선택될 때 실행
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(items[position]);
        textView.setText(items[position]);
    }
    
    //이벤트 핸들러
    //선택된 것을 뺏길때 - 이번 학습의 경우 호출될 경우가 없음
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textView.setText("");
    }
}