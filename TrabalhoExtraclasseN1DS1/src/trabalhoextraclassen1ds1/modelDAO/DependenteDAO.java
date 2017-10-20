/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoextraclassen1ds1.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trabalhoextraclassen1ds1.Control.ConnectionFactory;
import trabalhoextraclassen1ds1.Model.Dependente;
import trabalhoextraclassen1ds1.Model.Funcionario;

/**
 *
 * @author hellk
 */
public class DependenteDAO {
    
    Connection conn;
    
    public DependenteDAO(){
        
        conn = ConnectionFactory.getConnection();
        
    }
    
    public void create (Dependente d){
        
        PreparedStatement stmt = null;
        
               
        try {
            stmt = conn.prepareStatement("INSERT INTO dependente (cpf,nome)VALUES(?,?)");
            stmt.setInt(1, d.getCpf());
            stmt.setString(2,d.getNome());
            
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        
        
    }
    
    public List<Dependente> read(){
        
       PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Dependente> dependentes = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM dependente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Dependente dependente = new Dependente();

                dependente.setCpf(rs.getInt("cpf"));
                dependente.setNome(rs.getString("nome"));
                
                
                dependentes.add(dependente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return dependentes;
 
    }
    
    public Dependente readForID(Integer cpf){
       PreparedStatement stmt = null;
        ResultSet rs = null;

        Dependente dependente = new Dependente();

        try {
            stmt = conn.prepareStatement("SELECT * FROM dependente WHERE cpf=?");
            stmt.setString(1, "%"+cpf+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                

                dependente.setCpf(rs.getInt("cpf"));
                dependente.setNome(rs.getString("nome"));
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return dependente;

    }
    
    public void update(Dependente p, Integer cpf) {

        PreparedStatement stmt = null;
        
      

        try {
            stmt = conn.prepareStatement("UPDATE funcionario SET cpf = ? ,nome = ? WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());
            stmt.setString(2, p.getNome());
            stmt.setInt(4, cpf);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }   
    
     public void delete(Dependente p) {

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM dependente WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
     }
    
    
}
     
