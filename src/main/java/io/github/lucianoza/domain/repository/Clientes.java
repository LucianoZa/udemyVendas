package io.github.lucianoza.domain.repository;

import io.github.lucianoza.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository tira!
public interface Clientes extends JpaRepository<Cliente, Integer> {
                                              //Entidade, Tipo do ID da Entidade

    List<Cliente> findByNomeLike(String nome);


//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public Cliente salvar(Cliente cliente){
//        entityManager.persist(cliente);
//        return cliente;
//    }
//
//    @Transactional
//    public Cliente atualizar(Cliente cliente){
//        entityManager.merge(cliente);
//        return cliente;
//    }
//
//    @Transactional
//    public void deletar(Cliente cliente){
//        if(!entityManager.contains(cliente)) {
//            cliente = entityManager.merge(cliente);
//        }
//        entityManager.remove(cliente);
//    }
//
//    @Transactional
//    public void deletar(Integer id){
//        Cliente cliente = entityManager.find(Cliente.class, id);
//        deletar(cliente);
//    }
//
//    @Transactional//(readOnly=true) //otimiza, não cacheia, fica mais rápido
//    public List<Cliente> buscarPorNome(String nome){
//        String jpql = " select c from Cliente c where c.nome like :nome ";
//        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
//        query.setParameter("nome", "%"+ nome +"%");
//        return query.getResultList();
//    }
//
//    @Transactional//(readOnly=true) //otimiza, não cacheia, fica mais rápido
//    public List<Cliente> obterTodos(){
//        return entityManager
//                .createQuery("from Cliente", Cliente.class) //from Cliente é case sensitive!
//                .getResultList();
//    }

}
