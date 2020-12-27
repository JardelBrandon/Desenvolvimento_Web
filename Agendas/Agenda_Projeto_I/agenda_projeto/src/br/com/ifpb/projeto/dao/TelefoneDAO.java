package br.com.ifpb.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.projeto.factory.ConnectionFactory;
import br.com.ifpb.projeto.model.Telefone;

public class TelefoneDAO {
	
	public void createTelefonesTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS telefones (id int primary key unique auto_increment," +
				"ddd varchar(3), numero varchar(10), contato_id int, FOREIGN KEY (contato_id) REFERENCES contatos(id))";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			statement = connection.createStatement();
			statement.execute(sql);
			
			System.out.println("Tabela telefones criada com sucesso!");

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
	
public void createContatosTelefonesTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS contatos_telefones (\r\n" + 
					 "	contato_id int,\r\n" + 
					 "	telefone_id int, \r\n" + 
					 "	FOREIGN KEY (contato_id) REFERENCES contatos(id), \r\n" + 
					 "    FOREIGN KEY (telefone_id) REFERENCES telefones(id),\r\n" + 
					 "    UNIQUE (contato_id, telefone_id)\r\n" + 
					 ")";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			statement = connection.createStatement();
			statement.execute(sql);
			
			System.out.println("Tabela Contatos - Telefones criada com sucesso!");

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

	public int createTelefone(Telefone telefone, int contatoId) {

		String sql = "INSERT INTO telefones(ddd, numero, contato_id) VALUES(?, ?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;
		int telefoneId = 0;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, telefone.getDdd());
			preparedStatement.setString(2, telefone.getNumero());
			preparedStatement.setInt(3, contatoId);

			preparedStatement.execute();
			
			System.out.println("Telefone salvo com sucesso!");
			
			generatedKeys = preparedStatement.getGeneratedKeys();	
			if (generatedKeys.next()) {						
				telefoneId = generatedKeys.getInt(1);
			}
			
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
				if (generatedKeys != null) {
					generatedKeys.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		return telefoneId;
	}
	
	public void createContatoTelefone(int telefoneId, int contatoId) {

		String sql = "INSERT INTO contatos_telefones(telefone_id, contato_id) VALUES(?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, telefoneId);
			preparedStatement.setInt(2, contatoId);

			preparedStatement.execute();
			
			System.out.println("Relacionamento Contato-Telefone salvo com sucesso!");
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
	}
	
	public Telefone getTelefone(int id, int contatoId) {
		
		String sql = "SELECT * FROM telefones WHERE id = ? AND contato_id = ?";
				
		Telefone telefone = new Telefone();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, contatoId);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				telefone.setId(resultSet.getInt("id"));
				telefone.setDdd(resultSet.getString("ddd"));
				telefone.setNumero(resultSet.getString("numero"));
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

		return telefone;
	}

	public List<Telefone> getTelefones(int contatoId) {
		
		String sql = "SELECT * FROM telefones WHERE contato_id = ?";
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, contatoId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Telefone telefone = new Telefone();
				
				telefone.setId(resultSet.getInt("id"));		
				telefone.setDdd(resultSet.getString("ddd"));
				telefone.setNumero(resultSet.getString("numero"));
				
				telefones.add(telefone);		
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
	return telefones;
	}
	
public List<Telefone> getContatosTelefones() {
		
		String sql = "SELECT contatos.id, contatos.nome, contatos.genero, contatos.dataDeNascimento,\r\n" + 
					 "telefones.id AS telefones_id, telefones.ddd AS telefones_ddd, telefones.numero AS telefones_numero \r\n" + 
					 "FROM contatos\r\n" + 
					 "JOIN contatos_telefones on (contatos.id=contatos_telefones.contato_id)\r\n" + 
					 "JOIN telefones on (telefones.id=contatos_telefones.telefone_id)\r\n" + 
					 "WHERE (contatos.agenda_id=<%=agenda.getId()%>" +
					 ")";
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement = connection.prepareStatement(sql);	
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Telefone telefone = new Telefone();
				
				telefone.setId(resultSet.getInt("id"));		
				telefone.setDdd(resultSet.getString("ddd"));
				telefone.setNumero(resultSet.getString("numero"));
				
				telefones.add(telefone);		
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
	return telefones;
	}

	public void updateTelefone(Telefone telefone, int contatoId, int telefoneId) {
		
		String sql = "UPDATE telefones SET ddd = ?, numero = ?, contato_id = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, telefone.getDdd());
			preparedStatement.setString(2, telefone.getNumero());
			preparedStatement.setInt(3, contatoId);
			preparedStatement.setInt(4, telefoneId);
			preparedStatement.executeUpdate();

			System.out.println("Telefone atualizado com sucesso!");

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
	
	public void deleteTelefone(int id) {
		
		String sql = "DELETE FROM telefones WHERE id = ?";
				
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Telefone deletado com sucesso!");

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
