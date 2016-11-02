package br.com.caelum.pokemonapp.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.pokemonapp.classes.Autor;
import br.com.caelum.pokemonapp.classes.Livro;

/**
 * Created by android6275 on 01/11/16.
 */

public class LivroConverter {

    private final String ID = "id";
    private final String DESCRICAO_LIVRO = "descricaoLivro";
    private final String DATA_PUBLICACAO = "dataPublicacao";
    private final String ISBN = "isbn";
    private final String NUMERO_PAGINAS = "numeroPaginas";
    private final String VALOR_FISICO = "valorFisico";
    private final String VALOR_VIRTUAL = "valorVirtual";
    private final String VALOR_VIRTUAL_COM_FISICO = "valorVirtualComFisico";
    private final String URL_IMAGEM = "imagemUrl";
    private final String ID_AUTOR = "idAutor";
    private final String NOME_AUTOR = "nomeAutor";
    private final String DETALHES_AUTOR = "detalhesAutor";
    private final String IMAGEM_AUTOR = "imagemAutor";
    private final String AUTORES = "autores";
    private final String LISTA_ITENS = "itens";
    private final String LIVROS = "livros";
    private final String NOME_LIVRO = "nomeLivro";
    private final String TIPO_LIVRO = "formatoLivro";
    private final String USUARIO = "usuario";
    private final String EMAIL = "email";
    private final String LIVRO = "livro";

    public List<Livro> fromJson(String json) throws JSONException {

        List<Livro> livros = new ArrayList<>();

        if (json != null) {

            JSONObject jsonObjectTodosLivros = new JSONObject(json);
            JSONArray jsonArrayLivros = jsonObjectTodosLivros.getJSONArray(LIVROS);

            int nLivros = jsonArrayLivros.length();
            for (int i = 0; i < nLivros; i++) {

                JSONObject objectLivro = jsonArrayLivros.getJSONObject(i);

                Livro livro = geraLivroPorJSONObject(objectLivro);

                List<Autor> autores = getAutores(objectLivro);

                livro.setAutores(autores);

                livros.add(livro);
            }
        }
        return livros;
    }

    private List<Autor> getAutores(JSONObject objectLivro) throws JSONException {
        List<Autor> autors = new ArrayList<>();

        JSONArray jsonArrayAutores = objectLivro.getJSONArray(AUTORES);

        int nAutores = jsonArrayAutores.length();
        for (int j = 0; j < nAutores; j++) {

            JSONObject objectAutor = jsonArrayAutores.getJSONObject(j);

            Autor autor = geraAutorPorJSONObjetct(objectAutor);

            autors.add(autor);
        }
        return autors;
    }

    private Livro geraLivroPorJSONObject(JSONObject objectLivro) throws JSONException {
        Livro livro = new Livro();

        livro.setId(objectLivro.getLong(ID));
        livro.setNome(objectLivro.getString(NOME_LIVRO));
        livro.setDescricao(objectLivro.getString(DESCRICAO_LIVRO));
        livro.setDataPublicacao(objectLivro.getString(DATA_PUBLICACAO));
        if (objectLivro.has(ISBN)) {
            livro.setISBN(objectLivro.getString(ISBN));
        } else {
            livro.setISBN(objectLivro.getString("ISBN"));
        }
        livro.setNumPaginas(objectLivro.getInt(NUMERO_PAGINAS));
        livro.setValorFisico(objectLivro.getDouble(VALOR_FISICO));
        livro.setValorVirtual(objectLivro.getDouble(VALOR_VIRTUAL));
        livro.setValorDoisJuntos(objectLivro.getDouble(VALOR_VIRTUAL_COM_FISICO));
        livro.setImagemUrl(objectLivro.getString(URL_IMAGEM));

        return livro;
    }


    private Autor geraAutorPorJSONObjetct(JSONObject objectAutor) throws JSONException {
        Autor autor = new Autor();

        autor.setIdAutor(objectAutor.getLong(ID_AUTOR));
        autor.setNomeAutor(objectAutor.getString(NOME_AUTOR));
        autor.setDetalhesAutor(objectAutor.getString(DETALHES_AUTOR));
        autor.setImagemAutorUrl(objectAutor.getString(IMAGEM_AUTOR));

        return autor;
    }
}