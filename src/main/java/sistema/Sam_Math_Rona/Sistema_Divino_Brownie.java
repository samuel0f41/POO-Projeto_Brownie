package sistema.Sam_Math_Rona;

import java.time.Month;
import java.util.List;

public interface Sistema_Divino_Brownie {
    List<Produto> getListarProdutos();
    List<Pedido> getListarPedidos();

    String vendaRealizarPedido(Cliente cliente, List<ItensPedidos> itensPedidos) throws PedidoJaComCodigoJaExiste;
    List<Pedido> pedidosFaltaConcluir();
    void cancelarPedido(int codigo)throws NaoExistePedidoException;
    String finalizarVenda(int codigoPedido) throws NaoExistePedidoException;
    void cadastrarProduto(Produto produto) throws ProdutoJaExisteException;
    void removerProduto(String codigo)throws ProdutoNaoEcontradoException;

    void abasteceEstoqueProduto(String codigo, int unidadeAtualizada)throws ProdutoNaoEcontradoException;

    int quantidadeDeVendasMensal(List<Pedido> listaDePedidos, Month mes);
    int quantidadeDeVendasAnual(List<Pedido> listaDePedidos);
    double calculaLucroAnual(List<Pedido> listaDePedidos);
    double calculaLucroMensal(List<Pedido> listaDePedidos, Month mes); // tbm serve como lucro atual



}
