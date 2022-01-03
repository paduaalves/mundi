package br.com.alura.mvc.mundi.controller;

import br.com.alura.mvc.mundi.enums.StatusPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final PedidoRepository repository;

    @Autowired
    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String hello(Model model) {
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.ENTREGUE);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
