
package bd_hanzibox;

import Entradas.Unidad_final;
import Entradas.Unidad_min;
import Interfaces.Implementacion_metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class completar_entradas extends javax.swing.JFrame {
    
    static private String entradaHanzi_completar;
    static private String entradaPinyin_completar;
    static private String entradaTraduccion_completar;
    static private String entradaEjemplo_completar;
    static private String entradaRadical_completar;
    static private String entradaRadical_2_completar;
    static private String entradaRadical_3_completar;
    static private String entradaRadical_4_completar;
    
    static private ArrayList<String> lista_aCompletar;
    static private Unidad_final entrada_final = new Unidad_final();

    /**
     * Creates new form completar_entradas
     */
    public completar_entradas() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Completar entradas");
        
        //  ----------------- BOTON COMPLETAR Y COMBOS -------------------------
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        busqueda_resultados_completar = new javax.swing.JTable();
        jButton_volver = new javax.swing.JButton();
        jLab_entrada_completar = new javax.swing.JLabel();
        jTextField_entrada_completar = new javax.swing.JTextField();
        jButton_cargar = new javax.swing.JButton();
        jLabel_radical_completar = new javax.swing.JLabel();
        jComboBox_radical_completar = new javax.swing.JComboBox<>();
        jComboBox_radical_3_completar = new javax.swing.JComboBox<>();
        jComboBox_radical_4_completar = new javax.swing.JComboBox<>();
        jLab_pinyin = new javax.swing.JLabel();
        jLab_traduccion = new javax.swing.JLabel();
        jLab_ejemplo = new javax.swing.JLabel();
        jTextField_pinyin_completar = new javax.swing.JTextField();
        jTextField_traduccion_completar = new javax.swing.JTextField();
        jTextField_ejemplo_completar = new javax.swing.JTextField();
        jComboBox_radical_2_completar = new javax.swing.JComboBox<>();
        jLabel_notificacion_completar = new javax.swing.JLabel();
        jButton_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        busqueda_resultados_completar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        busqueda_resultados_completar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Radical", "Hanzi", "Fonetica", "Traduccion", "Ejemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        busqueda_resultados_completar.setCellSelectionEnabled(true);
        busqueda_resultados_completar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busqueda_resultados_completarKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(busqueda_resultados_completar);

        jButton_volver.setText("Volver");
        jButton_volver.setToolTipText("Volver al inicio");
        jButton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_volverActionPerformed(evt);
            }
        });

        jLab_entrada_completar.setText("Entrada");

        jTextField_entrada_completar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_entrada_completarActionPerformed(evt);
            }
        });
        jTextField_entrada_completar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_entrada_completarKeyReleased(evt);
            }
        });

        jButton_cargar.setText("Cargar");
        jButton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cargarActionPerformed(evt);
            }
        });

        jLabel_radical_completar.setText("Radical");

        jComboBox_radical_completar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" })
        );
        jComboBox_radical_completar.setSelectedItem("");
        jComboBox_radical_completar.setEnabled(false);
        jComboBox_radical_completar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_radical_completarActionPerformed(evt);
            }
        });

        jComboBox_radical_3_completar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_3_completar.setSelectedItem("");
        jComboBox_radical_3_completar.setEnabled(false);

        jComboBox_radical_4_completar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_4_completar.setSelectedItem("");
        jComboBox_radical_4_completar.setEnabled(false);

        jLab_pinyin.setText("Pinyin");

        jLab_traduccion.setText("Traduccion");

        jLab_ejemplo.setText("Ejemplo");

        jComboBox_radical_2_completar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"", "一", "口", "人" }));
        jComboBox_radical_2_completar.setSelectedItem("");
        jComboBox_radical_2_completar.setEnabled(false);

        jButton_guardar.setText("Limpiar");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_notificacion_completar, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_volver)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLab_entrada_completar)
                                        .addGap(382, 382, 382))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLab_traduccion)
                                                    .addComponent(jLab_ejemplo)))
                                            .addComponent(jLabel_radical_completar, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLab_pinyin, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField_traduccion_completar, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_pinyin_completar, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBox_radical_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox_radical_2_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox_radical_3_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox_radical_4_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField_ejemplo_completar)
                                            .addComponent(jTextField_entrada_completar))
                                        .addGap(22, 22, 22)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_guardar)
                                    .addComponent(jButton_cargar))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_entrada_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLab_entrada_completar)
                    .addComponent(jButton_cargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_radical_completar)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_radical_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_radical_2_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_radical_3_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_radical_4_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_guardar))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_pinyin_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLab_pinyin))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_traduccion)
                    .addComponent(jTextField_traduccion_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLab_ejemplo)
                    .addComponent(jTextField_ejemplo_completar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_notificacion_completar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_volver)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busqueda_resultados_completarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busqueda_resultados_completarKeyPressed

    }//GEN-LAST:event_busqueda_resultados_completarKeyPressed

    //  VOLVER A MENU INICIAL
    private void jButton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_volverActionPerformed

        ventana_principal voler_menu = new ventana_principal();

        voler_menu.setVisible(true);

        dispose();

    }//GEN-LAST:event_jButton_volverActionPerformed

    //  NADA
    private void jTextField_entrada_completarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_entrada_completarActionPerformed

    }//GEN-LAST:event_jTextField_entrada_completarActionPerformed

    //  NADA
    private void jTextField_entrada_completarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_entrada_completarKeyReleased

        

    }//GEN-LAST:event_jTextField_entrada_completarKeyReleased
    
    //  IR PASANDO ENTRADAS PARA COMPLETAR
    private void jButton_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cargarActionPerformed
       
        //  ------------------- TABLA PRINCIPAL --------------------------------
        
        Implementacion_metodos aplicar = new Implementacion_metodos();

        //ArrayList<String> lista_aCompletar;

        lista_aCompletar = aplicar.buscarEntradaIncompleta();

        if (!lista_aCompletar.isEmpty()) {
           
            System.out.println("Bloque if ejecutado. Lista no está vacía.");
 
            jTextField_entrada_completar.setText(lista_aCompletar.get(0));

            aplicar.contarHanzi_introducidos(completar_entradas.this);

            //  --------------------------------------------------------------------

            /*
            todo este bloque es medio futil: antes de presionar el boton los campos
            siempre estaran en blanco!
            */
            entradaHanzi_completar = jTextField_entrada_completar.getText();

            entradaPinyin_completar = jTextField_pinyin_completar.getText();
            entradaTraduccion_completar = jTextField_traduccion_completar.getText();
            entradaEjemplo_completar = jTextField_ejemplo_completar.getText();
            
            //  -------------------------------------------------------------------
            
            if(entradaPinyin_completar.isBlank()){
                
                //System.out.println("entraria al condicional pinyin");
                
                jTextField_pinyin_completar.setText(aplicar.autocompletarCamposPinyin(this));
            
            }
            
            if(entradaTraduccion_completar.isBlank() || entradaTraduccion_completar.isEmpty()){
                
                jTextField_traduccion_completar.setText(aplicar.autocompletarCamposTraduccion(this));
                
            }
            
            if(entradaEjemplo_completar.isBlank() || entradaEjemplo_completar.isEmpty()){
                
                jTextField_ejemplo_completar.setText(aplicar.autocompletarCamposEjemplo(this));
                
            }
            //  ComboBox -----------------------------------------------------------

            entradaRadical_completar = jComboBox_radical_completar.getSelectedItem().toString();
            entradaRadical_2_completar = jComboBox_radical_2_completar.getSelectedItem().toString();
            entradaRadical_3_completar = jComboBox_radical_3_completar.getSelectedItem().toString();
            entradaRadical_4_completar = jComboBox_radical_4_completar.getSelectedItem().toString();

            //  evitamos valores en blanco  ----------------------------------------

            if (entradaRadical_completar.isBlank()) {
                entradaRadical_completar = "○";
            }

            if(entradaRadical_2_completar.isBlank()){
                entradaRadical_2_completar = "○";
            }

            if(entradaRadical_3_completar.isBlank()){
                entradaRadical_3_completar = "○";
            }

            if(entradaRadical_4_completar.isBlank()){
                entradaRadical_4_completar = "○";
            }

            //  --------------------------------------------------------------------

            int n_hanzi_entrada = entradaHanzi_completar.length();    // num de hanzi introducidos

            ArrayList<Unidad_min> conjunto_semantico = new ArrayList<>(); //  creamos un array con obj hanzi

            String[] piny_coleccion = new String[n_hanzi_entrada];    //  el tamano esta dado por el n de hanzi

            if (!entradaPinyin_completar.isBlank()) {       //  con y sin entrada de pinyin

                piny_coleccion = entradaPinyin_completar.split(" ");    //  individualizamos segun los espacios

            }else{

                for(int i=0; i<n_hanzi_entrada; i++ ){

                    piny_coleccion[i] = "...";
                   
                }
            }

            String [] h_coleccion = entradaHanzi_completar.split("");

            ArrayList <String> rad_coleccion = new ArrayList<>();
            rad_coleccion.add(entradaRadical_completar);
            rad_coleccion.add(entradaRadical_2_completar);
            rad_coleccion.add(entradaRadical_3_completar);
            rad_coleccion.add(entradaRadical_4_completar);

            String hanzi_iterado ="";

            //  set del obj  "Unidad_min" --------------------------------------

            for(int i=0; i<h_coleccion.length; i++){    //  iteramos tantas veces como hanzi tenga la entrada

                Unidad_min unidad_semantica = new Unidad_min(); //  instanciamos nuevo obj

                hanzi_iterado = h_coleccion[i];  // aux para rescatar el hanzi en la posicion actual

                unidad_semantica.setSimbolo(hanzi_iterado); //  el nuevo obj seteado para hanzi
                
                // Asegúrate de que el índice i sea válido antes de acceder al elemento
                if (i < rad_coleccion.size()) {
                    unidad_semantica.setRadical(rad_coleccion.get(i));
                } else {
                    // Manejo de error o mensaje de advertencia
                    System.out.println("Índice fuera de rango para rad_coleccion");
                    }

                unidad_semantica.setRadical(rad_coleccion.get(i));

                unidad_semantica.setPinyin(piny_coleccion[i]);

                unidad_semantica.setTraduccion(entradaTraduccion_completar);
                unidad_semantica.setEjemplo(entradaEjemplo_completar);

                conjunto_semantico.add(unidad_semantica);   //  almacenamos los obj seteados en un arraylist, que sera parametro para setear el obj final

            }

            //  --------------------------------------------------------------------
            //  usamos "Unidad_min" para setear "Unidad_final"  --------------------
            entrada_final = new Unidad_final();    //  instanciamos el obj final, la sintesis de la expresion

            // Unidad_final 
            
            entrada_final.setObj(conjunto_semantico);   // esta seria la entrada en su total, con cada hanzi, pinyin y radical

            entrada_final.setTraduccion(entradaTraduccion_completar);
            entrada_final.setEjemplo(entradaEjemplo_completar);

            
            aplicar.modificar(entrada_final);

            //  ------------------------ REPORTE -----------------------------------

            //jLabel_notificacion_completar.setText(entradaHanzi_completar + " modificado");
            
            
            //  ------------------- TABLA SECUNDARIA --------------------------------
        
            aplicar.modificarSingularidad(entrada_final);
            
            //  ------------------ MOSTRAR TABLA -----------------------------------
            
            aplicar.mostrarTablaCompletar(entradaHanzi_completar);
                    
            

        }else{
            
            jLabel_notificacion_completar.setText("La base de datos está totalmente completa");
            
        }
        
        jButton_cargar.setText("Completar");
        
        //jTextField_pinyin_completar.setText("");
        //jTextField_traduccion_completar.setText("");
        //jTextField_ejemplo_completar.setText("");
        
    }//GEN-LAST:event_jButton_cargarActionPerformed

    private void jComboBox_radical_completarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_radical_completarActionPerformed

    }//GEN-LAST:event_jComboBox_radical_completarActionPerformed

    //  LIMPIAR Y HABILITAR COMBOS
    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        
        jButton_cargar.setText("Cargar");
        
        jLabel_notificacion_completar.setText(entradaHanzi_completar + " modificado");
        
        jTextField_entrada_completar.setText("");
        jTextField_pinyin_completar.setText("");
        jTextField_traduccion_completar.setText("");
        jTextField_ejemplo_completar.setText("");
        
        jComboBox_radical_completar.setEnabled(false);
        jComboBox_radical_2_completar.setEnabled(false);
        jComboBox_radical_3_completar.setEnabled(false);
        jComboBox_radical_4_completar.setEnabled(false);
        
    }//GEN-LAST:event_jButton_guardarActionPerformed

    //  ------------------------------------------------------------------------
    
       
    //  ------------------------------------------------------------------------
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(completar_entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(completar_entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(completar_entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(completar_entradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new completar_entradas().setVisible(true);
            }
        });
    }
    
    
    
    
    
    
    
    
    //  ---------------------- GETTERS AND SETTERS -----------------------------
    
    
    public static String getEntradaHanzi_completar() {
        return entradaHanzi_completar;
    }

    public static void setEntradaHanzi_completar(String entradaHanzi_completar) {
        completar_entradas.entradaHanzi_completar = entradaHanzi_completar;
    }

    public static String getEntradaPinyin_completar() {
        return entradaPinyin_completar;
    }

    public static void setEntradaPinyin_completar(String entradaPinyin_completar) {
        completar_entradas.entradaPinyin_completar = entradaPinyin_completar;
    }

    public static String getEntradaTraduccion_completar() {
        return entradaTraduccion_completar;
    }

    public static void setEntradaTraduccion_completar(String entradaTraduccion_completar) {
        completar_entradas.entradaTraduccion_completar = entradaTraduccion_completar;
    }

    public static String getEntradaEjemplo_completar() {
        return entradaEjemplo_completar;
    }

    public static void setEntradaEjemplo_completar(String entradaEjemplo_completar) {
        completar_entradas.entradaEjemplo_completar = entradaEjemplo_completar;
    }

    public static String getEntradaRadical_completar() {
        return entradaRadical_completar;
    }

    public static void setEntradaRadical_completar(String entradaRadical_completar) {
        completar_entradas.entradaRadical_completar = entradaRadical_completar;
    }

    public static String getEntradaRadical_2_completar() {
        return entradaRadical_2_completar;
    }

    public static void setEntradaRadical_2_completar(String entradaRadical_2_completar) {
        completar_entradas.entradaRadical_2_completar = entradaRadical_2_completar;
    }

    public static String getEntradaRadical_3_completar() {
        return entradaRadical_3_completar;
    }

    public static void setEntradaRadical_3_completar(String entradaRadical_3_completar) {
        completar_entradas.entradaRadical_3_completar = entradaRadical_3_completar;
    }

    public static String getEntradaRadical_4_completar() {
        return entradaRadical_4_completar;
    }

    public static void setEntradaRadical_4_completar(String entradaRadical_4_completar) {
        completar_entradas.entradaRadical_4_completar = entradaRadical_4_completar;
    }

    public static JTable getBusqueda_resultados_completar() {
        return busqueda_resultados_completar;
    }

    public static void setBusqueda_resultados_completar(JTable busqueda_resultados_completar) {
        completar_entradas.busqueda_resultados_completar = busqueda_resultados_completar;
    }

    public JButton getjButton1() {
        return jButton_cargar;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton_cargar = jButton1;
    }

    public JButton getjButton_volver() {
        return jButton_volver;
    }

    public void setjButton_volver(JButton jButton_volver) {
        this.jButton_volver = jButton_volver;
    }

    public JComboBox<String> getjComboBox_radical_2_completar() {
        return jComboBox_radical_2_completar;
    }

    public void setjComboBox_radical_2_completar(JComboBox<String> jComboBox_radical_2_completar) {
        this.jComboBox_radical_2_completar = jComboBox_radical_2_completar;
    }

    public JComboBox<String> getjComboBox_radical_3_completar() {
        return jComboBox_radical_3_completar;
    }

    public void setjComboBox_radical_3_completar(JComboBox<String> jComboBox_radical_3_completar) {
        this.jComboBox_radical_3_completar = jComboBox_radical_3_completar;
    }

    public JComboBox<String> getjComboBox_radical_4_completar() {
        return jComboBox_radical_4_completar;
    }

    public void setjComboBox_radical_4_completar(JComboBox<String> jComboBox_radical_4_completar) {
        this.jComboBox_radical_4_completar = jComboBox_radical_4_completar;
    }

    public JComboBox<String> getjComboBox_radical_completar() {
        return jComboBox_radical_completar;
    }

    public void setjComboBox_radical_completar(JComboBox<String> jComboBox_radical_completar) {
        this.jComboBox_radical_completar = jComboBox_radical_completar;
    }

    public JLabel getjLab_ejemplo() {
        return jLab_ejemplo;
    }

    public void setjLab_ejemplo(JLabel jLab_ejemplo) {
        this.jLab_ejemplo = jLab_ejemplo;
    }

    public JLabel getjLab_entrada_completar() {
        return jLab_entrada_completar;
    }

    public void setjLab_entrada_completar(JLabel jLab_entrada_completar) {
        this.jLab_entrada_completar = jLab_entrada_completar;
    }

    public JLabel getjLab_pinyin() {
        return jLab_pinyin;
    }

    public void setjLab_pinyin(JLabel jLab_pinyin) {
        this.jLab_pinyin = jLab_pinyin;
    }

    public JLabel getjLab_traduccion() {
        return jLab_traduccion;
    }

    public void setjLab_traduccion(JLabel jLab_traduccion) {
        this.jLab_traduccion = jLab_traduccion;
    }

    public JLabel getjLabel_radical_completar() {
        return jLabel_radical_completar;
    }

    public void setjLabel_radical_completar(JLabel jLabel_radical_completar) {
        this.jLabel_radical_completar = jLabel_radical_completar;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextField getjTextField_ejemplo_completar() {
        return jTextField_ejemplo_completar;
    }

    public void setjTextField_ejemplo_completar(JTextField jTextField_ejemplo_completar) {
        this.jTextField_ejemplo_completar = jTextField_ejemplo_completar;
    }

    public JTextField getjTextField_entrada_completar() {
        return jTextField_entrada_completar;
    }

    public void setjTextField_entrada_completar(JTextField jTextField_entrada_completar) {
        this.jTextField_entrada_completar = jTextField_entrada_completar;
    }

    public JTextField getjTextField_pinyin_completar() {
        return jTextField_pinyin_completar;
    }

    public void setjTextField_pinyin_completar(JTextField jTextField_pinyin_completar) {
        this.jTextField_pinyin_completar = jTextField_pinyin_completar;
    }

    public JTextField getjTextField_traduccion_completar() {
        return jTextField_traduccion_completar;
    }

    
    public void setjTextField_traduccion_completar(JTextField jTextField_traduccion_completar) {
        this.jTextField_traduccion_completar = jTextField_traduccion_completar;
    }    
    
    
    //  ---------------------- GETTERS AND SETTERS -----------------------------
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable busqueda_resultados_completar;
    private javax.swing.JButton jButton_cargar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_volver;
    public javax.swing.JComboBox<String> jComboBox_radical_2_completar;
    public javax.swing.JComboBox<String> jComboBox_radical_3_completar;
    public javax.swing.JComboBox<String> jComboBox_radical_4_completar;
    public javax.swing.JComboBox<String> jComboBox_radical_completar;
    private javax.swing.JLabel jLab_ejemplo;
    private javax.swing.JLabel jLab_entrada_completar;
    private javax.swing.JLabel jLab_pinyin;
    private javax.swing.JLabel jLab_traduccion;
    private javax.swing.JLabel jLabel_notificacion_completar;
    private javax.swing.JLabel jLabel_radical_completar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_ejemplo_completar;
    private javax.swing.JTextField jTextField_entrada_completar;
    private javax.swing.JTextField jTextField_pinyin_completar;
    private javax.swing.JTextField jTextField_traduccion_completar;
    // End of variables declaration//GEN-END:variables
}
