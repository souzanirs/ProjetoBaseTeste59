package br.com.caelum.pokemonapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.pokemonapp.R;
import br.com.caelum.pokemonapp.adapter.PokemonAdapter;
import br.com.caelum.pokemonapp.event.PokemonEvent;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista_pokemons)
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        String p1 = "https://media.giphy.com/media/ff0dv4KMGxjna/giphy.gif";
        String p2 = "https://media.giphy.com/media/tRUtppFnqVGzC/giphy.gif";
        String p3 = "https://media.giphy.com/media/yhfTY8JL1wIAE/giphy.gif";
        String p4 = "https://media.giphy.com/media/Jir3toQTWW9Ne/giphy.gif";
        String p5 = "https://media.giphy.com/media/v9dVqeqoYtkm4/giphy.gif";
        String p6 = "https://media.giphy.com/media/12dQX93ovj3MTS/giphy.gif";
        String p7 = "https://media.giphy.com/media/133cAiXr4T1te/giphy.gif";
        String p8 = "https://media.giphy.com/media/CtoPGag97rqJW/giphy.gif";
        String p9 = "https://media.giphy.com/media/11qiGLrrDQ6EZG/giphy.gif";
        String p10 = "https://media.giphy.com/media/ZUIMfPCruWn3W/giphy.gif";
        String p11 = "https://media.giphy.com/media/MziKDo6gO7x8A/giphy.gif";
        String p12 = "https://media.giphy.com/media/34BEabJLvwcRG/giphy.gif";

        List<String> listaPokemons = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);


        lista.setLayoutManager(new LinearLayoutManager(this));

        lista.setAdapter(new PokemonAdapter(listaPokemons));


    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void recebePokemon(PokemonEvent event) {
        Intent intent = new Intent(this, TelaActivity.class);
        startActivity(intent);
    }
}
