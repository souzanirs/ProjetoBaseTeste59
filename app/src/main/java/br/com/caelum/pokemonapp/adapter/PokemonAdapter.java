package br.com.caelum.pokemonapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import br.com.caelum.pokemonapp.R;
import br.com.caelum.pokemonapp.event.PokemonEvent;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by matheus on 01/11/16.
 */
public class PokemonAdapter extends RecyclerView.Adapter {
    private final List<String> listaPokemons;

    public PokemonAdapter(List<String> listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        String url = listaPokemons.get(position);

        Glide.with(viewHolder.foto.getContext())
                .load(url)
                .asGif()
                .placeholder(android.R.drawable.stat_sys_warning)
                .into(viewHolder.foto);
    }

    @Override
    public int getItemCount() {
        return listaPokemons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imagem)
        ImageView foto;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.item)
        public void clickNoItem() {

            // broadcast + delegate
            EventBus.getDefault().post(new PokemonEvent(listaPokemons.get(getAdapterPosition())));

        }
    }
}
