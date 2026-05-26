package controller;

// Bibliotecas necessárias
import java.util.ArrayList;
import model.AtividadeModel; // Model da Atividade
import util.Conexao; // Classe conexão
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author caior
 */

public class AtividadeController {
    // Método inserir
    public boolean inserir(AtividadeModel atividade) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql insert
        String sql = "insert into atividade (descricao,responsavel,musico,genero,buffet,tipo_cardapio,decoracao,danca,midia) values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar os parâmetros
            sentenca.setString(1, atividade.getDescricao());
            sentenca.setString(2, atividade.getResponsavel());
            sentenca.setString(3, atividade.getMusico());
            sentenca.setString(4, atividade.getGenero());
            sentenca.setString(5, atividade.getBuffet());
            sentenca.setString(6, atividade.getTipo_cardapio());
            sentenca.setString(7, atividade.getDecoracao());
            sentenca.setString(8, atividade.getDanca());
            sentenca.setString(9, atividade.getMidia());
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
    public boolean editar (AtividadeModel atividade) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql update
        String sql = "update atividade set descricao = ?, " 
            + "responsavel = ?, musico = ?, genero = ?, buffet = ?, tipo_cardapio = ?, decoracao = ?, danca = ?, midia = ? where idatividade = ?";
            try {
                PreparedStatement sentenca = c.conector.prepareStatement(sql);
                // Passar os parâmetros
                sentenca.setString(1, atividade.getDescricao());
                sentenca.setString(2, atividade.getResponsavel());
                sentenca.setString(3, atividade.getMusico());
                sentenca.setString(4, atividade.getGenero());
                sentenca.setString(5, atividade.getBuffet());
                sentenca.setString(6, atividade.getTipo_cardapio());
                sentenca.setString(7, atividade.getDecoracao());
                sentenca.setString(8, atividade.getDanca());
                sentenca.setString(9, atividade.getMidia());
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
    public boolean excluir (AtividadeModel atividade) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql delete
        String sql = "delete from atividade where idatividade = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar o parâmetro
            sentenca.setInt(1,atividade.getIdatividade());
            // Executar sentença
            if (!sentenca.execute()) {
                retorno = true;
            }
        } catch (SQLException e ) {
            // Informando erro no terminal
            System.out.println ("Erro ao deletar!" + e.getMessage());
        }       
        // Desconectar
        c.desconectar();
        return retorno;
    }
    
    // Método selecionar
    public AtividadeModel selecionar (AtividadeModel atividade) {
        AtividadeModel retorno = null;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from atividade where idatividade = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, atividade.getIdatividade());
            ResultSet result = sentenca.executeQuery();
            // Executar sentença
            if (result.next()) {
                retorno = new AtividadeModel();
                retorno.setIdatividade(result.getInt("idatividade"));
                retorno.setDescricao(result.getString("descricao"));
                retorno.setResponsavel(result.getString("responsavel"));
                retorno.setMusico(result.getString("musico"));
                retorno.setGenero(result.getString("genero"));
                retorno.setBuffet(result.getString("buffet"));
                retorno.setTipo_cardapio(result.getString("tipo_cardapio"));
                retorno.setDecoracao(result.getString("decoracao"));
                retorno.setDanca(result.getString("danca"));
                retorno.setMidia(result.getString("midia"));
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    // ArrayList
    public ArrayList<AtividadeModel> selecionarTodos(){
        ArrayList<AtividadeModel> retorno = new ArrayList<>();
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from atividade";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            // Executar sentença em while
            while (result.next()) {
               AtividadeModel a = new AtividadeModel();
               a.setIdatividade(result.getInt("idatividade"));
               a.setDescricao(result.getString("descricao"));
               a.setResponsavel(result.getString("responsavel"));
               a.setMusico(result.getString("musico"));
               a.setGenero(result.getString("genero"));
               a.setBuffet(result.getString("buffet"));
               a.setTipo_cardapio(result.getString("tipo_cardapio"));
               a.setDecoracao(result.getString("decoracao"));
               a.setDanca(result.getString("danca"));
               a.setMidia(result.getString("midia"));
               retorno.add(a);
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}

