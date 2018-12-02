package com.steven.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
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
        //LISTVIEW
        //listViewOut();
        //listViewIn();
        //SPINNER
        //spinnerOut();
        //spinnerIn();
        //GRIDVIEW
        //gridViewOut();
        //gridViewIn();
    }

    private void gridViewIn() {
        GridView functionGridViewIn = findViewById(R.id.grid);
        List<String> function = Arrays.asList("餘額查詢", "交易明細", "最新消息", "投資理財", "離開");
        ArrayAdapter<String> gridViewIn = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, function);
        functionGridViewIn.setAdapter(gridViewIn);
        functionGridViewIn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent test = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(test);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        finish();
                        break;
                }
            }
        });
    }

    private void gridViewOut() {
        GridView functionGridViewOut = findViewById(R.id.grid);
        ArrayAdapter<CharSequence> gridOut =
                ArrayAdapter.createFromResource(this, R.array.functionList, android.R.layout.simple_list_item_1);
        functionGridViewOut.setAdapter(gridOut);
        functionGridViewOut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent test = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(test);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        finish();
                        break;
                }
            }
        });
    }

    private void spinnerIn() {
        Spinner notifySpinnerIn = findViewById(R.id.spinner);
        List<String> notify = Arrays.asList("震動", "靜音", "有聲");
        final ArrayAdapter spinnerIn =
                new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, notify);
        notifySpinnerIn.setAdapter(spinnerIn);
        notifySpinnerIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spinnerIn.getItem(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spinnerOut() {
        Spinner notifySpinnerOut = findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> notifyOut =
                ArrayAdapter.createFromResource(this, R.array.notifyList, android.R.layout.simple_spinner_dropdown_item);
        notifySpinnerOut.setAdapter(notifyOut);
        notifySpinnerOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, notifyOut.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void listViewIn() {
        ListView functionListViewIn = findViewById(R.id.listView);
        List<String> function = Arrays.asList("餘額查詢", "交易明細", "最新消息", "投資理財", "離開");
        ArrayAdapter listViewIn = new ArrayAdapter(this, android.R.layout.simple_list_item_1, function);
        functionListViewIn.setAdapter(listViewIn);
        functionListViewIn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent test = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(test);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        finish();
                        break;
                }
            }
        });
    }

    private void listViewOut() {
        ListView functionListViewOut = findViewById(R.id.listView);
        ArrayAdapter<CharSequence> functionOut =
                ArrayAdapter.createFromResource(this, R.array.functionList, android.R.layout.simple_list_item_1);
        functionListViewOut.setAdapter(functionOut);
        functionListViewOut.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent test = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(test);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        finish();
                        break;
                }
            }
        });
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

