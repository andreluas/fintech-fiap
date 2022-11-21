package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.exceptions.DBException;
import br.com.fiap.fintech.model.Usuario;

public interface UsuarioDAO {

    boolean validUser(Usuario user);
    boolean validEmail(String email);
    Usuario findByEmail(String email);
    void registerUser(Usuario user) throws DBException ;
}
