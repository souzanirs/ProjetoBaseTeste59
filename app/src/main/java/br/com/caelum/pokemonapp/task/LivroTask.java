package br.com.caelum.pokemonapp.task;

import android.os.AsyncTask;
import java.util.List;
import br.com.caelum.pokemonapp.classes.Livro;

/**
 * Created by solzanir on 01/11/16.
 */

public class LivroTask extends AsyncTask<Object, Object, List<Livro>>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Livro> doInBackground(Object... objects) {

        //conecta com o webservice e retorna a lista de livros (JSON)

        return null;
    }

    @Override
    protected void onPostExecute(List<Livro> livros) {
        super.onPostExecute(livros);
    }
}
