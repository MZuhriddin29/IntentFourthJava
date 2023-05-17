package com.example.intentfourthjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intentfourthjava.model.Member;
import com.example.intentfourthjava.model.User;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    void initView() {
        Button button = findViewById(R.id.b_second_check);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(6, "PDP");
                backToMain(member);
            }
        });
        User user = (User)getIntent().getSerializableExtra("user");
        TextView tv_second = findViewById(R.id.tv_second);
        tv_second.setText(user.toString());
    }

    void backToMain(Member member){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("member" , member);
        setResult(Activity.RESULT_OK , returnIntent);
        finish();
    }


}
