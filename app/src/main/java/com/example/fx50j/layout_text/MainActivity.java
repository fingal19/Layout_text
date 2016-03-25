package com.example.fx50j.layout_text;

import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
    private List<MyData> list = new ArrayList<>();
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private SwipeRefreshLayout refresh;

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_data();
        init_view();


    }


    public void init_view(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawertoggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.setDrawerListener(drawertoggle);
        drawertoggle.syncState();


        //下拉刷新设置
        refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        refresh.setRefreshing(false);
                    }
                }, 5000);
            }
        });
        refresh.setColorScheme(android.R.color.white,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        //Recycler必须setManager
        manager = new LinearLayoutManager(this);
        adapter = new MyRecyclerAdapter(list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        //新建一个ItemDecoration的类，设置分割线
//        recyclerView.addItemDecoration(new ItemDecoration(this,manager.getOrientation()));
        recyclerView.setAdapter(adapter);
    }
    public void init_data(){
        for (int i = 0;i < 50;i++){
            MyData data = new MyData("item_" + i);
            list.add(data);
        }
    }


}
