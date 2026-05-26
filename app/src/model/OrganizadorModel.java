package model;

/**
 *
 * @author caior
 */
public class OrganizadorModel {
    private int idorganizador;
    private String cpf,nome,data_nasc,telefone;
    
    public OrganizadorModel(int idorganizador, String cpf, String nome, String data_nasc, String telefone) {
        this.idorganizador = idorganizador;
        this.cpf = cpf;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.telefone = telefone;
    }
    public OrganizadorModel(){
        idorganizador = 0;
        cpf = "";
        nome = "";
        data_nasc = "";
        telefone = "";
    }

    
    public int getIdorganizador() {
        return idorganizador;
    }

    public void setIdorganizador(int idorganizador) {
        this.idorganizador = idorganizador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
