package com.example.prgm17;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button b1, b2;
    TextView txt;
    EditText txt1;

    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt = (TextView) findViewById(R.id.txt);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);

        dbHelper = new DatabaseHelper(this);


        b1.setOnClickListener(v -> {
            String name = txt1.getText().toString().trim();

            if (name.isEmpty()) {
                txt1.setError("Enter a name");
                return;
            }

            if (dbHelper.addName(name)) {
                Toast.makeText(this, "Name added",
                        Toast.LENGTH_SHORT).show();
                txt1.setText("");
            } else {
                Toast.makeText(this, "Failed to add name",
                        Toast.LENGTH_SHORT).show();
            }
        });


        b2.setOnClickListener(v -> {
            String names = dbHelper.getAllNames();
            txt.setText(names);
        });
    }

}