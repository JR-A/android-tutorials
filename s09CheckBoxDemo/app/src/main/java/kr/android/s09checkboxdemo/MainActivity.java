package kr.android.s09checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = (CheckBox)findViewById(R.id.checkBox);
        //이벤트 소스와 이벤트 리스너가 구현된 객체 연결
        cb.setOnCheckedChangeListener(this);
    }

    //이벤트 핸들러
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked){
            cb.setText("체크 상태");
        }else{
            cb.setText("체크되지 않은 상태");
        }
    }
}