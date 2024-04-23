package sistema.Sam_Math_Rona;

import java.io.Serializable;

public class Produto implements Serializable {
    private Tipo tipo;
    private Sabores sabor;
    private int qtEstoque;
    private double preco;

    public Produto( Tipo tipo, Sabores sabor, int qtEstoque, double preco) {
        this.tipo = tipo;
        this.sabor = sabor;
        this.qtEstoque = qtEstoque;
        this.preco = preco;
    }
    public Produto(){
        this.qtEstoque = 0;
        this.sabor = Sabores.UNICO;
        this.tipo = Tipo.INDEFINIDO;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Sabores getSabor() {
        return sabor;
    }

    public void setSabor(Sabores sabor) {
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

        if (tipo != produto.tipo) return false;
        return sabor == produto.sabor;
    }

    @Override
    public int hashCode() {
        int result = tipo != null ? tipo.hashCode() : 0;
        result = 31 * result + (sabor != null ? sabor.hashCode() : 0);
        return result;
    }

    public String toString(){
        return  "Brownie de "+ this.sabor+ " Quantidade no estoque: "+ this.qtEstoque+ " Preço R$: "+ this.preco+"\n";
    }

}
