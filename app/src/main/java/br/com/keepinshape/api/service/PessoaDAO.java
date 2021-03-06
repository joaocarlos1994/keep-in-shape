package br.com.keepinshape.api.service;

import android.content.Context;

import java.util.List;

import br.com.keepinshape.api.entity.Pessoa;


/**
 * Created by Joao on 17/08/2015.
 */
public interface PessoaDAO {

    boolean save(Pessoa pessoa, Context context);
    Pessoa findById (int id, Context context);
    Pessoa update (Pessoa pessoa, Context context);
    boolean remove (Pessoa pessoa, Context context);
    List<Pessoa> findAll(Context context);
    public List<Pessoa> customizedQueryPessoa(String query, Context context);

}
