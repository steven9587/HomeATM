package com.steven.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    private TextView showNickname;
    private TextView showAge;
    private TextView showGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNickname = findViewById(R.id.finalNickname);
        showAge = findViewById(R.id.finalAge);
        showGender = findViewById(R.id.finalGender);
        showNickname.setText(user.getNickname());
        showAge.setText(String.valueOf(user.getAge()));
        showGender.setText(String.valueOf(user.getGender()));
        if (!login) {
            Intent login = new Intent(this, Login.class);
            startActivityForResult(login, RC_LOGIN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                if (!user.isValid()) {
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }
}

