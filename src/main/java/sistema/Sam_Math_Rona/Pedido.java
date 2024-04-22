package sistema.Sam_Math_Rona;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private int codigo = 0;
    private Cliente cliente;
    private List<Produto> carrinho;
    private double valorTotal;
    private EstadoPedido estadoPedido;
    private LocalDateTime data = LocalDateTime.now();

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.carrinho = produtos;
        this.codigo++;
        this.estadoPedido = EstadoPedido.PENDENTE;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigoDoPedido) {
        this.codigo = codigoDoPedido;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Produto> getCarrinho() {
        return this.carrinho;
    }
    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }
    public double getValorTotal() {
        double valorTotal = 0;
        for(Produto p: this.carrinho){
            valorTotal += p.getPreco();
        }
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }
    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido: "+ this.codigo + "\nCliente:  " + this.cliente.getNome()+ "\nEndereço: " +
                this.cliente.getEndereco()+ "\n" + this.carrinho + "\n Total a pagar" +this.valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedidos = (Pedido) o;
        return Objects.equals(codigo, pedidos.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}
