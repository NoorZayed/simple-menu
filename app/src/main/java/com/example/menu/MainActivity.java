package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private Spinner spnmenu;
private Button btnsearch;
private ListView lstitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        populateSpiner();
        btnsearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DatabaseItems dp = new DatabaseItems();
                String cat = spnmenu.getSelectedItem().toString();

                List<MenuItem> result = dp.getMenuItems(cat);
                MenuItem[] arr = result.toArray(new MenuItem[result.size()]);
                ArrayAdapter <MenuItem> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arr);
               lstitems.setAdapter(adapter);

            }
        });
    }

    private void populateSpiner() {
        DatabaseItems dp = new DatabaseItems();
        String [] cats = dp.getCategories();
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cats);
        spnmenu.setAdapter(adapter);
    }

    private void setupViews() {
        spnmenu = findViewById(R.id.spnmenu);
        btnsearch=findViewById(R.id.btnsearch);
        lstitems=findViewById(R.id.lstitems);
    }
}