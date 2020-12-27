package br.com.ifpb.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.projeto.factory.ConnectionFactory;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Usuario;

public class AgendaDAO {
	
	public void createAgendasTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS agendas (id int primary key unique auto_increment," +
				"nome varchar(50) UNIQUE, usuario_id int, FOREIGN KEY (usuario_id) REFERENCES usuarios(id))";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			statement = connection.createStatement();
			statement.execute(sql);
			
			System.out.println("Tabela agendas criada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean createAgenda(Agenda agenda) {

		String sql = "INSERT INTO agendas(nome, usuario_id) VALUES(?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean criado = false;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, agenda.getNome());
			preparedStatement.setInt(2, agenda.getUsuario().getId());

			preparedStatement.execute();
			
			System.out.println("Agenda salva com sucesso!");
			criado = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return criado;
	}
	
	public Agenda getAgenda(int id, Usuario usuario) {
		
		String sql = "SELECT * FROM agendas WHERE id = ? AND usuario_id = ?";
				
		Agenda agenda = new Agenda();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, usuario.getId());
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				agenda.setId(resultSet.getInt("id"));
				agenda.setNome(resultSet.getString("nome"));
				agenda.setUsuario(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return agenda;
	}

	public List<Agenda> getAgendas(Usuario usuario) {
		
		String sql = "SELECT * FROM agendas WHERE usuario_id = ?";
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, usuario.getId());
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Agenda agenda = new Agenda();
				
				agenda.setId(resultSet.getInt("id"));		
				agenda.setNome(resultSet.getString("nome"));
				agenda.setUsuario(usuario);
				
				agendas.add(agenda);		
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return agendas;
	}
	
	public void updateAgenda(Agenda agenda, int id) {
		
		String sql = "UPDATE agendas SET nome = ?, usuario_id = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, agenda.getNome());
			preparedStatement.setInt(2, agenda.getUsuario().getId());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

			System.out.println("Agenda atualizado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deleteAgenda(int id) {
		
		String sql = "DELETE FROM agendas WHERE id = ?";
				
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Agenda deletado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
