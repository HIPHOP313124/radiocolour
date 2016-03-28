package com.example.mac.radiocolour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final int SELECT_COLOR_REQUEST = 0;  //給傳令識別碼好方便辨識
    private int m_color = 0xFFFFFFFF;   //記錄選了什麼顏色  0xFFFFFFFF<<白色

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectColor(View view) {
//Intent (傳令的Activity,接受傳令的Activity)
        Intent intent = new Intent(this, colorPickerActivity.class);

        // startActivity(intent);  //intent傳令,這簡單傳令無回傳結果語法startActivity

        startActivityForResult(intent, SELECT_COLOR_REQUEST);  //傳令需要返回結果語法startActivityForResult

    }

    @Override        //android好萊鄔模式  回報有結果
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  //datat傳令 身上的包裹
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SELECT_COLOR_REQUEST) {  //如果回傳的包裹裡的識別碼與當初定義的相同，ˊ這結果(包裹)就是我們的
            if (resultCode == RESULT_OK) {//取得傳令兵得包裹
                Bundle bundle = data.getExtras();    //從包裹取出值
                m_color = bundle.getInt(colorPickerActivity.BUNDLE_KEY_COLOR_INT);
                CharSequence colorName = bundle.getCharSequence(colorPickerActivity.BUNDLE_KEY_COLOR_NAME);

                //從包裹拿出charSequence資料,須提供資料的key
                TextView tv_color = (TextView) findViewById(R.id.tv_color);
                tv_color.setGravity(Gravity.CENTER);
                tv_color.setText(colorName);

                //更scrollview改背景顏色
                ScrollView scorllView = (ScrollView) findViewById(R.id.scrollView_id);
                scorllView.setBackgroundColor(m_color);
            }
        }
    }

    /*
     } else if (requestCode == EDIT_TEXT_REQUEST) {
         if (requestCode == RESULT_OK) {

             Bundle bundle = data.getExtras();  //取得傳令兵包裹
             //從包裹拿出charsequence資料 ,須提供資料的key
             CharSequence text = bundle.getCharSequence(editTextActivity.BUNDLE_KEY_TEXT);

             TextView tv_color = (TextView) findViewById(R.id.tv_color);
             tv_color.setGravity(Gravity.LEFT);
             tv_color.setText(text);

         }
     }
 }
 */
    public void next(View view) {   //按下next後切換下一個畫面Activity
        Intent intent = new Intent(this, Activity1.class);

        intent.putExtra(colorPickerActivity.BUNDLE_KEY_COLOR_INT, m_color);
        startActivity(intent);
    }
}

