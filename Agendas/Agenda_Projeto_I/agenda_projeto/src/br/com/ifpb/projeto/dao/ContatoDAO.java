package br.com.ifpb.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.projeto.factory.ConnectionFactory;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Contato;
import br.com.ifpb.util.Genero;

public class ContatoDAO {
	
	public void createContatosTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS contatos (id int primary key unique auto_increment," +
					 "nome varchar(50), genero enum('MASCULINO', 'FEMININO') NOT NULL, dataDeNascimento date," +
					 "agenda_id int, FOREIGN KEY (agenda_id) REFERENCES agendas(id))";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			statement = connection.createStatement();
			statement.execute(sql);
			
			System.out.println("Tabela contatos criada com sucesso!");

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

	public boolean createContato(Contato contato) {

		String sql = "INSERT INTO contatos(nome, genero, dataDeNascimento, agenda_id) VALUES(?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean criado = false;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getGenero().name());
			preparedStatement.setDate(3, contato.getDataDeNascimento());
			preparedStatement.setInt(4, contato.getAgenda().getId());

			preparedStatement.execute();
			
			System.out.println("Contato salvo com sucesso!");
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
	
	public Contato getContato(int id, Agenda agenda) {
		
		String sql = "SELECT * FROM contatos WHERE id = ? AND agenda_id = ?";
				
		Contato contato = new Contato();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, agenda.getId());
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				contato.setId(resultSet.getInt("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setGenero(Genero.valueOf(resultSet.getString("genero")));
				contato.setDataDeNascimento(resultSet.getDate("dataDeNascimento"));
				contato.setAgenda(agenda);
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

		return contato;
	}

	public List<Contato> getContatos(Agenda agenda) {
		
		String sql = "SELECT * FROM contatos WHERE agenda_id = ?";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, agenda.getId());
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Contato contato = new Contato();
				
				contato.setId(resultSet.getInt("id"));		
				contato.setNome(resultSet.getString("nome"));
				contato.setGenero(Genero.valueOf(resultSet.getString("genero")));
				contato.setDataDeNascimento(resultSet.getDate("dataDeNascimento"));
				contato.setAgenda(agenda);
				
				contatos.add(contato);		
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
	return contatos;
	}
	
	public void updateContato(Contato contato, int id) {
		
		String sql = "UPDATE contatos SET nome = ?, genero = ?, dataDeNascimento = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getGenero().name());
			preparedStatement.setDate(3, contato.getDataDeNascimento());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();

			System.out.println("Contato atualizado com sucesso!");

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
	
	public void deleteContato(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
				
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Contato deletado com sucesso!");

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
