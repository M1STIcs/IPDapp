package sn.ipd.myschool.ui.university;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UniversityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UniversityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}