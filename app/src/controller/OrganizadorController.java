package controller;

// Bibliotecas necessárias
import java.util.ArrayList;
import model.OrganizadorModel; // Model do Organizador
import util.Conexao; // Classe conexão
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author caior
 */

public class OrganizadorController {
    // Método inserir
    public boolean inserir(OrganizadorModel organizador) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql insert
        String sql = "insert into organizador (cpf,nome,data_nasc,telefone) values (?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar os parâmetros
            sentenca.setString(1, organizador.getCpf());
            sentenca.setString(2, organizador.getNome());
            sentenca.setString(3, organizador.getData_nasc());
            sentenca.setString(4, organizador.getTelefone());
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
    public boolean editar (OrganizadorModel organizador) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql update
        String sql = "update organizador set cpf = ?, " 
            + "nome = ?, data_nasc = ?, telefone = ? where idorganizador = ? ";
            try {
                PreparedStatement sentenca = c.conector.prepareStatement(sql);
                // Passar os parâmetros
                sentenca.setString(1, organizador.getCpf());
                sentenca.setString(2, organizador.getNome());
                sentenca.setString(3, organizador.getData_nasc());
                sentenca.setString(4, organizador.getTelefone());
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
    public boolean excluir (OrganizadorModel organizador) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql delete
        String sql = "delete from organizador where idorganizador = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar o parâmetro
            sentenca.setInt(1,organizador.getIdorganizador());
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
    public OrganizadorModel selecionar (OrganizadorModel organizador) {
        OrganizadorModel retorno = null;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from organizador where idorganizador = ?";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, organizador.getIdorganizador());
            ResultSet result = sentenca.executeQuery();
            // Executar sentença
            if (result.next()) {
                retorno = new OrganizadorModel();
                retorno.setIdorganizador(result.getInt("idorganizador"));
                retorno.setCpf(result.getString("cpf"));
                retorno.setNome(result.getString("nome"));
                retorno.setData_nasc(result.getString("data_nasc"));
                retorno.setTelefone(result.getString("telefone"));
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    // ArrayList
    public ArrayList<OrganizadorModel> selecionarTodos(){
        ArrayList<OrganizadorModel> retorno = new ArrayList<>();
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select * from organizador";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            // Executar sentença em while
            while (result.next()) {
               OrganizadorModel p = new OrganizadorModel();
               p.setIdorganizador(result.getInt("idorganizador"));
               p.setCpf(result.getString("cpf"));
               p.setNome(result.getString("nome"));
               p.setData_nasc(result.getString("data_nasc"));
               p.setTelefone(result.getString("telefone"));
               retorno.add(p);
            }
        } catch (SQLException e) {
            // Informando erro no terminal
            System.out.println("Erro na seleção" + e.getMessage());
        }
        c.desconectar();
        return retorno;
        }
    }
    



