package com.nexis.fitnesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.AbstractCollection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    BottomNavigationView bottomnavi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomnavi= findViewById(R.id.navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Yemekler_frag()).commit();

        bottomnavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.yediklerin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Yemekler_frag()).commit();
                        break;
                    case R.id.hesap:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Hesapla_frag()).commit();
                        break;
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new Profil_frag()).commit();

                        break;
                }

                return false;
            }
        });


    }
}