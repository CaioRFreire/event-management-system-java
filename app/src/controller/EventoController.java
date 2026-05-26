package controller;

// Bibliotecas necessárias
import java.util.ArrayList;
import model.EventoModel; // Model do Evento
import util.Conexao; // Classe conexão
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author caior
 */

public class EventoController {
    // Método inserir
    public boolean inserir(EventoModel evento) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql insert
        String sql = "insert into evento (categoria,plano,valor_plano,atividade,local,organizador,programacao)values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar parâmetros
            sentenca.setString(1, evento.getCategoria());
            sentenca.setString(2, evento.getPlano());
            sentenca.setInt(3, evento.getValor_plano());
            sentenca.setInt(4, evento.getAtividade().getIdatividade());
            sentenca.setInt(5, evento.getLocal().getIdlocal());
            sentenca.setInt(6, evento.getOrganizador().getIdorganizador());
            sentenca.setInt(7, evento.getProgramacao().getIdprogramacao());
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
    public boolean editar (EventoModel evento) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql update
        String sql = "update evento set categoria = ?, " 
            + "plano = ?, valor_plano = ?, atividade = ?, local = ?, organizador = ?, programacao = ? where codevento = ? ";
            try {
                PreparedStatement sentenca = c.conector.prepareStatement(sql);
                // Passar parâmetros
                sentenca.setString(1, evento.getCategoria());
                sentenca.setString(2, evento.getPlano());
                sentenca.setInt(3, evento.getValor_plano());
                sentenca.setInt(4, evento.getAtividade().getIdatividade());
                sentenca.setInt(5, evento.getLocal().getIdlocal());
                sentenca.setInt(6, evento.getOrganizador().getIdorganizador());
                sentenca.setInt(7, evento.getProgramacao().getIdprogramacao());
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
    public boolean excluir(EventoModel evento) {
        boolean retorno = false;
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql delete
        String sql = "delete from evento where codevento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            // Passar o parâmetro
            sentenca.setInt(1, evento.getCodevento());
            // Executar sentença
            if(!sentenca.execute())
                retorno = true;
        }catch(SQLException e){
            // Informando erro no terminal
            System.out.println("Erro ao deletar!"+ e.getMessage());
        }
        // Desconectar
        c.desconectar();
        return retorno;
    }
    
    // Método selecionar
    public EventoModel selecionar(EventoModel evento) {
        EventoModel retorno = null;
        Conexao c = new Conexao();
        c.conectar();
        String sql = "select e.codevento, e.categoria, e.plano, e.valor_plano, " +
             "a.idatividade, a.descricao, a.responsavel, a.musico, a.genero, a.buffet, a.tipo_cardapio, a.decoracao, a.danca, a.midia, " +
             "l.idlocal, l.nome, l.endereco, l.capacidade, l.recursos_disponiveis, l.acessibilidade, l.quantidade_participantes, " +
             "p.idorganizador, p.cpf, p.nome, p.data_nasc, p.telefone, " +
             "pr.idprogramacao, pr.data_evento, pr.hora_inicio, pr.hora_fim " +
             "from evento e, atividade a, local l, organizador p, programacao pr " +
             "where e.atividade = a.idatividade " +
             "and e.local = l.idlocal " +
             "and e.organizador = p.idorganizador " +
             "and e.programacao = pr.idprogramacao " +
             "and e.codevento = ?";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            sentenca.setInt(1, evento.getCodevento());
            ResultSet result = sentenca.executeQuery();
            if(result.next()){
                retorno = new EventoModel();
                retorno.setCodevento(result.getInt("codevento"));
                retorno.setPlano(result.getString("plano"));
                retorno.setValor_plano(result.getInt("valor_plano"));
                
                retorno.getAtividade().setIdatividade(result.getInt("idatividade"));
                retorno.getAtividade().setDescricao(result.getString("descricao"));
                
                retorno.getLocal().setIdlocal(result.getInt("idlocal"));
                retorno.getLocal().setNome(result.getString("nome"));
                
                retorno.getOrganizador().setIdorganizador(result.getInt("idorganizador"));
                retorno.getOrganizador().setNome(result.getString("nome"));
                
                retorno.getProgramacao().setIdprogramacao(result.getInt("idprogramacao"));
                retorno.getProgramacao().setData_evento(result.getString("data_evento"));
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    // Método selecionar todos
    public ArrayList<EventoModel> selecionarTodos() {
        ArrayList<EventoModel> retorno = new ArrayList<>();
        // Conectar com o banco
        Conexao c = new Conexao();
        c.conectar();
        // Criar sql select
        String sql = "select e.codevento, e.categoria, e.plano, e.valor_plano, " +
             "a.idatividade, a.descricao, a.responsavel, a.musico, a.genero, a.buffet, a.tipo_cardapio, a.decoracao, a.danca, a.midia, " +
             "l.idlocal, l.nome, l.endereco, l.capacidade, l.recursos_disponiveis, l.acessibilidade, l.quantidade_participantes," +
             "p.idorganizador, p.cpf, p.nome, p.data_nasc, p.telefone, " +
             "pr.idprogramacao, pr.data_evento, pr.hora_inicio, pr.hora_fim " +
             "from evento e, atividade a, local l, organizador p, programacao pr " +
             "where e.atividade = a.idatividade " +
             "and e.local = l.idlocal " +
             "and e.organizador = p.idorganizador " +
             "and e.programacao = pr.idprogramacao";
        try{
            PreparedStatement sentenca = c.conector.prepareStatement(sql);
            ResultSet result = sentenca.executeQuery();
            // Executar sentença em while
            while(result.next()){
                EventoModel e = new EventoModel();
                e.setCodevento(result.getInt("codevento"));
                e.setCategoria(result.getString("categoria"));
                e.setPlano(result.getString("plano"));
                e.setValor_plano(result.getInt("valor_plano"));
                
                e.getAtividade().setIdatividade(result.getInt("idatividade"));
                e.getAtividade().setDescricao(result.getString("descricao"));
                
                e.getLocal().setIdlocal(result.getInt("idlocal"));
                e.getLocal().setNome(result.getString("nome"));
               
                e.getOrganizador().setIdorganizador(result.getInt("idorganizador"));
                e.getOrganizador().setNome(result.getString("nome"));
                
                e.getProgramacao().setIdprogramacao(result.getInt("idprogramacao"));
                e.getProgramacao().setData_evento(result.getString("data_evento"));
                retorno.add(e);
            }
        }catch(SQLException  e){
            System.out.println("Erro na seleção: "+ e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
