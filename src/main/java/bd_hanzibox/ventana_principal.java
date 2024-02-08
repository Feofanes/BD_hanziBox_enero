
package bd_hanzibox;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
import Interfaces.Implementacion_metodos;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ventana_principal extends javax.swing.JFrame {
    
    // tienen que ser static para poder set capturados desde implementacion_metodos
        static private String entradaHanzi;
        static private String entradaPinyin;
        static private String entradaTraduccion;
        static private String entradaEjemplo;
        static private String entradaRadical;
        static private String entradaRadical_2;
        static private String entradaRadical_3;
        static private String entradaRadical_4;
        static private String parametro_busqueda;
        
        static private ArrayList <Unidad_min> conjunto_semantico = new ArrayList <>(); //  creamos un array con obj hanzi
        
        
        static private StringBuilder total_radicales;
        
        static private int contador_han = 0;
        
        static private ArrayList hanzi_individual;
        
        
        static private String msj_advertencia;
        
        static private int n_hanzi_introducidos;
        
        private int n_input;
        
        private int n_hanzi_unicos;
        
        
    //  CONSTRUCTOR
    public ventana_principal() {
        
        panel_ventana miPanel = new panel_ventana(this);
        
        setContentPane(miPanel);
        
        miPanel.setVisible(true);

        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("HanziBox");
        
        Implementacion_metodos aplicar = new Implementacion_metodos();
        
        //  contadores ---------------------------------------------------------
        
        n_input = aplicar.contarInput();
        
        n_hanzi_unicos = aplicar.contarHanziUnicos();
        
        jLabel_contador_entradas.setText("Palabras/expresiones: " + n_input );
        
        jLabel_contador_entradas_unicas.setText("Hanzis: " + n_hanzi_unicos);
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    // --------------------------- METODOS -------------------------------------
    // -------------------------------------------------------------------------
    
    public void limpiar_campos(){
        
        jTextField_entrada.setText("");
        jTextField_pinyin.setText("");
        jTextField_traduccion.setText("");
        jTextField_ejemplo.setText("");
        jComboBox_radical.setSelectedItem("");
        jComboBox_radical_2.setSelectedItem("");
        jComboBox_radical_3.setSelectedItem("");
        jComboBox_radical_4.setSelectedItem("");
        //jLabel_tareaEjecutada.setText("");
        //jLabel_tareaEjecutada_2.setText("");
        
        //  queda pendiente limpiar el comboBox
        
        
    }  
    
    public void autocompletarCombo(JComboBox combo, int posicion_array){
        
        //  AUTOCOMPLETAR ------------------------------------------
        
        if (combo.isEnabled()) {

            Implementacion_metodos aplicar_metodo = new Implementacion_metodos();
            
            // CAPTURA DE ENTRADAS  --------------------------------------------
            entradaHanzi = jTextField_entrada.getText(); // capturamos la entrada en un string

            Unidad_min entrada = new Unidad_min();    //  instanciamos el obj final, la sintesis de la expresion 

            int n_hanzi = entradaHanzi.length();

            String[] deglosando_hanzi = new String[n_hanzi];    // almacenamos los hanzi individuales

            // RECUPERAMOS EL HANZI ESPECIFICO SEGUN POSICION ------------------
            deglosando_hanzi = entradaHanzi.split("");  // individualizamos los hanzi ingresados

            String captura_hanzi_ind = deglosando_hanzi[posicion_array]; // es 1 y no dos porque arranca en 0 el array

            entrada.setSimbolo(captura_hanzi_ind);

            String autocompletado = aplicar_metodo.autocompletarRadicales(entrada);

            combo.setSelectedItem(autocompletado);

        }


    }
    
    public void abrirProcesadorTexto(){
        
        procesador_texto nueva_ventana = new procesador_texto();
        
        nueva_ventana.setVisible(true);
        
        
    }
    
    public void abrirCompletarEntradas(){
        
        completar_entradas ventana_completar = new completar_entradas();
        
        ventana_completar.setVisible(true);
        
    }
    
    public void abrirVisualizador(){
        
        full_screen ventana_visualizador = new full_screen();
        
        ventana_visualizador.setVisible(true);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton4 = new javax.swing.JButton();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLab_entrada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLab_pinyin = new javax.swing.JLabel();
        jLab_traduccion = new javax.swing.JLabel();
        jTextField_entrada = new javax.swing.JTextField();
        jTextField_pinyin = new javax.swing.JTextField();
        jTextField_traduccion = new javax.swing.JTextField();
        jLab_ejemplo = new javax.swing.JLabel();
        jTextField_ejemplo = new javax.swing.JTextField();
        jComboBox_radical = new javax.swing.JComboBox<>();
        jButton_agregar = new javax.swing.JButton();
        jButton_borrar = new javax.swing.JButton();
        jButton_modificar = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        busqueda_resultados = new javax.swing.JTable();
        jLabel_contador_entradas = new javax.swing.JLabel();
        jComboBox_radical_2 = new javax.swing.JComboBox<>();
        jComboBox_radical_3 = new javax.swing.JComboBox<>();
        jComboBox_radical_4 = new javax.swing.JComboBox<>();
        jLabel_contador_entradas_unicas = new javax.swing.JLabel();
        jLabel_tareaEjecutada = new javax.swing.JLabel();
        jLabel_tareaEjecutada_2 = new javax.swing.JLabel();
        jLabel_tareaEjecutada_3 = new javax.swing.JLabel();
        jLabel_intermedio = new javax.swing.JLabel();
        jLabel_principiante = new javax.swing.JLabel();
        jLabel_avanzado = new javax.swing.JLabel();
        jMenuBar_barraSup = new javax.swing.JMenuBar();

        jTextField3.setText("jTextField1");

        jButton4.setText("Modificar");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLab_entrada.setText("Entrada");

        jLabel2.setText("Radical");

        jLab_pinyin.setText("Pinyin");

        jLab_traduccion.setText("Traduccion");

        jTextField_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_entradaActionPerformed(evt);
            }
        });
        jTextField_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_entradaKeyReleased(evt);
            }
        });

        jLab_ejemplo.setText("Ejemplo");

        jComboBox_radical.setModel(new DefaultComboBoxModel(new String[] {"", "人", "口", "土", "女", "心", "手", "日", "月", "木", "氵", "火", "纟", "艹", "讠", "辶", "钅", "刂", "宀", "贝", "一", "力", "又", "犭", "禾", "⺮", "虫", "阜", "大", "广", "田", "目", "石", "衤", "足", "马", "页", "巾", "米", "车", "八", "尸", "寸", "山", "攵", "彳", "十", "工", "方", "门", "饣", "欠", "儿", "冫", "子", "疒", "隹", "斤", "亠", "王", "白", "立", "羊", "艮", "冖", "厂", "皿", "礻", "穴", "走", "雨", "囗", "小", "戈", "几", "舌", "干", "殳", "夕", "止", "牜", "皮", "耳", "辛", "阝", "酉", "青", "鸟", "弓", "厶", "户", "羽", "舟", "里", "匕", "夂", "见", "卩", "罒", "士", "勹"})
        );
        //jComboBox1.setRenderer(new CustomTableCellRenderer());
        jComboBox_radical.setSelectedItem("");
        jComboBox_radical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_radicalActionPerformed(evt);
            }
        });

        jButton_agregar.setText("Agregar");
        jButton_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarActionPerformed(evt);
            }
        });

        jButton_borrar.setText("Borrar");
        jButton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrarActionPerformed(evt);
            }
        });

        jButton_modificar.setText("Modificar");
        jButton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificarActionPerformed(evt);
            }
        });

        jButton_buscar.setText("Buscar");
        jButton_buscar.setToolTipText("Si no hay parámetro de búsqueda se mostrará toda la base de datos");
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        busqueda_resultados.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        busqueda_resultados.setModel(new javax.swing.table.DefaultTableModel(
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
        busqueda_resultados.setCellSelectionEnabled(true);
        busqueda_resultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                busqueda_resultadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(busqueda_resultados);

        jLabel_contador_entradas.setText("Palabras/expresiones:");

        jComboBox_radical_2.setModel(new DefaultComboBoxModel(new String[] {"", "人", "口", "土", "女", "心", "手", "日", "月", "木", "氵", "火", "纟", "艹", "讠", "辶", "钅", "刂", "宀", "贝", "一", "力", "又", "犭", "禾", "⺮", "虫", "阜", "大", "广", "田", "目", "石", "衤", "足", "马", "页", "巾", "米", "车", "八", "尸", "寸", "山", "攵", "彳", "十", "工", "方", "门", "饣", "欠", "儿", "冫", "子", "疒", "隹", "斤", "亠", "王", "白", "立", "羊", "艮", "冖", "厂", "皿", "礻", "穴", "走", "雨", "囗", "小", "戈", "几", "舌", "干", "殳", "夕", "止", "牜", "皮", "耳", "辛", "阝", "酉", "青", "鸟", "弓", "厶", "户", "羽", "舟", "里", "匕", "夂", "见", "卩", "罒", "士", "勹"}));
        jComboBox_radical_2.setSelectedItem("");
        jComboBox_radical_2.setEnabled(false);
        jComboBox_radical_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_radical_2ItemStateChanged(evt);
            }
        });
        jComboBox_radical_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox_radical_2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox_radical_2FocusLost(evt);
            }
        });
        jComboBox_radical_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_radical_2ActionPerformed(evt);
            }
        });
        jComboBox_radical_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox_radical_2KeyReleased(evt);
            }
        });

        jComboBox_radical_3.setModel(new DefaultComboBoxModel(new String[] {"", "人", "口", "土", "女", "心", "手", "日", "月", "木", "氵", "火", "纟", "艹", "讠", "辶", "钅", "刂", "宀", "贝", "一", "力", "又", "犭", "禾", "⺮", "虫", "阜", "大", "广", "田", "目", "石", "衤", "足", "马", "页", "巾", "米", "车", "八", "尸", "寸", "山", "攵", "彳", "十", "工", "方", "门", "饣", "欠", "儿", "冫", "子", "疒", "隹", "斤", "亠", "王", "白", "立", "羊", "艮", "冖", "厂", "皿", "礻", "穴", "走", "雨", "囗", "小", "戈", "几", "舌", "干", "殳", "夕", "止", "牜", "皮", "耳", "辛", "阝", "酉", "青", "鸟", "弓", "厶", "户", "羽", "舟", "里", "匕", "夂", "见", "卩", "罒", "士", "勹"}));
        jComboBox_radical_3.setSelectedItem("");
        jComboBox_radical_3.setEnabled(false);

        jComboBox_radical_4.setModel(new DefaultComboBoxModel(new String[] {"", "人", "口", "土", "女", "心", "手", "日", "月", "木", "氵", "火", "纟", "艹", "讠", "辶", "钅", "刂", "宀", "贝", "一", "力", "又", "犭", "禾", "⺮", "虫", "阜", "大", "广", "田", "目", "石", "衤", "足", "马", "页", "巾", "米", "车", "八", "尸", "寸", "山", "攵", "彳", "十", "工", "方", "门", "饣", "欠", "儿", "冫", "子", "疒", "隹", "斤", "亠", "王", "白", "立", "羊", "艮", "冖", "厂", "皿", "礻", "穴", "走", "雨", "囗", "小", "戈", "几", "舌", "干", "殳", "夕", "止", "牜", "皮", "耳", "辛", "阝", "酉", "青", "鸟", "弓", "厶", "户", "羽", "舟", "里", "匕", "夂", "见", "卩", "罒", "士", "勹"}));
        jComboBox_radical_4.setSelectedItem("");
        jComboBox_radical_4.setEnabled(false);

        jLabel_contador_entradas_unicas.setText("Hanzis:");

        jLabel_tareaEjecutada.setText("<html>Tareas ejecutada:<br></html>");

        jLabel_intermedio.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/nivel_1.png")); // NOI18N
        jLabel_intermedio.setToolTipText("Nivel principiante");

        jLabel_principiante.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/nivel_1.png")); // NOI18N
        jLabel_principiante.setToolTipText("Nivel principiante");

        jLabel_avanzado.setIcon(new javax.swing.ImageIcon("/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/iconos/nivel_1.png")); // NOI18N
        jLabel_avanzado.setToolTipText("Nivel principiante");

        setJMenuBar(jMenuBar_barraSup);
        jMenuItem_visualizador = new javax.swing.JMenuItem();
        jMenuItem_visualizador.setIcon(new ImageIcon(ventana_principal.class.getResource("/bd_hanzibox/iconos/lectura.png")));
        jMenuBar_barraSup.add(jMenuItem_visualizador);
        
                jMenuItem_visualizador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
                jMenuItem_visualizador.setToolTipText("Visualizador de las entradas guardadas en ventana completa");
                jMenuItem_visualizador.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem_visualizadorActionPerformed(evt);
                    }
                });
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem2.setIcon(new ImageIcon(ventana_principal.class.getResource("/bd_hanzibox/iconos/completar.png")));
        jMenuBar_barraSup.add(jMenuItem2);
        
                jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
                jMenuItem2.setToolTipText("Completar información faltante entrada por entrada");
                jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem2ActionPerformed(evt);
                    }
                });
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem3.setIcon(new ImageIcon(ventana_principal.class.getResource("/bd_hanzibox/iconos/actualizar.png")));
        jMenuBar_barraSup.add(jMenuItem3);
        
                jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
                jMenuItem3.setToolTipText("Analizar el porcentaje de match entre la base de datos y listas HSK");
                jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem3ActionPerformed(evt);
                    }
                });
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem1.setIcon(new ImageIcon(ventana_principal.class.getResource("/bd_hanzibox/iconos/maquinaEscribir.png")));
        jMenuBar_barraSup.add(jMenuItem1);
        
                jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
                jMenuItem1.setToolTipText("Máquina de escribir y analizador de texto");
                jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jMenuItem1ActionPerformed(evt);
                    }
                });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(30)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLab_traduccion)
        						.addComponent(jLab_pinyin)
        						.addComponent(jLab_entrada)
        						.addComponent(jLab_ejemplo)
        						.addComponent(jLabel2))
        					.addGap(149)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jTextField_traduccion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        						.addComponent(jTextField_ejemplo, Alignment.LEADING)
        						.addComponent(jTextField_pinyin, Alignment.LEADING)
        						.addComponent(jTextField_entrada, Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jComboBox_radical, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jComboBox_radical_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(jComboBox_radical_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addComponent(jComboBox_radical_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jButton_modificar)
        							.addGap(18)
        							.addComponent(jButton_buscar))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jButton_agregar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(jButton_borrar))
        						.addComponent(jLabel_contador_entradas_unicas)
        						.addComponent(jLabel_contador_entradas)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel_avanzado)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel_intermedio)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel_principiante))))
        				.addComponent(jLabel_tareaEjecutada_2, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel_tareaEjecutada)
        					.addGap(0, 654, Short.MAX_VALUE))
        				.addComponent(jLabel_tareaEjecutada_3, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
        			.addGap(29))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(33)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLab_entrada)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(3)
        						.addComponent(jTextField_entrada))
        					.addComponent(jButton_agregar)
        					.addComponent(jButton_borrar)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboBox_radical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2)
        						.addComponent(jComboBox_radical_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jComboBox_radical_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jComboBox_radical_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLab_pinyin)
        						.addComponent(jTextField_pinyin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLab_traduccion)
        						.addComponent(jTextField_traduccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLab_ejemplo)
        						.addComponent(jTextField_ejemplo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton_modificar)
        						.addComponent(jButton_buscar))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel_contador_entradas)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(9)
        									.addComponent(jLabel_contador_entradas_unicas)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(jLabel_intermedio))
        								.addGroup(layout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(jLabel_avanzado))))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(0, 88, Short.MAX_VALUE)
        							.addComponent(jLabel_principiante)))))
        			.addGap(25)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel_tareaEjecutada)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel_tareaEjecutada_2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel_tareaEjecutada_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        			.addGap(42))
        );
        getContentPane().setLayout(layout);

        jLabel_intermedio.setVisible(false);
        jLabel_principiante.setVisible(false);
        jLabel_avanzado.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  NADA
    private void jTextField_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_entradaActionPerformed
        
        
        
        
         
        
        
        
    }//GEN-LAST:event_jTextField_entradaActionPerformed

    
    // --------------------------- BOTONES -------------------------------------
    // -------------------------------------------------------------------------
    
    //  AGREGAR ENTRADAS A LA BD ---- FUNCIONANDO
    private void jButton_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarActionPerformed
    
        //  ENFOQUE DE PRUEBA BASADO EN ARRAYS
        
        //  --------------------------------------------------------------------
        //  ---------------------- TABLA PRINCIPAL -----------------------------
        //  --------------------------------------------------------------------
        
        // CAPTURA DE ENTRADAS  ------------------------------------------------
        
        entradaHanzi = jTextField_entrada.getText(); // capturamos la entrada en un string
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaEjemplo = jTextField_ejemplo.getText();
        
        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        entradaRadical_2 = jComboBox_radical_2.getSelectedItem().toString();
        entradaRadical_3 = jComboBox_radical_3.getSelectedItem().toString();
        entradaRadical_4 = jComboBox_radical_4.getSelectedItem().toString();
        
        //  ComboBox -----------------------------------------------------------
        
        //  evitamos valores en blanco  ----------------------------------------
        
        if (entradaRadical.isBlank()) {
            entradaRadical = "○";
        }
        
        if(entradaRadical_2.isBlank()){
            entradaRadical_2 = "○";
        }
        
        if(entradaRadical_3.isBlank()){
            entradaRadical_3 = "○";
        }
        
        if(entradaRadical_4.isBlank()){
            entradaRadical_4 = "○";
        }
        
        //  --------------------------------------------------------------------
            
        int n_hanzi_entrada = entradaHanzi.length();    // num de hanzi introducidos

        ArrayList<Unidad_min> conjunto_semantico = new ArrayList<>(); //  creamos un array con obj hanzi

        String[] piny_coleccion = new String[n_hanzi_entrada];    //  el tamano esta dado por el n de hanzi

        if (!entradaPinyin.isBlank()) {       //  con y sin entrada de pinyin

            piny_coleccion = entradaPinyin.split(" ");    //  individualizamos segun los espacios 

            }else{
                
                for(int i=0; i<n_hanzi_entrada; i++ ){
                    
                    piny_coleccion[i] = "...";
                    System.out.println("la extension del array fue " + n_hanzi_entrada);
                    
                } 
            }
            
            String [] h_coleccion = entradaHanzi.split("");
           
            ArrayList <String> rad_coleccion = new ArrayList<>();
            rad_coleccion.add(entradaRadical);
            rad_coleccion.add(entradaRadical_2);
            rad_coleccion.add(entradaRadical_3);
            rad_coleccion.add(entradaRadical_4);
            
            String hanzi_iterado ="";
            
            //  set del obj  "Unidad_min" --------------------------------------
            
            for(int i=0; i<h_coleccion.length; i++){    //  iteramos tantas veces como hanzi tenga la entrada
                
                Unidad_min unidad_semantica = new Unidad_min(); //  instanciamos nuevo obj
                
                hanzi_iterado = h_coleccion[i];  // aux para rescatar el hanzi en la posicion actual
                
                System.out.println("h_colecc[i]" + h_coleccion[i]);
                
                unidad_semantica.setSimbolo(hanzi_iterado); //  el nuevo obj seteado para hanzi
                
                unidad_semantica.setRadical(rad_coleccion.get(i));
                
                unidad_semantica.setPinyin(piny_coleccion[i]);
                
                unidad_semantica.setTraduccion(entradaTraduccion);
                unidad_semantica.setEjemplo(entradaEjemplo);
                
                conjunto_semantico.add(unidad_semantica);   //  almacenamos los obj seteados en un arraylist, que sera parametro para setear el obj final
                
            }
            
        //  --------------------------------------------------------------------
        //  usamos "Unidad_min" para setear "Unidad_final"  --------------------
        Unidad_final entrada_final = new Unidad_final();    //  instanciamos el obj final, la sintesis de la expresion 

        entrada_final.setObj(conjunto_semantico);   // esta seria la entrada en su total, con cada hanzi, pinyin y radical

        entrada_final.setTraduccion(entradaTraduccion);
        entrada_final.setEjemplo(entradaEjemplo);

        //  --------------------------------------------------------------------
        //  CORROBORAR QUE LA ENTRADA ACTUAL NO EXISTA PREVIAMENTE EN LA BD
        //  --------------------------------------------------------------------
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos

        boolean hanziComprobado = aplicar_metodo.buscarExistencia(entrada_final, this);  //  seteado el objeto le aplicamos el metodo para buscar el atributo en la BD. Devolvera true o false

        //  --------------------------------------------------------------------
        //  AGREGAR A LA BD HANZI_ENTRADA SI SE COMPROBO QUE NO EXISTE YA 
        //  --------------------------------------------------------------------
        
        //  informamos la entrada agregada -------------------------------------
        String reporteHanzi = "";
        
        for(int i = 0; i<h_coleccion.length; i++){
                
                reporteHanzi += h_coleccion[i];
                
            }
        //  --------------------------------------------------------------------
        
        if(hanziComprobado == false){
            
            // recuperamos la entrada original en su totalidad (entrada_final)
            
            aplicar_metodo.agregar(entrada_final);    //  agregamos la entrada     BORRE EL THIS
            
            jLabel_tareaEjecutada.setText("Se agregó " + reporteHanzi + " a la base de datos");
            
            //  ----------------------------------------------------------------
           
        }else{
            
            aplicar_metodo.compararDuplicados(entrada_final);   // si ya existe, debe determinar cual entrada conservar

            Implementacion_metodos acceso_metodos = new Implementacion_metodos();
            
            jLabel_tareaEjecutada.setText(acceso_metodos.getMensaje());
            
            if(acceso_metodos.getMensaje_2() != null){
                
                jLabel_tareaEjecutada_2.setText(acceso_metodos.getMensaje_2());
                
            }
            
            if(acceso_metodos.getMensaje_3() != null){
                
                jLabel_tareaEjecutada_3.setText(acceso_metodos.getMensaje_3());
                
            }
        }
        
        //  --------------------------------------------------------------------
        //  ---------------------- TABLA SECUNDARIA ----------------------------
        //  --------------------------------------------------------------------
        
        /*
        debemos recorrer el obj "entrada_final" constituido por otros obj de tipo
        Unidad_min y recuperar el atributo Simbolo de cada uno para agregarlo a 
        la tabla secundaria, junto con el pinyin y el radical correspondientes
        */
        
        String recuperando_hanzi_ind;
        
        //  iteracion recuperando cada elemento de entrada y analizandolo ------
        
        for(int i=0; i < entrada_final.getObj().size(); i++){
            
            Unidad_min auxiliar = new Unidad_min(); // aux para recuperar c/u de los obj constituyentes de entrada_final
        
            auxiliar = (Unidad_min)entrada_final.getObj().get(i);   // cast en cada iteracion
            
            auxiliar.getSimbolo();  // recuperacion de los atributos
            auxiliar.getRadical();
            auxiliar.getPinyin();
            
            //  COMPROBACION DE EXISTENCIA PREVIA EN BD ------------------------
            
            boolean comprobacion = aplicar_metodo.corroborarSingularidad(auxiliar);    // devolvera true (ya existe) o false (no existe)
            
            //  AGREGACION A BD ------------------------------------------------
            
            if(!comprobacion){
                
                aplicar_metodo.agregarSingularidades(auxiliar);
                
            }
            
            //  DE EXISTIR COMPLETA LA INFO PREEXISTENTE CON LA ENTRADA NUEVA --
            
            if(comprobacion){
                
                aplicar_metodo.compararDuplicados_singular(auxiliar);   // le elimine el this
                
            }
            
        }
        
        //------------------- actualizacion de contadores ----------------------
            
            n_input = aplicar_metodo.contarInput();
            n_hanzi_unicos = aplicar_metodo.contarHanziUnicos();
            jLabel_contador_entradas.setText("Palabras/expresiones: " + n_input);
            jLabel_contador_entradas_unicas.setText("Hanzis: " + n_hanzi_unicos);

        //----------------------------------------------------------------------
        
        
        limpiar_campos();
        
    }//GEN-LAST:event_jButton_agregarActionPerformed
    
    //  MODIFICAR ---- FUNCIONANDO
    private void jButton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificarActionPerformed
        
        //  MODIFICACIONES EN LA TABLA HANZI_ENTRADA    ------------------------
        //----------------------------------------------------------------------
        
        // CAPTURA DE ENTRADAS  -----------------------------------------------
         
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();
         
        entradaHanzi = jTextField_entrada.getText(); // capturamos la entrada en un string
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaEjemplo = jTextField_ejemplo.getText();

        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        entradaRadical_2 = jComboBox_radical_2.getSelectedItem().toString();
        entradaRadical_3 = jComboBox_radical_3.getSelectedItem().toString();
        entradaRadical_4 = jComboBox_radical_4.getSelectedItem().toString();

        //  ComboBox -----------------------------------------------------------
        //  evitamos valores en blanco  ----------------------------------------
        if (entradaRadical.isBlank()) {
            entradaRadical = "○";
        }

        if (entradaRadical_2.isBlank()) {
            entradaRadical_2 = "○";
        }

        if (entradaRadical_3.isBlank()) {
            entradaRadical_3 = "○";
        }

        if (entradaRadical_4.isBlank()) {
            entradaRadical_4 = "○";
        }

        //  --------------------------------------------------------------------
        int n_hanzi_entrada = entradaHanzi.length();    // num de hanzi introducidos

        ArrayList<Unidad_min> conjunto_semantico = new ArrayList<>(); //  creamos un array con obj hanzi

        String[] piny_coleccion = new String[n_hanzi_entrada];    //  el tamano esta dado por el n de hanzi

        if (!entradaPinyin.isBlank()) {       //  con y sin entrada de pinyin

            piny_coleccion = entradaPinyin.split(" ");    //  individualizamos segun los espacios 

        } else {

            for (int i = 0; i < n_hanzi_entrada; i++) {

                piny_coleccion[i] = "...";
                System.out.println("la extension del array fue " + n_hanzi_entrada);

            }
        }

        String[] h_coleccion = entradaHanzi.split("");

        ArrayList<String> rad_coleccion = new ArrayList<>();
        rad_coleccion.add(entradaRadical);
        rad_coleccion.add(entradaRadical_2);
        rad_coleccion.add(entradaRadical_3);
        rad_coleccion.add(entradaRadical_4);

        String hanzi_iterado = "";

        //  set del obj  "Unidad_min" --------------------------------------
        for (int i = 0; i < h_coleccion.length; i++) {    //  iteramos tantas veces como hanzi tenga la entrada

            Unidad_min unidad_semantica = new Unidad_min(); //  instanciamos nuevo obj

            hanzi_iterado = h_coleccion[i];  // aux para rescatar el hanzi en la posicion actual

            System.out.println("h_colecc[i]" + h_coleccion[i]);

            unidad_semantica.setSimbolo(hanzi_iterado); //  el nuevo obj seteado para hanzi

            unidad_semantica.setRadical(rad_coleccion.get(i));

            unidad_semantica.setPinyin(piny_coleccion[i]);

            unidad_semantica.setTraduccion(entradaTraduccion);
            unidad_semantica.setEjemplo(entradaEjemplo);

            conjunto_semantico.add(unidad_semantica);   //  almacenamos los obj seteados en un arraylist, que sera parametro para setear el obj final

        }

        //  --------------------------------------------------------------------
        //  usamos "Unidad_min" para setear "Unidad_final"  --------------------
        Unidad_final entrada_final = new Unidad_final();    //  instanciamos el obj final, la sintesis de la expresion 

        entrada_final.setObj(conjunto_semantico);   // esta seria la entrada en su total, con cada hanzi, pinyin y radical

        entrada_final.setTraduccion(entradaTraduccion);
        entrada_final.setEjemplo(entradaEjemplo);
        
        //  --------------------------------------------------------------------
        
        aplicar_metodo.modificar(entrada_final);  // aplicamos el metodo BORRE EL ACCESO
        
        
        //  reportar accion ----------------------------------------------------
        
        String reporte = "";
        
        for(int i =0; i<entrada_final.getObj().size(); i++){
            
            Unidad_min captura_nueva = new Unidad_min();
            
            captura_nueva = (Unidad_min) entrada_final.getObj().get(i);
            
            reporte += captura_nueva.getSimbolo();
            
        }
            
        jLabel_tareaEjecutada.setText("Entrada " + reporte + " fue modificada");

        
        aplicar_metodo.modificarSingularidad(entrada_final);    // se borro , ventana_principal acceso
        
        limpiar_campos();
        
    }//GEN-LAST:event_jButton_modificarActionPerformed

    //  BUSCAR Y MOSTRAR EN TABLA ---- FUNCIONANDO
    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        
        Conexion conexion = Conexion.getInstance(); 
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        
        String columna_busqueda = "";
        
        if(!jTextField_entrada.getText().isBlank() && jTextField_pinyin.getText().isBlank()  
                && jTextField_traduccion.getText().isBlank()){
            
            columna_busqueda = "Hanzi";     // jComboBox_radical.getSelectedIndex() == 0
            
            parametro_busqueda = jTextField_entrada.getText();
            
            jLabel_tareaEjecutada.setText("Buscando " + "[" + parametro_busqueda + "]");
            
        }else if(jTextField_entrada.getText().isBlank() && jComboBox_radical.getSelectedIndex() == 0 
                && !jTextField_pinyin.getText().isBlank() && jTextField_traduccion.getText().isBlank()){
            
            columna_busqueda = "Fonetica";
            
            parametro_busqueda = jTextField_pinyin.getText();
            
            jLabel_tareaEjecutada.setText("Buscando " + "[" + parametro_busqueda + "]");
            
        }else if(jTextField_entrada.getText().isBlank() && jComboBox_radical.getSelectedIndex() == 0 
                && jTextField_pinyin.getText().isBlank() && !jTextField_traduccion.getText().isBlank()){
            
            columna_busqueda = "Traduccion";
            
            parametro_busqueda = jTextField_traduccion.getText();
            
            jLabel_tareaEjecutada.setText("Buscando " + "[" + parametro_busqueda + "]");
            
        }else if(jTextField_entrada.getText().isBlank() && jComboBox_radical.getSelectedIndex() != 0 
                && jTextField_pinyin.getText().isBlank() && jTextField_traduccion.getText().isBlank()){
            
            columna_busqueda = "Radical";
            
            parametro_busqueda = jComboBox_radical.getSelectedItem().toString();
            
            jLabel_tareaEjecutada.setText("Buscando " + "[" + parametro_busqueda  + "]");
            
        }else if(jTextField_entrada.getText().isBlank() && jComboBox_radical.getSelectedIndex() == 0 
                && jTextField_pinyin.getText().isBlank() && jTextField_traduccion.getText().isBlank()){
            
            parametro_busqueda = "";
            
            jLabel_tareaEjecutada.setText("Buscando todas las entradas guardadas");
            
            jLabel_tareaEjecutada_2.setText("");    //  limpieza de reportes de accion
            
            jLabel_tareaEjecutada_3.setText("");
            
            
            //------------------- actualizacion de contadores ------------------
            
            n_input = aplicar_metodo.contarInput();
            n_hanzi_unicos = aplicar_metodo.contarHanziUnicos();
            jLabel_contador_entradas.setText("Palabras/expresiones: " + n_input);
            jLabel_contador_entradas_unicas.setText("Hanzis: " + n_hanzi_unicos);

            //------------------------------------------------------------------
            
        } else{
            
            columna_busqueda = null;
            
        }
        
        aplicar_metodo.mostrarTabla(columna_busqueda, this);
        
        limpiar_campos();
        
    }//GEN-LAST:event_jButton_buscarActionPerformed

    //  BORRAR ELEMENTOS DE LA TABLA ---- FUNCIONANDO
    private void jButton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrarActionPerformed
        
        //  creamos variables que seran parametros de busqueda
        entradaHanzi = jTextField_entrada.getText();
        entradaPinyin = jTextField_pinyin.getText();
        entradaTraduccion = jTextField_traduccion.getText();
        entradaEjemplo = jTextField_ejemplo.getText();
        entradaRadical = jComboBox_radical.getSelectedItem().toString();
        
        Hanzi miHanzi = new Hanzi();    // instanciamos el obj para setear con la entrada
        
        miHanzi.setIdiograma(entradaHanzi); //  seteamos con la entrada
        
        Implementacion_metodos aplicar_metodo = new Implementacion_metodos();   // para usar los metodos
        
        if(!entradaHanzi.isBlank() && entradaPinyin.isBlank() && entradaTraduccion.isBlank() && entradaEjemplo.isBlank() && entradaRadical.isBlank()){
            
            aplicar_metodo.borrar(miHanzi, this);   //  eliminamos con el Hanzi como unico parametro
            
            jLabel_tareaEjecutada.setText("La entrada " + miHanzi.getIdiograma() + " fue eliminada.");
            
        }else{
            
            jLabel_tareaEjecutada.setText("Introduzca solo el hanzi a eliminar");
          
        } 
        
        //------------------- actualizacion de contadores ----------------------
            
            n_input = aplicar_metodo.contarInput();
            n_hanzi_unicos = aplicar_metodo.contarHanziUnicos();
            jLabel_contador_entradas.setText("Palabras/expresiones: " + n_input);
            jLabel_contador_entradas_unicas.setText("Hanzis: " + n_hanzi_unicos);

        //----------------------------------------------------------------------
        
        limpiar_campos();
        
    }//GEN-LAST:event_jButton_borrarActionPerformed

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    
    //  HABILITAR LOS COMBO DE ACUERDO AL NUMERO DE HANZI INGRESADO (1-4)  ---- FUNCIONANDO   
    private void jTextField_entradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_entradaKeyReleased
        
        jTextField_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                contarHanzi_introducidos();
            }
        });
    }
    
    private void contarHanzi_introducidos() {
        entradaHanzi = jTextField_entrada.getText();

        // Llamada para actualizar el primer JComboBox
        autocompletarCombo(jComboBox_radical, 0);

        int n_hanzi_introducidos = entradaHanzi.length();

        if (n_hanzi_introducidos == 1) {
            jComboBox_radical_2.setEnabled(false);
            jComboBox_radical_3.setEnabled(false);
            jComboBox_radical_4.setEnabled(false);
        } else if (n_hanzi_introducidos == 2) {
            jComboBox_radical_2.setEnabled(true);
            autocompletarCombo(jComboBox_radical_2, 1);
            jComboBox_radical_3.setEnabled(false);
            jComboBox_radical_4.setEnabled(false);
        } else if (n_hanzi_introducidos == 3) {
            jComboBox_radical_3.setEnabled(true);
            autocompletarCombo(jComboBox_radical_3, 2);
            jComboBox_radical_4.setEnabled(false);
        } else if (n_hanzi_introducidos == 4) {
            jComboBox_radical_2.setEnabled(true);
            jComboBox_radical_3.setEnabled(true);
            jComboBox_radical_4.setEnabled(true);
            autocompletarCombo(jComboBox_radical_2, 1);
            autocompletarCombo(jComboBox_radical_3, 2);
            autocompletarCombo(jComboBox_radical_4, 3);
        }
    
        
        /*
        jTextField_entrada.getDocument().addDocumentListener(new DocumentListener(){
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                
                 // Agregar una llamada adicional para actualizar el primer JComboBox
                autocompletarCombo(jComboBox_radical, 0);

                
                contarHanzi_introducidos();
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
                contarHanzi_introducidos();
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
                contarHanzi_introducidos();
                
            }
            
            private void contarHanzi_introducidos(){
                
                entradaHanzi = jTextField_entrada.getText();
                
                int n_hanzi_introducidos = entradaHanzi.length();
               
                 // Agregar una llamada adicional para actualizar el primer JComboBox
                //autocompletarCombo(jComboBox_radical, 0);

                if (n_hanzi_introducidos == 1) {
                    
                   // autocompletarCombo(jComboBox_radical, 0);   // el n del combo -1, porque el array empieza en 0
                    
                    jComboBox_radical_2.setEnabled(false);
                    jComboBox_radical_3.setEnabled(false);
                    jComboBox_radical_4.setEnabled(false);
                    
                } else if (n_hanzi_introducidos == 2) {
                    
                    jComboBox_radical_2.setEnabled(true);
                    
                    autocompletarCombo(jComboBox_radical_2, 1); // el n del combo -1, porque el array empieza en 0
                    
                    jComboBox_radical_3.setEnabled(false);
                    jComboBox_radical_4.setEnabled(false);

                } else if (n_hanzi_introducidos == 3) {
                    
                    jComboBox_radical_3.setEnabled(true);
                    
                    autocompletarCombo(jComboBox_radical_3, 2); // el n del combo -1, porque el array empieza en 0
                    
                    jComboBox_radical_4.setEnabled(false);
                    
                } else if (n_hanzi_introducidos == 4) {
                    
                    jComboBox_radical_2.setEnabled(true);
                    jComboBox_radical_3.setEnabled(true);
                    jComboBox_radical_4.setEnabled(true);
                 
                    autocompletarCombo(jComboBox_radical_2, 1);
                    autocompletarCombo(jComboBox_radical_3, 2);
                    autocompletarCombo(jComboBox_radical_4, 3);
                    
                }
        }     
    });
        
        /*
        hay que implementar KeyEvent para que el evento sea la misma escritura, 
        caso contrario hay que presionar Enter en tras escribir algo como para que 
        empiece a registrar el input
        */
        
        
        
        
    }//GEN-LAST:event_jTextField_entradaKeyReleased

    //  SIN USO
    private void jComboBox_radicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_radicalActionPerformed
        
        
        
        
    }//GEN-LAST:event_jComboBox_radicalActionPerformed

    //  SIN USO
    private void jComboBox_radical_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_radical_2ActionPerformed
        
    }//GEN-LAST:event_jComboBox_radical_2ActionPerformed

    //  SIN USO
    private void jComboBox_radical_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_radical_2ItemStateChanged
       
        
    }//GEN-LAST:event_jComboBox_radical_2ItemStateChanged

    //  SIN USO
    private void jComboBox_radical_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_radical_2FocusGained
        
    }//GEN-LAST:event_jComboBox_radical_2FocusGained
    
    //  SIN USO
    private void jComboBox_radical_2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_radical_2FocusLost
        
         
    }//GEN-LAST:event_jComboBox_radical_2FocusLost

    //  SIN USO
    private void jComboBox_radical_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_radical_2KeyReleased
       
        
    }//GEN-LAST:event_jComboBox_radical_2KeyReleased

    //  ABRE LA VENTANA DE PROCESADOR DE TEXTO
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        abrirProcesadorTexto();

        dispose();


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    //  EVENTO ENTER            SIN USAR
    private void busqueda_resultadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busqueda_resultadosKeyPressed
        
                
                
        
        
        
        
        
    }//GEN-LAST:event_busqueda_resultadosKeyPressed
    
    //  VENTANA DE COMPLETAR ENTRADAS
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        abrirCompletarEntradas();
        
        dispose();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    //  ACTUALIZAR
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
        Implementacion_metodos aplicar = new Implementacion_metodos();
        
        //   nivel de la BD ----------------------------------------------------
        
        String hsk1 = "hsk1";
        String hsk2 = "hsk2";
        String hsk3 = "hsk3";
        String hsk4 = "hsk4";
        String hsk5 = "hsk5";
        String hsk6 = "hsk6";
        String hsk7 = "hsk7";
        
        int porcentaje_hsk1 = aplicar.comparadorHSK(hsk1);
        int porcentaje_hsk2 = aplicar.comparadorHSK(hsk2);
        int porcentaje_hsk3 = aplicar.comparadorHSK(hsk3);
        int porcentaje_hsk4 = aplicar.comparadorHSK(hsk4);
        int porcentaje_hsk5 = aplicar.comparadorHSK(hsk5);
        int porcentaje_hsk6 = aplicar.comparadorHSK(hsk6);
        int porcentaje_hsk7 = aplicar.comparadorHSK(hsk7);
        
        boolean mostrar_insignia_1 = aplicar.mostrarIconLevel(hsk1, hsk2, hsk3);
        boolean mostrar_insignia_2 = aplicar.mostrarIconLevel(hsk4, hsk5, hsk6);
        boolean mostrar_insignia_3 = aplicar.mostrarIconLevel_avanzado(hsk7);
        
        if(mostrar_insignia_1){
            
            jLabel_principiante.setVisible(true);
            
        }else{
            
            jLabel_principiante.setVisible(false);
            
        }
        
        if(mostrar_insignia_2){
            
            jLabel_intermedio.setVisible(true);
            
        }else{
            
            jLabel_intermedio.setVisible(false);
            
        }
        
        if(mostrar_insignia_3){
            
            jLabel_avanzado.setVisible(true);
            
        }else{
            
            jLabel_avanzado.setVisible(false);
            
        }
        
        jLabel_tareaEjecutada.setText("HSK 1: " + porcentaje_hsk1 + "%" + "     " + "HSK 2: " 
                + porcentaje_hsk2 + "%" + "     " + "HSK 3: " + porcentaje_hsk3 + "%" + "     " 
                + "HSK 4: " + porcentaje_hsk4 + "%" + "     " + "HSK 5: " + porcentaje_hsk5 + "%" + "     " +
                "HSK 6: " + porcentaje_hsk6 + "%" + "     " + "HSK 7: " + porcentaje_hsk7 + "%" + "     ");
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    //  VISUALIZADOR FULL SCREEN
    private void jMenuItem_visualizadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_visualizadorActionPerformed
        
        abrirVisualizador();
        
        dispose();
        
    }//GEN-LAST:event_jMenuItem_visualizadorActionPerformed
    
    
    //  ------------------- GETTERS AND SETTERS --------------------------------
    //--------------------------------------------------------------------------
    
    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
    }

    public JButton getjButton_agregar() {
        return jButton_agregar;
    }

    public void setjButton_agregar(JButton jButton_agregar) {
        this.jButton_agregar = jButton_agregar;
    }

    public JButton getjButton_borrar() {
        return jButton_borrar;
    }

    public void setjButton_borrar(JButton jButton_borrar) {
        this.jButton_borrar = jButton_borrar;
    }

    public JButton getjButton_buscar() {
        return jButton_buscar;
    }

    public void setjButton_buscar(JButton jButton_buscar) {
        this.jButton_buscar = jButton_buscar;
    }

    public JButton getjButton_modificar() {
        return jButton_modificar;
    }

    public void setjButton_modificar(JButton jButton_modificar) {
        this.jButton_modificar = jButton_modificar;
    }

    public JComboBox<String> getjComboBox_radical() {
        return jComboBox_radical;
    }

    public void setjComboBox_radical(JComboBox<String> jComboBox_radical) {
        this.jComboBox_radical = jComboBox_radical;
    }

    public JLabel getjLab_ejemplo() {
        return jLab_ejemplo;
    }

    public void setjLab_ejemplo(JLabel jLab_ejemplo) {
        this.jLab_ejemplo = jLab_ejemplo;
    }

    public JLabel getjLab_entrada() {
        return jLab_entrada;
    }

    public void setjLab_entrada(JLabel jLab_entrada) {
        this.jLab_entrada = jLab_entrada;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel_tareaEjecutada() {
        return jLabel_tareaEjecutada;
    }

    public void setjLabel_tareaEjecutada(JLabel jLabel_tareaEjecutada) {
        this.jLabel_tareaEjecutada = jLabel_tareaEjecutada;
    }
    
    public String setjLabel_tareaEjecutada(String jLabel_tareaEjecutada) {
        return jLabel_tareaEjecutada;
    }

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField_ejemplo() {
        return jTextField_ejemplo;
    }

    public void setjTextField_ejemplo(JTextField jTextField_ejemplo) {
        this.jTextField_ejemplo = jTextField_ejemplo;
    }

    public JTextField getjTextField_entrada() {
        return jTextField_entrada;
    }

    public void setjTextField_entrada(JTextField jTextField_entrada) {
        this.jTextField_entrada = jTextField_entrada;
    }

    public JTextField getjTextField_pinyin() {
        return jTextField_pinyin;
    }

    public void setjTextField_pinyin(JTextField jTextField_pinyin) {
        this.jTextField_pinyin = jTextField_pinyin;
    }

    public JTextField getjTextField_traduccion() {
        return jTextField_traduccion;
    }

    public String getEntradaHanzi() {
        return entradaHanzi;
    }

    public void setEntradaHanzi(String entradaHanzi) {
        this.entradaHanzi = entradaHanzi;
    }

    public String getEntradaPinyin() {
        return entradaPinyin;
    }

    public void setEntradaPinyin(String entradaPinyin) {
        this.entradaPinyin = entradaPinyin;
    }

    public String getEntradaTraduccion() {
        return entradaTraduccion;
    }

    public void setEntradaTraduccion(String entradaTraduccion) {
        this.entradaTraduccion = entradaTraduccion;
    }

    public String getEntradaEjemplo() {
        return entradaEjemplo;
    }

    public void setEntradaEjemplo(String entradaEjemplo) {
        this.entradaEjemplo = entradaEjemplo;
    }

    public String getEntradaRadical() {
        return entradaRadical;
    }

    public void setEntradaRadical(String entradaRadical) {
        this.entradaRadical = entradaRadical;
    }
    
    public void setjTextField_traduccion(JTextField jTextField_traduccion) {
        this.jTextField_traduccion = jTextField_traduccion;
    }

    public static JTable getBusqueda_resultados() {
        return busqueda_resultados;
    }

    public static void setBusqueda_resultados(JTable busqueda_resultados) {
        ventana_principal.busqueda_resultados = busqueda_resultados;
    }

    public static String getMsj_advertencia() {
        return msj_advertencia;
    }

    public static void setMsj_advertencia(String msj_advertencia) {
        ventana_principal.msj_advertencia = msj_advertencia;
    }

    public static String getParametro_busqueda() {
        return parametro_busqueda;
    }

    public static void setParametro_busqueda(String parametro_busqueda) {
        ventana_principal.parametro_busqueda = parametro_busqueda;
    }

    public JComboBox<String> getjComboBox_radical_2() {
        return jComboBox_radical_2;
    }

    public void setjComboBox_radical_2(JComboBox<String> jComboBox_radical_2) {
        this.jComboBox_radical_2 = jComboBox_radical_2;
    }

    public JComboBox<String> getjComboBox_radical_3() {
        return jComboBox_radical_3;
    }

    public void setjComboBox_radical_3(JComboBox<String> jComboBox_radical_3) {
        this.jComboBox_radical_3 = jComboBox_radical_3;
    }

    public JComboBox<String> getjComboBox_radical_4() {
        return jComboBox_radical_4;
    }

    public void setjComboBox_radical_4(JComboBox<String> jComboBox_radical_4) {
        this.jComboBox_radical_4 = jComboBox_radical_4;
        
    }

    public static String getEntradaRadical_2() {
        return entradaRadical_2;
    }

    public static void setEntradaRadical_2(String entradaRadical_2) {
        ventana_principal.entradaRadical_2 = entradaRadical_2;
    }

    public static String getEntradaRadical_3() {
        return entradaRadical_3;
    }

    public static void setEntradaRadical_3(String entradaRadical_3) {
        ventana_principal.entradaRadical_3 = entradaRadical_3;
    }

    public static String getEntradaRadical_4() {
        return entradaRadical_4;
    }

    public static void setEntradaRadical_4(String entradaRadical_4) {
        ventana_principal.entradaRadical_4 = entradaRadical_4;
    }

    public static StringBuilder getTotal_radicales() {
        return total_radicales;
    }

    public static void setTotal_radicales(StringBuilder total_radicales) {
        ventana_principal.total_radicales = total_radicales;
    }

    public JLabel getjLabel_tareaEjecutada_2() {
        return jLabel_tareaEjecutada_2;
    }

    public void setjLabel_tareaEjecutada_2(JLabel jLabel_tareaEjecutada_2) {
        this.jLabel_tareaEjecutada_2 = jLabel_tareaEjecutada_2;
    }
    
    
    
    
    //  GETTERS AND SETTERS ----------------------------------------------------

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
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable busqueda_resultados;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_agregar;
    private javax.swing.JButton jButton_borrar;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_modificar;
    private javax.swing.JComboBox<String> jComboBox_radical;
    private javax.swing.JComboBox<String> jComboBox_radical_2;
    private javax.swing.JComboBox<String> jComboBox_radical_3;
    private javax.swing.JComboBox<String> jComboBox_radical_4;
    private javax.swing.JLabel jLab_ejemplo;
    private javax.swing.JLabel jLab_entrada;
    private javax.swing.JLabel jLab_pinyin;
    private javax.swing.JLabel jLab_traduccion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_avanzado;
    private javax.swing.JLabel jLabel_contador_entradas;
    private javax.swing.JLabel jLabel_contador_entradas_unicas;
    private javax.swing.JLabel jLabel_intermedio;
    private javax.swing.JLabel jLabel_principiante;
    private javax.swing.JLabel jLabel_tareaEjecutada;
    private javax.swing.JLabel jLabel_tareaEjecutada_2;
    private javax.swing.JLabel jLabel_tareaEjecutada_3;
    private javax.swing.JMenuBar jMenuBar_barraSup;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem_visualizador;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField_ejemplo;
    private javax.swing.JTextField jTextField_entrada;
    private javax.swing.JTextField jTextField_pinyin;
    private javax.swing.JTextField jTextField_traduccion;
    // End of variables declaration//GEN-END:variables

  
}

class panel_ventana extends JPanel {
    public panel_ventana(JFrame ventana_principal) {
        // Obtén el contentPane del JFrame
        Container contentPane = ventana_principal.getContentPane();

        // Obtén los componentes del contentPane
        Component[] components = contentPane.getComponents();

        // Agrega los componentes al JPanel
        for (Component component : components) {
            add(component);
        }
    }
}

    

    
    

    
    
    

