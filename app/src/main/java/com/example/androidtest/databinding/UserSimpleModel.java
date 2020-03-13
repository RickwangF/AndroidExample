package com.example.androidtest.databinding;

import android.databinding.ObservableField;

public class UserSimpleModel {

    public ObservableField<String> UserName = new ObservableField<>();

    public ObservableField<String> FamilyName = new ObservableField<>();

    public UserSimpleModel() {
    }

    public UserSimpleModel(String userName, String familyName) {
        this.UserName.set(userName);
        this.FamilyName.set(familyName);
    }
}
