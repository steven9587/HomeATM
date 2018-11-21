package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends BaseActivity {

    private EditText edAge;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edAge = findViewById(R.id.ed_age);
    }

    public void next(View view) {
        age = Integer.parseInt(edAge.getText().toString());
        user.setAge(age);
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }
}
