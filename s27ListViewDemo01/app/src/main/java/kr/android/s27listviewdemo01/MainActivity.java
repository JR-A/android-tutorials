package kr.android.s27listviewdemo01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView textView;
    ListView listView;
    String[] items = {"서울", "부산", "대전", "광주", "대구", "제주", "인천", "수원", "원주", "강릉", "속초", "춘천", "안산", "성남", "과천", "안양", "순천", "여수", "고흥", "포항", "울산"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        listView = (ListView)findViewById(R.id.listView);
        //리스트뷰에 배열 데이터 표시하기 - 배열의 index와 리스트뷰의 position을 연결, listView row 하나당 TextView하나 사용하여 문자열 표시
        //어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        /*ArrayAdapter(android.content.Context context, @LayoutRes int resource, T[] objects)
         context – The current context.
         resource – The resource ID for a layout file containing a TextView to use when instantiating views.
         objects – The objects to represent in the ListView.
        **/
        //ListView에 어댑터 지정, 매핑
        listView.setAdapter(adapter);

        //이벤트 연결
        listView.setOnItemClickListener(this);
    }

    //이벤트 핸들러
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(items[position]);
    }
}