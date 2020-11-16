package kr.android.s34viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_one, btn_two, btn_three;
    ViewPager mPager;
    int[] btn = {R.id.btn_one, R.id.btn_two, R.id.btn_three};

    //이벤트처리(익명객체)
    private View.OnClickListener myListener = new View.OnClickListener(){
        //이벤트핸들러
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_one:
                    mPager.setCurrentItem(0);
                    break;
                case R.id.btn_two:
                    mPager.setCurrentItem(1);
                    break;
                case R.id.btn_three:
                    mPager.setCurrentItem(2);
                    break;
                case R.id.btn_yellow:
                case R.id.btn_skyblue:
                case R.id.btn_pink:
                    //btn_yellow, skyblue, btn_pink 눌렀을때 같은동작
                    String text = ((Button)v).getText().toString();
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show(); //this라고만 하면 익명객체 가리키므로 에러
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loop돌며 각 버튼에 이벤트 연결
        for(int id : btn){
            findViewById(id).setOnClickListener(myListener);
        }
        mPager = (ViewPager)findViewById(R.id.pager);

        //어댑터 등록
        mPager.setAdapter(new MyPagerAdapter(this));
    }

    //내부클래스
    //커스텀 페이지 어댑터 정이 - 어댑터를 커스터마이징
    private class MyPagerAdapter extends PagerAdapter{

        //UI를 나타내는 xml의 정보를 읽어들여 View 객체를 생성하는 역할
        LayoutInflater inflater;
        
        public MyPagerAdapter(Context c){
            //LayoutInflater 객체 생성
            inflater = LayoutInflater.from(c);
        }
        
        //현재 PagerAdapter에서 관리할 View의 개수
        @Override
        public int getCount() { //몇 개의 화면인지
            return btn.length;
        }

        //ViewPager에서 사용할 뷰 객체 생성 및 등록
        @Override
        public Object instantiateItem(ViewGroup container, int position){
            View v = null;
            switch (position){
                case 0:
                    v = inflater.inflate(R.layout.page_one, null);
                    //이벤트 연결
                    v.findViewById(R.id.btn_yellow).setOnClickListener(myListener);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.page_two, null);
                    //이벤트연결
                    v.findViewById(R.id.btn_skyblue).setOnClickListener(myListener);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.page_three, null);
                    //이벤트연결
                    v.findViewById(R.id.btn_pink).setOnClickListener(myListener);
                    break;
            }

            //생성된 View 객체 등록
            ((ViewPager)container).addView(v,0);

            return v;
        }
         
        
        //뷰 객체 삭제
        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            ((ViewPager)container).removeView((View)object);
        }
        
        //instanctiateItem에서 생성한 객체를 이용할 것인지 여부 지정
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

}