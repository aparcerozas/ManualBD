/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualbd;

import java.sql.*;

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
    
    public void crearTabla() {
        String url = "jdbc:sqlite:manual.db";
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + "referencia integer PRIMARY KEY,\n"
                + "nome text NOT NULL,\n"
                + "nota integer\n"
                + ");"
                + "DELETE TABLE alumnos;";     
        try (Connection conn = this.conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertar(int referencia, String nome, int nota) {
        String url = "jdbc:sqlite:manual.db";
        String sql = "INSERT INTO alumnos(referencia, nome, nota) VALUES(?,?,?)";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, referencia);
            pstmt.setString(2, nome);
            pstmt.setInt(3, nota);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void consulta(int valor){
        String sql = "SELECT referencia,nome,nota "
        + "FROM alumnos WHERE referencia=?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1,valor);
            ResultSet rs  = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("referencia") +  "\t" + 
                                   rs.getString("nome") + "\t" +
                                   rs.getDouble("nota"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    
    public void borrar(int referencia) {
        String sql = "DELETE FROM alumnos WHERE referencia = ?";
        try (Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, referencia);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
