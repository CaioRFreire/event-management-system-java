package controller;

// Bibliotecas necessárias
import java.util.ArrayList;
import model.LocalModel; // Model do Local
import util.Conexao; // Classe conexão
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author caior
 */

public class LocalController {
    // Método inserir
    public boolean inserir(LocalModel local) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql insert
        String sql = "insert into local (nome,endereco,capacidade,recursos_disponiveis,acessibilidade,quantidade_participantes) values (?,?,?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar os parâmetros
            sentenca.setString(1, local.getNome());
            sentenca.setString(2, local.getEndereco());
            sentenca.setInt(3, local.getCapacidade());
            sentenca.setString(4, local.getRecursos_disponiveis());
            sentenca.setString(5, local.getAcessibilidade());
            sentenca.setInt(6, local.getQuantidade_participantes());
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
    public boolean editar (LocalModel local) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql update
        String sql = "update local set nome = ?, " 
            + "endereco = ?, capacidade = ?, recursos_disponiveis = ?, acessibilidade = ?, quantidade_participantes = ? where idlocal = ? ";
            try {
                PreparedStatement sentenca = c.conector.prepareStatement(sql);
                // Passar os parâmetros
                sentenca.setString(1, local.getNome());
                sentenca.setString(2, local.getEndereco());
                sentenca.setInt(3, local.getCapacidade());
                sentenca.setString(4, local.getRecursos_disponiveis());
                sentenca.setString(5, local.getAcessibilidade());
                sentenca.setInt(6, local.getQuantidade_participantes());
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
    public boolean excluir (LocalModel local) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql delete
        String sql = "delete from local where idlocal = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar o parâmetro
            sentenca.setInt(1,local.getIdlocal());
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
    public LocalModel selecionar (LocalModel local) {
        LocalModel retorno = null;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from local where idlocal = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, local.getIdlocal());
            ResultSet result = sentenca.executeQuery();
            // Executar sentença
            if (result.next()) {
                retorno = new LocalModel();
                retorno.setIdlocal(result.getInt("idlocal"));
                retorno.setNome(result.getString("nome"));
                retorno.setEndereco(result.getString("endereco"));
                retorno.setCapacidade(result.getInt("capacidade"));
                retorno.setRecursos_disponiveis(result.getString("recursos_disponiveis"));
                retorno.setAcessibilidade(result.getString("acessibilidade"));
                retorno.setQuantidade_participantes(result.getInt("quantidade_participantes"));
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    // ArrayList
    public ArrayList<LocalModel> selecionarTodos(){
        ArrayList<LocalModel> retorno = new ArrayList<>();
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from local";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            // Executar sentença em while
            while (result.next()) {
               LocalModel l = new LocalModel();
               l.setIdlocal(result.getInt("idlocal"));
               l.setNome(result.getString("nome"));
               l.setEndereco(result.getString("endereco"));
               l.setCapacidade(result.getInt("capacidade"));
               l.setRecursos_disponiveis(result.getString("recursos_disponiveis"));
               l.setAcessibilidade(result.getString("acessibilidade"));
               l.setQuantidade_participantes(result.getInt("quantidade_participantes"));
               retorno.add(l);
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção" + e.getMessage());
        }
        c.desconectar();
        return retorno;
        }
    }

