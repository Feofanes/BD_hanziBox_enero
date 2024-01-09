
package Interfaces;

import Entradas.Hanzi;
import Entradas.Hanzi_molde;
import Entradas.Unidad_final;
import Entradas.Unidad_min;
import bd_hanzibox.completar_entradas;
import bd_hanzibox.procesador_texto;
import bd_hanzibox.ventana_principal;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

public interface Metodos {
        
    //  CRUD BASICO ------------------------------------------------------------
    
    public void agregar(Unidad_final hanzi_agregar);   // funcionalizado
    
    public void borrar(Hanzi hanzi_eliminar, ventana_principal acceso); //  funcionalizado
    
    public void modificar(Unidad_final hanzi); // funcionalizado        , ventana_principal acceso
    
    public void buscar(Hanzi hanzi, ventana_principal acceso);
    
    
    
    //  OPCIONES AVANZADAS  ----------------------------------------------------
    
    public boolean buscarExistencia(Unidad_final hanzi_aCorroborar, ventana_principal acceso);    // funcionalizado
    
    public void mostrarTabla(String columna_busqueda, ventana_principal acceso);  // funcionalizado
    
    public void compararDuplicados(Unidad_final hanzi_aCorroborar);
        
    public int contarInput();   //  funcionalizado
    
    public int contarHanziUnicos();
    
    public String autocompletarRadicales(Unidad_min hanzi_autocompletar);
    
    
    
    //  TABLA SECUNDARIA -------------------------------------------------------
    
    public boolean corroborarSingularidad(Unidad_min hanzi_ingresado);
    
    public void agregarSingularidades(Unidad_min hanzi);
    
    public void compararDuplicados_singular(Unidad_min hanzi_aCorroborar);
    
    public void modificarSingularidad(Unidad_final hanzi);  // se borro , ventana_principal acceso
    
    
    
    //  PROCESADOR DE TEXTO ----------------------------------------------------
    
    public boolean buscarSeleccion(String texto_seleccionado);
    
    public void mostrarTablaProcesador(String mostrar_texto_seleccionado);
    
    public boolean buscarExistenciaProcesador(Unidad_final hanzi_aCorroborar, procesador_texto acceso); 
    
    public void analizadorTexto(JTextPane texto, procesador_texto acceso);
    
    public void aplicarEstiloColor(JTextPane textPane, int start, int length, Color color);
    
    public boolean existeEnBaseDeDatos(Connection conexion, String caracter) throws SQLException;
    
    public boolean quedarseSoloHanzi(String caracter);
    
    public void guardarTexto(String ruta, JTextPane textPane, String titulo, JComboBox<String> biblioteca) throws IOException;
    
    public void completarBiblioteca(JComboBox<String> biblioteca);
    
    public void leyendoBiblioteca(JTextPane textPane, JComboBox<String> biblioteca);
    
    public void editarTextoBiblioteca(JTextPane textPane, JComboBox<String> biblioteca, String titulo_nuevo);
    
    public void eliminarTextoBiblioteca(JComboBox<String> biblioteca, String texto_eliminar);
    
    public String agregarAutoTodosHanzi(JTextPane texto, procesador_texto acceso);
    
    public void copiarTexto(JTextPane texto);
    
    public void pegarTexto(JTextPane texto);
    
    
    
    //  COMPARADORES HSK -------------------------------------------------------
    
    public ArrayList<String> cargarListasHSK(String lista) ; 
    
    public int comparadorHSK(String hsk_comparar);
    
    public boolean mostrarIconLevel(String hskA,String hskB, String hskC);
    
    public boolean mostrarIconLevel_avanzado(String hsk);
    
    
    
    //  COMPLETAR ENTRADAS  ----------------------------------------------------
    
    public ArrayList<String> buscarEntradaIncompleta();
    
    public void autocompletarCombo_completar(JComboBox combo, int posicion_array, completar_entradas acceso);
    
    public void contarHanzi_introducidos(completar_entradas acceso);
    
    public String autocompletarCamposPinyin(completar_entradas acceso);
    
    public String autocompletarCamposTraduccion(completar_entradas acceso);
    
    public String autocompletarCamposEjemplo(completar_entradas acceso);
    
    public void mostrarTablaCompletar(String mostrar_texto_seleccionado);
    
    
}
