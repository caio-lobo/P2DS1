/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoextraclassen1ds1.Control;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import trabalhoextraclassen1ds1.Model.Departamento;
import trabalhoextraclassen1ds1.Model.Funcionario;
import trabalhoextraclassen1ds1.View.DepartamentoFuncionarioGUI;
import trabalhoextraclassen1ds1.View.DepartamentoGUI;
import trabalhoextraclassen1ds1.modelDAO.DepartamentoDAO;
import trabalhoextraclassen1ds1.modelDAO.FuncionarioDAO;


/**
 *
 * @author hellk
 */
public class DepartamentoControl {
    
    FuncionarioDAO funcionarioDAO;
    Departamento departamento;
    DepartamentoDAO departamentoDAO;
    
    public void gravar (Departamento d) throws SQLException{
        DepartamentoDAO dao = new DepartamentoDAO();
        try{
            if(d.getId()==null || d.getId()<=0) 
                dao.create(d);
            
            else dao.update(d, d.getGerente());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar as informações: \n"+ex.getMessage());
            
        }        
        
    }

    public void updateListFuncionarios(JList<Funcionario> listFuncionarios) {
    
        DefaultListModel model = (DefaultListModel) listFuncionarios.getModel();
        model.clear();
        List funcionarios = funcionarioDAO.read();
        for(Object o : funcionarios){
        
            Funcionario f = (Funcionario) o;
            model.addElement(f);
               
        }
         
    }
  
    public void updateListDepartamentos(JList<Departamento> listDepartamentos) {
    
       DefaultListModel model = (DefaultListModel) listDepartamentos.getModel();
        model.clear();
        List departamentos = departamentoDAO.read();
        for(Object o : departamentos){
        
            Departamento f = (Departamento) o;
            model.addElement(f);
               
        } 
    
    
    }

    public void novoDepartamentoButton() {
   
        DepartamentoGUI dg = new DepartamentoGUI();
        dg.setEnabled(true);
        dg.setVisible(true);
    
    
    }

    public void selecionarDepartamentoButton(Departamento d) {
    
        DepartamentoGUI dg = new DepartamentoGUI(d);
        dg.setEnabled(true);
        dg.setVisible(true);
    
    }

    public void addFuncionarioButtom(Departamento id) {
        
        DepartamentoFuncionarioGUI dfg = new DepartamentoFuncionarioGUI(id);
        dfg.setEnabled(true);
        dfg.setVisible(true);
    }

    public void updateListFuncionariosDepartamento(JList<Funcionario> listFuncionarios, Departamento d) {
        
        DefaultListModel model = (DefaultListModel) listFuncionarios.getModel();
        model.clear();
        
        List funcionarios = funcionarioDAO.readForDepartamentoFuncionario(d.getId()); 
        
        for(Object o : funcionarios){
        
            Funcionario f = (Funcionario) o;
            model.addElement(f);
               
        }
    
    }
    
        
        
}
