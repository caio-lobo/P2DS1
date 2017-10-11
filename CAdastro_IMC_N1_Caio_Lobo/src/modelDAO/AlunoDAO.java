/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import Control.ConnectionFactory;
import Model.Aluno;
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
/**
 *
 * @author hellk
 */
public class AlunoDAO {
    
    Connection conn;
    public AlunoDAO(){
        
        conn = ConnectionFactory.getConnection();
       
        
        
    }
    
     public void create(Aluno p) {

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO aluno (imc,nome,massa,estatura,idade,sexo)VALUES(?,?,?,?,?,?)");
            stmt.setFloat(1, p.getImc());
            stmt.setString(2,p.getNome());
            stmt.setFloat(3, p.getMassa());
            stmt.setFloat(4, p.getEstatura());
            stmt.setInt(5,p.getIdade());
            stmt.setString(6, p.getSexo());
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public List<Aluno> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> produtos = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno produto = new Aluno();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setMassa(rs.getFloat("massa"));
                produto.setEstatura(rs.getFloat("estatura"));
                produto.setIdade(rs.getInt("idade"));
                produto.setSexo(rs.getString("sexo"));
                produto.setImc(rs.getFloat("imc"));
                
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return produtos;

    }
    
   public Aluno readForID(Integer id) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Aluno produto = new Aluno();

        try {
            stmt = conn.prepareStatement("SELECT * FROM aluno WHERE id=?");
            stmt.setString(1, "%"+id+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setMassa(rs.getFloat("massa"));
                produto.setEstatura(rs.getFloat("estatura"));
                produto.setIdade(rs.getInt("idade"));
                produto.setSexo(rs.getString("sexo"));
                produto.setImc(rs.getFloat("imc"));
                
    
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return produto;

    } 
    
}
