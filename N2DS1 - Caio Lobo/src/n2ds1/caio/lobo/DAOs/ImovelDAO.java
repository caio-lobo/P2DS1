/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n2ds1.caio.lobo.DAOs;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import n2ds1.caio.lobo.model.Imovel;

/**
 *
 * @author hellk
 */
public class ImovelDAO implements IDAO{

    @Override
    public void adicionar(Object o) throws SQLException {
    
        Imovel i = (Imovel) o;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("N2DS1-CaioLoboPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void alterar(Object o) throws SQLException {
        
         Imovel i = (Imovel) o;
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("N2DS1-CaioLoboPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    
        
    }

    @Override
    public void excluir(Object o) throws SQLException {
         Imovel i = (Imovel) o;
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("N2DS1-CaioLoboPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.remove(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void excluir(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos() throws SQLException {
    
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("N2DS1-CaioLoboPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Imovel> query = em.createQuery("select c from Imovel c", Imovel.class);
        List<Imovel> list = query.getResultList();
        
        em.close();
        emf.close();
        return list;
    }

    @Override
    public Object listarPorId(Long id) throws SQLException {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("N2DS1-CaioLoboPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Imovel> query = em.createQuery("select c from Imovel c where id ="+id+"", Imovel.class);
        List<Imovel> list = query.getResultList();
        
        em.close();
        emf.close();
        return list;
    }
    
}
