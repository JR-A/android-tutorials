package kr.android.s25intentmsgdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.edit); //UI에 선언한 edit를 읽어옴


    }

    public void onClick(View view) {
        //Html: a태그 android: 컴포넌트간 연결해주는 intent를 사용
        Intent i = null;
        if(view.getId() == R.id.button){
            //이동
            i = new Intent(this, SecondActivity.class);
            //만들어진 앱에서 어플리케이션으로 등록이 되어 있어야 함_설정파일에 등록(Activity 추가사용할 거라고 명시)
            //AndroidManifest.xml : 설정파일
            //Intent를 실행시켜서 Intent에 명시된 Activity를 구동시킴
            startActivity(i); //AppCompatActivity가 가지고 있는 메서드
        } else if(view.getId() == R.id.button2){
            //EditText에 입력한 데이터를 갖고 이동

            String msg = edit.getText().toString();
            if("".equals(msg)){
                Toast.makeText(this, "데이터를 입력하세요!", Toast.LENGTH_SHORT).show();
            }else{
                i = new Intent(this, SecondActivity.class); //파일을 찾아서 객체생성을 하기 때문에 - SecondActivity는 단순 타입임
                i.putExtra("msg", edit.getText().toString()); //key와 value의 쌍으로 데이터를 가지고 이동
                //Intent를 실행시켜서 Intent에 명시된 Activity를 구동시킴
                startActivity(i); //AppCompatActivity가 가지고 있는 메서드
            }
        }

    }
}