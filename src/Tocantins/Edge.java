package Tocantins;

/**
 * Definição da classe Edge
 * Realiza a representação da ligação de dois vertices (cidades) adjacentes
 * @author @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class Edge extends Object
{
    // <------------------- 0.Variables ------------------->
    private int source;
    private int destination;
    private double distance;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da aresta com id do vertice de destino, origem e a distancia entre eles
     * @param source id do vertice de origem
     * @param destination id do vertice de destino
     * @param distance distancia do vertice origem ao vertice destino
     */
    public Edge( int source, int destination, double distance )
    {
        setSource( source );
        setDestination( destination );
        setDistance( distance );
    }
    
    // <------------------- 2.Getters methods ------------------->
    /**
     * Retorna o id do vertice de origem
     * @return id do vertice de origem
     */
    public int getSource()
    {
        return this.source;
    }
    
    /**
     * Retorna o id do vertice de destino
     * @return id do vertice de destino
     */
    public int getDestination()
    {
        return this.destination;
    }
    
    /**
     * Retorna a distancia (peso) entre o vertice de origem e destino
     * @return distancia (peso) entre o vertice de origem e destino
     */
    public double getDistance()
    {
        return this.distance;
    }
    
    // <------------------- 3.Setters methods ------------------->
    /**
     * Define a origem da aresta
     * @param source id do vertice de origem
     */
    public void setSource( int source )
    {
        if( source >= 0 )
            this.source = source;
        else this.source = -1;
    }
    
    /**
     * Define o destino da aresta
     * @param destination id do vertice de destino
     */
    public void setDestination( int destination )
    {
        if( destination >= 0 )
            this.destination = destination;
        else this.destination = -1;
    }
    
    /**
     * Define a distancia (peso) da aresta
     * @param distance distancia do vertice origem ao vertice destino
     */
    public void setDistance( double distance )
    {
        if( distance >= 0.0 )
            this.distance = distance;
        else this.distance = -1.0;
    }
    
    // <------------------- 4.Functional methods ------------------->
    /**
     * Compara se a a aresta this tem os mesmos extremos de source e destination
     * @param source id do vertice de origem
     * @param destination id do vertice de destino
     * @return true se extremos são iguais, false caso contrario
     */
    public boolean compare( int source, int destination )
    {
        return ( this.source == source && this.destination == destination ) ? true : false;
    }
    
    /**
     * Retorna representação em String da estrada representada por essa aresta
     * @return representação em String da aresta
     */
    @Override
    public String toString()
    {
        return "" + distance;
    }
}
