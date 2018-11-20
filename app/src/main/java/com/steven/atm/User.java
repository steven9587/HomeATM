package com.steven.atm;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private Context context;
    String id;
    String nickname;
    int age;
    int gender;
    SharedPreferences setting;
    boolean valid;

    public User(Context context){
        this.context = context;
        setting = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }
    public String getId() {
        id = setting.getString("ID",null);
        return id;
    }

    public void setId(String id) {
        setting.edit()
                .putString("ID",id)
                .apply();
        this.id = id;
    }

    public String getNickname() {
        nickname = setting.getString("NICKNAME",nickname);
        return nickname;
    }

    public void setNickname(String nickname) {
        setting.edit()
                .putString("NICKNAME",nickname)
                .apply();
        this.nickname = nickname;
    }

    public int getAge() {
        age = setting.getInt("AGE",age);
        return age;
    }

    public void setAge(int age) {
        setting.edit()
                .putInt("AGE",age)
                .apply();
        this.age = age;
    }

    public int getGender() {
        gender = setting.getInt("GENDER",gender);
        return gender;
    }

    public void setGender(int gender) {
        setting.edit()
                .putInt("GENDER",gender)
                .apply();
        this.gender = gender;
    }

    public boolean isValid() {
        valid = getNickname() != null && getAge() !=0 && getGender() !=0;
        return valid;
    }
}
