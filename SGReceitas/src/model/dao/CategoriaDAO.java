/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author hellk
 */
public class CategoriaDAO{
    
    Connection con;
    
    public CategoriaDAO(){
        con = ConnectionFactory.getConnection();
    }
    
     public void create(Categoria c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO categoria (nome, descricao)VALUES(?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getDescricao());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     
     public List<Categoria> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
               
                produtos.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

 /*    
 public List<Categoria> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
               
                produtos.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }    */
    
     public  Categoria readForID(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Categoria categoria = new Categoria();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE id = ?");
            stmt.setInt(1,id);
            
            
            rs = stmt.executeQuery();

            rs.next();

                
                
                
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
              
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return categoria;

    }

     
    public void update(Categoria p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE categoria SET nome = ? , descricao = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public void delete(Categoria p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM categoria WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    
}
