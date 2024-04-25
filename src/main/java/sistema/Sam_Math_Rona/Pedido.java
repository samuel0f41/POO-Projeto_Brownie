package sistema.Sam_Math_Rona;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido implements Serializable {
    private int codigo;
    private Cliente cliente;
    private List<Produto> carrinho;
    private double valorTotal;
    private EstadoPedido estadoPedido;
    private LocalDateTime data = LocalDateTime.now();

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.carrinho = produtos;
        this.estadoPedido = EstadoPedido.PENDENTE;
    }

    public double getValorTotal() {
        for(Produto p: this.carrinho){
            this.valorTotal += p.getPreco();
        }
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
        return "Pedido: "+ this.codigo +  " Estado do pedido: "+ this.estadoPedido+" Data "+ this.data + "\nCliente:  " +this.cliente.getNome()+ " Endereço: " +
                this.cliente.getEndereco()+ " N: "+this.cliente.getNumeroCasa() +"\n" + this.carrinho + "\n Total a pagar" +this.valorTotal+"\n\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return codigo == pedido.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
