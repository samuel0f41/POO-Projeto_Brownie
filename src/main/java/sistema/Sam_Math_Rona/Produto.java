package sistema.Sam_Math_Rona;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private String tipo;
    private String sabor;
    private int qtEstoque;
    private double preco;

    public Produto( String tipo, String sabor, int qtEstoque, double preco) {
        this.tipo = tipo;
        this.sabor = sabor;
        this.qtEstoque = qtEstoque;
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getQtEstoque() {
        return qtEstoque;
    }

    public void setQtEstoque(int qtEstoque) {
        this.qtEstoque = qtEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(tipo, produto.tipo) && Objects.equals(sabor, produto.sabor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, sabor);
    }

    public String toString(){
        return  "Brownie de "+ this.sabor+ " Quantidade no estoque: "+ this.qtEstoque+ " Preço R$: "+ this.preco+"\n";
    }

}
