package com.example.androidtest.multisection;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class TypeModel {
    public ObservableInt imageId = new ObservableInt();

    public ObservableField<String> name = new ObservableField<>();

    public ObservableField<String> imageUrl = new ObservableField<>();

    public ObservableInt typeId = new ObservableInt();

    public TypeModel() {
    }

    public TypeModel(ObservableInt imageId, ObservableField<String> name, ObservableField<String> imageUrl, ObservableInt typeId) {
        this.imageId = imageId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.typeId = typeId;
    }
}
