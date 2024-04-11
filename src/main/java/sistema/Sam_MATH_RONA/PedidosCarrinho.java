package sistema.Sam_MATH_RONA;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PedidosCarrinho {
    private List<Produto> unidade;
    private String nomeDoLache;
    private String endereco;
    private String codigoDoPedido;

    private LocalDateTime data = LocalDateTime.now();

    private double total;


    public PedidosCarrinho(List<Produto> unidade, String nomeDoLache, String endereco, String codigoDoPedido, double total) {
        this.unidade = unidade;
        this.nomeDoLache = nomeDoLache;
        this.endereco = endereco;
        this.codigoDoPedido = codigoDoPedido;
        this.total = total;
    }

    public PedidosCarrinho(){
        this.endereco = "Retirada no local";
    }

    public List<Produto> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Produto> unidade) {
        this.unidade = unidade;
    }

    public String getNomeDoLache() {
        return nomeDoLache;
    }

    public void setNomeDoLache(String nomeDoLache) {
        this.nomeDoLache = nomeDoLache;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pedidos " +
                "unidade=" + unidade +
                ", nomeDoLache='" + nomeDoLache + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidosCarrinho pedidos = (PedidosCarrinho) o;
        return Objects.equals(codigoDoPedido, pedidos.codigoDoPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDoPedido);
    }


}
