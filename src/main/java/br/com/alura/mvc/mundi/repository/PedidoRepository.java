package br.com.alura.mvc.mundi.repository;

import br.com.alura.mvc.mundi.enums.StatusPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByStatus(StatusPedido status);

    @Query("select p from Pedido p join p.user u where u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username")String username);

    @Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}
