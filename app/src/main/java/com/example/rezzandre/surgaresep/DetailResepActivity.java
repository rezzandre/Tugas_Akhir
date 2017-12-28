package com.example.rezzandre.surgaresep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailResepActivity extends AppCompatActivity {

    TextView judul, penulis, bahan, langkah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        Intent intent = getIntent();

        getSupportActionBar().setTitle(intent.getStringExtra("judul"));

        judul = findViewById(R.id.judul);
        penulis = findViewById(R.id.penulis);
        bahan = findViewById(R.id.bahan);
        langkah = findViewById(R.id.langkah);

        judul.setText(intent.getStringExtra("judul"));
        penulis.setText("ditulis oleh: "+intent.getStringExtra("penulis"));
        bahan.setText(intent.getStringExtra("bahan"));
        langkah.setText(intent.getStringExtra("langkah"));
    }
}
