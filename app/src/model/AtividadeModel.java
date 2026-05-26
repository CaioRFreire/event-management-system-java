package model;

/**
 *
 * @author caior
 */
public class AtividadeModel {
    private int idatividade;
    private String descricao,responsavel,musico,genero,buffet,tipo_cardapio,decoracao,danca,midia;

    public AtividadeModel(int idatividade, String descricao, String responsavel, String musico, String genero, String buffet, String tipo_cardapio, String decoracao, String danca, String midia) {
        this.idatividade = idatividade;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.musico = musico;
        this.genero = genero;
        this.buffet = buffet;
        this.tipo_cardapio = tipo_cardapio;
        this.decoracao = decoracao;
        this.danca = danca;
        this.midia = midia;
    }

    public AtividadeModel() {
        idatividade = 0;
        descricao = "";
        responsavel ="";
        musico = "";
        genero = "";
        buffet = "";
        tipo_cardapio = "";
        decoracao = "";
        danca = "";
        midia = "";
    }
    
    public int getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMusico() {
        return musico;
    }

    public void setMusico(String musico) {
        this.musico = musico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBuffet() {
        return buffet;
    }

    public void setBuffet(String buffet) {
        this.buffet = buffet;
    }

    public String getTipo_cardapio() {
        return tipo_cardapio;
    }

    public void setTipo_cardapio(String tipo_cardapio) {
        this.tipo_cardapio = tipo_cardapio;
    }

    public String getDecoracao() {
        return decoracao;
    }

    public void setDecoracao(String decoracao) {
        this.decoracao = decoracao;
    }

    public String getDanca() {
        return danca;
    }

    public void setDanca(String danca) {
        this.danca = danca;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }
}
