package com.example.intentfourthjava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intentfourthjava.model.Member;
import com.example.intentfourthjava.model.User;

public class MainActivity extends AppCompatActivity {
    int LAUNCH_SECOND = 29;
    public TextView tv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    ActivityResultLauncher<Intent> detailLauncher  = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==Activity.RESULT_OK){
                        Intent intent = result.getData();
                        Member member = (Member) intent.getSerializableExtra("member");
                        tv_main.setText(member.toString());
                    }
                }
            });

    private void initView() {
        tv_main = findViewById(R.id.tv_main);
        Button b_check = findViewById(R.id.b_main_check);
        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(21, "Zuhriddin");
                startSecondActivity(user);
            }
        });
    }

    void startSecondActivity(User user){
        Intent intent =new Intent(this , SecondActivity.class);
        intent.putExtra("user" , user);
        detailLauncher.launch(intent);
    }
}