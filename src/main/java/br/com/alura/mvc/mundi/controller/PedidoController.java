package br.com.alura.mvc.mundi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mundi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoRepository repository;

    @Autowired
    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("formulario")
    public String formulario() {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido requisicaoNovoPedido){
        Pedido pedido = requisicaoNovoPedido.toPedido();
        repository.save(pedido);
        return "home";
    }

}
