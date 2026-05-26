package model;

/**
 *
 * @author caior
 */
public class LocalModel {
    private int idlocal, capacidade, quantidade_participantes;
    String nome,endereco,recursos_disponiveis,acessibilidade;

    public LocalModel(int idlocal, int capacidade, int quantidade_participantes, String nome, String endereco, String recursos_disponiveis, String acessibilidade) {
        this.idlocal = idlocal;
        this.capacidade = capacidade;
        this.nome = nome;
        this.endereco = endereco;
        this.recursos_disponiveis = recursos_disponiveis;
        this.acessibilidade = acessibilidade;
        this.quantidade_participantes = quantidade_participantes;
    }
    public LocalModel(){
        idlocal = 0;
        capacidade = 0;
        quantidade_participantes = 0;
        nome = "";
        endereco = "";
        recursos_disponiveis = "";
        acessibilidade = "";
    }

    public int getQuantidade_participantes() {
        return quantidade_participantes;
    }

    public void setQuantidade_participantes(int quantidade_participantes) {
        this.quantidade_participantes = quantidade_participantes;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
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

    public String getRecursos_disponiveis() {
        return recursos_disponiveis;
    }

    public void setRecursos_disponiveis(String recursos_disponiveis) {
        this.recursos_disponiveis = recursos_disponiveis;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }
}
