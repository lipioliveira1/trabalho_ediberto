package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.view.View;

import android.widget.Toast;



public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        EditText usuario = (EditText) findViewById(R.id.textUsuario);

        EditText senha = (EditText) findViewById(R.id.textSenha);

        Button acesso = (Button) findViewById(R.id.acesso);



        setTitle("Trabalho Final - Marcos Filipi Oliveira");



        acesso.setOnClickListener((new View.OnClickListener(){

            @Override



            public void onClick(View view){

                if(usuario.getText().toString().equals("marcos filipi") &&

                        senha.getText().toString().equals("0000")){



                    Intent intent = new Intent(MainActivity.this, ListarClientesActivity.class);

                    intent.putExtra("usuario", usuario.getText().toString());



                    startActivity(intent);

                }



                else {

                    Toast.makeText(MainActivity.this, "Login ou senha invalidos!", Toast.LENGTH_LONG).show();

                }

            }

        }));



    }

}