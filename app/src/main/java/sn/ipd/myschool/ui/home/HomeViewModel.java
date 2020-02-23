package sn.ipd.myschool.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bienvenue sur IPDapp \n" +
                "Pour toutes informations complémentaires, veuillez contactez notre service administratif.:\n" +
                "- \n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}