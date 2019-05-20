package com.gary.recyclerviewtest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button intentButtom;
    List<String> deskIdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //步骤一：绑定RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        intentButtom = findViewById(R.id.intent_button);
        //步骤二：设置布局管理器
        GridLayoutManager grid = new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(grid);

      //创建集合添加数据
        deskIdList = new ArrayList<>();
      for(int i =1;i<=10000;i++){
          deskIdList.add(String.valueOf(i));
      }
        //步骤三：设置adapter适配器


        recyclerView.setAdapter(new DeskIdAdapter(MainActivity.this, deskIdList, new DeskIdAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                view.setBackgroundColor(Color.RED);

            }
        }));

        intentButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
