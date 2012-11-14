package edu.uft.tocantins.Models;

import java.sql.*;

/**
 * Classe para gerenciamento do banco de dados MySQL (grafos)
 * Realiza a conexão com o banco e consultas SQL
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 */
public class DBManager extends Object
{
    // <------------------- 0.Variables ------------------->
    private static DBManager instance;
    private static final String username = "root";
    private static final String password = "savio";
    private static final String link = "jdbc:mysql://localhost/grafos";
    
    private Connection connection = null;
    
    // <------------------- 1.Constructor ------------------->
    /**
     * Construtor da classe DBManager
     * @throws SQLException 
     */
    private DBManager() throws SQLException
    {
        setConnection();
    }
    
    // <------------------- 2.Getters methods ------------------->
    /**
     * Retorna a classe, evitando que a classe seja varias vezes instanciada
     * @return classe instanciada
     * @throws SQLException 
     */
    public static DBManager getInstance() throws SQLException
    {
        if( instance == null ) instance = new DBManager();
        return instance;
    }
    
    /**
     * Retorna o usuario do banco de dados
     * @return usuario do banco de dados
     */
    public static String getUsername()
    {
        return username;
    }
    
    /**
     * Retorna a senha do banco de dados
     * @return senha do banco de dados
     */
    public static String getPassword()
    {
        return password;
    }
    
    /**
     * Retorna a conexão com o banco de dados
     * @return conexão com o banco de dados
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException
    {
        setConnection();
        return this.connection;
    }
    
    // <------------------- 3.Setters methods ------------------->
    /**
     * Cria conexao com o banco de dados
     * @throws SQLException 
     */
    private void setConnection() throws SQLException
    {
        connection = DriverManager.getConnection( link, username, password );
        connection.setAutoCommit( true );
    }
    
    // <------------------- 4.Functional methods ------------------->
    /**
     * Fecha a conexão com o banco de dados
     * @throws SQLException 
     */
    public void closeConnection() throws SQLException
    {
        connection.close();
        connection = null;
    }
    
    /**
     * Executa SQL command
     * @param sql SQL a ser executada
     * @throws SQLException 
     */
    public void execute( String sql ) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement( sql );
        preparedStatement.execute();
        preparedStatement.close();
    }
    
    /**
     * Executa consulta SQL e retorna o resultado
     * @param sql SQL a ser executada
     * @return ResultSet com os valores de retorno da SQL
     * @throws SQLException
     */
    public ResultSet getResultSet( String sql ) throws SQLException
    {
        PreparedStatement preparedStatement = connection.prepareStatement( sql );
        return preparedStatement.executeQuery();
    }
}
