package model;

/**
 *
 * @author caior
 */
public class EventoModel {
    private int codevento, valor_plano;
    private String categoria, plano;
    private AtividadeModel atividade;
    private LocalModel local;
    private OrganizadorModel organizador;
    private ProgramacaoModel programacao;

    public EventoModel(int codevento, int valor_plano, String categoria, String plano, AtividadeModel atividade, LocalModel local, OrganizadorModel organizador, ProgramacaoModel programacao) {
        this.codevento = codevento;
        this.valor_plano = valor_plano;
        this.categoria = categoria;
        this.plano = plano;
        this.atividade = atividade;
        this.local = local;
        this.organizador = organizador;
        this.programacao = programacao;
    }
    public EventoModel(){
        codevento = 0;
        valor_plano = 0;
        categoria = "";
        plano = "";
        atividade = new AtividadeModel();
        local = new LocalModel();
        organizador = new OrganizadorModel();
        programacao = new ProgramacaoModel();
    }

    public int getCodevento() {
        return codevento;
    }

    public void setCodevento(int codevento) {
        this.codevento = codevento;
    }

    public int getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(int valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public AtividadeModel getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeModel atividade) {
        this.atividade = atividade;
    }

    public LocalModel getLocal() {
        return local;
    }

    public void setLocal(LocalModel local) {
        this.local = local;
    }

    public OrganizadorModel getOrganizador() {
        return organizador;
    }

    public void setOrganizador(OrganizadorModel organizador) {
        this.organizador = organizador;
    }

    public ProgramacaoModel getProgramacao() {
        return programacao;
    }

    public void setProgramacao(ProgramacaoModel programacao) {
        this.programacao = programacao;
    }
    
    
}
