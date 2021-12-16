package br.com.alura.mvc.mundi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
public class HomeController {

    private final PedidoRepository repository;

    @Autowired
    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/home")
    public ModelAndView hello(ModelAndView modelAndView) {
        List<Pedido> pedidos = repository.findAll();
        modelAndView.addObject("pedidos", pedidos);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
