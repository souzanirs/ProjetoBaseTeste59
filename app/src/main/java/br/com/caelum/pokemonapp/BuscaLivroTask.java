package br.com.caelum.pokemonapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by solzanir on 02/11/16.
 */

public class BuscaLivroTask extends AsyncTask<Void, Void, String> {

    private ProgressDialog progress;
    private final LivroActivity context;
    String url = "http://cdcmob.herokuapp.com/listarlivros?indicePrimeiroLivro=0&qtdLivros=10";

    public BuscaLivroTask(LivroActivity livroActivity) {
        this.context = livroActivity;
    }

    @Override
    protected String doInBackground(Void... objects) {

        WebClient webClient = new WebClient();
        String resposta = null;

        try {
            resposta = webClient.execute(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {
        progress.dismiss();
        Toast.makeText(context, "REPOSTA WEBSERVICE: "+resposta, Toast.LENGTH_LONG).show();
        super.onPostExecute(resposta);
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(context,"Aguarde","Baixando livros...",true, true);
    }
}
