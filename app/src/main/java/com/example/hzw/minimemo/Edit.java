package com.example.hzw.minimemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class Edit extends AppCompatActivity {
    TextView txv;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent it = getIntent();
        String s =it.getStringExtra("备忘");
        txv = (TextView)findViewById(R.id.textView);
        txv.setText(s.substring(0,2));

        edt = (EditText) findViewById(R.id.editText);
        if(s.length() > 3){
            edt.setText(s.substring(3));
        }
    }

    public void OnCancel(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void OnSave(View v)
    {
        Intent it2 = new Intent();
        it2.putExtra("备忘",txv.getText() + " " + edt.getText());
        it2.putExtra("日期", new Date().toString());
        setResult(RESULT_OK, it2);
        finish();
    }
}
