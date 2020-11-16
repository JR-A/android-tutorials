package kr.android.s36viewflippertouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ViewFlipper flipper;

    //터치 이벤트 발생 지점의 x좌표 저장
    float down_x;
    float up_x;
    int[] imageItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageItems = new int[]{R.drawable.koala, R.drawable.landscape, R.drawable.penguins};
        flipper = (ViewFlipper)findViewById(R.id.flipper);

        //반복문을 이용해서 이미지를 ViewFlipper에 추가
        for(int i : imageItems){
            ImageView image = new ImageView(this);
            image.setImageResource(i);
            flipper.addView(image, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        }

        //이벤트 연결
        flipper.setOnTouchListener(this);
    }

    //이벤트 핸들러
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //터치 이벤트가 일어난 뷰가 ViewFlipper가 아니면 return false
        if(view != flipper){
            return false;
        }

        //사용자가 터치하는 순간 좌표 저장(누르는 순간)
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            //터치 시작 지점 X좌표 저장
            down_x = motionEvent.getX();
        }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){ //사용자가 화면에서 손을 떼는 순간 좌표 저장
            //터치 끝난 지점 X좌표 저장
            up_x = motionEvent.getX();

            if(up_x < down_x){ //터치 진행방향이 왼쪽일 경우
                //애니메이션 지정
                flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
                flipper.showNext();
            }else if(up_x > down_x){ //터치 진행방향이 오른쪽일 경우
                //애니메이션 지정
                flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
                flipper.showPrevious();
            }
        }

        return true;
    }
}