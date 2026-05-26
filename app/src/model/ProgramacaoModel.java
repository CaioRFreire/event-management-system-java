package model;

/**
 *
 * @author caior
 */
public class ProgramacaoModel {
    private int idprogramacao;
    private String data_evento, hora_inicio, hora_fim;

    public ProgramacaoModel(int idprogramacao, String data_evento, String hora_inicio, String hora_fim) {
        this.idprogramacao = idprogramacao;
        this.data_evento = data_evento;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
    }
    public ProgramacaoModel(){
        idprogramacao = 0;
        data_evento = "";
        hora_inicio = "";
        hora_fim = "";
    }
    public void setIdprogramacao(int idprogramacao) {
        this.idprogramacao = idprogramacao;
    }

    public void setData_evento(String data_evento) {
        this.data_evento = data_evento;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public int getIdprogramacao() {
        return idprogramacao;
    }

    public String getData_evento() {
        return data_evento;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }
}



