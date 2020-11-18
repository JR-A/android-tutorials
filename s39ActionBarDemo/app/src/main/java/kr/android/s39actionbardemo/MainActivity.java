package kr.android.s39actionbardemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        //ActionBar 숨기기
        actionBar.hide();
        //ActionBar 노출
        actionBar.show();

        //타이틀 세팅
        actionBar.setTitle("Action Bar");
        //서브타이틀 세팅
        actionBar.setSubtitle("Subtitle of Action Bar");

        //홈 아이콘(<-모양) 노출 및 제목표시
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_TITLE);   // |는 or의 의미


    }

    //메뉴에 대한 이벤트 핸들러 역할
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            Toast.makeText(this, "홈 클릭!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}