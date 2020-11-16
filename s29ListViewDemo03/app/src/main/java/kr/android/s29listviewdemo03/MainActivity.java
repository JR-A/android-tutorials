package kr.android.s29listviewdemo03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    EditText edit;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        edit = (EditText)findViewById(R.id.newItem);

        //저장소를 생성하고 초기 데이터를 저장
        items = new ArrayList<String>();
        items.add("First");
        items.add("Second");
        items.add("Third");

        //어댑터 생성 (싱글선택 가능한 리스트-라디오버튼)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, items);   //디자인적 제약(라디오버튼)

        //ListView에 어댑터 등록
        list.setAdapter(adapter);

        //선택모드 지정
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);    //기능적 제약
    }

    //이벤트 핸들러
   public void onClick(View view) {
        switch (view.getId()) { //id가 정수이므로 switch로 조건체크 가능
            case R.id.add:
                String text = edit.getText().toString();
                if(text.length()>0){    //데이터를 입력한 경우
                    //입력된 문자열을 list에 추가
                    items.add(0, text);
                    //ListView 갱신
                    adapter.notifyDataSetChanged();
                    //EditText 초기화
                    edit.setText("");
                }else{                  //데이터를 입력하지 않은 경우
                    Toast.makeText(this, "데이터를 입력하세요!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.del:
                //선택한 항목의 포지션
                int position = list.getCheckedItemPosition();
                //항목을 선택하지 않으면 getCheckedItemPosition()이 -1(INVALID_POSITION)반환
                if(position != ListView.INVALID_POSITION){  //삭제 항목 선택
                    //포지션값을 인덱스로 하여 list에서 삭제
                    items.remove(position);
                    //RadioButton 초기화
                    list.clearChoices();
                    //ListView갱신
                    adapter.notifyDataSetChanged();

                }else{  //삭제 항목 미선택
                    Toast.makeText(this, "삭제할 항목을 선택하세요!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}