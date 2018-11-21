package com.steven.atm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Login extends BaseActivity {

    private EditText edId;
    private EditText edPassword;
    private String id;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edId = findViewById(R.id.ed_id);
        edPassword = findViewById(R.id.ed_password);
        edId.setText(user.getId());
    }

    public void Login(View view){
        id = edId.getText().toString();
        password = edPassword.getText().toString();
        if ("steven".equals(id) && "1234".equals(password)) {
            user.setId(id);
            setResult(RESULT_OK);
            finish();
        }else{
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
