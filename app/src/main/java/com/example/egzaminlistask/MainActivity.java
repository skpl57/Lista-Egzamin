package com.example.egzaminlistask;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaZadan;
    private EditText opisZadania;
    private Button dodajBtn;
    private ArrayAdapter<Todo> arrayAdapter;
    private ArrayList<Todo> arrayList;
    private Spinner spinner;

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
        spinner = findViewById(R.id.spinner);

        arrayList = new ArrayList<>();
        arrayList.add(new Todo("Wyjście do kina", (byte) 1));
        arrayList.add(new Todo("Pomyśleć ciepło o projekcie", (byte) 0));
        arrayList.add(new Todo("Bajlando w domu", (byte) 2));

        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList);

        listaZadan.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );


        dodajBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String rzeczDoZrobienia = opisZadania.getText().toString();
                        byte priorytet = (byte) spinner.getSelectedItemPosition();
                        arrayList.add(new Todo(rzeczDoZrobienia, priorytet));
                        arrayAdapter.notifyDataSetChanged();
                        opisZadania.setText("");
                    }
                }
        );

        listaZadan.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        TextView textView = (TextView) view;
                        if(arrayList.get(i).isCzyWykonane()){
                            arrayList.get(i).setCzyWykonane(false);
                            textView.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                            view.setBackgroundColor(Color.WHITE);
                        }
                        else{
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            view.setBackgroundColor(Color.GRAY);
                            arrayList.get(i).setCzyWykonane(true);
                        }
                    }
                }
        );
//
//        listaZadan.setOnItemLongClickListener(
//                new AdapterView.OnItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        arrayList.remove(i);
//                        arrayAdapter.notifyDataSetChanged();
//                        return false;
//                    }
//                }
//        );

    }
}