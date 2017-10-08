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
import model.Ingrediente;
import model.Receita;
import model.Receita_Ingrediente;

/**
 *
 * @author hellk
 */
public class IngredienteDAO {
    
    Connection con;
    
    public IngredienteDAO(){
        con = ConnectionFactory.getConnection();
    }
    
     public void create(Ingrediente c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ingrediente (nome, descricao)VALUES(?,?)");
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
     
     public List<Ingrediente> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ingrediente> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ingrediente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ingrediente categoria = new Ingrediente();

                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
               
                produtos.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

 public List<Ingrediente> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Ingrediente> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM ingrediente WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Ingrediente categoria = new Ingrediente();

                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
               
                produtos.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }    
    
    public void update(Ingrediente p) {

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
    
        public void delete(Ingrediente p) {

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
public List<Receita_Ingrediente> readForReceitasIngrediente(Receita receita) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Receita_Ingrediente> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM receita_ingrediente WHERE id_receita = ?");
            stmt.setInt(1, receita.getId());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Receita_Ingrediente categoria = new Receita_Ingrediente();

                categoria.setIngrediente(readForId(rs.getInt("id_ingrediente")));
                categoria.setReceita(receita);
                
                categoria.setQuantidade(rs.getInt("quantidade"));
                categoria.setUnidade(rs.getString("unidade"));
                
                
                //finalizar 
                
                produtos.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            
            
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        
        return produtos;
    }    

    private Ingrediente readForId(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Ingrediente categoria = new Ingrediente();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ingrediente WHERE id = ?");
            stmt.setInt(1,id);
            
            
            rs = stmt.executeQuery();

            rs.next();

                
                
                
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //puxar list de Receita_Ingrediente
              
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return categoria;

    }
 
}