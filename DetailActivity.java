package com.example.appsvikavp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;



public class DetailActivity extends AppCompatActivity {

    public static final String IMG_FAUNA = "fauna_photo";
    public static final String NAME_FAUNA = "fauna_name";
    public static final String DESC_FAUNA = "fauna_desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgPhoto =findViewById(R.id.img_item_photo);
        TextView tvName = findViewById(R.id.tv_item_name);
        TextView tvDesc = findViewById(R.id.tv_item_desc);

        Bundle bundle = getIntent().getExtras();
        String nameFauna = getIntent().getStringExtra(NAME_FAUNA);
        String descFauna = getIntent().getStringExtra(DESC_FAUNA);
        String imgFauna = getIntent().getStringExtra(IMG_FAUNA);

        tvName.setText(nameFauna);
        tvDesc.setText(descFauna);
        Glide.with(this).load(imgFauna).into(imgPhoto);

        if (getSupportActionBar() != null ){
            getSupportActionBar().setTitle("DETAIL FAUNA");
        }

    }

}
