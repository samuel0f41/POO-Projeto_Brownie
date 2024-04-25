package sistema.Sam_Math_Rona;

import java.time.Month;
import java.time.Year;
import java.util.List;

public interface SistemaDivinoBrownie {
    List<Produto> listaDeProdutos();
    List<Pedido> listaDeTodosPedidos();
    List<Pedido> listaDePedidosPendentes();

    void cadastrarPedido(Pedido pedido) throws CodigoPedidoJaExiste;
    void cancelarPedido(int codigo) throws PedidoNaoExisteException;
    void finalizarPedido(int codigo) throws PedidoNaoExisteException;

    void cadastrarProduto(Produto produto) throws ProdutoJaExisteException;
    void removerProduto(Tipo tipo, Sabores sabor);
    void abasteceEstoqueProduto(Tipo tipo, Sabores sabor, int quantidade) throws ProdutoNaoExisteException;
    public int quantidadeNoEstoque(Tipo tipo, Sabores sabor) throws ProdutoNaoExisteException;

    int quantidadeDeVendasMensal(Month mes);
    int quantidadeDeVendasAnual(Year ano);
    double calculaLucroAnual(Year ano);
    double calculaLucroMensal(Month mes);
    void salvarDados();
}
