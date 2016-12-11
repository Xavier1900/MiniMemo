package com.example.hzw.minimemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    String[] aMemo = {"1. 单击可以编辑备忘",
                      "2. 长按可以清除备忘","3.","4.","5.","6."};

    ListView lv;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        aa = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, aMemo);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it = new Intent(this, Edit.class);
        it.putExtra("编号", i+1);
        it.putExtra("备忘", aMemo[i]);
        //startActivity(it);
        startActivityForResult(it, i);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        aMemo[i] = (i+1)+".";
        aa.notifyDataSetChanged();
        return true;
    }

    public void onActivityResult(int requestCode,
                                 int resultCode, Intent it){
        if(resultCode == RESULT_OK) {
            aMemo[requestCode] = it.getStringExtra("备忘");
            Toast.makeText(this,"备忘数据已于\n" + it.getStringExtra("日期")+"\n 修改",Toast.LENGTH_LONG).show();
            aa.notifyDataSetChanged();
        }
    }
}
