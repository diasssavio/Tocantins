package edu.uft.tocantins.Models;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Definição da classe DijkstraAlgorithm
 * Classe que faz a manipulação do algoritmo de dijkstra sobre um grafo
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 */
public class DijkstraAlgorithmImproved extends DijkstraAlgorithm
{
    // <------------------- 0.Variables ------------------->
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da classe DijkstraAlgorithm
     * @param myGraph Grafo a ser utilizado o algoritmo
     */
    public DijkstraAlgorithmImproved( MyGraph myGraph )
    {
        super( myGraph );
    }
    
    // <------------------- 2.Functional methods ------------------->
    /**
     * Calcula os caminhos para todos os vertices a partir de source
     * @param source vertice de origem
     */
    @Override
    public void execute( Vertex source )
    {   
        settledVertexes = new HashSet<Vertex>();
        unSettledVertexes = new HashSet<Vertex>();
        distance = new HashMap<Vertex, Integer>();
        predecessors = new HashMap<Vertex, Vertex>();
        
        distance.put( source, 0 );
        unSettledVertexes.add( source );
        while( unSettledVertexes.size() > 0 )
        {
            Vertex vertex = getMinimum( unSettledVertexes );
            settledVertexes.add( vertex );
            unSettledVertexes.remove( vertex );
            findMinimalDistances( vertex );
        }
    }
    
    /**
     * 
     * @param vertex 
     */
    private void findMinimalDistances( Vertex vertex )
    {
        List<Vertex> adjacentVertexes = getNeighbors( vertex );
        for( Vertex target : adjacentVertexes )
            if( getShortestDistance( target ) > getShortestDistance( vertex ) + getDistance( vertex, target ) )
            {
                distance.put( target, getShortestDistance( vertex ) + getDistance( vertex, target ) );
                predecessors.put( target, vertex );
                unSettledVertexes.add( target );
            }
    }
    
    /**
     * 
     * @param source
     * @param destination
     * @return 
     */
    private int getDistance( Vertex source, Vertex destination  )
    {
        for( Edge edge : edges )
            if( edge.getSource() == source.getID() && edge.getDestination() == destination.getID() && edge.getAsfalt() )
                return edge.getDistance();
        
        return Integer.MAX_VALUE;
    }
    
    
    /**
     * 
     * @param destination
     * @return 
     */
    private int getShortestDistance( Vertex destination )
    {
        Integer shortest = distance.get( destination );
        if( shortest == null )
            return Integer.MAX_VALUE;
        else return shortest;
    }
    
    /**
     * 
     * @param vertex
     * @return 
     */
    private List<Vertex> getNeighbors( Vertex vertex )
    {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for( Edge edge : edges )
            if( edge.getSource() == vertex.getID() && !isSettled( vertexes.get( edge.getDestination() ) ) )
                neighbors.add( vertexes.get( edge.getDestination() ) );
        
        return neighbors;
    }
    
    /**
     * 
     * @param vertex
     * @return 
     */
    private boolean isSettled( Vertex vertex )
    {
        return settledVertexes.contains( vertex );
    }
    
    /**
     * 
     * @param vertexes
     * @return 
     */
    private Vertex getMinimum( Set<Vertex> vertexes )
    {
        Vertex minimum = null;
        for( Vertex vertex : vertexes )
            if( minimum == null )
                minimum = vertex;
            else if ( getShortestDistance( vertex ) < getShortestDistance( minimum ) )
                minimum = vertex;
        
        return minimum;
    }
    
    /**
     * 
     * @param destination
     * @return 
     */
    @Override
    public LinkedList<Vertex> getPath( Vertex destination )
    {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = destination;
        
        if( predecessors.get( step ) == null ) return null;
        
        path.add( step );
        while( predecessors.get( step ) != null )
        {
            step = predecessors.get( step );
            path.add( step );
        }
        Collections.reverse( path );
        
        return path;
     }
}
