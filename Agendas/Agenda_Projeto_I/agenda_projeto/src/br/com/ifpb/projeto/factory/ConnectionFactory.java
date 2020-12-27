package br.com.ifpb.projeto.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// Nome de usuario do mysql
	private static final String USERNAME = "b9c527b3c4c2d6";
	
	// Senha do banco
	private static final String PASSWORD = "9761ec43";
	
	// Caminho do banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_46fc30ee9372392?useTimezone=true&serverTimezone=UTC";
	
	/*
	 * Conexao com o banco de dados
	 */
	public static Connection createConnectionToMySQL() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		// Recuperar uma conexao com o banco de dados
		Connection connection = createConnectionToMySQL();
		
		// Testar se a conexao esta vazia
		if (connection != null) {
			System.out.println("Conexao obtida com sucesso!");
			connection.close();
		}
	}

}
