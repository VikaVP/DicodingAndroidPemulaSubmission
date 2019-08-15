package com.example.appsvikavp;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFauna;

    private ArrayList<Fauna> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFauna = findViewById(R.id.rv_fauna);
        rvFauna.setHasFixedSize(true);

        list.addAll(FaunaData.getListData());
        showRecyclerCardView();

        if (getSupportActionBar() != null ){
            getSupportActionBar().setTitle("FAUNA INDONESIA");
        }

    }

    private void showRecyclerCardView() {
        rvFauna.setLayoutManager(new LinearLayoutManager(this));
        ListFaunaAdapter listFaunaAdapter = new ListFaunaAdapter(list);
        rvFauna.setAdapter(listFaunaAdapter);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprofil, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.my_profile){
            startActivity(new Intent(this, MyProfile.class));
        }
        return true;
    }

}