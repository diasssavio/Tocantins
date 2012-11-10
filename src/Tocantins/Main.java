package Tocantins;

import com.mxgraph.view.mxGraph;
import com.mxgraph.swing.mxGraphComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Definição da classe Main
 * Realiza o processamento do grafo e os exibe na tela
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class Main extends JFrame
{
    // <------------------- 0.Variables ------------------->
    // Screen size
    private final int width = 1024;
    private final int height = 768;
    
    // Graph in memory
    private MyGraph myGraph;
    
    // Graph showing components
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    
    // Hash to do the maping between inserted vertex and it edges
    private HashMap<Integer, Object> hash;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da classe Main
     */
    private Main()
    {
        frameSettings();
        
        myGraph = new MyGraph();
        readDataBase();
        
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
        graph.setCellsDisconnectable( false );  // Disconnect edges and vertex
        graph.setCellsEditable( false );        // Want to edit the value of a cell in the graph?
        graph.setCellsMovable( true );          // Moving cells in the graph. Note that an edge is also a cell.
        graph.setCellsResizable( false );       // Inhibit cell re-sizing.
        graph.setCellsSelectable( true );       // Now I can't even select the cells!!!
        graph.setEnabled( true );               // Catch-All: no interaction with the graph.
        graphComponent.setConnectable( false ); // Inhibit edge creation in the graph.
    }
    
    // <------------------- 3.Read and Transfer Data ------------------->
    /**
     * Realiza leitura das tabelas do banco de dados e os armazena em myGraph
     */
    private void readDataBase()
    {
        try
        {
            DBManager dataBase = DBManager.getInstance();
            
            // Adding vertexes (cities)
            ResultSet search = dataBase.getResultSet( "SELECT * FROM cidades" );
            while( search.next() )
                myGraph.addVertex( search.getString( "Nome" ) , search.getInt( "Populacao" ) );
            
            search.close();
            search = null;
            
            // Adding edges (estradas)
            search = dataBase.getResultSet( "SELECT * FROM conexoes" );
            while( search.next() )
                myGraph.addEdge( search.getInt( "idConexoes" ) - 1 , search.getInt( "Cidade" ) - 1, search.getDouble( "Distancia" ) );
            
            search.close();
        } catch (SQLException exception)
        {
            JOptionPane.showMessageDialog( null, exception.getMessage() );
        }
    }
    
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
    
    // <------------------- 5.Main ------------------->
    /**
     * Função principal, chamada pelo processador
     * @param args argumentos de linha de comando
     */
    public static void main( String args[] )
    {
        new Main().setVisible( true );
    }
}
