package kr.android.s38notifydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ME_ID = 1;
    private static final String CHANNEL_ID = "my_channel";
    private static final String CHANNEL_NAME = "my Notifications";

    private Timer timer =  new Timer();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //이벤트 핸들러
    public void onClick(View view) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //알림메시지 표시
                notifyMe();
            }
        };
        
        //5초 후에 TimerTask 실행
        timer.schedule(task, 5000);
    }
    
    //알림 메시지를 발생시키는 메서드
    private void notifyMe(){
        NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //메시지를 클릭하면 NotifyMessage 화면으로 이동하게 처리
        PendingIntent i = PendingIntent.getActivity(this, 0, new Intent(this, NotifyMessage.class), 0);

        NotificationCompat.Builder note;

        //사용자 OS버전이 오레오(26) 이상인지 체크
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ // "O" : Oreo
            //채널 사용
            //안드로이드 8.0(API레벨 26)부터 알림 채널을 이용해서 사용자가 알림을 관리할 수 있도록 도와주는 통합시스템 제공

            //채널 생성
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            
            //채널 설정 (기기가 각 기능을 지원하지 않으면, 실행되지 않을 수 있음)
            //1. 라이트 설정
            channel.enableLights(true);
            channel.setLightColor(Color.RED);        //기기가 이 기능을 지원한다면, 이 채널에 게시되는 알림에 대한 불빛색상을 설정
            //2. 진동 설정
            channel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            channel.enableVibration(true);
            //3. 뱃지알림 설정
            channel.setShowBadge(true);
            //4. 잠금화면시 알림을 어느정도로 보여줄지 설정
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            //NotificationManager에 채널 등록
             mgr.createNotificationChannel(channel);

             //알림 메시지 생성
            note = new NotificationCompat.Builder(this, CHANNEL_ID);

        }else{
            //채널 미사용
            note = new NotificationCompat.Builder(this);
        }
        note.setAutoCancel(true);
        note.setSmallIcon(R.drawable.red_ball);
        note.setContentTitle("제목입니다");
        note.setContentText("내용입니다");
        note.setContentIntent(i);

        mgr.notify(NOTIFY_ME_ID, note.build());
    }
}