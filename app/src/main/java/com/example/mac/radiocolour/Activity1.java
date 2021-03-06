package com.example.mac.radiocolour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    private TextView m_tv_main_activity_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        init();
    }

    private void init() {
        m_tv_main_activity_message = (TextView) findViewById(R.id.tv_main_activity_message);
        initBackgroundColor();
    }

    private void initBackgroundColor() {

//從intent 取得傳來的顏色值,如果對方忘放顏色值,我們會將顏色值設為-1
        int color = getIntent().getIntExtra(colorPickerActivity.BUNDLE_KEY_COLOR_INT, -1);
    if(color==-1){   //當顏色值為-1時 直接結束
        return;

    }
        //將傳來的顏色設定到TextView
    m_tv_main_activity_message.setBackgroundColor(color);
    }
    public void next(View view){
        Intent intent =new Intent(this,Activity2.class);
        startActivity(intent);
    }


}