package com.steven.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    private TextView finalNIckname;
    private TextView finalAge;
    private TextView finalGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finalNIckname = findViewById(R.id.finalNickname);
        finalAge = findViewById(R.id.finalAge);
        finalGender = findViewById(R.id.finalGender);
        finalNIckname.setText(user.getNickname());
        finalAge.setText(String.valueOf(user.getAge()));
        finalGender.setText(String .valueOf(user.getGender()));
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
//                String saveNickname = getSharedPreferences("user", MODE_PRIVATE)
//                        .getString("NICKNAME", null);
//                int saveAge = getSharedPreferences("user", MODE_PRIVATE)
//                        .getInt("AGE", 0);
//                int saveGender = getSharedPreferences("user", MODE_PRIVATE)
//                        .getInt("GENDER", 0);
//                if (saveNickname == null || saveAge == 0 || saveGender == 0) {
                if (!user.isValid()) {
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }else{
                    finalNIckname = findViewById(R.id.finalNickname);
                    finalAge = findViewById(R.id.finalAge);
                    finalGender = findViewById(R.id.finalGender);
                    finalNIckname.setText(user.getNickname());
                    finalAge.setText(String.valueOf(user.getAge()));
                    finalGender.setText(String .valueOf(user.getGender()));
                }
            }
        }
    }
}

