package com.steven.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText edID;
    private EditText edPassword;
    private String id;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edID = findViewById(R.id.ed_id);
        edPassword = findViewById(R.id.ed_password);
        String saveID = getSharedPreferences("ATM",MODE_PRIVATE)
                .getString("USERID",id);
        edID.setText(saveID);
    }

    public void Login(View view) {
        id = edID.getText().toString();
        password = edPassword.getText().toString();
        if ("steven".equals(id) && "1234".equals(password)) {
            getSharedPreferences("ATM",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",id)
                    .apply();
            setResult(RESULT_OK);
            finish();
        } else {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
