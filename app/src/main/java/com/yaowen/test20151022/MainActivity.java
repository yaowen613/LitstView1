package com.yaowen.test20151022;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by YAOWEN
 * on 2015/10/22
 * 这是在回顾以前学过的知识的案例
 **/
public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);//绑定XML中的ListView，作为Item的容器
        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> lists = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 20; i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("ItemTitle", "新闻标题" + (i + 1));
            hashMap.put("ItemContent", "这个是新闻" + (i + 1) + "的内容，说的是...");
            lists.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(//生成适配器，数组===》ListItem
                this,
                lists,//数据来源
                R.layout.item_layout,//ListItem的XML实现
                new String[]{"ItemTitle", "ItemContent"},//动态数组与ListItem对应的子项
                new int[]{R.id.ItemTitle, R.id.ItemText});//ListItem的XML文件里面的两个TextView ID
        listView.setAdapter(adapter);//添加并且显示
    }
}
