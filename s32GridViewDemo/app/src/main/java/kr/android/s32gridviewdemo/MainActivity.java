package kr.android.s32gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    TextView textView;
    GridView grid;
    ArrayAdapter<String> adapter;
    String[] items = {"서울", "대전", "대구", "광주", "부산", "울산",
                      "서울", "대전", "대구", "광주", "부산", "울산",
                      "서울", "대전", "대구", "광주", "부산", "울산",
                      "서울", "대전", "대구", "광주", "부산", "울산",
                      "서울", "대전", "대구", "광주", "부산", "울산"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        grid = (GridView)findViewById(R.id.grid);

        //이벤트 연결
        grid.setOnItemClickListener(this);

        //어댑터 생성
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        
        //GridView에 어댑터 등록
        grid.setAdapter(adapter);
    }

    //이벤트 핸들러
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(items[position]);
        
    }
}