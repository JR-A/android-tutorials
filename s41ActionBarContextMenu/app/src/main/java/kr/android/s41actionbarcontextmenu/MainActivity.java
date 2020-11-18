package kr.android.s41actionbarcontextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);

        //컨텍스트 메뉴를 연결할 View 인스턴스 등록
        registerForContextMenu(text);

    }
}