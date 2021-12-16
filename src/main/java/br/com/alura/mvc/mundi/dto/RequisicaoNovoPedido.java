package br.com.alura.mvc.mundi.dto;

import br.com.alura.mvc.mundi.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequisicaoNovoPedido {
    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        return Pedido.builder().nomeProduto(nomeProduto)
                .urlProduto(urlProduto)
                .urlImagem(urlImagem)
                .descricao(descricao)
                .build();
    }
}
