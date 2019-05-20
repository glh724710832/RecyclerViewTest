package com.gary.recyclerviewtest;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHodler> {

    private List<String> testList;
    private Context context;

    public TestAdapter(Context context, List<String> testList) {
        this.context = context;
        this.testList = testList;

    }
    //步骤三：重写RecyclerView.Adapter的三个方法
    @NonNull
    @Override
    public TestViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //将item布局和ViewHolder绑定，并返回一个ViewHolder类型的对象
          //将item布局映射到view试图
        View view = LayoutInflater.from(context).inflate(R.layout.item_test,null);
        TestViewHodler testViewHodler = new TestViewHodler(view);
        return testViewHodler;
    }

    //设置数据
    @Override
    public void onBindViewHolder(@NonNull TestViewHodler testViewHodler, int position) {
        testViewHodler.btn_test.setText(String.valueOf(position+1));
        testViewHodler.tv_test.setText(testList.get(position));

    }

    @Override
    public int getItemCount() {
        return testList.size();
    }




    //步骤二：自定义一个ViewHodler类继承父类RecyclerView.ViewHolder，在构造器处绑定控件，第三步骤绑定的是item 布局
    public static class TestViewHodler extends RecyclerView.ViewHolder {
        Button btn_test;
        TextView tv_test;

        public TestViewHodler(@NonNull View itemView) {
            super(itemView);
            btn_test = itemView.findViewById(R.id.btn_test);
            tv_test = itemView.findViewById(R.id.tv_test);

        }
    }







}

