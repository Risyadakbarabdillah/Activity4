package com.example.activity2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Deklarasi variable untuk button
    Button btnLogin;

    //Deklarasi variable untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variable untuk menyimpan email dan password
    String nama, password;

    String correct_edemail = "admin@gmail.com";
    String correct_edpassword = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variable btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variable edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variable edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclick pada btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variable nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variable password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@gmail.com";

                //mengeset password yang benar
                String pass = "123";

                //Memvalidasi input
                if (TextUtils.isEmpty(edemail.getText().toString()) || TextUtils.isEmpty(edpassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Email dan Password Salah", Toast.LENGTH_LONG).show();
                } else if (edemail.getText().toString().equals(correct_edemail)) {
                    //check password
                    if (edpassword.getText().toString().equals(correct_edpassword)) {
                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_LONG).show();
                }

                //mengecek apakah isi dari email dan password sudah sama dengan email dan
                // password yang sudah diset
                if (nama.equals(email) && password.equals(pass)) {
                    //membuat variabel toast dan menampilkan pesan "Login sukses"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email anda: " + nama + "dan password anda: " + password + "",
                            Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    // dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    // dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);
                } else {
                    //membuat variabel dengan toast dan membuat toast dan menampilkan pesan "Login gagal"

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Gagal", Toast.LENGTH_LONG);

                    //menampilkan toast
                    t.show();
                }
            }
        });
    }
}