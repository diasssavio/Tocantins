package Windows;

import Tocantins.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Definição de RoadsForm
 * formulário para adicionar estradas (arestas)
 * @author <a href="mailto:wolfdragon2@gmail.com">Sávio S. Dias</a>
 * @version 1.0
 */
public class RoadsForm extends JFrame 
{
    // <------------------- 0.Variables ------------------->
    private DBManager dbManager;
    private ResultSet resultSet;
    private DefaultTableModel edgesTable;
    
    // <------------------- 1.Constructors ------------------->
    /**
     * Construtor da classe RoadsForm
     * @throws SQLException 
     */
    public RoadsForm() throws SQLException
    {
        initComponents();
        setLocationRelativeTo( null );
        
        dbManager = DBManager.getInstance();
        edgesTable = new DefaultTableModel();
        
        beginTable();
        beginCombos();
        
    }
    
    // <------------------- 2. Utilities ------------------->
    /**
     * Inicializa tabela
     */
    private void initializeTable()
    {
        edgesTable = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Origem", "Destino", "Distancia", "Sem Asfalto"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
        jTable1.setModel( edgesTable );
    }
    
    /**
     * Define valores à tabela de arestas
     * @throws SQLException 
     */
    private void beginTable() throws SQLException
    {
        resultSet = dbManager.getResultSet( "SELECT * FROM conexoes" );
        // Needs to add the last column name
        while( resultSet.next() )
            edgesTable.addRow( new Object[] { resultSet.getString( "idConexoes" ), resultSet.getString( "Cidade" ), resultSet.getDouble( "Distancia" ), resultSet.getBoolean( "Sem_Asfalto" ) } );
        
        resultSet.close();
        resultSet = null;
    }
    
    /**
     * Inicializa e define os combos box
     * @throws SQLException 
     */
    private void beginCombos() throws SQLException
    {
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        
        resultSet = dbManager.getResultSet( "SELECT * FROM cidades" );
        while( resultSet.next() ){
            jComboBox1.addItem( resultSet.getInt( "idCidades" ) );
            jComboBox2.addItem( resultSet.getInt( "idCidades" ) );
        }
        
        resultSet.close();
        resultSet = null;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Aresta");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Origem:");

        jLabel2.setText("Fim:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origem", "Destino", "Distancia", "Sem Asfalto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jLabel3.setText("Adicionar Aresta");

        jLabel4.setText("Distancia:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Sim");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Não");

        jLabel5.setText("Asfalto");

        jLabel6.setText("ARESTAS");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addGap(43, 43, 43))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <------------------- 3. Events ------------------->
    /**
     * Ação do clique no botão "Salvar"
     * @param evt evento
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Adding new edge on the bench
        try{
            dbManager.execute( "INSERT INTO conexoes(idConexoes, Cidade, Distancia, Sem_Asfalto)"
                    + " VALUES(" + jComboBox1.getSelectedItem() + ", " + jComboBox2.getSelectedItem() 
                    + ", " + jTextField1.getText() + ", " + ( ( jRadioButton1.isSelected() ) ? 0 : 1 ) + ")" );
            
            dbManager.execute( "INSERT INTO conexoes(idConexoes, Cidade, Distancia, Sem_Asfalto)"
                    + " VALUES(" + jComboBox2.getSelectedItem() + ", " + jComboBox1.getSelectedItem()
                    + ", " + jTextField1.getText() + ", " + ( ( jRadioButton1.isSelected() ) ? 0 : 1 ) + ")" );
            
            // Cleaning GUI form options
            jComboBox1.setSelectedIndex( 0 );
            jComboBox2.setSelectedIndex( 0 );
            jTextField1.setText( null );
            buttonGroup1.clearSelection();
            
            // Updating edgesTable
            initializeTable();
            beginTable();
        }
        catch ( SQLException exception )
        {
            JOptionPane.showMessageDialog( null, exception.getMessage() );
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
