package sistema.Sam_Math_Rona;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SistemaBrownieTest {
    SistemaBrownie sistema = new SistemaBrownie();

    @Test
    public void testaCadastrarProduto() throws ProdutoJaExisteException {
        Produto p1 = new Produto("Brownie", "Morango",1,5.0);
        assertEquals(1  , sistema.listaDeProdutos().size());
        sistema.cadastrarProduto(p1);
        assertEquals(2 , sistema.listaDeProdutos().size());

    }
    @Test
    public void VerQuantidadeNoEstoque() throws ProdutoJaExisteException {
        Produto p1 = new Produto("Brownie", "Morango",1,5.0);
        sistema.cadastrarProduto(p1);
        for(Produto p: sistema.listaDeProdutos()){
            if(p.getTipo().equals("Brownie") && p.getSabor().equals("Morango")   ){
                assertTrue(p.getQtEstoque()==1);
                break;
            }
        }
    }

    @Test
    public void testaRemoverProduto() throws ProdutoJaExisteException, ProdutoNaoExisteException {
        Produto p1 = new Produto("Brownie", "Morango", 1, 5.00);
        assertTrue(sistema.listaDeProdutos().size()==1);

        sistema.cadastrarProduto(p1);
        assertEquals(2, sistema.listaDeProdutos().size());

        sistema.removerProduto("Brownie", "Morango");
        assertEquals(1, sistema.listaDeProdutos().size());

    }


    @Test
    public void testaCadastrarPedido() throws ProdutoJaExisteException, CodigoPedidoJaExiste, PedidoNaoExisteException, EstoqueDoProdutoVazioException {
        Produto p1 = new Produto("Brownie", "Morango", 10, 5.00);
        assertEquals(1, sistema.listaDeProdutos().size());

        sistema.cadastrarProduto(p1);
        assertEquals(2, sistema.listaDeProdutos().size());

        List<Produto> carrinho = new LinkedList<>();
        carrinho.add(p1);
        Cliente c1 = new Cliente("TesteCliente");

        Pedido pe1 = new Pedido(c1,carrinho);
        sistema.cadastrarPedido(pe1);

        assertTrue(sistema.listaDePedidosPendentes().size()==1);

        sistema.finalizarPedido(pe1.getCodigo());

        assertTrue(sistema.listaDePedidosPendentes().size()==0);

        assertTrue(sistema.listaDeTodosPedidos().size()==1);

    }

    @Test
    public void testaRemoverPedido() throws ProdutoJaExisteException, CodigoPedidoJaExiste, PedidoNaoExisteException, EstoqueDoProdutoVazioException {
         Produto p1 = new Produto("Brownie", "Morango", 10, 5.00);
        assertEquals(1, sistema.listaDeProdutos().size());

        sistema.cadastrarProduto(p1);
        assertEquals(2, sistema.listaDeProdutos().size());

        List<Produto> carrinho = new LinkedList<>();
        carrinho.add(p1);
        Cliente c1 = new Cliente("TesteCliente");

        Pedido pe1 = new Pedido(c1,carrinho);

        sistema.cadastrarPedido(pe1);

        assertTrue(sistema.listaDePedidosPendentes().size()==1);

        sistema.cancelarPedido(pe1.getCodigo());
        assertTrue(sistema.listaDePedidosPendentes().size()==0);

        sistema.cadastrarPedido(pe1);
        sistema.finalizarPedido(pe1.getCodigo());
        assertTrue(sistema.listaDeTodosPedidos().size()==1);

        sistema.removerPedidoFinalizado(pe1.getCodigo());
        assertTrue(sistema.listaDeTodosPedidos().size()==0);

    }
}
