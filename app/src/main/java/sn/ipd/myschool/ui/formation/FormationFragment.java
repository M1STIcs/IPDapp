package sn.ipd.myschool.ui.formation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import sn.ipd.myschool.InscriptionActivity;
import sn.ipd.myschool.R;

public class FormationFragment extends Fragment {

    private FormationViewModel formationViewModel;
    private ListView listFormation;
    private String[] tabFormation, tabDetail;
    private String formation, detail;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        formationViewModel =
                ViewModelProviders.of(this).get(FormationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_formation, container, false);
        listFormation = root.findViewById(R.id.listFormation);
        tabFormation = getResources().getStringArray(R.array.tabFormation);

        tabDetail = getResources().getStringArray(R.array.tabDetail);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, tabFormation);
        //nous avons chargé la liste

        listFormation.setAdapter(adapter);

        //nous allons gerer le click sur l'élément
        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                formation = tabFormation[i];
                detail = tabDetail[i];
                final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                //l'icone de la boite de dialog
                dialog.setIcon(R.mipmap.ic_launcher);
                //le ditre de la boite
                dialog.setTitle(formation);
                //le message (les détails de la formation choisie)
                dialog.setMessage(detail);
                //les boutons cancel et ok
                dialog.setNegativeButton(getString(R.string.cancel), null);
                dialog.setPositiveButton(getString(R.string.inscription), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//
                        Intent intent = new Intent(getActivity(), InscriptionActivity.class);
                        intent.putExtra("formationExtra", formation);
                        startActivity(intent);
/*
                        FragmentManager frman = getParentFragmentManager();
                        FragmentTransaction ftran = frman.beginTransaction();
                        Fragment ffrag = new HomeFragment();
                        ftran.replace(R.id.container, ffrag);
                        ftran.commit();*/
                    }

                });
                dialog.show();
            }
        });
        final TextView textView = root.findViewById(R.id.text_formation);
        /**formationViewModel.getText().observe(this, new Observer<String>() {
        @Override public void onChanged(@Nullable String s) {
        textView.setText(s);
        }
        });
         **/
        return root;
    }
}