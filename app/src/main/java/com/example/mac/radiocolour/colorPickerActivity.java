package com.example.mac.radiocolour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class colorPickerActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY_COLOR_INT="hiphop313124_colorInt";
    public static final String BUNDLE_KEY_COLOR_NAME="hiphop313124_colorName";


    private int mColorInt;
    private CharSequence mColorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker_acitvity);
        initColorData();

    }

    private void initColorData(){

        //預設選取紅色
        RadioButton radio=(RadioButton)findViewById(R.id.radio_hold_red_light);
        mColorInt=radio.getCurrentTextColor();
        mColorName=radio.getText();
    }

    public void clickColor(View v){

        RadioButton radio =(RadioButton)v;
        mColorInt=radio.getCurrentTextColor();
        mColorName=radio.getText();
    }

    public void ok(View view){
        Intent intent=new Intent();  //建立意圖

        intent.putExtra(BUNDLE_KEY_COLOR_INT,mColorInt);  //key:String   value:int
        intent.putExtra(BUNDLE_KEY_COLOR_NAME,mColorName);  //key:String   value:String
        setResult(RESULT_OK, intent);  //設定結果ＯＫ，傳送意圖
        finish();  //目前activity 結束
    }
public void cancel(View view){

    setResult(RESULT_CANCELED);
    finish();
}

}
