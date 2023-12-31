package com.example.day6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends Activity {

    private Button btnregister;
    private EditText editname,passwd,repasswd;
    private RadioGroup rad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);


        //Intent用法，Bundle传递数据
        btnregister = (Button)findViewById(R.id.btnregister);
        editname = (EditText)findViewById(R.id.editname);
        passwd = (EditText)findViewById(R.id.passwd);
        repasswd = (EditText)findViewById(R.id.repasswd);
        rad = (RadioGroup)findViewById(R.id.radioGroup);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,sex = "";
                Intent it = new Intent(MainActivity.this,SecondActivity.class);

                name = editname.getText().toString();

                //遍历RadioGroup找出被选中的单选按钮
                for(int i = 0;i < rad.getChildCount();i++)
                {
                    RadioButton rd = (RadioButton)rad.getChildAt(i);
                    if(rd.isChecked())
                    {
                        sex = rd.getText().toString();
                        break;
                    }
                }

                //新建Bundle对象,并把数据写入
                Bundle bd = new Bundle();
                bd.putCharSequence("user",name);
                bd.putCharSequence("sex",sex);

                //将数据包Bundle绑定到Intent上
                it.putExtras(bd);
                startActivity(it);
                //界面切换动画
                overridePendingTransition(R.anim.fade, R.anim.fade);
                //关闭第一个Activity
                finish();
            }
        });
    }
}
