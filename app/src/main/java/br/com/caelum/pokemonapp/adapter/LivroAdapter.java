package br.com.caelum.pokemonapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import br.com.caelum.pokemonapp.R;
import br.com.caelum.pokemonapp.classes.Livro;

/**
 * Created by solzanir on 02/11/16.
 */

public class LivroAdapter extends BaseAdapter {

    private final List<Livro> livros;
    private final Activity activity;

    public LivroAdapter(Activity activity, List<Livro> livros) {
        this.livros = livros;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int i) {
        return livros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return livros.get(i).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        View livroView = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);

        Livro livro = livros.get(posicao);

        TextView nomeLivro = (TextView) livroView.findViewById(R.id.item_nomeLivro);
        ImageView capaLivro = (ImageView) livroView.findViewById(R.id.item_capa);

        nomeLivro.setText(livro.getNome());

        //Para a capa utilizar o Picasso

        return livroView;
    }
}
