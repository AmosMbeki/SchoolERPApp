package it.com.ke.mainui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import it.com.ke.R;

public class Students extends AppCompatActivity {

    private EditText xADM, xNAME, xSTREAM;
    private Button xCapture;
    DatabaseReference studentDatabaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        xADM = findViewById(R.id.adm);
        xNAME = findViewById(R.id.name);
        xSTREAM = findViewById(R.id.stream);

        xCapture = findViewById(R.id.capdata_btn);

        studentDatabaseReference = FirebaseDatabase.getInstance().getReference().child("StudentDatabase");

        xCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String admission = xADM.getText().toString();
                String student_name = xNAME.getText().toString();
                String student_stream = xSTREAM.getText().toString();

                final HashMap<String, Object> studentData = new HashMap<>();

                studentData.put("admission_number", admission);
                studentData.put("student_name", student_name);
                studentData.put("student_stream", student_stream);

                studentDatabaseReference.push().setValue(studentData);
            }
        });
    }
}