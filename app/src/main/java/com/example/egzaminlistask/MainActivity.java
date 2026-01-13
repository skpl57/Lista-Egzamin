package com.example.egzaminlistask;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ListView listaZadan;
    private TextView opisZadania;
    private Button dodajBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaZadan = findViewById(R.id.lista);
        opisZadania = findViewById(R.id.opisText);
        dodajBtn = findViewById(R.id.dodajBtn);

        dodajBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dodawanieDoListy();
                    }
                }
        );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
            MainActivity.this
        );
        listaZadan.setAdapter();

    }
    private void dodawanieDoListy(){

    }
}