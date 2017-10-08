/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Array;
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
public class ReceitaDAO {
  Connection con;
  CategoriaDAO cd;
  IngredienteDAO id; 
    
    public ReceitaDAO(){
        con = ConnectionFactory.getConnection();
    }
    
     public void create(Receita c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO categoria (nome, preparo, modoServir, categoria)VALUES(?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getPreparo());
            stmt.setObject(3, c.getCat());
            stmt.setString(4, c.getModoServir());
            //corrigir esse insert
            //stmt.setArray(4, (Array) c.getIngredientes());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     
     public List<Receita> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Receita> listReceitas = new ArrayList<>();
        cd = new CategoriaDAO();
        id = new IngredienteDAO();

        try {
            stmt = con.prepareStatement("SELECT * FROM receita");
            rs = stmt.executeQuery();
            
            
            
            while (rs.next()) {

                Receita receita = new Receita();

                receita.setId(rs.getInt("id"));
                receita.setNome(rs.getString("nome"));
                receita.setPreparo(rs.getString("preparo"));
                receita.setModoServir(rs.getString("modoServir"));
                receita.setCat(cd.readForID(rs.getInt("categoria")));
                
                receita.setIngredientes(id.readForReceitasIngrediente(receita));
               
                listReceitas.add(receita);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listReceitas;

    }

 public List<Receita> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        cd = new CategoriaDAO();

        List<Receita> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM categoria WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Receita receita = new Receita();

                
               receita.setNome(rs.getString("nome"));
                receita.setPreparo(rs.getString("preparo"));
                receita.setModoServir(rs.getString("modoServir"));
                receita.setCat(cd.readForID(rs.getInt("categoria")));
                
                produtos.add(receita);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReceitaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }    
    
    public void update(Receita p) {

        PreparedStatement stmt = null;
        cd = new CategoriaDAO();
        Categoria cat; 

        try {
            stmt = con.prepareStatement("UPDATE receita SET nome = ? , preparo = ?, modoServir = ?, categoria = ?,  WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getPreparo());
            stmt.setString(3,p.getModoServir());
            
            cat = p.getCat();
            stmt.setInt(4, cat.getId());
            //concluir esse update
            
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public void delete(Receita p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM receita WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

        public void deleteIngrediente(Receita_Ingrediente p) {

        PreparedStatement stmt = null;

        Ingrediente i = p.getIngrediente();
        Receita r = p.getReceita();
        
        try {
            stmt = con.prepareStatement("DELETE FROM receita_ingrediente WHERE id_ingrediente = ? and id_receita = ?");
            stmt.setInt(1, i.getId());
            stmt.setInt(2, r.getId());

            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
        
    public List<Receita_Ingrediente> readForIngredienteReceitas(Ingrediente ingrediente) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Receita_Ingrediente> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM receita_ingrediente WHERE id_receita = ?");
            stmt.setInt(1, ingrediente.getId());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Receita_Ingrediente categoria = new Receita_Ingrediente();

                categoria.setIngrediente(ingrediente);
                categoria.setReceita(readForId(rs.getInt("id_receita")));
                
                
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

    private Receita readForId(int id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Receita receita = new Receita();
        CategoriaDAO cdao = new CategoriaDAO();
        IngredienteDAO idao = new IngredienteDAO();
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM receita WHERE id = ?");
            stmt.setInt(1,id);
            
            
            rs = stmt.executeQuery();

            rs.next();

                
                
                
                receita.setId(rs.getInt("id"));
                receita.setNome(rs.getString("nome"));
                receita.setModoServir(rs.getString("modoServir"));
                receita.setPreparo(rs.getString("preparo"));
                
                receita.setCat(cdao.readForID(rs.getInt("categoria")));
                receita.setIngredientes(idao.readForReceitasIngrediente(receita));
                
              
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return receita;

    }
 
}