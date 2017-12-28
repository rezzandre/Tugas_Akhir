package com.example.rezzandre.surgaresep;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivity extends AppCompatActivity {

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    EditText judul, bahan, langkah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        getSupportActionBar().setTitle("Tambah Resep");

        judul = findViewById(R.id.tambah_judul);
        bahan = findViewById(R.id.tambah_bahan);
        langkah = findViewById(R.id.tambah_langkah);
    }

    public void tambah(View view) {
        String mjudul, mbahan, mlangkah, mpenulis;

        SharedPreferences preferences = getSharedPreferences(LoginActivity.loginsPref, 0);

        mjudul = judul.getText().toString();
        mbahan = bahan.getText().toString();
        mlangkah = langkah.getText().toString();
        mpenulis = preferences.getString("user", "");

        if (mjudul.isEmpty() && mbahan.isEmpty() && mlangkah.isEmpty()) {
            Toast.makeText(this, "Ada field kosong", Toast.LENGTH_SHORT).show();
        } else {
            DatabaseReference ceritaRef = ref.child("resep");

            ceritaRef.push().setValue(new Resep(mjudul, mbahan, mlangkah, mpenulis));
            Toast.makeText(this, "Resep di tambahkan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
