package sistema.Sam_Math_Rona;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
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

    public double getAtualizarValorTotal(){
        double valorTotalDoPedido = 0;
        for(Produto p: this.carrinho){
            valorTotalDoPedido += p.getPreco();
        }
        setValorTotal(valorTotalDoPedido);
        return valorTotalDoPedido;
    }

    public double getValorTotal() {
        return this.valorTotal;
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
        if(this.cliente.getEndereco().equals("Retirada")){
            return "Pedido: "+ this.codigo +
                    "\n"+ "Estado do pedido: "+ this.estadoPedido+
                    "\n"+ "Data "+ this.data +
                    "\n"+ "Cliente:  " +this.cliente.getNome() +
                    "\n"+ "Itens do carrinho: " + this.carrinho +
                    "\n"+ "Total a pagar: " +this.getValorTotal();
        }else {
            return "Código do pedido: " + this.codigo +
                    "\n"+ "Estado do pedido: " + this.estadoPedido +
                    "\n"+ "Data " + this.data.toString() +
                    "\n"+ "Cliente:  " + this.cliente.getNome() +
                    "\n"+ "Endereço: " + this.cliente.getEndereco() +
                    "\n"+ "Número da casa: " + this.cliente.getNumeroCasa() +
                    "\n"+ "Itens do carrinho: "+ this.carrinho +
                    "\n"+ "Total a pagar: " + this.valorTotal;
        }
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
