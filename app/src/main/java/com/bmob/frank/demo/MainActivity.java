package com.bmob.frank.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText name;
    private EditText pwd;
    private Button Blogin;
    private Button Bpwd;
    private String APP_KEY="023e1a461cb0e22081c49f17c245b789";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this,APP_KEY);


        name=(EditText)this.findViewById(R.id.name1);
        pwd=(EditText)this.findViewById(R.id.psw1);
        Blogin=(Button) this.findViewById(R.id.butLog1);
        Bpwd=(Button) this.findViewById(R.id.butSign1);
        Blogin.setOnClickListener(this);
        Bpwd.setOnClickListener(this);
        init();
    }
    void init(){
        String namestr=name.getText().toString().trim();
        String pwdstr=pwd.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册
            case R.id.butLog1:
                BmobUser user=new BmobUser();
                user.setUsername(name.getText().toString().trim());
                user.setPassword(pwd.getText().toString().trim());
                user.login(MainActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();

                    }
                });
                break;
            //登录
            case R.id.butSign1:
                Intent intent=new Intent(MainActivity.this,Sign.class);
                startActivity(intent);
//                Toast.makeText(this, "dengluchenggong", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
