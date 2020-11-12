package kr.android.s18framelayoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.img);
    }

    //이벤트 핸들러
    public void onClick(View view) {
        //img가 보여지고있다면(노출되어있으면)
        if(img.getVisibility() == View.VISIBLE){
            img.setVisibility(View.INVISIBLE);  //숨김
        }else{ //img가 숨김처리되어있으면
            img.setVisibility(View.VISIBLE);    //노출
        }
    }
}