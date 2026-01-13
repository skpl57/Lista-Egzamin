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
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

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

        arrayList = new ArrayList<>();
        arrayList.add("Wyjście do kina");
        arrayList.add("Nauczyć się robienia list w mobilnej");
        arrayList.add("Pomyśleć ciepło o projekcie");

        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList);

        listaZadan.setAdapter(arrayAdapter);


        dodajBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String rzeczDoZrobienia = opisZadania.getText().toString();
                        arrayList.add(rzeczDoZrobienia);
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
                        if(textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG){
                            textView.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                            view.setBackgroundColor(Color.WHITE);
                        }
                        else{
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                            view.setBackgroundColor(Color.GRAY);
                        }
                    }
                }
        );

        listaZadan.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        arrayList.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );

    }
}