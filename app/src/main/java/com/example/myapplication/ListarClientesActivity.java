package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;



import android.content.DialogInterface;

import android.content.Intent;

import android.os.Bundle;

import android.view.ContextMenu;

import android.view.Menu;

import android.view.MenuInflater;

import android.view.MenuItem;

import android.widget.Adapter;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.ListView;

import android.widget.SearchView;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

public class ListarClientesActivity extends AppCompatActivity {

    private ListView listView;

    private ClienteDAO dao;

    private List<Cliente> clientes;

    private List<Cliente> clientesFiltrado = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar_clientes);

        listView = findViewById(R.id.lista_clientes);

        dao = new ClienteDAO(this);

        clientes = dao.obterTodos();

        clientesFiltrado.addAll(clientes);

        setTitle("Lista de Clientes");

        ArrayAdapter<Cliente> adaptador = new ArrayAdapter<Cliente>(this,

                android.R.layout.simple_list_item_1, clientesFiltrado);

        listView.setAdapter(adaptador);



        registerForContextMenu(listView);

    }

    @Override

    public void onResume(){

        super.onResume();

        clientes = dao.obterTodos();

        clientesFiltrado.clear();

        clientesFiltrado.addAll(clientes);

        listView.invalidateViews();

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater i = getMenuInflater();

        i.inflate(R.menu.menu_principal, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override

            public boolean onQueryTextSubmit(String s){

                return false;

            }

            @Override

            public boolean onQueryTextChange(String s){

                System.out.println("Digitou " + s);

                procuraCliente(s);

                return false;

            }

        });

        return true;

    }

    public void procuraCliente(String nome){

        clientesFiltrado.clear();

        for(Cliente c:clientes){

            if(c.getNome().toLowerCase().contains(nome.toLowerCase())){

                clientesFiltrado.add(c);

            }

        }

        listView.invalidateViews();

    }

    public void cadastrarr(MenuItem item){

        Intent it = new Intent(ListarClientesActivity.this, MainActivity2.class );

        Bundle bundle = getIntent().getExtras();

        String usuario = bundle.getString("usuario");

        it.putExtra("usuario", usuario.toString());

        startActivity(it);

    }

    public void onCreateContextMenu(ContextMenu menu, android.view.View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater i = getMenuInflater();

        i.inflate(R.menu.menu_contexto, menu);

    }

    public void excluir(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo =

                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Cliente clienteExcluir = clientesFiltrado.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)

                .setTitle("Atenção")

                .setMessage("Deseja mesmo excluir o cliente?")

                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                    @Override

                    public void onClick(DialogInterface dialogInterface, int i) {

                        dao.excluir(clienteExcluir);

                        clientesFiltrado.remove(clienteExcluir);

                        clientes.remove(clienteExcluir);

                        listView.invalidateViews();

                    }

                }).create(); //OBS

        dialog.show();

    }
    public void atualizar(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Cliente clienteatualizar = clientesFiltrado.get(menuInfo.position);
        Intent it = new Intent(this, MainActivity2.class);
        it.putExtra("cliente", clienteatualizar);
        startActivity(it);
    }


}