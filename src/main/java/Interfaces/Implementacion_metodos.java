package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
import java.sql.Connection;
import bd_hanzibox.*;
import static bd_hanzibox.completar_entradas.busqueda_resultados_completar;
import static bd_hanzibox.procesador_texto.resultados_seleccion;
import bd_hanzibox.ventana_principal;
import static bd_hanzibox.ventana_principal.busqueda_resultados;
import com.mysql.cj.result.Row;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import jdk.dynalink.StandardOperation;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Implementacion_metodos implements Metodos {

    static String auxiliar_elemento;
    static String auxiliar_campo;

    private static String ruta_archivo = "/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/Textos";
    private static String rutaCompleta = "";
    private static String lista_biblio = "";

    private static String mensaje;
    private static String mensaje_2;
    private static String mensaje_3;

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        Implementacion_metodos.mensaje = mensaje;
    }

    public static String getMensaje_2() {
        return mensaje_2;
    }

    public static void setMensaje_2(String mensaje_2) {
        Implementacion_metodos.mensaje_2 = mensaje_2;
    }

    public static String getMensaje_3() {
        return mensaje_3;
    }

    public static void setMensaje_3(String mensaje_3) {
        Implementacion_metodos.mensaje_3 = mensaje_3;
    }

    public static String getRuta_archivo() {
        return ruta_archivo;
    }

    public static void setRuta_archivo(String ruta_archivo) {
        Implementacion_metodos.ruta_archivo = ruta_archivo;
    }

    public static String getRutaCompleta() {
        return rutaCompleta;
    }

    public static void setRutaCompleta(String rutaCompleta) {
        Implementacion_metodos.rutaCompleta = rutaCompleta;
    }
    
    
    // instanciamos la conxion para acceder a esta desde los metodos
    Conexion conexion = Conexion.getInstance();
    

    //---------------------------- METODOS -------------------------------------
    
    
    //  ------------------ CRUD BASICO (tabla principal) -----------------------
    //  ------------------------------------------------------------------------
    
    //  AGREGAR ENTRADAS    -- le borre el acceso a ver que onda
    @Override
    public void agregar(Unidad_final hanzi_agregar) {

        Connection conectar = conexion.conectar();

        try {

            String nombre_entrada = "";         //  hanzi
            String simbolo = "";                //  hanzi
            String radical = "";                //  radical
            String radical_entrada = "";        //  radical
            String pinyin = "";                 //  pinyin
            String pinyin_entrada = "";         //  pinyin
            String traduccion = "";
            String ejemplo = "";

            Unidad_min aux;

            PreparedStatement agregar = conectar.prepareStatement("insert into hanzi_entrada (Radical, Hanzi, Fonetica, Traduccion, Ejemplo) "
                    + "values (?,?,?,?,?)");

            for (int i = 0; i < hanzi_agregar.getObj().size(); i++) {

                // hacemos un cast instanciando un obj tipo unidad_min tomando uno igual de la posicion i de los almacenados en unidad_final
                aux = (Unidad_min) hanzi_agregar.getObj().get(i);

                simbolo = aux.getSimbolo(); // tomamos el nombre del hanzi
                radical = aux.getRadical();
                pinyin = aux.getPinyin();
                traduccion = aux.getTraduccion();
                ejemplo = aux.getEjemplo();

                nombre_entrada = nombre_entrada + simbolo;
                radical_entrada = radical_entrada + radical;
                pinyin_entrada = (pinyin_entrada + " " + pinyin).trim();    // el trim es sugerencia de chat...

                System.out.println("en metodo AGREGAR nombre_entrada es " + nombre_entrada);
                System.out.println("y su radical es " + aux.getRadical());
                System.out.println("su pinyin es " + aux.getPinyin());

                agregar.setString(1, radical_entrada);
                agregar.setString(2, nombre_entrada);
                agregar.setString(3, pinyin_entrada);
                agregar.setString(4, traduccion);
                agregar.setString(5, ejemplo);

            }

            agregar.executeUpdate();  // va fuera del for o insertara en cada iteracion

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    //  BORRAMOS ENTRADAS CON EL HANZI COMO UNICO PARAMETRO
    @Override
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso) {

        try {

            Connection conectar = conexion.conectar();  //  conectamos

            PreparedStatement eliminar = conectar.prepareStatement("delete from hanzi_entrada where Hanzi = ?");    //  sql de eliminacion

            eliminar.setString(1, hanzi_eliminar.getIdiograma());   // seteamos parametros de eliminacion

            eliminar.executeUpdate();   //  ejecutamos

            conexion.desconectar(); //  desconectamos

        } catch (Exception e) {

            e.printStackTrace();

        }

    }   // FUNCIONANDO

    //  MODIFICAR ENTRADAS BUSCANDO POR HANZI
    @Override
    public void modificar(Unidad_final hanzi) {

        //  LE BORRO EL ACCESO A VENTANA PRINCIPAL , ventana_principal acceso
        
        // instanciamos la conxion para acceder a esta desde los metodos
        Conexion conexion = Conexion.getInstance();
        Connection conectar = conexion.conectar();

        String nombre_entrada = "";         //  hanzi
        String simbolo = "";                //  hanzi
        String radical = "";                //  radical
        String radical_entrada = "";        //  radical
        String pinyin = "";                 //  pinyin
        String pinyin_entrada = "";         //  pinyin
        String traduccion = "";
        String ejemplo = "";

        Unidad_min aux;

        try {

            for (int i = 0; i < hanzi.getObj().size(); i++) {

                // hacemos un cast instanciando un obj tipo unidad_min tomando uno igual de la posicion i de los almacenados en unidad_final
                aux = (Unidad_min) hanzi.getObj().get(i);

                simbolo = aux.getSimbolo(); // tomamos el nombre del hanzi
                radical = aux.getRadical();
                pinyin = aux.getPinyin();
                traduccion = aux.getTraduccion();
                ejemplo = aux.getEjemplo();

                nombre_entrada = nombre_entrada + simbolo;
                radical_entrada = radical_entrada + radical;
                pinyin_entrada = (pinyin_entrada + " " + pinyin).trim();    // el trim es sugerencia de chat

                System.out.println("en metodo AGREGAR nombre_entrada es " + nombre_entrada);
                System.out.println("y su radical es " + aux.getRadical());
                System.out.println("su pinyin es " + aux.getPinyin());

            }

            // solo modificara en los campos donde se ingreso informacion
            
            //  -------------------------- RADICAL -----------------------------
            if (radical != null || !radical.isBlank() || !radical.equalsIgnoreCase("○")) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Radical = ? where Hanzi = ?");

                modificar.setString(1, radical_entrada);
                modificar.setString(2, nombre_entrada);
                modificar.executeUpdate();

            }

            //  ----------------------- PINYIN ---------------------------------
            if (pinyin != null && !pinyin.isBlank() && !pinyin.equals("...")) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");

                modificar.setString(1, pinyin_entrada);
                modificar.setString(2, nombre_entrada);
                modificar.executeUpdate();

            }

            //  ----------------------- TRADUCCION -----------------------------
            if (traduccion != null && !traduccion.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Traduccion = ? where Hanzi = ?");

                modificar.setString(1, traduccion);
                modificar.setString(2, nombre_entrada);
                modificar.executeUpdate();

            }
            //  ----------------------- EJEMPLO ----------------------------
            if (ejemplo != null && !ejemplo.isBlank()) {

                PreparedStatement modificar = conectar.prepareStatement(
                        "update hanzi_entrada set Ejemplo = ? where Hanzi = ?");

                modificar.setString(1, ejemplo);
                modificar.setString(2, nombre_entrada);
                modificar.executeUpdate();

            }

            conexion.desconectar();

        } catch (Exception e) {
            System.out.println("Error, no existe el hanzi que se quiere modificar");
            e.printStackTrace();
        }

    }   //  FUNCIONANDO

    @Override
    public void buscar(Hanzi hanzi, ventana_principal acceso) {

        // Funciona a partir de la implementacion del metodo mostrarTabla();
    }   //  FUNCIONANDO
    
    
    

    //  -------------------------- TABLA SECUNDARIA ----------------------------
    //  ------------------------------------------------------------------------
    
    //  CONSTATA QUE EL HANZI INGRESADO NO EXISTA PREVIAMENTE EN LA TABLA "HANZI"
    @Override
    public boolean corroborarSingularidad(Unidad_min hanzi_ingresado) {

        Connection conectar = conexion.conectar();  // conectamos

        boolean hanzi_singular = false;  //  variable que retornaremos

        try {

            //  buscamos en el campo
            PreparedStatement corroborando_singularidad = conectar.prepareStatement("SELECT * FROM hanzi WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            corroborando_singularidad.setString(1, hanzi_ingresado.getSimbolo());

            //  la consulta en si
            ResultSet consulta = corroborando_singularidad.executeQuery();

            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if (consulta.next()) {

                hanzi_singular = true;

            } else {

                hanzi_singular = false;

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return hanzi_singular;

    }   //  FUNCIONANDO

    //  AGREGA A "HANZI" DE MANERA INDIVIDUALIZADA CADA HANZI CON SU RADICAL Y PINYIN
    @Override
    public void agregarSingularidades(Unidad_min hanzi) {

        try {

            Connection conectar = conexion.conectar();

            PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Pinyin, Radical) "
                    + "values (?,?,?)");

            agregar.setString(1, hanzi.getSimbolo());
            agregar.setString(2, hanzi.getPinyin());
            agregar.setString(3, hanzi.getRadical());

            agregar.executeUpdate();

            conexion.desconectar();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }   //  FUNCIONANDO

    //  MODIFICAR RADICAL O PINYIN EN TABLA HANZI
    @Override
    public void modificarSingularidad(Unidad_final hanzi) {

        try {

            Connection conectar = conexion.conectar();

            String nombre_entrada = "";         //  hanzi
            String simbolo = "";                //  hanzi
            String radical = "";                //  radical
            String radical_entrada = "";        //  radical
            String pinyin = "";                 //  pinyin
            String pinyin_entrada = "";         //  pinyin

            Unidad_min auxiliar;

            for (int i = 0; i < hanzi.getObj().size(); i++) {

                // hacemos un cast instanciando un obj tipo unidad_min tomando uno igual de la posicion i de los almacenados en unidad_final
                auxiliar = (Unidad_min) hanzi.getObj().get(i);

                simbolo = auxiliar.getSimbolo(); // tomamos el nombre del hanzi
                radical = auxiliar.getRadical();
                pinyin = auxiliar.getPinyin();

                nombre_entrada = nombre_entrada + simbolo;
                radical_entrada = radical_entrada + radical;
                pinyin_entrada = (pinyin_entrada + " " + pinyin).trim();

                //  pinyin  ----------------------------------------------------
                if (pinyin != null && !pinyin.isBlank() && !pinyin.equalsIgnoreCase("...")) {

                    PreparedStatement modificar = conectar.prepareStatement(
                            "update hanzi set Pinyin = ? where Hanzi = ?");

                    modificar.setString(1, pinyin);
                    modificar.setString(2, simbolo);
                    modificar.executeUpdate();

                    System.out.println("pinyin fue " + pinyin);

                }

                //  radical ----------------------------------------------------
                if (!radical.equalsIgnoreCase("○")) {

                    PreparedStatement modificarRad_01 = conectar.prepareStatement(
                            "update hanzi set Radical = ? where Hanzi = ?");

                    modificarRad_01.setString(1, radical);
                    modificarRad_01.setString(2, simbolo);
                    modificarRad_01.executeUpdate();

                    System.out.println("entro en el condicional para modificar radical");
                    System.out.println("el radical fue " + radical);

                }

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();;

        }

    }   //  FUNCIONANDO     se borro , ventana_principal acceso

    //  SOBRE LA TABLA SECUNDARIA COMPARA ENTRADAS NUEVAS Y PREEXISTENTES, EVITANDO DUPLICADOS Y COMPLETANDO LA INFORMACION FALTANTE A PARTIR DE A NUEVA    -- BORRE EL ACCESO
    @Override
    public void compararDuplicados_singular(Unidad_min hanzi_aCorroborar) {

        try {

            Connection conectar = conexion.conectar();  // conectamos

            //  ENTRADA NUEVA --------------------------------------------------
            hanzi_aCorroborar.getSimbolo();
            hanzi_aCorroborar.getPinyin();
            hanzi_aCorroborar.getRadical();

            //  RECUPERACION DE ENTRADA PREEXISTENTE ---------------------------
            //  buscamos en BD y seteamos un nuevo obj con lo preexistente------
            Unidad_min entrada_antigua = new Unidad_min();  //  ENTRADA ANTIGUA

            //  variables aux para recuperar de la bd --------------------------
            String valorCampo1 = "";
            String valorCampo2 = "";

            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando_bd = conectar.prepareStatement("SELECT Radical, Pinyin FROM hanzi WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando_bd.setString(1, hanzi_aCorroborar.getSimbolo());

            //  la consulta en si
            ResultSet consulta = recuperando_bd.executeQuery();

            // Recuperar información de distintos campos
            while (consulta.next()) {

                valorCampo1 = consulta.getString("Radical");
                valorCampo2 = consulta.getString("Pinyin");

            }

            // seteamos con lo preexistente ------------------------------------
            entrada_antigua.setRadical(valorCampo1);    // seteamos un obj con valores preexistentes
            entrada_antigua.setPinyin(valorCampo2);

            //  ----------------------------------------------------------------
            //  COMPARACION, ELEMENTO A ELEMENTO ENTRE ENTRADAS ----------------
            //  ----------------------------------------------------------------
            //          --------------------------------------------------------
            //  RADICAL --------------------------------------------------------
            //          --------------------------------------------------------
            if (entrada_antigua.getRadical().equalsIgnoreCase("○")) {

                PreparedStatement actualizar = conectar.prepareStatement(
                        "update hanzi set Radical = ? where Hanzi = ?");

                actualizar.setString(1, hanzi_aCorroborar.getRadical());
                actualizar.setString(2, hanzi_aCorroborar.getSimbolo());

                actualizar.executeUpdate();

            }

            //          --------------------------------------------------------
            //  PINYIN  --------------------------------------------------------
            //          --------------------------------------------------------
            if (entrada_antigua.getPinyin().contains("...")) {  // PINYIN

                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi set Pinyin = ? where Hanzi = ?");

                actualizar_2.setString(1, hanzi_aCorroborar.getPinyin());
                actualizar_2.setString(2, hanzi_aCorroborar.getSimbolo());

                actualizar_2.executeUpdate();

                System.out.println("entro en el if de pinyin");

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }   //  FUNCIONANDO     -- le elimine el acceso
    
    

    //  ----------------------- FUNCIONES AVANZADAS ----------------------------
    //  ------------------------------------------------------------------------
    
    //  CONSTATA QUE NO EXISTA PREVIAMENTE LO QUE SE QUIERE AGREGAR
    @Override
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso) {

        Connection conectar = conexion.conectar();  // conectamos

        boolean registroExistente = false;  //  variable que retornaremos

        try {

            //  variables aux para el for --------------------------------------
            String recuperandoEntrada = "";
            String simbolo = "";
            Unidad_min aux = new Unidad_min();

            //System.out.println("el tamano es " + hanzi_aCorroborar.getObj().size());
            for (int i = 0; i < hanzi_aCorroborar.getObj().size(); i++) {

                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);

                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();

                recuperandoEntrada = recuperandoEntrada + simbolo;

            }

            //  ----------------------------------------------------------------
            //  buscamos en el campo
            PreparedStatement chequeandoExistencia = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            chequeandoExistencia.setString(1, recuperandoEntrada);

            //  la consulta en si
            ResultSet consulta = chequeandoExistencia.executeQuery();

            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if (consulta.next()) {

                registroExistente = true;

                System.out.println("Encontro que ya esta");

            } else {

                registroExistente = false;

                System.out.println("No lo encontro");

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return registroExistente;

    }   //  FUNCIONANDO

    //  MOSTRAR BUSQUEDA EN TABLA
    @Override
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso) {

        try {

            String elemento_busqueda = acceso.getParametro_busqueda();

            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla

            busqueda_resultados.setModel(modelo);

            busqueda_resultados.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            Connection conexionMySQL = conexion.conectar();

            if (columna_busqueda == null) {

                acceso.setMsj_advertencia("Introduzca un solo parametro de busqueda");

            } else if (columna_busqueda.isBlank()) {

                try {

                    PreparedStatement seleccion = conexionMySQL.prepareStatement("SELECT * from hanzi_entrada");

                    ResultSet consulta = seleccion.executeQuery();

                    ResultSetMetaData datos = consulta.getMetaData();
                    int cantidadColumnas = datos.getColumnCount();

                    //modelo.addColumn("Codigo");
                    modelo.addColumn("Radical");
                    modelo.addColumn("Hanzi");
                    modelo.addColumn("Fonetica");
                    modelo.addColumn("Traduccion");
                    modelo.addColumn("Ejemplo");

                    for (int i = 0; i < cantidadColumnas; i++) {

                        busqueda_resultados.getColumnModel().getColumn(i);

                    }

                    while (consulta.next()) {

                        Object arreglo[] = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {

                            arreglo[i] = consulta.getObject(i + 1);
                        }
                        modelo.addRow(arreglo);
                    }

                    conexion.desconectar();

                } catch (SQLException e) {

                    e.printStackTrace();

                }

            } else {

                PreparedStatement seleccion = conexionMySQL.prepareStatement("SELECT * from hanzi_entrada WHERE " + columna_busqueda + " LIKE ?");

                seleccion.setString(1, "%" + elemento_busqueda + "%");

                ResultSet consulta = seleccion.executeQuery();

                ResultSetMetaData datos = consulta.getMetaData();
                int cantidadColumnas = datos.getColumnCount();

                //modelo.addColumn("Codigo");
                modelo.addColumn("Radical");
                modelo.addColumn("Hanzi");
                modelo.addColumn("Fonetica");
                modelo.addColumn("Traduccion");
                modelo.addColumn("Ejemplo");

                for (int i = 0; i < cantidadColumnas; i++) {

                    busqueda_resultados.getColumnModel().getColumn(i);

                }

                while (consulta.next()) {

                    Object arreglo[] = new Object[cantidadColumnas];

                    for (int i = 0; i < cantidadColumnas; i++) {

                        arreglo[i] = consulta.getObject(i + 1);
                    }
                    modelo.addRow(arreglo);
                }
            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }   //  FUNCIONANDO

    //  CONTAR LA CANTIDAD DE REGISTROS TOTALES
    @Override
    public int contarInput() {

        int registros_encontrados = 0;

        try {

            Connection conectar = conexion.conectar();

            PreparedStatement agregar = conectar.prepareStatement("Select COUNT(Hanzi) from hanzi_entrada");

            ResultSet consulta = agregar.executeQuery();

            if (consulta.next()) {

                registros_encontrados = consulta.getInt(1);

            }

            conexion.desconectar();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return registros_encontrados;

    }   //  FUNCIONANDO

    //  CONTAR LA CANTIDAD DE HANZIS UNICOS QUE HAY
    @Override
    public int contarHanziUnicos() {

        int registros_encontrados = 0;

        try {

            Connection conectar = conexion.conectar();

            PreparedStatement agregar = conectar.prepareStatement("Select COUNT(Hanzi) from hanzi");

            ResultSet consulta = agregar.executeQuery();

            if (consulta.next()) {

                registros_encontrados = consulta.getInt(1);

            }

            conexion.desconectar();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return registros_encontrados;

    }   //  FUNCIONANDO

    //  COMPARA ENTRADA NUEVA Y PREEXISTENTE, EVITANDO DUPLICADOS Y COMPLETANDO LA INFORMACION FALTANTE A PARTIR DE A NUEVA     -- LE BORRE EL ACCESO
    @Override
    public void compararDuplicados(Unidad_final hanzi_aCorroborar) {

        try {

            Connection conectar = conexion.conectar();  // conectamos

            mensaje = "La entrada ya existe. ";
            mensaje_2 = "";
            mensaje_3 = "";

            //  CAPTURA DE LA ENTRADA DE USUARIO -------------------------------
            String simbolo_entrada = "";
            String pinyin_entrada = "";
            String radical_entrada = "";
            String traduccion_entrada = "";
            String ejemplo_entrada = "";

            String simbolo = "";
            String pinyin = "";
            String radical = "";
            String traduccion = "";
            String ejemplo = "";

            //  instanciamos nuevo obj para setearlo con las entradas ----------
            Unidad_min aux = new Unidad_min();  //  ENTRADA NUEVA

            //  recuperamos los atributos ingresados ---------------------------
            for (int i = 0; i < hanzi_aCorroborar.getObj().size(); i++) {

                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);

                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();
                pinyin = aux.getPinyin();
                radical = aux.getRadical();
                traduccion = aux.getTraduccion();
                ejemplo = aux.getEjemplo();

                System.out.println("el radical recuperado es " + radical);

                simbolo_entrada = simbolo_entrada + simbolo;
                pinyin_entrada = pinyin_entrada + " " + pinyin;
                radical_entrada = radical_entrada + radical;

            }

            //  RECUPERACION DE ENTRADA PREEXISTENTE ---------------------------
            //  buscamos en BD y seteamos un nuevo obj con lo preexistente------
            Unidad_min entrada_antigua = new Unidad_min();  //  ENTRADA ANTIGUA

            //  variables aux para recuperar de la bd --------------------------
            String valorCampo1 = "";
            String valorCampo2 = "";
            String valorCampo3 = "";
            String valorCampo4 = "";

            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando_bd = conectar.prepareStatement("SELECT Radical, Fonetica, Traduccion, Ejemplo FROM hanzi_entrada WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando_bd.setString(1, simbolo_entrada);

            //  la consulta en si
            ResultSet consulta = recuperando_bd.executeQuery();

            // Recuperar información de distintos campos
            while (consulta.next()) {

                valorCampo1 = consulta.getString("Radical");
                valorCampo2 = consulta.getString("Fonetica");
                valorCampo3 = consulta.getString("Traduccion");
                valorCampo4 = consulta.getString("Ejemplo");
            }

            // seteamos con lo preexistente ------------------------------------
            entrada_antigua.setRadical(valorCampo1);    // seteamos un obj con valores preexistentes
            entrada_antigua.setPinyin(valorCampo2);
            entrada_antigua.setTraduccion(valorCampo3);
            entrada_antigua.setEjemplo(valorCampo4);

            //  ----------------------------------------------------------------
            //  COMPARACION, ELEMENTO A ELEMENTO ENTRE ENTRADAS ----------------
            //  ----------------------------------------------------------------
            //          --------------------------------------------------------
            //  RADICAL --------------------------------------------------------
            //          --------------------------------------------------------
            String radicalAntiguo = entrada_antigua.getRadical();
            String radical_final = "";
            String auxiliar_radical = "";
            String radicales_conservados = "";

            for (int i = 0; i < radicalAntiguo.length(); i++) {

                char radical_test = radicalAntiguo.charAt(i);

                System.out.println("radical_test fue " + radical_test);

                if (radical_test == '○') {

                    radical_final += radical_entrada.charAt(i);

                } else {

                    radical_final += radical_test;
                    radicales_conservados += radical_test;

                }

                System.out.println("el radical final va siendo " + radical_final);

            }

            PreparedStatement actualizar = conectar.prepareStatement(
                    "update hanzi_entrada set Radical = ? where Hanzi = ?");

            actualizar.setString(1, radical_final);
            actualizar.setString(2, simbolo_entrada);

            actualizar.executeUpdate();

            //  reporte de accion ------------------------------------------
            if (radical_entrada.equalsIgnoreCase("○")) {

                //mensaje += "La entrada ya existe";
            } else if (radical_entrada.equalsIgnoreCase("○○")) {

                //mensaje = "La entrada ya existe";
            } else if (radical_entrada.equalsIgnoreCase("○○○")) {

                //mensaje = "La entrada ya existe";
            } else if (radical_entrada.equalsIgnoreCase("○○○○")) {

                //mensaje = "La entrada ya existe";
            } else {

                mensaje_2 += "Se agregaron los radicales " + "【" + radical_entrada + "】, conservándose " + "【" + radicalAntiguo + "】. ";

            }

            //          --------------------------------------------------------
            //  PINYIN  --------------------------------------------------------
            //          --------------------------------------------------------
            if (entrada_antigua.getPinyin().contains("...") && !aux.getPinyin().isBlank() && !aux.getPinyin().contains("...")) {  // PINYIN

                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");

                actualizar_2.setString(1, pinyin_entrada);
                actualizar_2.setString(2, simbolo_entrada);

                actualizar_2.executeUpdate();

                System.out.println("entro en el if de pinyin");

                mensaje_2 += "Se agregó su pinyin " + pinyin_entrada;

            } else if (!entrada_antigua.getPinyin().isBlank() && !entrada_antigua.getPinyin().contains("...") && !aux.getPinyin().contains("...")) {

                //  queda lo viejo, ya que esto no MODIFICA, solo agrega info sobre vacios
                String pinyin_viejo = entrada_antigua.getPinyin();

                PreparedStatement actualizar_2 = conectar.prepareStatement(
                        "update hanzi_entrada set Fonetica = ? where Hanzi = ?");

                actualizar_2.setString(1, pinyin_viejo);
                actualizar_2.setString(2, simbolo_entrada);

                actualizar.executeUpdate();

                //  reporte de accion ------------------------------------------
                mensaje_2 += "Se conservó el pinyin original " + pinyin_viejo + ". ";

                //  ----------------------------------------------------------------
                System.out.println("entro en el if else de pinyin");

            }

            //              ----------------------------------------------------
            //  TRADUCCION  ----------------------------------------------------
            //              ----------------------------------------------------
            if (entrada_antigua.getTraduccion().isBlank() && !aux.getTraduccion().isBlank()) {

                PreparedStatement actualizar_3 = conectar.prepareStatement(
                        "update hanzi_entrada set Traduccion = ? where Hanzi = ?");

                actualizar_3.setString(1, traduccion);
                actualizar_3.setString(2, simbolo_entrada);

                actualizar_3.executeUpdate();

                //  reporte de accion ------------------------------------------
                mensaje_3 += "Se agregó una traducción. ";

            }

            //              ----------------------------------------------------
            //  EJEMPLO     ----------------------------------------------------
            //              ----------------------------------------------------
            if (entrada_antigua.getEjemplo().isBlank() && !aux.getEjemplo().isBlank()) {

                PreparedStatement actualizar_4 = conectar.prepareStatement(
                        "update hanzi_entrada set Ejemplo = ? where Hanzi = ?");

                actualizar_4.setString(1, ejemplo);
                actualizar_4.setString(2, simbolo_entrada);

                actualizar_4.executeUpdate();

                //  reporte de accion ------------------------------------------
                mensaje_3 += "Se agregó un ejemplo. ";

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }   //  FUNCIONANDO

    //  AUTOCOMPLETA EL RADICAL EN TIEMPO REAL, SI ES QUE ESE HANZI YA EXISTE EN LA BD
    @Override
    public String autocompletarRadicales(Unidad_min hanzi_autocompletar) {

        String radical_seleccionado = "";

        Unidad_min auxiliar = new Unidad_min();

        try {

            Connection conectar = conexion.conectar();  // conectamos

            //  buscamos la entrada en la bd -----------------------------------
            PreparedStatement recuperando = conectar.prepareStatement("SELECT Radical FROM hanzi WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            recuperando.setString(1, hanzi_autocompletar.getSimbolo());

            //  la consulta en si
            ResultSet consulta = recuperando.executeQuery();

            // Verificamos si hay algún resultado antes de intentar acceder a él
            if (consulta.next()) {

                radical_seleccionado = consulta.getString("Radical");   // recuperamos el string del campo "Radical"

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return radical_seleccionado;    // retornamos el string del campo radical

    }   //  FUNCIONANDO
    
    

    //  ---------------------- PROCESASOR DE TEXTO -----------------------------
    //  ------------------------------------------------------------------------
    
    //  BUSCA EN TABLA PRINCIPAL EL TEXTO SELECCIONADO
    @Override
    public boolean buscarSeleccion(String texto_seleccionado) {

        boolean registro_existente = false;

        try {

            Connection conectar = conexion.conectar();  // conectamos

            //  buscamos en el campo
            PreparedStatement buscando = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi LIKE ?");

            buscando.setString(1, "%" + texto_seleccionado + "%");

            //  la consulta en si
            ResultSet consulta = buscando.executeQuery();

            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if (consulta.next()) {

                mostrarTablaProcesador(texto_seleccionado);

                registro_existente = true;

            } else {

                registro_existente = false;

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return registro_existente;

    }   //  FUNCIONANDO

    //  MUESTRA LA TABLA PRINCIPAL CON COINCIDENCIAS DE LA BUSQUEDA DEL TEXTO SELECCIONADO
    @Override
    public void mostrarTablaProcesador(String mostrar_texto_seleccionado) {

        try {

            Connection conectar = conexion.conectar();

            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla

            resultados_seleccion.setModel(modelo);

            resultados_seleccion.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            PreparedStatement seleccion = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi LIKE ?");

            seleccion.setString(1, "%" + mostrar_texto_seleccionado + "%");

            ResultSet consulta = seleccion.executeQuery();

            ResultSetMetaData datos = consulta.getMetaData();
            int cantidadColumnas = datos.getColumnCount();

            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");

            for (int i = 0; i < cantidadColumnas; i++) {

                resultados_seleccion.getColumnModel().getColumn(i);

            }

            while (consulta.next()) {

                Object arreglo[] = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    arreglo[i] = consulta.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }   //FUNCIONANDO

    //  METODOS PROPUESTOS POR CHAT PARA LA BUSQUEDA AUTOMATIZADA EN EL JTEXTPANE
    @Override
    public boolean buscarExistenciaProcesador(Unidad_final hanzi_aCorroborar, procesador_texto acceso) {

        Connection conectar = conexion.conectar();  // conectamos

        boolean registroExistente = false;  //  variable que retornaremos

        try {

            //  variables aux para el for --------------------------------------
            String recuperandoEntrada = "";
            String simbolo = "";
            Unidad_min aux = new Unidad_min();

            //System.out.println("el tamano es " + hanzi_aCorroborar.getObj().size());
            for (int i = 0; i < hanzi_aCorroborar.getObj().size(); i++) {

                aux = (Unidad_min) hanzi_aCorroborar.getObj().get(i);

                // Acceder a los atributos de Unidad_min
                simbolo = aux.getSimbolo();

                recuperandoEntrada = recuperandoEntrada + simbolo;

            }

            //  ----------------------------------------------------------------
            //  buscamos en el campo
            PreparedStatement chequeandoExistencia = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            chequeandoExistencia.setString(1, recuperandoEntrada);

            //  la consulta en si
            ResultSet consulta = chequeandoExistencia.executeQuery();

            //  cambiamos el valor de la instancia de retorno segun corresponda a la busqueda
            if (consulta.next()) {

                registroExistente = true;

            } else {

                registroExistente = false;

            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return registroExistente;

    }

    //  IDENTIFICA HANZI NUEVOS EN EL TEXTO Y LOS RESALTA EN ROJO
    @Override
    public void analizadorTexto(JTextPane texto, procesador_texto acceso) {
        
        try {
            Connection conectar = conexion.conectar(); // Conectar a la base de datos
            StyledDocument doc = texto.getStyledDocument();
            
            int tamano = doc.getLength();
            boolean chequeando_que_sea_hanzi;
            

            for (int i = 0; i < tamano; i++) {
                char caracter = doc.getText(i, 1).charAt(0);
                
                //  comprobamos que se trate de un hanzi y no otra cosa
                chequeando_que_sea_hanzi = quedarseSoloHanzi(String.valueOf(caracter));
                
                if(chequeando_que_sea_hanzi){
                    
                    // Puedes agregar la lógica para evaluar el carácter en la base de datos
                    if (!existeEnBaseDeDatos(conectar, String.valueOf(caracter))) {
                        aplicarEstiloColor(texto, i, 1, Color.RED);

                    }

                }
                
            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        } catch (BadLocationException ex) {
            Logger.getLogger(Implementacion_metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   //  FUNCIONANDO
    
    //  COLOREA (ACCESORIO DE analizadorTexto())
    @Override
    public void aplicarEstiloColor(JTextPane textPane, int start, int length, Color color) {
        StyledDocument doc = textPane.getStyledDocument();
        Style estilo = textPane.addStyle("miEstilo", null);
        StyleConstants.setForeground(estilo, color);
        doc.setCharacterAttributes(start, length, estilo, false);
    }   //  FUNCIONANDO

    //  BUSCA EN BD (ACCESORIO DE analizadorTexto())
    @Override
    public boolean existeEnBaseDeDatos(Connection conexion, String caracter) throws SQLException {
        PreparedStatement analizando = conexion.prepareStatement("SELECT * FROM hanzi WHERE Hanzi = ?");
        analizando.setString(1, caracter);
        ResultSet consulta = analizando.executeQuery();
        return consulta.next();
    }
    
    //  EXCLUYE ELEMENTOS QUE NO SEAN HANZI (ACCESORIO DE analizadorTexto())
    @Override
    public boolean quedarseSoloHanzi(String caracter) {
        
        boolean es_hanzi = true;
        
        //  ruta del txt con simbolos NO hanzi
        String ruta_simbolos = "/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/Archivos varios/Simbolos puntuacion.txt";
        
        try{
            
            FileReader lectura = new FileReader(ruta_simbolos);     // leemos la lista de los simbolos
            
            BufferedReader br = new BufferedReader(lectura); 
            
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                for(int i = 0; i <linea.length(); i++){
                    
                    char simbolo = linea.charAt(i);     // capturamos el simbolo por reglon
                    
                    if(caracter.equalsIgnoreCase(String.valueOf(simbolo))){
                        
                        es_hanzi = false;   //  cambiamos el boolean que retornamos de acuerdo a la comparacion
                        
                    }
                    
                }
                
            }
            
        } catch (IOException e) {

             e.printStackTrace();

         }
        
        return es_hanzi;
        
        }   //  FUNCIONANDO
        
        
    

    //  ------------------------------------------------------------------------
    
    //  METODO PARA GUARDAR EN TXT EL CONTENIDO DE JTextPANE
    @Override
    public void guardarTexto(String ruta, JTextPane textPane, String titulo, JComboBox<String> biblioteca) throws IOException {
        
        try{
            
            //  generacion y escritura del txt ---------------------------------
            
            String nombre_archivo = titulo + ".txt";    // titulo del txt  

            rutaCompleta = Paths.get(ruta_archivo, nombre_archivo).toString();   // construye la ruta

            System.out.println("la ruta es " + rutaCompleta);

            FileWriter escribir = new FileWriter(rutaCompleta); // crea el txt 

            String texto_guardar = textPane.getText();  // pasamos a string el texto

            for (int i = 0; i < texto_guardar.length(); i++) {

                escribir.write(texto_guardar.charAt(i));    // escribimos char a char

            }
            
            //  biblioteca -----------------------------------------------------
            
            biblioteca.addItem(titulo);     //  agrega el titulo sin el .txt
            
            //  edicion Lista.txt ----------------------------------------------
            
            String lista_titulos = "/Lista.txt";
            
            String ruta_lista = Paths.get(ruta_archivo, lista_titulos).toString();
            
            FileWriter escribir_2 = new FileWriter(ruta_lista, true); // crea el txt 
            
            titulo += "\n";
            
            for (int i = 0; i < titulo.length(); i++) {

                escribir_2.write(titulo.charAt(i));
                
            }

            escribir.close();   // cerramos
            escribir_2.close();

        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }   //  ANDA

    //  AGREGA LA LISTA DE TITULOS DEL TXT AL COMBO
    @Override
    public void completarBiblioteca(JComboBox<String> biblioteca) {
        
        try{
            
            for(String texto : Files.readAllLines(Paths.get(ruta_archivo + "/Lista.txt"))){
            
            biblioteca.addItem(texto);  // agregamos en bucle los items de la lista
            
        }
            
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }   // ANDA

    //  SETEA EL JTextPane CON EL CONTENIDO DEL TXT 
    @Override
    public void leyendoBiblioteca(JTextPane textPane, JComboBox<String> biblioteca) {
        
        try{
            
            //  recuperamos el titulo y la ruta --------------------------------
            
            String titulo_lectura = biblioteca.getSelectedItem().toString();
            
            String ruta_lectura = ruta_archivo + "/" + titulo_lectura + ".txt";
            
            //  leemos el codigo de cada carcter -------------------------------
            
            FileReader lectura = new FileReader(ruta_lectura);
            
            int c = 0;  // 0 para que arranque desde antes del primer caracter
            
            String recuperando_texto = "";
            
            while (c != -1) {

                c = lectura.read(); // devuelve un int que se traducira a caracter luego

                if (c != -1) {

                    char letra = (char) c;  // casteamos a caracter el codigo

                    recuperando_texto += String.valueOf(letra); // armamos el String

                }
            }
            
            textPane.setText(recuperando_texto);    // mostramos el texto
        
            lectura.close();
        
        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        
    }   //  ANDA

    //  EDITA ARCHIVOS YA EXISTENTES
    @Override
    public void editarTextoBiblioteca(JTextPane textPane, JComboBox<String> biblioteca, String titulo_nuevo) {
        
        try {
            
            //  evaluamos si cambio el titulo ----------------------------------
            
            String nombre_nuevo;
            
            // Seleccionamos el título actual
            String titulo_viejo = biblioteca.getSelectedItem().toString();
            
            //String texto_eliminar = titulo;
  
            if (Objects.nonNull(titulo_nuevo) && !titulo_nuevo.isEmpty()) {
                
                // Nuevo título proporcionado
                nombre_nuevo = titulo_nuevo;
                
                lista_biblio = nombre_nuevo + System.lineSeparator();   // asi se almacena sin txt en el combo
                
                // Actualizamos el JComboBox
                biblioteca.addItem(nombre_nuevo);
                
                nombre_nuevo += ".txt";
                
                //  al editar se crea uno nuevo, elinamos el viejo ------------------
                eliminarTextoBiblioteca(biblioteca, titulo_viejo);

                System.out.println("el titulo es nuevo");
                
            } else {
                
                // Mantenemos el título actual
                nombre_nuevo = titulo_viejo + ".txt";
                
                System.out.println("el titulo es el mismo");
            }
            
            //  establecemos la ruta -------------------------------------------
            
             String nombre_archivo = "/" + nombre_nuevo;    // titulo del txt  

            rutaCompleta = Paths.get(ruta_archivo, nombre_archivo).toString();   // construye la ruta

            System.out.println("la ruta es " + rutaCompleta);
            
            //  escribimos el archivo ------------------------------------------

            FileWriter escribir = new FileWriter(rutaCompleta); // crea el txt 

            String texto_guardar = textPane.getText();  // pasamos a string el texto

            for (int i = 0; i < texto_guardar.length(); i++) {

                escribir.write(texto_guardar.charAt(i));    // escribimos char a char

            }
            
            escribir.close();   // cerramos
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }   //  FUNCIONA !!!

    //  ELIMINA ARCHIVOS SELECCIONADOS DEL COMBO
    @Override
    public void eliminarTextoBiblioteca(JComboBox<String> biblioteca, String texto_eliminar) {
        
        //  sacamos del combo --------------------------------------------------
        
        for(int i = 0; i < biblioteca.getItemCount(); i++){
           
            if(biblioteca.getItemAt(i).equalsIgnoreCase(texto_eliminar)){
                
                biblioteca.removeItemAt(i);
                
            } 
        }
        
        System.out.println("texto eliminado del combo fue " + texto_eliminar);
        
        //  sacamos el archivo -------------------------------------------------
        
        try{
            
            rutaCompleta = ruta_archivo + "/" + texto_eliminar + ".txt";
            
            Files.delete(Paths.get(rutaCompleta));

        }catch(IOException e){
            
            e.printStackTrace();
            
            }
        
        //  sacamos del Lista.txt, reescribiendola   ---------------------------
        
        String ruta_lista = ruta_archivo + "/Lista.txt";
        
        try{
            
            FileWriter escribir = new FileWriter(ruta_lista, false);  // false reescribe el mismo txt
            
            for(int i = 0; i<biblioteca.getItemCount(); i++){
                
                if(!biblioteca.getItemAt(i).equalsIgnoreCase(texto_eliminar)){
                
                String itemCombo = biblioteca.getItemAt(i);
                
                escribir.write(itemCombo + System.lineSeparator());
                
                }
            
            }
            
            escribir.close();
        
        }catch(IOException e){
            
            e.printStackTrace();
            
        }

    }   //   FUNCIONA !!!!

    //  AGREGA TODOS LOS HANZIS NUEVOS, DISCRIMINANDO LOS SIGNOS DE PUNTUACION
    @Override
    public String agregarAutoTodosHanzi(JTextPane texto, procesador_texto acceso) {
        
        String mensajito = "";
        
        try {
            
            Connection conectar = conexion.conectar(); // Conectar a la base de datos
            StyledDocument doc = texto.getStyledDocument();
            int tamano = doc.getLength();
            
            ArrayList <Unidad_min> hanzi_nuevos = new ArrayList<>();
            
            for (int i = 0; i < tamano; i++) {
                char caracter = doc.getText(i, 1).charAt(0);

                // agrega a lista de hanzi individual solo si no existe y solo si NO es un signo de puntuacion, numero, letra, etc
                if (!existeEnBaseDeDatos(conectar, String.valueOf(caracter)) && quedarseSoloHanzi(String.valueOf(caracter))) {
                    aplicarEstiloColor(texto, i, 1, Color.BLACK);
                    
                    //  agregamos los hanzi nuevos a un array ------------------
                    
                    Unidad_min hanzi_capturado = new Unidad_min();
                    
                    hanzi_capturado.setSimbolo(String.valueOf(caracter));
                    hanzi_capturado.setPinyin("...");
                    hanzi_capturado.setRadical("○");
                    
                    hanzi_nuevos.add(hanzi_capturado);
                    
                }
            }
            
            for(Unidad_min e: hanzi_nuevos){
               
                PreparedStatement agregar = conectar.prepareStatement("insert into hanzi (Hanzi, Radical, Pinyin) VALUES  (?, ?, ?) ");
                       
                agregar.setString(1, e.getSimbolo());
                agregar.setString(2, e.getRadical());
                agregar.setString(3, e.getPinyin());

                agregar.executeUpdate();
                
                System.out.println("los hanzi insertados fueron " + e.getSimbolo());

            }
            
             mensajito= "Se agregaron " + hanzi_nuevos.size() + " nuevos hanzis";
            
            //acceso.setMensaje_1(mensaje);

            conexion.desconectar();
       
    }catch(SQLException e){
        
        e.printStackTrace();
        
    }   catch (BadLocationException ex) {
            Logger.getLogger(Implementacion_metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    return mensajito;
    
}   //  FUNCIONA
    
    //  COPIAR
    @Override
    public void copiarTexto(JTextPane texto){
        
        // Texto que se copiará al portapapeles
                String textoACopiar = texto.getSelectedText();

                // Crea una StringSelection con el texto
                StringSelection seleccion = new StringSelection(textoACopiar);

                // Obtiene el sistema del portapapeles
                Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();

                // Copia la selección al portapapeles
                portapapeles.setContents(seleccion, null);
    
    }   //  FUNCIONA
    
    //  PEGAR
    @Override
    public void pegarTexto(JTextPane texto){
        
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
                try {
                    // Obtiene el contenido actual del JTextPane
                    String contenidoActual = texto.getText();

                    // Obtiene el contenido del portapapeles
                    String contenidoPortapapeles = (String) portapapeles.getData(DataFlavor.stringFlavor);

                    // Combina el contenido actual con el contenido del portapapeles
                    String contenidoCombinado = contenidoActual + contenidoPortapapeles;

                    // Establece el contenido combinado en el JTextPane
                    texto.setText(contenidoCombinado);

                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
            }   //  FUNCIONA
        
    

    
    //  ------------------------------------------------------------------------
    
    //  COMPARA LA LISTA HSK CON LA BD Y DEVUELVE EL PORCENTAJE DE COBERTURA
    @Override
    public int comparadorHSK(String hsk_comparar) {
        
        Connection conectar = conexion.conectar();  // conectamos
       
        // variables para sacar %   --------------------------------------------
        
        int contador_palabras = 0;
        int porcentaje_cobertura;
        
        int vueltas_dadas = 0;
        
        //  creamos un array y le asignamos el retorno del metodo --------------
        
        ArrayList <String> lista_HSK = new ArrayList<>();  // aca almacenaremos las palabras
        
        lista_HSK = cargarListasHSK(hsk_comparar);
        
        try {
            
            //  recorremos el array buscando cada palabra   --------------------
            
            for(String palabra : lista_HSK){
                
                vueltas_dadas ++;
                
                //  buscamos en el campo
                PreparedStatement comparar = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?");

                //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
                comparar.setString(1, palabra);

                //  la consulta en si
                ResultSet consulta = comparar.executeQuery();
                
                //  contabilizamos los match    --------------------------------
                
                if(consulta.next()){
                    
                    contador_palabras ++;
                    
                    System.out.println("en el bucle las vuelts fueron: " + vueltas_dadas);
                    
                }
            }
            
            conexion.desconectar();
            
            } catch (SQLException e) {
            e.printStackTrace();
        }
        
        porcentaje_cobertura = contador_palabras * 100 / lista_HSK.size();
        
        System.out.println("palabras encontradas: "+contador_palabras);
        System.out.println("tamano de la lista hsk: " + lista_HSK.size());
        System.out.println("porcentaje de cobertura del HSK: " + porcentaje_cobertura + " para " + hsk_comparar);
        

        return porcentaje_cobertura;
    }   //  FUNCIONA

    //  CARGA LA LISTA DE PALABRAS HSK EN UN ARRAYLIST
    @Override
    public ArrayList<String> cargarListasHSK(String lista) { // throws IOException 
        
        ArrayList<String> lista_HSK = new ArrayList<>();    // donde se guardaran las palabras
        
        //  la ruta se completa con el parametro -nombre de la lista- que se le pase 
        String ruta_completa = "/Users/nahuellaluce/NetBeansProjects/BD_hanziBox/src/main/java/bd_hanzibox/Listas HSK/" + lista + ".txt"; 
        
        try{
            
            BufferedReader br = new BufferedReader(new FileReader(ruta_completa));  //  se lee linea a linea

            String linea;

            while ((linea = br.readLine()) != null) {   //  se almacena en un string si la linea NO esta vacia

                lista_HSK.add(linea);   //  se guarda el strin en el array
            }

        }catch(IOException e){
            
            e.printStackTrace();
            
        }

        return lista_HSK;
    }   //  FUNCIONA

    @Override
    public boolean mostrarIconLevel(String hskA,String hskB, String hskC) {
        
        boolean completado = false;
       
        int nivel_hskA = 0;
        int nivel_hskB = 0;
        int nivel_hskC = 0;
        
        nivel_hskA = comparadorHSK(hskA);   // deberia meter un sout de todos los elementos
        nivel_hskB = comparadorHSK(hskB);
        nivel_hskC = comparadorHSK(hskC);
        
        if(nivel_hskA >= 90 && nivel_hskB  >= 90 && nivel_hskC >= 90){
            
            completado = true;
            
        }
        
        return completado;
        
    }   //  NO PROBADO

    @Override
    public boolean mostrarIconLevel_avanzado(String hsk) {
        
        boolean completado = false;
       
        int nivel_hsk = 0;
        
        nivel_hsk = comparadorHSK(hsk);   // deberia meter un sout de todos los elementos
        
        
        if(nivel_hsk >= 90){
            
            completado = true;
            
        }
        
        return completado;
        
    }   //  NO PROBADO

    
    //  ------------------------------------------------------------------------
    
    //  RECORRE TODA LA BD EN BUSCA DE ENTRADAS QUE TENGAN ALGO INCOMPLETO
    @Override
    public ArrayList<String> buscarEntradaIncompleta() {
        
        String entrada_incompleta = "";
        String hanzi_rescatado = "";
        ArrayList<String> guardando_entradas = new ArrayList<>();

        try ( Connection conectar = conexion.conectar()) {
            //  buscamos en el campo
            PreparedStatement entrada = conectar.prepareStatement("SELECT Hanzi FROM hanzi_entrada");
            //  la consulta en si
            ResultSet consulta = entrada.executeQuery();

            while (consulta.next()) {
                hanzi_rescatado = consulta.getString("Hanzi");

                PreparedStatement buscando = conectar.prepareStatement("SELECT Radical, Fonetica, Traduccion, Ejemplo FROM hanzi_entrada WHERE Hanzi = ?");
                buscando.setString(1, hanzi_rescatado);

                ResultSet consulta2 = buscando.executeQuery();

                if (consulta2.next()) {
                    // Verificar condiciones y agregar a la lista
                    if (consulta2.getString("Radical").contains("○") || consulta2.getString("Fonetica").contains("...")
                            || consulta2.getString("Traduccion").isBlank() || consulta2.getString("Ejemplo").isBlank()) {
                        guardando_entradas.add(hanzi_rescatado);
                    }

                    for (String e : guardando_entradas) {
                        System.out.println("La entrada guardada fue " + e);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guardando_entradas;
    }

    //  EN LA FUNCION DE COMPLETAR PRESETEA LOS COMBO CON LA INFO QUE YA HAYA
    @Override
    public void autocompletarCombo_completar(JComboBox combo, int posicion_array, completar_entradas acceso){
        
        String entradaHanzi_completar;

        //  AUTOCOMPLETAR ------------------------------------------
        
        if (combo.isEnabled()) {
            
            System.out.println("entro en el if del autocompletar");

            Implementacion_metodos aplicar_metodo = new Implementacion_metodos();

            Unidad_min entrada = new Unidad_min();    //  instanciamos el obj final, la sintesis de la expresion 

            int n_hanzi = acceso.getjTextField_entrada_completar().getText().length();
            
            System.out.println("n_hanzi en autocompletar era " + n_hanzi);
            
            //acceso.getjTextField_entrada_completar().getText().length();

            String[] deglosando_hanzi = new String[n_hanzi];    // almacenamos los hanzi individuales

            // CAPTURA DE ENTRADAS  --------------------------------------------
            entradaHanzi_completar = acceso.getjTextField_entrada_completar().getText(); // capturamos la entrada en un string

            // RECUPERAMOS EL HANZI ESPECIFICO SEGUN POSICION ------------------
            deglosando_hanzi = entradaHanzi_completar.split("");  // individualizamos los hanzi ingresados

            String captura_hanzi_ind = deglosando_hanzi[posicion_array]; // es 1 y no dos porque arranca en 0 el array

            entrada.setSimbolo(captura_hanzi_ind);
            
            String autocompletado = aplicar_metodo.autocompletarRadicales(entrada);
            
            combo.setSelectedItem(autocompletado);
            
        }
    }   //  FUNCIONANDO

    //  CUENTA LOS HANZI PARA HABILITAR LOS COMBO NECESARIOS
    @Override
    public void contarHanzi_introducidos(completar_entradas acceso) {
        
        String entradaHanzi_completar = acceso.getjTextField_entrada_completar().getText();
        
        if (entradaHanzi_completar != null) {
            
        entradaHanzi_completar = entradaHanzi_completar.trim(); // Asegura que la cadena no sea nula y elimina espacios en blanco
        
        int n_hanzi_introducidos = entradaHanzi_completar.length();
        
            System.out.println("leyo que hay " + n_hanzi_introducidos+ " hanzi");
        
        if (n_hanzi_introducidos == 1) {
            
            if (!acceso.jComboBox_radical_completar.isEnabled()) {
                
                acceso.jComboBox_radical_completar.setEnabled(true);
                
                autocompletarCombo_completar(acceso.jComboBox_radical_completar, 0, acceso);
            }
            
            System.out.println("entro en el if de 1 hanzi");

            //autocompletarCombo_completar(acceso.jComboBox_radical_completar, 0, acceso);   // el n del combo -1, porque el array empieza en 0

            acceso.jComboBox_radical_2_completar.setEnabled(false);
            acceso.jComboBox_radical_3_completar.setEnabled(false);
            acceso.jComboBox_radical_4_completar.setEnabled(false);

        } else if (n_hanzi_introducidos == 2) {
            
            System.out.println("dentro del else if ==2 ");
            
             if (!acceso.jComboBox_radical_2_completar.isEnabled() && !acceso.jComboBox_radical_completar.isEnabled()) {
                 
                acceso.jComboBox_radical_completar.setEnabled(true);
                autocompletarCombo_completar(acceso.jComboBox_radical_completar, 0, acceso); 
                 
                acceso.jComboBox_radical_2_completar.setEnabled(true);
                autocompletarCombo_completar(acceso.jComboBox_radical_2_completar, 1, acceso);
                
             System.out.println("evaluo si estaban habilitados o no");
            }

              System.out.println("entro en el if de 2 hanzi");
            //acceso.jComboBox_radical_2_completar.setEnabled(true);

            //autocompletarCombo_completar(acceso.jComboBox_radical_2_completar, 1, acceso); // el n del combo -1, porque el array empieza en 0

            acceso.jComboBox_radical_3_completar.setEnabled(false);
            acceso.jComboBox_radical_4_completar.setEnabled(false);

        } else if (n_hanzi_introducidos == 3) {
            
             if (!acceso.jComboBox_radical_2_completar.isEnabled() && !acceso.jComboBox_radical_completar.isEnabled() && !acceso.jComboBox_radical_3_completar.isEnabled()) {
                 
                acceso.jComboBox_radical_completar.setEnabled(true);
                autocompletarCombo_completar(acceso.jComboBox_radical_completar, 0, acceso); 
                 
                acceso.jComboBox_radical_2_completar.setEnabled(true);
                autocompletarCombo_completar(acceso.jComboBox_radical_2_completar, 1, acceso);
                 
                acceso.jComboBox_radical_3_completar.setEnabled(true);
                autocompletarCombo_completar(acceso.jComboBox_radical_3_completar, 2, acceso);
            }

            //acceso.jComboBox_radical_3_completar.setEnabled(true);

            //autocompletarCombo_completar(acceso.jComboBox_radical_3_completar, 2, acceso); // el n del combo -1, porque el array empieza en 0

            acceso.jComboBox_radical_4_completar.setEnabled(false);

        } else if (n_hanzi_introducidos == 4) {

            acceso.jComboBox_radical_completar.setEnabled(true);
            acceso.jComboBox_radical_2_completar.setEnabled(true);
            acceso.jComboBox_radical_3_completar.setEnabled(true);
            acceso.jComboBox_radical_4_completar.setEnabled(true);

            autocompletarCombo_completar(acceso.jComboBox_radical_completar, 0, acceso);
            autocompletarCombo_completar(acceso.jComboBox_radical_2_completar, 1, acceso);
            autocompletarCombo_completar(acceso.jComboBox_radical_3_completar, 2, acceso);
            autocompletarCombo_completar(acceso.jComboBox_radical_4_completar, 3, acceso);

        }
        
        }
        
        
        
        }   //  FUNCIONANDO
    
    @Override
    public String autocompletarCamposPinyin(completar_entradas acceso){
        
        String hanzi_buscado = acceso.getjTextField_entrada_completar().getText();
        
        String pinyinCapturado = "";
    
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            //  buscamos en el campo
            PreparedStatement buscando_hanzi = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?;");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            buscando_hanzi.setString(1, hanzi_buscado);

            //  la consulta en si
            ResultSet consulta = buscando_hanzi.executeQuery();
            
            if(consulta.next()){
                
                if(!consulta.getString("Fonetica").contains("...")){
                    
                    pinyinCapturado = consulta.getString("Fonetica");
                    
                }
                
            }
            
            conexion.desconectar();
        
        }catch(SQLException e){
            
            e.printStackTrace();
                
        }
        
        System.out.println("pinyin capturado fue " + pinyinCapturado);
    
        return pinyinCapturado;
        
    }   //  FUNCIONANDO

    @Override
    public String autocompletarCamposTraduccion(completar_entradas acceso) {
        
        String hanzi_buscado = acceso.getjTextField_entrada_completar().getText();
        
        String traduccionCapturada = "";
        
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            //  buscamos en el campo
            PreparedStatement buscando_hanzi = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?;");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            buscando_hanzi.setString(1, hanzi_buscado);

            //  la consulta en si
            ResultSet consulta = buscando_hanzi.executeQuery();
            
            if(consulta.next()){
                
                System.out.println("entro en el NEXT ");
                
                if(!consulta.getString("Traduccion").isEmpty()){
                    
                    traduccionCapturada = consulta.getString("Traduccion");
                    
                    System.out.println("entro en el condicional de traduccion");
                    
                }
                
                System.out.println("ahora traduccionCapturada es " + traduccionCapturada);
                
            }
            
            conexion.desconectar();
        
        }catch(SQLException e){
            
            e.printStackTrace();
                
        }
        
        return traduccionCapturada;
    }   //  FUNCIONANDO

    @Override
    public String autocompletarCamposEjemplo(completar_entradas acceso) {
        
        
        String hanzi_buscado = acceso.getjTextField_entrada_completar().getText();
        
        String ejemploCapturado = "";
        
        try{
            
            Connection conectar = conexion.conectar();  // conectamos
            
            //  buscamos en el campo
            PreparedStatement buscando_hanzi = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi = ?;");

            //  seteamos la instancia con el parametro del metodo, que sera el parametro de busqueda tambien
            buscando_hanzi.setString(1, hanzi_buscado);

            //  la consulta en si
            ResultSet consulta = buscando_hanzi.executeQuery();
            
            if(consulta.next()){
                
                //System.out.println("entro en el NEXT ");
                
                if(!consulta.getString("Ejemplo").isEmpty()){
                    
                    ejemploCapturado = consulta.getString("Ejemplo");
                    
                    //System.out.println("entro en el condicional de traduccion");
                    
                }
                
                //System.out.println("ahora traduccionCapturada es " + traduccionCapturada);
                
            }
            
            conexion.desconectar();
        
        }catch(SQLException e){
            
            e.printStackTrace();
                
        }
        
        return ejemploCapturado;
       
    }   //  FUNCIONANDO

    @Override
    public void mostrarTablaCompletar(String mostrar_texto_seleccionado) {
        
        try {

            Connection conectar = conexion.conectar();

            DefaultTableModel modelo = new DefaultTableModel(); //  modelamos la tabla

            busqueda_resultados_completar.setModel(modelo);

            busqueda_resultados_completar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            PreparedStatement seleccion = conectar.prepareStatement("SELECT * FROM hanzi_entrada WHERE Hanzi LIKE ?");

            seleccion.setString(1, "%" + mostrar_texto_seleccionado + "%");

            ResultSet consulta = seleccion.executeQuery();

            ResultSetMetaData datos = consulta.getMetaData();
            int cantidadColumnas = datos.getColumnCount();

            modelo.addColumn("Radical");
            modelo.addColumn("Hanzi");
            modelo.addColumn("Fonetica");
            modelo.addColumn("Traduccion");
            modelo.addColumn("Ejemplo");

            for (int i = 0; i < cantidadColumnas; i++) {

                busqueda_resultados_completar.getColumnModel().getColumn(i);

            }

            while (consulta.next()) {

                Object arreglo[] = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {

                    arreglo[i] = consulta.getObject(i + 1);
                }
                modelo.addRow(arreglo);
            }

            conexion.desconectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
    }
    
    
    
    
    
        
    }
    
    



    
    

