package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends FragmentActivity {
    Button finTask;
    Button curTask;
    Button repTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finTask = findViewById(R.id.fin);
        curTask = findViewById(R.id.cur);
        repTask = findViewById(R.id.rep);
        FragmentManager fm=getSupportFragmentManager();
        Fragment curf = new CurrentTaskFrag();
        Fragment finf = new FinishedTaskFrag();
        Fragment repf = new RepeatingTaskFrag();
        curTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fm.findFragmentById(R.id.fragment_container);
                FragmentTransaction ft=fm.beginTransaction();
                if(fragment==null) {
                    ft.add(R.id.fragment_container, curf);
                    ft.commit();
                } else {
                    ft.replace(R.id.fragment_container, curf);
                    ft.commit();
                }
            }
        });
        repTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fm.findFragmentById(R.id.fragment_container);
                FragmentTransaction ft=fm.beginTransaction();
                if(fragment==null) {
                    ft.add(R.id.fragment_container, repf);
                    ft.commit();
                } else {
                    ft.replace(R.id.fragment_container, repf);
                    ft.commit();
                }
            }
        });
        finTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=fm.findFragmentById(R.id.fragment_container);
                FragmentTransaction ft=fm.beginTransaction();
                if(fragment==null) {
                    ft.add(R.id.fragment_container, finf);
                    ft.commit();
                } else {
                    ft.replace(R.id.fragment_container, finf);
                    ft.commit();
                }
            }
        });


    }
}