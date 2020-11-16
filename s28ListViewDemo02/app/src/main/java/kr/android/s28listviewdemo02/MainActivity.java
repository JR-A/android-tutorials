package kr.android.s28listviewdemo02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView myListView;
    EditText myEditText;
    //버튼은 onClick 매핑해놓았으므 멤버변수로 가질 필요 없음
    ArrayList<String> todoItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.listView);
        myEditText = (EditText)findViewById(R.id.myEditText);

        //데이터 저장소로 ArrayList를 사용하기 때문에 객체 생성
        todoItems = new ArrayList<String>();
        //어댑터 생성
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
        //public ArrayAdapter(android.content.Context context, @LayoutRes int resource, java.util.List<T> objects)

        //ListView에 어댑터 지정, 매핑
        myListView.setAdapter(adapter);

    }

    //이벤트 핸들러
    public void onClick(View view) {
        String text = myEditText.getText().toString();
        if(text.length() > 0){
            todoItems.add(0, text);
            //ArrayAdapter에 등록된 저장소에서 데이터가 변경되었으면 이를 ListView에 반영
            adapter.notifyDataSetChanged();
            //데이터가 정상적으로 저장되면 EditText초기화
            myEditText.setText("");
        }else{
            //토스트 알림 메시지 표시
            Toast.makeText(this, "일정을 입력하세요!", Toast.LENGTH_SHORT).show();
        }
    }
}