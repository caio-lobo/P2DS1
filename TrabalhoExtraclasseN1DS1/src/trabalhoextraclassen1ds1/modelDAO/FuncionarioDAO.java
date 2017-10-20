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
import trabalhoextraclassen1ds1.Model.Departamento;
import trabalhoextraclassen1ds1.Model.Funcionario;

/**
 *
 * @author hellk
 */
public class FuncionarioDAO {
    
    Connection conn;
    
    Funcionario_DependenteDAO funcionario_dependenteDAO;
    DependenteDAO dependenteDAO;
    DepartamentoDAO departamentoDAO;
    
    public FuncionarioDAO(){
        
        conn = ConnectionFactory.getConnection();
        
    }
    
    public void create (Funcionario f){
        
        PreparedStatement stmt = null;
        
        Departamento d = f.getDepartamento();
        
        try {
            stmt = conn.prepareStatement("INSERT INTO funcionario (cpf,nome,departamento)VALUES(?,?,?)");
            stmt.setInt(1, f.getCpf());
            stmt.setString(2,f.getNome());
            stmt.setInt(3, d.getId());
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        
        
    }
    
    public List<Funcionario> read(){
        
       PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDepartamento(departamentoDAO.readForID(rs.getInt("departamento")));
                funcionario.setDependentes(funcionario_dependenteDAO.readForDependentesInFuncionario(funcionario));
                
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return funcionarios;
 
    }
    
    public Funcionario readForID(Integer cpf){
       PreparedStatement stmt = null;
        ResultSet rs = null;

        Funcionario funcionario = new Funcionario();

        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE cpf=?");
            stmt.setString(1, "%"+cpf+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                

                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDepartamento(departamentoDAO.readForID(rs.getInt("departamento")));
                funcionario.setDependentes(funcionario_dependenteDAO.readForDependentesInFuncionario(funcionario));
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return funcionario;

    } 
    
 public void update(Funcionario p, Integer cpf) {

        PreparedStatement stmt = null;
        
        Departamento d = p.getDepartamento();

        try {
            stmt = conn.prepareStatement("UPDATE funcionario SET cpf = ? ,nome = ?,departamento = ? WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, d.getId());
            stmt.setInt(4,cpf);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }   
    
     public void delete(Funcionario p) {

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM produto WHERE cpf = ?");
            stmt.setInt(1, p.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public List<Funcionario> readForDepartamentoFuncionario(Integer id) {
    PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM funcionario where departamento = ?");
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(rs.getInt("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDepartamento(departamentoDAO.readForID(rs.getInt("departamento")));
                funcionario.setDependentes(funcionario_dependenteDAO.readForDependentesInFuncionario(funcionario));
                
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return funcionarios;}

    
    
    
}
