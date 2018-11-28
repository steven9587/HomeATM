package com.steven.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends BaseActivity {
    private static final int RC_LOGIN = 100;
    boolean login = true;
    private TextView showNickname;
    private TextView showAge;
    private TextView showGender;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!login) {
            Intent login = new Intent(this, Login.class);
            startActivityForResult(login, RC_LOGIN);
        }
        //ArrayAdapterOne
        //arrayAdapterOne();
        //ArrayAdapterTwo
        arrayAdapterTwo();
        //SpinnerOne
        //spinnerOne();
        //SpinnerTwo
        spinnerTwo();
    }

    private void spinnerTwo() {
        Spinner notify = findViewById(R.id.spinner);
        List<String> notifyList = Arrays.asList("靜音", "震動", "有聲");
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, notifyList);
        notify.setAdapter(arrayAdapter);
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spinnerOne() {
        Spinner notify = findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> arrayAdapter =
                ArrayAdapter.createFromResource(this, R.array.notifyList, android.R.layout.simple_spinner_dropdown_item);
        notify.setAdapter(arrayAdapter);
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void arrayAdapterTwo() {
        ListView functions = findViewById(R.id.listView);
        List<String> functionList = Arrays.asList("餘額查詢", "交易明細", "最新消息", "投資理財", "離開");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, functionList);
        functions.setAdapter(arrayAdapter);
    }

    private void arrayAdapterOne() {
        ListView functions = findViewById(R.id.listView);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.functionList, android.R.layout.simple_list_item_1);
        functions.setAdapter(arrayAdapter);
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
                } else {
                    //showPersonalData
                    //showPersonalData();
                }
            }
        }
    }

    private void showPersonalData() {
        showNickname = findViewById(R.id.finalNickname);
        showAge = findViewById(R.id.finalAge);
        showGender = findViewById(R.id.finalGender);
        showNickname.setText(user.getNickname());
        showAge.setText(String.valueOf(user.getNickname()));
        showGender.setText(String.valueOf(user.getNickname()));
    }
}

