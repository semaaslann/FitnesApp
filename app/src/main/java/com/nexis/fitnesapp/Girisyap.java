package com.nexis.fitnesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Girisyap extends AppCompatActivity {

    EditText mail, sifre;
    Button girisyap;

    String dogruEposta = "sema@gmail.com";
    String dogruSifre = "123456";

    String eposta, sifresi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girisyap);
        mail=findViewById(R.id.edtxtposta);
        sifre=findViewById(R.id.edtxtsifre);
        girisyap=findViewById(R.id.btngirisyap);


        girisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eposta = mail.getText().toString();
                String sifresi = sifre.getText().toString();

                if (eposta.equals(dogruEposta) && sifresi.equals(dogruSifre)) {
                    // Doğru e-posta ve şifre girişi yapıldığında yapılacak işlemler
                    Intent i = new Intent(Girisyap.this, MainActivity.class);
                    startActivity(i);

                    Toast.makeText(Girisyap.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();
                    // Örneğin, yeni bir aktiviteye geçebilirsiniz
                } else {
                    // Yanlış e-posta veya şifre girişi yapıldığında yapılacak işlemler
                    Toast.makeText(Girisyap.this, "Hatalı e-posta veya şifre!", Toast.LENGTH_SHORT).show();
                }


        }
        });
    }
}