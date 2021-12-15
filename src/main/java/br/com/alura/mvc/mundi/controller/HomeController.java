package br.com.alura.mvc.mundi.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mundi.model.Pedido;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String hello(Model model) {
        Pedido pedido = new Pedido("Echo Dot (3ª Geração)", new BigDecimal(189.05).setScale(2, RoundingMode.DOWN),
                LocalDate.now(),
                "https://www.amazon.com.br/Echo-Dot-3%C2%AA-Gera%C3%A7%C3%A3o-Cor-Preta/dp/B07PDHSJ1H/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1F8EKTZW6P2JT&keywords=echo+dot&qid=1639497711&sprefix=echo%2Caps%2C250&sr=8-1&ufe=app_do%3Aamzn1.fos.4bddec23-2dcf-4403-8597-e1a02442043d",
                "O Echo Dot é o nosso smart speaker de maior sucesso. Controlado por voz com a Alexa, ele é perfeito para qualquer ambiente. Você pode pedir músicas, notícias, informações e muito mais. Além de ligar para amigos e familiares e controlar dispositivos compatíveis de casa inteligente com sua voz.",
                "https://m.media-amazon.com/images/I/41GZCWFJB1L._AC_.jpg");
        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
