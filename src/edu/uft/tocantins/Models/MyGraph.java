package edu.uft.tocantins.Models;

import java.util.ArrayList;

/**
 * Definição da classe MyGraph
 * Realiza a representação do grafo (estado)
 * @author @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class MyGraph extends Object
{
    // <------------------- 0.Variables ------------------->
    private ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private double[][] adjacencyMatrix;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor vazio, inicializa o grafo para novas operações
     */
    public MyGraph()
    {
        vertexes.clear();
        edges.clear();
    }
    
    // <------------------- 2.Getters methods ------------------->
    /**
     * Retorna os vertices do grafo
     * @return vertices do grafo
     */
    public ArrayList<Vertex> getVertexes()
    {
        return this.vertexes;
    }
    
    /**
     * Retorna vertice do vetor de vertices no indice index
     * @param index indice do vertice no vetor de vertice
     * @return vertice no indice index
     */
    public Vertex getVertex( int index )
    {
        return this.vertexes.get( index );
    }
    
    /**
     * Retorna as arestas do grafo
     * @return arestas do grafo
     */
    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }
    
    /**
     * Retorna aresta do vetor de arestas no indice index
     * @param index indice da aresta no vetor de arestas
     * @return aresta no indice index
     */
    public Edge getEdge( int index )
    {
        return this.edges.get( index );
    }
    
    /**
     * Retorna aresta de origem source e destino destination, caso exista
     * @param source id do vertice de origem
     * @param destination id do vertice de destino
     * @return aresta entre os dois vertices
     */
    public Edge getEdge( int source, int destination )
    {
        if( hasEdge( source, destination ) )
        {
            for( int i = 0; i < edges.size(); i++ )
            {
                if( edges.get( i ).compare( source, destination ) )
                    return edges.get( i );
            }
        }
        return null;
    }
    
    // <------------------- 3.Functional methods ------------------->
    /**
     * Adiciona um vertice ao grafo (cidade)
     * @param cityName nome da cidade a ser definida pelo vertice
     * @param population população da cidade representada pelo vertice
     * @return true se adicionou vertice com sucesso, false caso contrario
     */
    public boolean addVertex( String cityName, int population )
    {
        return ( vertexes.add( new Vertex( cityName, population ) ) ) ? true : false;
    }
    
    /**
     * Adiciona uma aresta ao grafo (estrada)
     * @param source id do vertice de origem
     * @param destination id do vertice de destino
     * @param distance distancia do vertice origem ao vertice destino
     * @return true se adicionou aresta com sucesso, false caso contrario
     */
    public boolean addEdge( int source, int destination, double distance )
    {
        if( hasVertex( source ) && hasVertex( destination ) )
            return ( edges.add( new Edge( source, destination, distance ) ) ) ? true : false;
        else return false;
    }
    
    /**
     * Cria matriz de adjacencia do grafo
     */
    public void makeMatrix()
    {
        allocateMatrix();
        
        for( int i = 0; i < vertexes.size(); i++ )
        {
            for( int j = 0; j < vertexes.size(); j++ )
            {
                if( i == j )
                    adjacencyMatrix[i][j] = vertexes.get( i ).getPopulation();
                else if( hasEdge( i, j ) )
                    adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = getEdge( i, j ).getDistance();
                else adjacencyMatrix[i][j] = adjacencyMatrix[j][i] = 0.0;
            }
        }
    }
    
    /**
     * Aloca matriz de adjacencia do grafo
     */
    public void allocateMatrix()
    {
        adjacencyMatrix = new double[ vertexes.size() ][ vertexes.size() ];
    }
    
    /**
     * Verifica se existe aresta entre os vertices de id source e destination
     * @param source id do vertice de origem
     * @param destination id do vertice de destino
     * @return true se existe a aresta entre os vertices, false caso contrario
     */
    public boolean hasEdge( int source, int destination )
    {
        for( int i = 0; i < edges.size(); i++ )
            if( edges.get( i ).compare( source, destination ) )
                return true;
        
        return false;
    }
    private boolean hasVertex( int id )
    {
        for( int i = 0; i < vertexes.size(); i++ )
            if( vertexes.get( i ).getID() == id)
                return true;
        return false;
    }
}
