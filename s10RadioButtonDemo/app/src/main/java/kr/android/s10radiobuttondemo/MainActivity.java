package kr.android.s10radiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup group;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup)findViewById(R.id.radioGroup);
        tv = (TextView)findViewById(R.id.textView);

        //이벤트 소스와 이벤트핸들러 연결
        group.setOnCheckedChangeListener(this);
    }

    //이벤트 핸들러
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //checkedId : 선택한 RadioButton의 id
        RadioButton rb = (RadioButton)findViewById(checkedId);
        tv.setText("당신의 선택 : " + rb.getText());
    }
}