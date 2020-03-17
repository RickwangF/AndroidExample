package com.example.androidtest.multisection;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.androidtest.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MultiTypeViewModel extends ViewModel {

    private MutableLiveData<List<TypeModel>> imageList;

    public MutableLiveData<List<TypeModel>> getImageList() {
        if (imageList == null) {
            imageList = new MutableLiveData<>();
        }
        return imageList;
    }

    public void getImageListSync() {
        List<TypeModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                TypeModel modelOne = new TypeModel();
                modelOne.imageId.set(R.mipmap.ic_lake);
                modelOne.name.set("fuxian lake" + i);
                modelOne.typeId.set(1);
                list.add(modelOne);
            } else {
                TypeModel modelTwo = new TypeModel();
                modelTwo.imageUrl.set("https://dbrestest.jaadee.net/appdir/2020/3/17/5680152c57f1499da701dcc8451f07e320200317092941677974.jpg");
                modelTwo.name.set("tree stand in front of lake" + i);
                modelTwo.typeId.set(2);
                list.add(modelTwo);
            }
        }
        imageList.setValue(list);
    }
}
