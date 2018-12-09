package com.steven.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    int [] ageChoose = {10,11,12,13,14,15};
    private TextView edAge;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        edAge = findViewById(R.id.ed_age);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new ageAdpter());
    }
    class ageAdpter extends RecyclerView.Adapter<ageAdpter.ageViewHolder> {
        @NonNull
        @Override
        public ageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.age_row,viewGroup,false);
            return new ageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ageViewHolder ageViewHolder, int i) {
            ageViewHolder.ageText.setText(ageChoose[i]+"");
        }

        @Override
        public int getItemCount() {
            return ageChoose.length;
        }

        class ageViewHolder extends RecyclerView.ViewHolder {
            TextView ageText;
            public ageViewHolder(@NonNull View itemView) {
                super(itemView);
                ageText = itemView.findViewById(R.id.ageText);
            }
        }
    }

    public void next(View view){
        age = Integer.parseInt(edAge.getText().toString());
//        getSharedPreferences("user",MODE_PRIVATE)
//                .edit()
//                .putInt("USERAGE",age)
//                .apply();
        user.setAge(age);
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view){
        finish();
    }
}
