package controller;

// Bibliotecas necessárias
import java.util.ArrayList;
import model.ProgramacaoModel; // Model de programação
import util.Conexao; // Classe conexão
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author caior
 */

public class ProgramacaoController {
    // Método inserir
    public boolean inserir(ProgramacaoModel programacao) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql insert
        String sql = "insert into programacao (data_evento,hora_inicio,hora_fim) values (?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar os parâmetros
            sentenca.setString(1, programacao.getData_evento());
            sentenca.setString(2, programacao.getHora_inicio());
            sentenca.setString(3, programacao.getHora_fim());
            // Executar sentença
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na sentença SQL: " + e.getMessage());
        }
        // Desconectar
        c.desconectar();
        return retorno;
    }
    
    // Método editar
    public boolean editar(ProgramacaoModel programacao) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql update
        String sql = "update programacao set data_evento = ?, "
                + "hora_inicio = ?, hora_fim = ? where idprogramacao = ? ";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar os parâmetros
            sentenca.setString(1, programacao.getData_evento());
            sentenca.setString(2, programacao.getHora_inicio());
            sentenca.setString(3, programacao.getHora_fim());
            sentenca.setInt(4, programacao.getIdprogramacao());
            // Executar sentença
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro ao editar: " + e.getMessage());
        }
        // Desconectar
        c.desconectar();
        return retorno;
    }
    
    // Método excluir
    public boolean excluir(ProgramacaoModel programacao) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql delete
        String sql = "delete from programacao where idprogramacao = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar o parâmetro
            sentenca.setInt(1, programacao.getIdprogramacao());
            // Executar sentença
            if(!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e){
            // Informando erro no terminal
            System.out.println("Erro ao deletar!"+ e.getMessage());
        }
        // Desconectar
        c.desconectar();
        return retorno;
    }
    
    // Método selecionar
    public ProgramacaoModel selecionar (ProgramacaoModel programacao) {
        ProgramacaoModel retorno = null;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from programacao where idprogramacao = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, programacao.getIdprogramacao());
            ResultSet result = sentenca.executeQuery();
            // Executar sentença
            if(result.next()){
                retorno = new ProgramacaoModel();
                retorno.setIdprogramacao(result.getInt("idprogramacao"));
                retorno.setData_evento(result.getString("data_evento"));
                retorno.setHora_inicio(result.getString("hora_inicio"));
                retorno.setHora_fim(result.getString("hora_fim"));
            }
        }catch(SQLException  e){
            // Informando erro no terminal
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    // ArrayList
    public ArrayList<ProgramacaoModel> selecionarTodos() {
        ArrayList<ProgramacaoModel> retorno = new ArrayList<>();
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from programacao";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            // Executar sentença em while
            while(result.next()){
                ProgramacaoModel p = new ProgramacaoModel();
                p.setIdprogramacao(result.getInt("idprogramacao"));
                p.setData_evento(result.getString("data_evento"));
                p.setHora_inicio(result.getString("hora_inicio"));
                p.setHora_fim(result.getString("hora_fim"));
                retorno.add(p);
            }
        }catch(SQLException  e){
            // Informando erro no terminal
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
