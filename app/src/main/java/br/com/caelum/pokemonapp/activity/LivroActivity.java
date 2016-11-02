package br.com.caelum.pokemonapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.caelum.pokemonapp.R;
import br.com.caelum.pokemonapp.fragment.ListaLivroFragment;

/**
 * Created by solzanir on 01/11/16.
 */

public class LivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livro_activity);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.livros_view, new ListaLivroFragment());
        transaction.commit();

    }
}
