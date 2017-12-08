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
import n2ds1.caio.lobo.DAOs.TipoDAO;
import n2ds1.caio.lobo.model.Imovel;
import n2ds1.caio.lobo.model.Tipo;

/**
 *
 * @author hellk
 */
public class TipoControl {
    public void gravar(Tipo c)throws SQLException{
         TipoDAO dao = new TipoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.adicionar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }
    public void excluir(Tipo c)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            TipoDAO dao = new TipoDAO();    
            dao.excluir(c);
        }
    
}
    
     public void excluir(Long id)throws SQLException{
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir esta categoria?")==JOptionPane.YES_OPTION){
            TipoDAO dao = new TipoDAO();    
            dao.excluir(id);
        }
    }
    
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        //limpa as linhas da tabela.
        for(int i=0; i<model.getRowCount(); i++)
            model.removeRow(i);
        
        TipoDAO dao = new TipoDAO();
        List clientes = dao.listarTodos();
        //Adiciona as linhas
        for (Object o : clientes){
            Tipo c = (Tipo) o;
            model.addRow(new Object[]{ c.getId(),c.getNome(),c.getDescricao()});
           
        }
        
    }
    
    public Tipo getTipoPorId(Long id) throws SQLException {
        TipoDAO dao = new TipoDAO();
        Tipo c = (Tipo)dao.listarPorId(id);
        return c;       
    }



    public List listarTipos() throws SQLException {
    
        TipoDAO t = new TipoDAO();
        return  t.listarTodos();
    }

    public List listarImoveis(Long id) {
      ImovelDAO dao = new ImovelDAO();
    
      return  dao.listarPorTipo(id);
      
    }

    
}
