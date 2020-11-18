package kr.android.s38notifydemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotifyMessage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        TextView text = new TextView(this);
        text.setText("알림메시지 표시");

        setContentView(text);
    }
}
