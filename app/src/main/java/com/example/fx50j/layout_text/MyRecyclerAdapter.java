package com.example.fx50j.layout_text;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by FX50J on 2016/3/25.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHoler> {
    List<MyData> list;
    MyViewHoler holer;
    public MyRecyclerAdapter(List<MyData> list){
        this.list = list;
    }
    @Override
    public MyViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        holer = new MyViewHoler(view);
        return holer;
    }

    @Override
    public void onBindViewHolder(MyViewHoler holder, int position) {
        MyData data = list.get(position);
        holder.tv.setText(data.getData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewHoler(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
