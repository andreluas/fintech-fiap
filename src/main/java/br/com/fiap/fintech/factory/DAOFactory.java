package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.EntradaDAO;
import br.com.fiap.fintech.dao.SaidaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.service.OracleEntradaDAO;
import br.com.fiap.fintech.service.OracleSaidaDAO;
import br.com.fiap.fintech.service.OracleUsuarioDAO;

public class DAOFactory {

    public static UsuarioDAO getUsuarioDAO() {
        return new OracleUsuarioDAO();
    }
    
    public static EntradaDAO getEntradaDAO() {
        return new OracleEntradaDAO();
    }
    
    public static SaidaDAO getSaidaDAO() {
        return new OracleSaidaDAO();
    }
}
