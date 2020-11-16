package kr.android.s26externalactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
/*
*  4대 컴포넌트 - 액티비티, 서비스, 브로드캐스트 리시버, 컨텐트 프로바이더
**/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent  = null;
        
        //클릭된 아이디 가져옴
        if(view.getId()==R.id.btn1){    //WEB페이지 표시
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        }else if(view.getId()==R.id.btn2){  //지도표시
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Seoul"));  //위도, 경도 쓰지않고(0), 서울을 검색
        }else if(view.getId()==R.id.btn3){ //다이얼러 표시
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678"));
        }else if(view.getId()==R.id.btn4){  //메시지 표시
            intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:010-1234-5678"));
        }

        //Intent에 저장한 정보를 이요해서 앱의 특정 화면을 호출함
        startActivity(intent);
    }
}