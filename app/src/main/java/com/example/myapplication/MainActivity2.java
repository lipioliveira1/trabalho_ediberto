package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;





public class MainActivity2 extends AppCompatActivity {



    private EditText nome;

    private EditText matricula;

    private EditText endereco;

    private EditText numero;

    private EditText complemento;

    private EditText cidade;

    public TextView bemVindo;



    private ClienteDAO dao;
    private Cliente cliente = null;




    @Override



    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main2);



        setTitle("Cadastro de Clientes");

        Intent it = getIntent();



        Bundle bundle = getIntent().getExtras();

        String login = bundle.getString("usuario");



        bemVindo = (TextView) findViewById(R.id.bemVindo);

        bemVindo.setText("Usuário " + login  + ", Bem Vindo");





        nome = (EditText) findViewById(R.id.textNome);

        matricula = (EditText) findViewById(R.id.textMatricula);

        endereco = (EditText) findViewById(R.id.textEndereco);

        numero = (EditText) findViewById(R.id.textNumero);

        complemento = (EditText) findViewById(R.id.textComplemento);

        cidade = (EditText) findViewById(R.id.textCidade);





        dao = new ClienteDAO(this);


        if (it.hasExtra("cliente")) {
            cliente = (Cliente) it.getSerializableExtra("cliente");
            nome.setText(cliente.getNome());
            matricula.setText(cliente.getMatricula());
            endereco.setText(cliente.getEndereco());
            numero.setText(cliente.getNumero());
            complemento.setText(cliente.getComplemento());
           cidade.setText(cliente.getCidade());
        }

    }



    public void salvar(View view) {

        if (cliente == null) {
            Cliente c = new Cliente();
            c.setNome(nome.getText().toString());
            c.setMatricula(matricula.getText().toString());
            c.setEndereco(endereco.getText().toString());
            c.setNumero(numero.getText().toString());
            c.setComplemento(complemento.getText().toString());
            c.setCidade(cidade.getText().toString());

            long id = dao.inserir(c);

            Toast.makeText(this, "cliente id:" + id , Toast.LENGTH_SHORT).show();

        } else {
            cliente.setNome(nome.getText().toString());
            cliente.setMatricula(matricula.getText().toString());
            cliente.setEndereco(endereco.getText().toString());
            cliente.setNumero(numero.getText().toString());
            cliente.setComplemento(complemento.getText().toString());
            cliente.setCidade(cidade.getText().toString());
            dao.atualizar(cliente);

            Toast.makeText(this, "Atualizado com Sucesso" , Toast.LENGTH_SHORT).show();
        }


    }



}