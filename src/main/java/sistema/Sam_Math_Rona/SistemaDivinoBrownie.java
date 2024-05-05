package sistema.Sam_Math_Rona;

import java.time.Month;
import java.util.List;

public interface SistemaDivinoBrownie {
    List<Produto> listaDeProdutos();
    List<Pedido> listaDeTodosPedidos();
    List<Pedido> listaDePedidosPendentes();

    void cadastrarPedido(Pedido pedido) throws CodigoPedidoJaExiste;
    void cancelarPedido(int codigo) throws PedidoNaoExisteException;
    void finalizarPedido(int codigo) throws PedidoNaoExisteException;

    void cadastrarProduto(Produto produto) throws ProdutoJaExisteException;
    void removerProduto(String tipo, String sabor)  throws ProdutoNaoExisteException;
    void abasteceEstoqueProduto(String tipo, String sabor,int quantAbastecer) throws ProdutoNaoExisteException;
    public int quantidadeNoEstoque(String tipo,String sabor) throws ProdutoNaoExisteException;
    public Produto procurarProduto(String tipo, String sabor)throws ProdutoNaoExisteException;
    int quantidadeDeVendasMensal(Month mes);
    int quantidadeDeVendasAnual(int ano);
    double calculaLucroAnual(int ano);
    double calculaLucroMensal(Month mes);
    void salvarDados();
}
