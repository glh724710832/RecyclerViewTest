package com.gary.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String>testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        //设置线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //或者此方法。不推荐recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,true));

        //添加集合，后期不考虑此方法。 参照listView的convertView复用机制
        testList = new ArrayList<>();
        for(int i =1;i<=100;i++){

            testList.add("第"+i+"天");
        }

        //设置适配器
        recyclerView.setAdapter(new TestAdapter(TestActivity.this,testList));
    }
}
