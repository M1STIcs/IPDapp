package sn.ipd.myschool;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {
    private EditText formation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        formation = findViewById(R.id.formation);
        Intent intent = getIntent();
        if (intent != null) {
            String formationChoisie = "";
            if (intent.hasExtra("formationExtra")) {
                formationChoisie = intent.getStringExtra("formationExtra");
                formation.setText(formationChoisie);
            }
        }
    }
}
