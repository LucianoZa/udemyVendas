package io.github.lucianoza.domain.repository;

import io.github.lucianoza.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository tira!
public interface Clientes extends JpaRepository<Cliente, Integer> {
                                              //Entidade, Tipo do ID da Entidade
    // select c from Cliente where c.nome like
    List<Cliente> findByNomeLike(String nome); //Query Métodos
    //Ou hql
    @Query(value = " select c from Cliente c where c.nome like %:nome% ")
    List<Cliente> encontrarPorNomeHQL(@Param("nome") String nome); //Query Métodos
    //Ou sql nativo
    @Query(value = " select * from cliente c where c.nome like :nome ", nativeQuery = true)
    List<Cliente> encontrarPorNomeSQL(@Param("nome") String nome); //Query Métodos

    boolean existsByNome(String nome);// valida se existe

    //Retorna Todos os pedidos do cliente
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos( @Param("id") Integer id );

//    @Query(" delete from Cliente c where c.nome =:nome ")
//    @Modifying //indica que tem transacao, que não é de consulta apenas
//    void deleteByNome(String nome);
//    //ou
//    @Modifying
//    void deleteByNome(String nome);


    //Pode usar padroes de HQL
    //List<Cliente> findByNomeOrId(String nome, Integer id); //Query Métodos

    //List<Cliente> findByNomeLikeOrIdOrderById(String nome, Integer id); //Query Métodos

    //* * * find retorna Lista uma de Objetos

    //Cliente findOneByNome(String nome); //Retorna um unico registro ou dá erro!

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
