package com.steven.atm;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    String id;
    String nickname;
    int age;
    int gender;
    private Context context;
    SharedPreferences setting;
    boolean Valid;

    public User(Context context) {
        this.context = context;
        setting = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public String getId() {
        id = setting.getString("USERID", null);
        return id;
    }

    public void setId(String id) {
        setting.edit()
                .putString("USERID", id)
                .apply();
        this.id = id;
    }

    public String getNickname() {
        nickname = setting.getString("USERNICKNAME", null);
        return nickname;
    }

    public void setNickname(String nickname) {
        setting.edit()
                .putString("USERNICKNAME", nickname)
                .apply();
        this.nickname = nickname;
    }

    public int getAge() {
        age = setting.getInt("USERAGE", 0);
        return age;
    }

    public void setAge(int age) {
        setting.edit()
                .putInt("USERAGE", age)
                .apply();
        this.age = age;
    }

    public int getGender() {
        gender = setting.getInt("USERGENDER", 0);
        return gender;
    }

    public void setGender(int gender) {
        setting.edit()
                .putInt("USERGENDER", gender)
                .apply();
        this.gender = gender;
    }

    public boolean isValid() {
        Valid = getNickname() != null && getAge() != 0 && getGender() != 0;
        return Valid;
    }
}
