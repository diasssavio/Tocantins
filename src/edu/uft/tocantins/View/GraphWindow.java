package edu.uft.tocantins.View;

import edu.uft.tocantins.Models.MyGraph;
import com.mxgraph.view.mxGraph;
import com.mxgraph.swing.mxGraphComponent;
import javax.swing.JFrame;
import java.util.HashMap;
import java.util.Random;

/**
 * Definição da classe GraphWindow
 * Realiza o processamento do grafo e os exibe na tela
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class GraphWindow extends JFrame
{
    // <------------------- 0.Variables ------------------->
    // Screen size
    private final int width = 4000;
    private final int height = 4000;
    
    // Graph in memory
    private MyGraph myGraph;
    
    // Graph showing components
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    
    // Hash to do the maping between inserted vertex and it edges
    private HashMap<Integer, Object> hash;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da classe GraphWindow
     */
    public GraphWindow()
    {
        frameSettings();
        
        myGraph = MyGraph.getInstance();
        
        graph = new mxGraph();
        toMxGraph();
        
        graphComponent = new mxGraphComponent( graph );
        getContentPane().add( graphComponent );
        
        graphSettings();
    }
    
    // <------------------- 2.Settings ------------------->
    /**
     * Função que define as configurações da janela
     */
    private void frameSettings()
    {
        this.setTitle( "Grafo das cidades do Tocantins" );
        this.setAlwaysOnTop( true );
        this.setSize( width, height );
        this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        this.setLocationRelativeTo( null );
    }
    
    /**
     * Função que define as configurações de visualização do grafo
     */
    private void graphSettings()
    {
        graph.setSplitEnabled( false );         // Split cells enabled?
        graph.setCellsDisconnectable( false );  // Disconnect edges and vertexes?
        graph.setCellsEditable( false );        // Want to edit the value of a cell in the graph?
        graph.setCellsMovable( true );          // Moving cells in the graph. Note that an edge is also a cell.
        graph.setCellsResizable( false );       // Inhibit cell re-sizing.
        graph.setCellsSelectable( true );       // Now I can't even select the cells!!!
        graph.setEnabled( true );               // Catch-All: no interaction with the graph.
        graphComponent.setConnectable( false ); // Inhibit edge creation in the graph.
    }
    
    // <------------------- 3.Read and Transfer Data ------------------->
    /**
     * Transfere os dados (vertices, arestas) de myGraph para graph para visualização na tela
     */
    private void toMxGraph()
    {
        Object defaultParent;
        Object reference;
        hash = new HashMap<Integer, Object>();
        
        graph.getModel().beginUpdate();
        
        // Adding vertexes here
        for( int i = 0; i < myGraph.getVertexes().size(); i++ )
        {
            defaultParent = graph.getDefaultParent();
            reference = graph.insertVertex( defaultParent, null, myGraph.getVertex( i ).getCityName(), generateRandomNumber( width ), generateRandomNumber( height ), 20, 20 );
            hash.put( i, reference );
        }
        
        // Adding edges here
        for( int i = 0; i < myGraph.getEdges().size(); i++ )
        {
            defaultParent = graph.getDefaultParent();
            graph.insertEdge( defaultParent, null, myGraph.getEdge( i ), hash.get( myGraph.getEdge( i ).getSource() ), hash.get( myGraph.getEdge( i ).getDestination() ) );
        }
        
        graph.getModel().endUpdate();
    }
    
    // <------------------- 4. Utilities ------------------->
    /**
     * Gera numero aleatório de 0-limit
     * @param limit número limite para geração
     * @return numero gerado
     */
    private int generateRandomNumber( int limit )
    {
        return new Random().nextInt( limit );
    }
}
