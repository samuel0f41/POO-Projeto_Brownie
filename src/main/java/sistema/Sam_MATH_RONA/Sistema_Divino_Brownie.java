package sistema.Sam_MATH_RONA;

import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public interface Sistema_Divino_Brownie {
    List<Produto> getListarProdutos();
    List<Pedido> getListarPedidos();

    void vendaFazendoPedido(Pedido pedido);
    void pedidosFaltaConcluir();
    void vendaFinalizada(String codigoPedido);

    void abasteceEstoqueProduto(String codigo);

    int quantidadeDeVendasMensal(List<Pedido> listaDePedidos, Month mes);
    int quantidadeDeVendasAnual(List<Pedido> listaDePedidos);
    double calculaLucroAnual(List<Pedido> listaDePedidos);
    double calculaLucroMensal(List<Pedido> listaDePedidos, Month mes); // tbm serve como lucro atual



}
