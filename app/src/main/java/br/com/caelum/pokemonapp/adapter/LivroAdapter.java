package br.com.caelum.pokemonapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

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
    public View getView(int posicao, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){

            view = LayoutInflater.from(activity).inflate(R.layout.item, viewGroup, false);

            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }

        Livro livro = (Livro) getItem(posicao);

        holder.nomeLivro.setText(livro.getNome());
        holder.valorLivro.setText("R$ " + String.valueOf(livro.getValorVirtual()));
        Picasso.with(activity).load(livro.getImagemUrl()).into(holder.capaLivro);

        return view;
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

    class ViewHolder{

        TextView nomeLivro;
        TextView valorLivro;
        ImageView capaLivro;

        ViewHolder(View view){
            this.nomeLivro = (TextView) view.findViewById(R.id.item_nomeLivro);
            this.valorLivro = (TextView) view.findViewById(R.id.item_valorLivro);
            this.capaLivro = (ImageView) view.findViewById(R.id.item_capa);
        }

    }

}
