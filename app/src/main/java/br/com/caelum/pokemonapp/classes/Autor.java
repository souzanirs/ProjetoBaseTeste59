package br.com.caelum.pokemonapp.classes;

import java.io.Serializable;

/**
 * Created by android6275 on 01/11/16.
 */

public class Autor implements Serializable {

    private String nomeAutor;
    private String detalhesAutor;
    private long idAutor;
    private String imagemAutorUrl;

    public String getImagemAutorUrl() {
        return imagemAutorUrl;
    }

    public void setImagemAutorUrl(String imagemAutorUrl) {
        this.imagemAutorUrl = imagemAutorUrl;
    }

    public long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getDetalhesAutor() {
        return detalhesAutor;
    }

    public void setDetalhesAutor(String detalhesAutor) {
        this.detalhesAutor = detalhesAutor;
    }
}
