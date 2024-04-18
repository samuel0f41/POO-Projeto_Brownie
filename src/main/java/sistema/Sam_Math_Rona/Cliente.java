package sistema.Sam_Math_Rona;

public class Cliente {
    private String nome;
    private String endereco;
    private String numeroCasa;

    public Cliente(String nome, String endereco, String numeroCasa) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroCasa = numeroCasa;
    }
    public Cliente(String nome){
        this.nome = nome;
        this.endereco = "Retirada";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
}
