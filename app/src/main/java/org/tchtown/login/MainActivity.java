package org.tchtown.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ///////////////////////////////////////////////////////////
        noticeListView = (ListView) findViewById(R.id.noticeListView);




        noticeList = new ArrayList<>();
        noticeList.add(new notice("공지사항입니다.","안경잡이개발자","2022-01-01"));
        noticeList.add(new notice("공지사항입니다.","안경잡이개발자","2022-01-01"));
        noticeList.add(new notice("공지사항입니다.","안경잡이개발자","2022-01-01"));
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button statisticsButton = (Button) findViewById(R.id.statisticsButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);


        courseButton.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View view){
                 notice.setVisibility(View.GONE);
                 courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                 statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                 scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                 FragmentManager fragmentManager= getSupportFragmentManager();
                 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fragment, new CourseFragment());
                 fragmentTransaction.commit();
             }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                fragmentTransaction.commit();
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                statisticsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager= getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();
            }
        });
    }
}