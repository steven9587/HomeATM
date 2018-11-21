package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends BaseActivity {

    private EditText edNickname;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        edNickname = findViewById(R.id.ed_nickname);
    }

    public void next(View view) {
        nickname = edNickname.getText().toString();
        user.setNickname(nickname);
        Intent age = new Intent(this, AgeActivity.class);
        startActivity(age);
    }
}
