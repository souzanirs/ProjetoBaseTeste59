package br.com.caelum.pokemonapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.caelum.pokemonapp.R;

/**
 * Created by solzanir on 02/11/16.
 */

public class DetalheLivroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View detalheLivro = inflater.inflate(R.layout.fragment_detalhes_livro, container,false);

        return detalheLivro;
    }
}
