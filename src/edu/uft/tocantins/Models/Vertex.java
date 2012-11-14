package edu.uft.tocantins.Models;

/**
 * Definição da classe Vertex, 
 * Realiza a representação de um vertice (cidade)
 * @author @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class Vertex extends Object
{
    // <------------------- 0.Variables ------------------->
    private static int vertexCount = 0;
    private int id;
    private String cityName;
    private int population;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor do vertice com nome da cidade e população
     * @param cityName nome da cidade a ser definida pelo vertice
     * @param population população da cidade representada pelo vertice
     */
    public Vertex( String cityName, int population )
    {
        setID( vertexCount );
        vertexCount++;
        setCityName( cityName );
        setPopulation( population );
    }
    
    // <------------------- 2.Getters methods ------------------->
    /**
     * Retorna o id do vertice
     * @return id do vertice
     */
    public int getID()
    {
        return this.id;
    }
    
    /**
     * Retorna o nome da cidade representada pelo vertice
     * @return nome da cidade representada pelo vertice
     */
    public String getCityName()
    {
        return this.cityName;
    }
    
    /**
     * Retorna a população da cidade representada pelo vertice
     * @return população da cidade representada pelo vertice
     */
    public int getPopulation()
    {
        return this.population;
    }
    
    // <------------------- 3.Setters methods ------------------->
    /**
     * Define o ID do vertice
     * @param ID id a ser definido no vertice
     */
    public void setID( int ID )
    {
        if( ID >= 0)
            this.id = ID;
        else this.id = -1;
    }
    
    /**
     * Define o nome da cidade que o vertice representa
     * @param cityName nome da cidade a ser definida pelo vertice
     */
    public void setCityName( String cityName )
    {
        this.cityName = cityName;
    }
    
    /**
     * Define população da cidade que o vertice representa
     * @param population populacao da cidade a ser definida pelo vertice
     */
    public void setPopulation( int population )
    {
        if( population > 0 )
            this.population = population;
        else this.population = -1;
    }
    
    // <------------------- 4.Functional methods ------------------->
    /**
     * Retorna representação em String da cidade representada por esse vertice
     * @return representação em String do vertice
     */
    @Override
    public String toString()
    {
	return "ID: " + id + "\tNome da cidade: " + cityName + "\tPopulação: " + population;
    }
    
    /**
     * Verifica se o vertice vertex é igual à vertice
     * @param vertex vertice a ser comparado
     * @return true se vertex é igual ao vertice, false caso contrario
     */
    public boolean compare( Vertex vertex )
    {
        if( cityName.equals( vertex.getCityName() ) && population == vertex.getPopulation() )
            return true;
        else return false;
    }
}
