/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n2ds1.caio.lobo.Control;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import n2ds1.caio.lobo.DAOs.ImovelDAO;
import n2ds1.caio.lobo.model.Imovel;
import n2ds1.caio.lobo.model.Tipo;

/**
 *
 * @author hellk
 */
public class ImovelControl {
    public void gravar(Imovel c)throws SQLException{
         ImovelDAO dao = new ImovelDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Imovel c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            ImovelDAO dao = new ImovelDAO();    
            dao.excluir(c);
        }
    
}
    
     public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            ImovelDAO dao = new ImovelDAO();    
            dao.excluir(id);
        }
    }
    
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        ImovelDAO dao = new ImovelDAO();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            Imovel c = (Imovel) o;
            
           model.addRow(new Object[]{ c.getId(),c.getNome(),c.getDescricao(),c.getAreaConstruída(),c.getAreaTotal(), c.getTipo()});
           
        }
        
    }
    
    public Imovel getImovelPorId(Long id) throws SQLException {
        ImovelDAO dao = new ImovelDAO();
        Imovel c = (Imovel)dao.listarPorId(id);
        return c;       
    }
}
