package edu.uft.tocantins.View;

import edu.uft.tocantins.Models.MyGraph;
import edu.uft.tocantins.Models.Vertex;
import edu.uft.tocantins.Models.DijkstraAlgorithm;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Definição de DijkstraForm
 * Formulário para achar o menor caminho entre duas cidades
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class DijkstraForm extends JFrame
{
    // <------------------- 0.Variables ------------------->
    private MyGraph myGraph;
    private DijkstraAlgorithm dijkstra;
    private List<Vertex> path;
    
    private DefaultTableModel pathTable;

    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da classe DijkstraForm
     */
    public DijkstraForm()
    {
        initComponents();
        this.setLocationRelativeTo( null );
        
        myGraph = MyGraph.getInstance();
        initializeTable();
        dijkstra = new DijkstraAlgorithm( myGraph );
        
        beginCombos();
    }

    // <------------------- 2. Utilities ------------------->
    /**
     * Inicializa tabela
     */
    private void initializeTable()
    {
        pathTable = new DefaultTableModel( new Object [][] {}, new String [] { "Cidade", "Distância" } ) 
        {
            Class[] types = new Class [] { java.lang.String.class, java.lang.Integer.class };
            boolean[] canEdit = new boolean [] { false, false };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        jTable1.setModel( pathTable );
    }
    
    /**
     * Inicializa e define os combos box
     */
    private void beginCombos()
    {
        jComboBox1.addItem( "Origem" );
        jComboBox2.addItem( "Destino" );
        
        for( int i = 0; i < myGraph.getVertexes().size(); i++ )
        {
            jComboBox1.addItem( myGraph.getVertex( i ).getCityName() );
            jComboBox2.addItem( myGraph.getVertex( i ).getCityName() );
        }
    }
    
    /**
     * 
     */
    private void calculatePath()
    {
        dijkstra.execute( myGraph.getVertex( jComboBox1.getSelectedIndex() - 1 ) );
        path = dijkstra.getPath( myGraph.getVertex( jComboBox2.getSelectedIndex() - 1 ) );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Calcular menor caminho (Algoritmo de Dijkstra)");

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cidade", "Distância"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);

        jLabel2.setText("Cidades por onde passar:");

        jButton2.setText("Desenhar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, 0, 171, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(62, 62, 62)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <------------------- 3. Events ------------------->
    /**
     * "Calcular" action performed
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Gerar tabela com caminhos do menor percurso
        initializeTable();
        calculatePath();
        
        int source = jComboBox1.getSelectedIndex() - 1;
        
        int sum = 0;
        pathTable.addRow( new Object [] { myGraph.getVertex( source ).getCityName(), 0 } );
        for( Vertex vertex : path )
        {
            if( vertex.getID() == source ) continue;
            
            pathTable.addRow( new Object [] { myGraph.getVertex( vertex.getID() ).getCityName(), myGraph.getEdge( source , vertex.getID() ).getDistance() } );
            
            sum += myGraph.getEdge( source , vertex.getID() ).getDistance();
            
            source = vertex.getID();
        }
        pathTable.addRow( new Object [] { "TOTAL", sum } );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Mostrando o grafo com percurso destacado
        if( path == null ) calculatePath();
        new GraphWindow( myGraph, path ).setVisible( true );
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
