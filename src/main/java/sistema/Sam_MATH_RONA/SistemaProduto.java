package sistema.Sam_MATH_RONA;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaProduto implements Sistema_Divino_Brownie{

    private Map<String, Pedido> pedidos;
    private Map<String, Produto> produtos;
    private double dispesaMateriasGastos;
    private LocalDate dataLucros;

    public SistemaProduto(double dispesaMateriasGastos) {
        this.pedidos = new HashMap<>();
        this.produtos = new HashMap<>();
        this.dispesaMateriasGastos = dispesaMateriasGastos;
    }

    @Override
    public List<Produto> getListarProdutos() {
        return null;
    }

    @Override
    public List<Pedido> getListarPedidos() {
        return null;
    }

    @Override
    public void vendaFazendoPedido(Pedido pedido) {

    }

    @Override
    public void pedidosFaltaConcluir() {

    }

    @Override
    public void vendaFinalizada(String codigoPedido) {

    }

    @Override
    public void abasteceEstoqueProduto(String codigo) {

    }

    @Override
    public int quantidadeDeVendasMensal(List<Pedido> listaDePedidos, Month mes) {
        return 0;
    }

    @Override
    public int quantidadeDeVendasAnual(List<Pedido> listaDePedidos) {
        return 0;
    }

    @Override
    public double calculaLucroAnual(List<Pedido> listaDePedidos) {
        return 0;
    }

    @Override
    public double calculaLucroMensal(List<Pedido> listaDePedidos, Month mes) {
        return 0;
    }

    public void setPedidos(Map<String, Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setProdutos(Map<String, Produto> produtos) {
        this.produtos = produtos;
    }
    public double getDispesaMateriasGastos() {
        return dispesaMateriasGastos;
    }
    public void setDispesaMateriasGastos(double dispesaMateriasGastos) {
        this.dispesaMateriasGastos = dispesaMateriasGastos;
    }
}
