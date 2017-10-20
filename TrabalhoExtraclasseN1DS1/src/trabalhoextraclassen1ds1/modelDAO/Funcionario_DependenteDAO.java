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
import trabalhoextraclassen1ds1.Model.Funcionario_Dependente;

/**
 *
 * @author hellk
 */
public class Funcionario_DependenteDAO {
    
    Connection conn;
    
    FuncionarioDAO funcionarioDAO;
    DependenteDAO dependenteDAO;
    
    public Funcionario_DependenteDAO(){
        
        conn = ConnectionFactory.getConnection();
        
    }
    
    public void create (Funcionario_Dependente fd){
                
        PreparedStatement stmt = null;
        
        Funcionario f = fd.getResponsavel1();
        Dependente d = fd.getDependente();
               
        try {
            stmt = conn.prepareStatement("INSERT INTO funcionario_dependente (responsavel1,dependente)VALUES(?,?)");
            stmt.setInt(1, f.getCpf());
            stmt.setInt(2,d.getCpf());
            
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        
        
    }
    
    public List<Funcionario_Dependente> readForDependentesInFuncionario(Funcionario f){
        
       PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario_Dependente> funcionarios_dependentes = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario_dependente WHERE responsavel1 OR responsavel2 = ?");
            stmt.setInt(1, f.getCpf());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario_Dependente funcionario_dependente = new Funcionario_Dependente();

                funcionario_dependente.setResponsavel1(funcionarioDAO.readForID(rs.getInt("responsavel1")));
                funcionario_dependente.setDependente(dependenteDAO.readForID(rs.getInt("dependente")));
                
                
                funcionarios_dependentes.add(funcionario_dependente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario_DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return funcionarios_dependentes;
 
    }
    
    
     public Funcionario_Dependente readForDependente(Dependente d){
       
         PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario_Dependente fd = new Funcionario_Dependente();
        Funcionario r1;


        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario_dependente WHERE dependente=?");
            stmt.setInt(1, d.getCpf());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                r1 = funcionarioDAO.readForID(rs.getInt("responsavel1"));

                fd.setDependente(d);
                fd.setResponsavel1(r1);
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario_DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return fd;

    }
    
     public Funcionario_Dependente readForFuncionario(Funcionario f){
       
         PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario_Dependente fd = new Funcionario_Dependente();
        Funcionario r1;
        
        Dependente d = new Dependente();


        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario_dependente WHERE responsavel1 =?");
            stmt.setInt(1, f.getCpf());
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                r1 = funcionarioDAO.readForID(rs.getInt("responsavel1"));
                
                fd.setDependente(d);
                fd.setResponsavel1(r1);
                
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionario_DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return fd;

    }
    
     public void update(Funcionario_Dependente fd) {

        PreparedStatement stmt = null;
        Funcionario r1 = fd.getResponsavel1();
        
        
        Dependente d = fd.getDependente();
      

        try {
            stmt = conn.prepareStatement("UPDATE funcionario_dependente SET responsavel1 = ? , dependente = ? WHERE responsavel1 = ? AND dependente = ?");
            stmt.setInt(1, r1.getCpf());
            stmt.setInt(2, d.getCpf());
            stmt.setInt(3, r1.getCpf());
            stmt.setInt(4, d.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }
    
    public void delete(Funcionario_Dependente fd) {

        PreparedStatement stmt = null;
        
        Funcionario r1 = fd.getResponsavel1();
        
        Dependente d = fd.getDependente();

        try {
            stmt = conn.prepareStatement("DELETE FROM funcionario_dependente WHERE WHERE responsavel1 = ? AND dependente = ?");
            stmt.setInt(1, r1.getCpf());
            stmt.setInt(2, d.getCpf());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
     } 
     
}
