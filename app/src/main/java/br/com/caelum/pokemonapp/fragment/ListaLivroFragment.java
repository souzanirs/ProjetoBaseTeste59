package br.com.caelum.pokemonapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

import br.com.caelum.pokemonapp.R;
import br.com.caelum.pokemonapp.adapter.LivroAdapter;
import br.com.caelum.pokemonapp.classes.Livro;

/**
 * Created by solzanir on 02/11/16.
 */

public class ListaLivroFragment extends Fragment {

    private ListView livrosView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //chamando o layout do fragment
        View listaLivros = inflater.inflate(R.layout.fragment_lista_livros, container, false);

        //chamando a lista view que receberá os livros
        livrosView = (ListView) listaLivros.findViewById(R.id.lista_livros_view);

        //Instanciando um livro novo para
        Livro livro = new Livro();
        livro.setNome("NOME DO LIVRO");

        //Adicionando o livro novo a lista de livros
        List<Livro> listaDeLivros = Arrays.asList(livro);

        //Instanciando o adapter com o layout da lista a ser exibida na tela, e lista de livros com o conteúdo
        LivroAdapter adapter = new LivroAdapter(getActivity(), listaDeLivros);

        //passando o adapter preenchido para nossa lista exibi-lo
        livrosView.setAdapter(adapter);

        return listaLivros;
    }
}
