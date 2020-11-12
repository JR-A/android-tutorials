package kr.android.s17linearlayoutdemo07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    /*
        [실습] 첫 번째 숫자와 두 번째 숫자를 입력한 후 연산자 선택을 위해 버튼을 누르면
        연산 결과를 TextView에 표시하는 앱
        0으로 나누면 TextView에 "(주의)0으로 나눌 수 없습니다."를 표시함

        ex) EditText에서 입력 정보 읽어 숫자로 변환
        Integer.parseInt(editText.getText().toString());
     */

    EditText editText1, editText2;
    TextView text;
    Button plus, minus, mult, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        text = (TextView)findViewById(R.id.text);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        mult = (Button)findViewById(R.id.mult);
        div = (Button)findViewById(R.id.div);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });
        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });
    }

    void calculate(String op){

        int result = 0;
        int num1 = Integer.parseInt(editText1.getText().toString());
        int num2 = Integer.parseInt(editText2.getText().toString());

        boolean check = true;

        if(op.equals("+")){
            result = num1 + num2;
        }else if(op.equals("-")) {
            result = num1 - num2;
        }else if(op.equals("*")){
            result = num1*num2;
        }else if(op.equals("/")) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                text.setText("(주의)0으로 나눌 수 없습니다.");
                check = false;
            }
        }else {
            text.setText("오류 발생!");
            check = false;
        }

        if(check != false) {
            text.setText("계산결과 : " + Integer.toString(result));
        }
    }
}