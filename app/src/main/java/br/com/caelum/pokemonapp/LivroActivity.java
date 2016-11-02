package br.com.caelum.pokemonapp;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.caelum.pokemonapp.fragment.DetalheLivroFragment;
import br.com.caelum.pokemonapp.fragment.ListaLivroFragment;

/**
 * Created by solzanir on 01/11/16.
 */

public class LivroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(isLand()){
            transaction.replace(R.id.livros_lista, new ListaLivroFragment());
            transaction.replace(R.id.livros_detalhes, new DetalheLivroFragment());
        } else {
            transaction.replace(R.id.livros_view, new ListaLivroFragment());
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_lista_livros, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_pega_livros:

                new BuscaLivroTask(this).execute();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isLand(){
        return getResources().getBoolean(R.bool.isLand);
    }

}
