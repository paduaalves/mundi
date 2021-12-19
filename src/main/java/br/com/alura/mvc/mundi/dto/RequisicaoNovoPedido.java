package br.com.alura.mvc.mundi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mundi.enums.StatusPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoPedido {
    
    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        return Pedido.builder().nomeProduto(nomeProduto)
                .urlProduto(urlProduto)
                .urlImagem(urlImagem)
                .descricao(descricao)
                .status(StatusPedido.AGUARDANDO)
                .build();
    }
}
