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
    
    public void crearTabla(String tabla, String palabra, String numero) {
        String sql1 = "DROP TABLE IF EXISTS " + tabla + ";\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS " + tabla + " (\n"
                + "id integer PRIMARY KEY,\n"
                + palabra + " text NOT NULL,\n"
                + numero + " integer\n"
                + ");";    
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void crearTablaAlumnos() {
        String sql1 = "DROP TABLE IF EXISTS alumnos;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "id integer PRIMARY KEY,\n"
                + "nombre text NOT NULL,\n"
                + "nota integer\n"
                + ");";    
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertar(String tabla, int id, String palabra, int numero) {
        String sql = "INSERT INTO " + tabla + " VALUES(?,?,?)";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, palabra);
            pstmt.setInt(3, numero);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertarEnAlumnos(int id, String nombre, int nota) {
        String sql = "INSERT INTO alumnos VALUES(?,?,?)";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.setInt(3, nota);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno registrado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
        }
    }
    
    public void borrar(String tabla, int id) {
        String sql = "DELETE FROM " + tabla + " WHERE id = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Integer> borrarAlumnos(String campo, Object valor){
        ArrayList<Integer> alumnos = new ArrayList<>();
        String sql1 = "SELECT id FROM alumnos WHERE " + campo + "=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql1)){
            pstmt.setObject(1, valor);
            pstmt.executeUpdate();
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                alumnos.add(rs.getInt("id"));
            }
            return alumnos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            String sql2 = "DELETE FROM alumnos WHERE " + campo + "=?";
            try (Connection conn = this.conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                pstmt.setObject(1, valor);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return alumnos;
        }
    }
    
    public void consulta(String tabla, int valor, String campo){
        String sql = "SELECT id," + campo
        + " FROM " + tabla + " WHERE id=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,valor);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") +  "\t" + 
                                   campo + ": " + rs.getString(campo));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> consultaAlumnos(String campo, Object valor){
        ArrayList<String> alumnos = new ArrayList<>();
        String sql = "SELECT id,nombre,nota"
        + " FROM alumnos WHERE " + campo + "=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setObject(1, valor);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                alumnos.add(rs.getInt("id") +  "," + 
                                   rs.getString("nombre") + "," +
                                   rs.getDouble("nota"));
            }
            return alumnos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return alumnos;
        }
    }
    
    public String devolver(String tabla, int id, String campo1, String campo2){
        String sql = "SELECT id," + campo1 + "," + campo2
        + " FROM " + tabla + " WHERE id=?";
        String resultado = "";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") +  "," + 
                                   rs.getString(campo1) + "," +
                                   rs.getDouble(campo2));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public String devolverAlumno(int id){
        String sql = "SELECT id,nombre,nota"
        + " FROM alumnos WHERE id=?";
        String resultado = "";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") +  "," + 
                                   rs.getString("nombre") + "," +
                                   rs.getDouble("nota"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
    
    public void modificar(String nome, int nota, int referencia) {
        String sql = "UPDATE alumnos SET nome = ? , "
                + "nota = ? "
                + "WHERE referencia = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, nota);
            pstmt.setInt(3, referencia);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
