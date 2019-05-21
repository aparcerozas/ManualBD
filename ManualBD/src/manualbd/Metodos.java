/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualbd;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aparcerozas
 */
public class Metodos {
    //Método de conexión a la base de datos, especificando la url

    /**
     *
     * @return
     */
    public Connection conectar() {
        String url = "jdbc:sqlite:manual.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    //Método de creación de la tabla alumnos

    /**
     *
     */
    public void crearTablaAlumnos() {
        String sql1 = "DROP TABLE IF EXISTS alumnos;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "id integer PRIMARY KEY,\n"
                + "nombre text NOT NULL,\n"
                + "nota integer,\n"
                + "curso integer\n"
                + ");";    
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para insertar filas en la tabla alumnos

    /**
     *
     * @param id
     * @param nombre
     * @param nota
     * @param curso
     */
    public void insertarAlumno(int id, String nombre, int nota, int curso) {
        String sql = "INSERT INTO alumnos VALUES(?,?,?,?)";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, nota);
            pstmt.setInt(4, curso);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno registrado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
        }
    }
    
    //Método para modificar el nombre y nota de una fila de la tabla alumnos,
    //especificando el id

    /**
     *
     * @param nome
     * @param nota
     * @param referencia
     */
    public void modificarAlumno(String nome, int nota, int referencia) {
        String sql = "UPDATE alumnos SET nombre = ? , "
                + "nota = ? "
                + "WHERE id = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, nota);
            pstmt.setInt(3, referencia);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para modificar el nombre, nota y curso de una fila de la tabla alumnos,
    //especificando el id

    /**
     *
     * @param nome
     * @param nota
     * @param curso
     * @param referencia
     */
    public void modificarAlumnoCurso(String nome, int nota, int curso, int referencia) {
        String sql = "UPDATE alumnos SET nombre = ? , "
                + "nota = ? , "
                + "curso = ?"
                + "WHERE id = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, nota);
            pstmt.setInt(3, curso);
            pstmt.setInt(4, referencia);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para borrar una fila de la tabla alumnos, especificando el id

    /**
     *
     * @param id
     */
    public void borrarAlumno(int id){
        String sql = "DELETE FROM alumnos WHERE id=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para buscar filas de la tabla alumnos,
    //especificando cualquiera de sus campos
    //Devuelve un ArrayList con todos los campos de las filas

    /**
     *
     * @param campo
     * @param valor
     * @return
     */
    public ArrayList<String> consultaAlumnos(String campo, Object valor){
        ArrayList<String> alumnos = new ArrayList<>();
        String sql = "SELECT id,nombre,nota,curso"
        + " FROM alumnos WHERE " + campo + "=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setObject(1, valor);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                alumnos.add(rs.getInt("id") +  "," + 
                                   rs.getString("nombre") + "," +
                                   rs.getInt("nota") + "," +
                                   rs.getInt("curso"));
            }
            return alumnos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return alumnos;
        }
    }
    
    //Método que devuelve un String con todos los campos de una fila,
    //especificando el id

    /**
     *
     * @param id
     * @return
     */
    public String devolverAlumno(int id){
        String sql = "SELECT id,nombre,nota,curso"
        + " FROM alumnos WHERE id=?";
        String resultado = "";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") +  "," + 
                                   rs.getString("nombre") + "," +
                                   rs.getInt("nota") + "," +
                                   rs.getInt("curso"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    //Método de creación de la tabla cursos

    /**
     *
     */
    public void crearTablaCursos() {
        String sql1 = "DROP TABLE IF EXISTS cursos;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS cursos (\n"
                + "id integer PRIMARY KEY,\n"
                + "nombre text NOT NULL\n"
                + ");";
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para insertar las filas de la tabla cursos
    //La tabla no es modificable y viene con estas filas por defecto

    /**
     *
     */
    public void insertarCursos() {
        String sql1 = "INSERT INTO cursos VALUES(1,'DAM1º');";
        String sql2 = "INSERT INTO cursos VALUES(2,'DAM2º');";
        String sql3 = "INSERT INTO cursos VALUES(3,'ASIR1º');";
        String sql4 = "INSERT INTO cursos VALUES(4,'ASIR2º');";
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método que devuelve el nombre del curso, especificando el id

    /**
     *
     * @param id
     * @return
     */
    public String obtenerCurso(int id){
        String sql = "SELECT nombre FROM cursos where id = ?;";
        String resultado = "";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getString("nombre");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    //Método que devuelve un String con todos los campos de una fila,
    //especificando el id

    /**
     *
     * @param id
     * @return
     */
    public String devolverCurso(int id){
        String sql = "SELECT id,nombre"
        + " FROM cursos WHERE id=?";
        String resultado = "";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") +  "," + 
                                   rs.getString("nombre"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
//    public void crearTabla(String tabla, String palabra, String numero) {
//        String sql1 = "DROP TABLE IF EXISTS " + tabla + ";\n";
//        String sql2 = "CREATE TABLE IF NOT EXISTS " + tabla + " (\n"
//                + "id integer PRIMARY KEY,\n"
//                + palabra + " text NOT NULL,\n"
//                + numero + " integer\n"
//                + ");";    
//        try (Connection conn = this.conectar();
//            Statement stmt = conn.createStatement()) {
//            stmt.execute(sql1);
//            stmt.execute(sql2);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
//    public void insertar(String tabla, int id, String palabra, int numero) {
//        String sql = "INSERT INTO " + tabla + " VALUES(?,?,?)";
//        try (Connection conn = this.conectar();
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.setString(2, palabra);
//            pstmt.setInt(3, numero);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
//    public void borrar(String tabla, int id) {
//        String sql = "DELETE FROM " + tabla + " WHERE id = ?";
//        try (Connection conn = this.conectar();
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }  
    
//    public void consulta(String tabla, int valor, String campo){
//        String sql = "SELECT id," + campo
//        + " FROM " + tabla + " WHERE id=?";
//        try (Connection conn = this.conectar();
//            PreparedStatement pstmt  = conn.prepareStatement(sql)){
//            pstmt.setInt(1,valor);
//            ResultSet rs  = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.println("id: " + rs.getInt("id") +  "\t" + 
//                                   campo + ": " + rs.getString(campo));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
//    public String devolver(String tabla, int id, String campo1, String campo2){
//        String sql = "SELECT id," + campo1 + "," + campo2
//        + " FROM " + tabla + " WHERE id=?";
//        String resultado = "";
//        try (Connection conn = this.conectar();
//            PreparedStatement pstmt  = conn.prepareStatement(sql)){
//            pstmt.setInt(1,id);
//            ResultSet rs  = pstmt.executeQuery();
//            while (rs.next()) {
//                resultado = (rs.getInt("id") +  "," + 
//                                   rs.getString(campo1) + "," +
//                                   rs.getDouble(campo2));
//            }
//            return resultado;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            return resultado;
//        }
//    }
    
    
    
//    public void modificar(String nome, int nota, int referencia) {
//        String sql = "UPDATE alumnos SET nome = ? , "
//                + "nota = ? "
//                + "WHERE referencia = ?";
//        try (Connection conn = this.conectar();
//            PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, nome);
//            pstmt.setInt(2, nota);
//            pstmt.setInt(3, referencia);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
}
