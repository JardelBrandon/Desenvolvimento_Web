package br.com.ifpb.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.projeto.factory.ConnectionFactory;
import br.com.ifpb.projeto.model.Usuario;

public class UsuarioDAO {
	
	public void createUsuariosTable() {
		
		String sql = "CREATE TABLE IF NOT EXISTS usuarios ( "
						+ "id int primary key unique auto_increment,"
						+ "nome varchar(50) NOT NULL, "
						+ "email varchar(50) NOT NULL UNIQUE, "
						+ "senha varchar(50) NOT NULL "
					+ ")";
		
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			statement = connection.createStatement();
			statement.execute(sql);
			
			System.out.println("Tabela usuarios criada com sucesso!");

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

	public boolean createUsuario(Usuario usuario) {

		String sql = "INSERT INTO usuarios(nome, email, senha) VALUES(?, ?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean criado = false;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());

			preparedStatement.execute();
			
			criado = true;
			System.out.println("Usuario salvo com sucesso!");
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
	
	public Usuario loginUsuario(String email, String senha){
        
        String sql ="select * from usuarios where email=? and senha=?";
        
        Usuario usuario=null;
        Connection connection = null;
		PreparedStatement preparedStatement = null;
		
        try{
            
        	connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
	
	public Usuario getUsuario(int id) {
		
		String sql = "SELECT * FROM usuarios WHERE id = ?";
				
		Usuario usuario = new Usuario();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
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

		return usuario;
	}

	public List<Usuario> getUsuarios() {
		
		String sql = "SELECT * FROM usuarios";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(resultSet.getInt("id"));		
				usuario.setNome(resultSet.getString("login"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				usuarios.add(usuario);		
				
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
	return usuarios;
	}
	
	public void updateUsuario(Usuario usuario, int id) {
		
		String sql = "UPDATE usuarios SET login = ?, email = ?, senha = ? WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();

			System.out.println("Usuario atualizado com sucesso!");

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
	
	public void deleteUsuario(int id) {
		
		String sql = "DELETE FROM usuarios WHERE id = ?";
				
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("Usuario deletado com sucesso!");

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
