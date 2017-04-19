package com.bmob.frank.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by frank on 17-4-19.
 */

public class Sign extends AppCompatActivity {
    private EditText name;
    private EditText pwd;
    private Button Blogin;
//    private Button Bpwd;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        name=(EditText)this.findViewById(R.id.name2);
        pwd=(EditText)this.findViewById(R.id.psw2);
        Blogin=(Button) this.findViewById(R.id.butSign2);
        Blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user=new BmobUser();
                user.setUsername(name.getText().toString().trim());
                user.setPassword(pwd.getText().toString().trim());
                user.signUp(Sign.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(Sign.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(Sign.this, "FAIL", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
//        Bpwd.setOnClickListener(this);
//        init();

    }
}