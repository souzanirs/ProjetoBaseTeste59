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

        //Instanciando um livro na mão
        Livro livro = new Livro();
        livro.setNome("Livro de Android Avançado");
        livro.setImagemUrl("http://1.bp.blogspot.com/-6ngm0VJaKSM/VH9kHnXUgLI/AAAAAAAACAs/9e-xji45vSg/s1600/capa_livro.png");
        livro.setValorVirtual(39.9);
        livro.setISBN("14152535246");
        livro.setDescricao("Um livro sobre Android Avançado, muito avançado");
        livro.setNumPaginas(143);

        Livro livro2 = new Livro();
        livro.setNome("Livro de Android Basico");
        livro.setImagemUrl("http://ishop.s8.com.br/produtos/01/00/item/118035/8/118035866_1GG.jpg");
        livro.setValorVirtual(19.9);
        livro.setISBN("14152535246");
        livro.setDescricao("Um livro sobre Android Basico, muito basico");
        livro.setNumPaginas(129);

        //chamando o layout do fragment
        View listaLivros = inflater.inflate(R.layout.fragment_lista_livros, container, false);

        //chamando a lista view que receberá os livros
        livrosView = (ListView) listaLivros.findViewById(R.id.lista_livros_view);

        //Adicionando o livro novo a lista de livros
        List<Livro> listaDeLivros = Arrays.asList(livro, livro2);

        //Instanciando o adapter com o layout da lista a ser exibida na tela, e lista de livros com o conteúdo
        LivroAdapter adapter = new LivroAdapter(getActivity(), listaDeLivros);

        //passando o adapter preenchido para nossa lista exibi-lo
        livrosView.setAdapter(adapter);

        return listaLivros;
    }
}
