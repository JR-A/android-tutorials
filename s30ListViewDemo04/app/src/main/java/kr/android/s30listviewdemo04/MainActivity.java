package kr.android.s30listviewdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    EditText newItem;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        newItem = (EditText)findViewById(R.id.newItem);

        //ArrayList를 초기화하고 초기 데이터 저장
        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        //어댑터 생성
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, items); //디자인적 제약(체크박스)

        //ListView에 어댑터 등록
        list.setAdapter(adapter);

        //선택모드 지정
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);  //기능적 제약
    }

    //이벤트 핸들러
    public void onClick(View view) {
        switch (view.getId()){ //id가 정수이므로 switch로 조건체크 가능
            case R.id.add:
                String text = newItem.getText().toString();
                if(text.length()>0){    //데이터를 입력한 경우
                    //입력된 문자열을 list에 추가
                    items.add(0, text);
                    //ListView 갱신
                    adapter.notifyDataSetChanged();
                    //EditText초기화
                    newItem.setText("");
                }else {                  //데이터를 입력하지 않은 경우
                    Toast.makeText(this, "데이터를 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.del:
                //선택한 항목들의 포지션(항목들의 선택여부 boolean 배열의 형태)
                SparseBooleanArray positions = list.getCheckedItemPositions();
                if(positions.size() > 0){   //삭제 항목 (하나이상)선택한 경우
                    //선택된 항목들을 list에서 삭제
                    for(int i=list.getCount()-1; i>=0; i--){
                        if(positions.get(i)){   //positions의 i번째 값이 true이면(선택된 항목이면)
                            items.remove(i);
                        }
                    }
                    //CheckBox 초기화
                    list.clearChoices();
                    //ListView 갱신
                    adapter.notifyDataSetChanged();

                }else{  //삭제 항목 미선택
                    Toast.makeText(this, "삭제할 항목을 선택하세요!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}