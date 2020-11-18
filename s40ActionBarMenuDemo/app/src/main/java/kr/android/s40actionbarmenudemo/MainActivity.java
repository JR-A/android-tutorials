package kr.android.s40actionbarmenudemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_TITLE);
    }

    //메뉴생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //MenuInflater를 이용해서 menu_main.xml에 정의된 메뉴를 객체 생성
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //메뉴에 대한 이벤트 핸들러
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String msg = null;
        switch (item.getItemId()){
            case android.R.id.home:
                msg = "홈으로";
                break;
            case R.id.menu_search:
                msg = "검색 선택";
                break;
            case R.id.itemChat:
                msg = "Chat 선택";
                break;
            case R.id.itemEmail:
                msg = "Email 선택";
                break;
            case R.id.action_setting:
                msg = "환경 설정";
                break;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}