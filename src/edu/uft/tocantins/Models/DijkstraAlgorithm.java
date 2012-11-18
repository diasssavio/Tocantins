package edu.uft.tocantins.Models;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Definição da classe DijkstraAlgorithm
 * Classe que faz a manipulação do algoritmo de dijkstra sobre um grafo
 * @author Savio Dias
 */
public class DijkstraAlgorithm
{
    // <------------------- 0.Variables ------------------->
    private final List<Vertex> vertexes;
    private final List<Edge> edges;
    private Set<Vertex> settledVertexes;
    private Set<Vertex> unSettledVertexes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * 
     * @param myGraph 
     */
    public DijkstraAlgorithm( MyGraph myGraph )
    {
        this.vertexes = new ArrayList<Vertex>( myGraph.getVertexes() );
        this.edges = new ArrayList<Edge>( myGraph.getEdges() );
    }
    
    // <------------------- 2.Functional methods ------------------->
    /**
     * 
     * @param source 
     */
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
            if( edge.getSource() == source.getID() && edge.getDestination() == destination.getID() )
                return edge.getDistance();
        
        throw new RuntimeException( "Aresta não existente" );
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
    private int getShortestDistance( Vertex destination )
    {
        Integer shortest = distance.get( destination );
        if( shortest == null )
            return Integer.MAX_VALUE;
        else return shortest;
    }
    
    /**
     * 
     * @param destination
     * @return 
     */
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
