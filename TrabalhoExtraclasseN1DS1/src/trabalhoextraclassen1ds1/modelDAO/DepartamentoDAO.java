/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoextraclassen1ds1.modelDAO;

import trabalhoextraclassen1ds1.Control.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import trabalhoextraclassen1ds1.Model.Departamento;
import trabalhoextraclassen1ds1.Model.Funcionario;

/**
 *
 * @author hellk
 */
public class DepartamentoDAO {
    Connection conn;
    
    FuncionarioDAO funcionarioDAO;
    
    public DepartamentoDAO(){
        
        conn = ConnectionFactory.getConnection();
        
        
    }
    
    public void create(Departamento d) throws SQLException{
        
        PreparedStatement stmt = null;
        
        Funcionario f = d.getGerente();
        
        try{
            stmt = conn.prepareStatement("INSERT INTO departamento (nome, gerente) VALUES (?,?)");
            stmt.setString(1,d.getNome());
            stmt.setInt(2, f.getCpf());            
            
            
            stmt.executeUpdate();
             JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch(SQLException ex){
            System.out.println(ex);
        }finally{
            ConnectionFactory.closeConnection(conn, stmt);
        }
   }
    
    public List<Departamento> read(){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Departamento> departamentos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM departamento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Departamento departamento = new Departamento();

                departamento.setId(rs.getInt("id"));
                departamento.setNome(rs.getString("nome"));
                departamento.setGerente(funcionarioDAO.readForID(rs.getInt("gerente")));
                
                
                departamentos.add(departamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return departamentos;
    }
    
    public Departamento readForID(Integer id){
       PreparedStatement stmt = null;
        ResultSet rs = null;

        Departamento departamento = new Departamento();

        try {
            stmt = conn.prepareStatement("SELECT * FROM departamento WHERE id=?");
            stmt.setString(1, "%"+id+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                

                departamento.setId(id);
                departamento.setNome(rs.getString("nome"));
                departamento.setGerente(funcionarioDAO.readForID(rs.getInt("gerente")));
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return departamento;

    }
    
    public void update(Departamento d, Funcionario gerente) {

        PreparedStatement stmt = null;
        
      

        try {
            stmt = conn.prepareStatement("UPDATE departamento SET id = ? ,nome = ?, gerente = ? WHERE id = ?");
            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getNome());
            stmt.setInt(3, gerente.getCpf());
            stmt.setInt(4, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }
    
    public void delete(Departamento d) {

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM dependente WHERE id = ?");
            stmt.setInt(1, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
     }
    
}
