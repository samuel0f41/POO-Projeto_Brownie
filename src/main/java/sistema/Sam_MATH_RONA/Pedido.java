package sistema.Sam_MATH_RONA;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private Cliente cliente;
    private List<ItensPedidos> itensPedidos;
    private String codigoDoPedido;
    private double total;
    private LocalDateTime data = LocalDateTime.now();



    public Pedido(Cliente cliente, List<ItensPedidos> itensPedidos, String codigoDoPedido) {
        this.cliente = cliente;
        this.itensPedidos = itensPedidos;
        this.codigoDoPedido = codigoDoPedido;
    }


    public String getCodigoDoPedido() {
        return codigoDoPedido;
    }

    public void setCodigoDoPedido(String codigoDoPedido) {
        this.codigoDoPedido = codigoDoPedido;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getTotal() {
        double totalDoPedido = 0.0;
        for(ItensPedidos i: this.itensPedidos){
            totalDoPedido += i.getPrecoTotal();
        }
        return totalDoPedido;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setLanches(List<ItensPedidos> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    @Override
    public String toString() {
        return "Pedido: "+ this.codigoDoPedido + "\nCliente:  " + this.cliente.getNome()+ "\nEndereço: " +
                this.cliente.getEndereco()+ "\n" + this.itensPedidos + "\n Total a pagar" +this.total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensPedidos> getItensPedidos() {
        return this.itensPedidos;
    }

    public void setItensPedidos(List<ItensPedidos> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedidos = (Pedido) o;
        return Objects.equals(codigoDoPedido, pedidos.codigoDoPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDoPedido);
    }


}
