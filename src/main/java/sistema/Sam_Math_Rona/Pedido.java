package sistema.Sam_Math_Rona;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Pedido implements Serializable {
    private int codigo;
    private Cliente cliente;
    private List<Produto> carrinho;
    private double valorTotal = 0;
    private EstadoPedido estadoPedido;
    private LocalDateTime data = LocalDateTime.now();

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.carrinho = produtos;
        this.estadoPedido = EstadoPedido.PENDENTE;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        for(Produto p: this.carrinho){
            this.valorTotal += p.getPreco();
        }
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
    public Month getMes(){
        LocalDateTime data = this.data;
        return data.getMonth();
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(this.cliente.getEndereco().equals("Retirada")){
            return "Pedido: "+ this.codigo +
                    "\n"+ "Estado do pedido: "+ this.estadoPedido+
                    "\n"+ "Data "+ this.data.getMonth() +
                    "\n"+ "Cliente:  " +this.cliente.getNome() +
                    "\n"+ "Itens do carrinho: " + this.carrinho +
                    "\n"+ "Total a pagar: " +this.valorTotal;
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
