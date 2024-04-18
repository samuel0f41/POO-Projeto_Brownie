package sistema.Sam_Math_Rona;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SistemaBrownieTest {
    SistemaBrownie sistema = new SistemaBrownie(1000);

    @TesT
    public void testaCadastrarProduto_E_VerQuantidadeNoEstoque() throws ProdutoJaExisteException, ProdutoNaoEcontradoException {
        Produto p1 = new Produto("Brownie de Ninho", Tipo.BROWNIE, Sabores.NINHO, 10, 5.00,"0001");
        assertEquals(0, sistema.getListarProdutos().size());

        sistema.cadastrarProduto(p1);
        assertEquals(1, sistema.getListarProdutos().size());
        assertTrue(sistema.quantidadeNoEstoque("0001") == 10);
    }

    @Test
    public void testaRemoverProduto() throws ProdutoJaExisteException {
        Produto p1 = new Produto("Brownie de Ninho", Tipo.BROWNIE, Sabores.NINHO, 10, 5.00,"0001");
        assertEquals(0, sistema.getListarProdutos().size());

        sistema.cadastrarProduto(p1);
        assertEquals(1, sistema.getListarProdutos().size());
    }

    @Test
    public void testaRealizarPedido() throws ProdutoJaExisteException, PedidoJaComCodigoJaExiste {
        Produto p1 = new Produto("Brownie de Ninho", Tipo.BROWNIE, Sabores.NINHO, 10, 5.00,"0001");
        assertEquals(0, sistema.getListarProdutos().size());

        sistema.cadastrarProduto(p1);
        assertEquals(1, sistema.getListarProdutos().size());

        List<ItensPedidos> listaItens = new LinkedList<>();
        ItensPedidos i1 = new ItensPedidos(p1, 1);
        listaItens.add(i1);
        Cliente c1 = new Cliente();
        c1.setNome("jurema");

        sistema.vendaRealizarPedido(c1, listaItens);
        assertEquals(1, sistema.getListarPedidos().size());

    }
}
