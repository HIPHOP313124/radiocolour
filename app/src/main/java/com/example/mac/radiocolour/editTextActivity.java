package com.example.mac.radiocolour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class editTextActivity extends AppCompatActivity {


    public static final String BUNDLE_KEY_TEXT="hiphop313124.android.text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }
public void ok (View view){
    //取得輸入文字
    EditText editText=(EditText)findViewById(R.id.edit_text_id);
    CharSequence text=editText.getText();

    Intent intent=new Intent();   //建立傳令兵
    intent.putExtra(BUNDLE_KEY_TEXT,text);  //將輸入文字的結果放進傳令兵的包裹

    setResult(RESULT_OK, intent);  //傳送結果 一切ok
    finish();  //結束˙目前的Activity
}

    public  void cancel(View view){

        setResult(RESULT_CANCELED);  //傳送結果，取消了，所以包裹沒資料
        finish();       //結束目前的activity
    }

}
