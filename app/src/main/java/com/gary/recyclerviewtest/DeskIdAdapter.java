package com.gary.recyclerviewtest;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//步骤一：自定义适配器继承RecyclerView.Adapter
public class DeskIdAdapter extends RecyclerView.Adapter<DeskIdAdapter.DeskIdViewHolder> {

    Context context;
    List<String> deskIdList;
    Set<Integer> onItemClickSet;
    static OnItemClickListener onItemClickListener;
    //创建构造器
    public  DeskIdAdapter(Context context, List<String> deskIdList,OnItemClickListener onItemClickListener){
        this.context = context;
        this.deskIdList = deskIdList;
        this.onItemClickListener = onItemClickListener;
        onItemClickSet = new HashSet<>();
    }

    //步骤二：创建一个ViewHolder类继承父类RecyclerView.ViewHolder，重写他的构造器，并把这个类（DeskIdViewHolder）传给RecyclerView.Adapter<>指定泛型
           //在构造器里绑定控件
    public  static class DeskIdViewHolder extends RecyclerView.ViewHolder{

        TextView tv_deskid;

        public DeskIdViewHolder(@NonNull View itemView) {
            super(itemView);
            //itemView相当于item的id
            //绑定控件
            tv_deskid= itemView.findViewById(R.id.tv_deskid);
        }
    }



    //步骤三：重写RecyclerView.Adapter的方法

    //将Item和ViewHolder进行绑定，并返回一个DeskIdViewHolder类型的deskIdViewHolder对象
    @NonNull
    @Override
    public DeskIdViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //item布局映射为View对象
      View view = LayoutInflater.from(context).inflate(R.layout.item_deskid,null);
      //创建一个ViewHolder,并将View对象传到他的构造器里面
        DeskIdViewHolder deskIdViewHolder = new DeskIdViewHolder(view);
        return deskIdViewHolder;
    }

    //通常用来显示数据的
    @Override
    public void onBindViewHolder(@NonNull final DeskIdViewHolder deskIdViewHolder, final int position) {
        //int i是指在RecyclerView中显示的item位置或排序
        Log.e("位置",position+"");


        deskIdViewHolder.tv_deskid.setText(deskIdList.get(position));
        deskIdViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position,deskIdViewHolder.itemView);
                boolean isAdd = onItemClickSet.add(position);
                if(!isAdd){
                    deskIdViewHolder.itemView.setBackgroundColor(Color.WHITE);
                    onItemClickSet.remove(position);
                }
            }
        });
        if(onItemClickSet.contains(position)){
            deskIdViewHolder.itemView.setBackgroundColor(Color.RED);
        }else {
            deskIdViewHolder.itemView.setBackgroundColor(Color.WHITE);
        }
//
        //通过参数列表里的参数调用方法
//        deskIdViewHolder.tv_deskid.setText(deskIdList.get(i));
//        if(copyInt %5 ==0) {
//            deskIdViewHolder.itemView.setBackgroundColor(Color.BLUE);
//        }else {
//            deskIdViewHolder.itemView.setBackgroundColor(Color.WHITE);
//        }
//        if(copyInt%2 ==0){
//            deskIdViewHolder.tv_deskid.setTextColor(Color.GREEN);
//        }else{
//            deskIdViewHolder.tv_deskid.setTextColor(Color.RED);
//        }
    }

    //RecyclerView显示的Item总个数
    @Override
    public int getItemCount() {
        return deskIdList.size();
    }



    public interface OnItemClickListener{
        void onItemClick(int positipon,View view);

    }


}
