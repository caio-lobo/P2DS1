/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n2ds1.caio.lobo.DAOs;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anamm
 */
public interface IDAO {
    public void adicionar(Object o) throws SQLException;
    public void alterar(Object o) throws SQLException;
    public void excluir(Object o) throws SQLException;
    public void excluir(Long id) throws SQLException;
    public List listarTodos() throws SQLException;
    public Object listarPorId(Long id) throws SQLException;
}
