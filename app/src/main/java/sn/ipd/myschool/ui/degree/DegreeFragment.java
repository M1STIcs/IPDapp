package sn.ipd.myschool.ui.degree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import sn.ipd.myschool.R;

public class DegreeFragment extends Fragment {

    private DegreeViewModel degreeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        degreeViewModel =
                ViewModelProviders.of(this).get(DegreeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_university, container, false);
        final TextView textView = root.findViewById(R.id.text_degree);
        degreeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}