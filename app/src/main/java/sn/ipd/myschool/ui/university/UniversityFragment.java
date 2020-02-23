package sn.ipd.myschool.ui.university;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import sn.ipd.myschool.R;

public class UniversityFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    private UniversityViewModel universityViewModel;
    private GoogleMap mMap;

    public UniversityFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //  universityViewModel =
        //        ViewModelProviders.of(this).get(UniversityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_university, container, false);
       /* final TextView textView = root.findViewById(R.id.text_university);
        universityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        //   mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        // mapFragment=(SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            FragmentManager fm = getParentFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in IPD and move the camera
        LatLng ipd = new LatLng(14.7382738, -17.4669431);
        mMap.addMarker(new MarkerOptions().position(ipd).title("IPD")
                .snippet("IPD Thomas Sankara, Sud Foire Dakar, Téléphone : 33 867 90 45"));
        // Add a marker in UCAD and move the camera
        LatLng ucad = new LatLng(14.6903724, -17.4663242);
        mMap.addMarker(new MarkerOptions().position(ucad).title("UCAD")
                .snippet("Université Cheikh Anta Diop de Dakar, Avenue Cheikh Anta Diop, Téléphone : 33 867 90 45"));
//La caméra sur un seul lieu
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ipd, 13));
    }
}