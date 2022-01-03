package br.com.alura.mvc.mundi.controller;

import br.com.alura.mvc.mundi.enums.StatusPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public UsuarioController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    @GetMapping("pedido")
    public String hello(Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("pedido/{status}")
    public String porStatus(Model model, @PathVariable String status, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);

        return "home";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}