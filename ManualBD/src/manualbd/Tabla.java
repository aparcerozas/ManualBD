/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manualbd;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aparcerozas
 */
public class Tabla extends javax.swing.JFrame {

    /**
     * Creates new form Tabla
     */
    Metodos m = new Metodos();
    ArrayList<Integer> ids = new ArrayList<>();
    
    //En el constructor, me conecto con la base de datos, crear las tablas alumnos
    //y cursos, añadir filas a la tabla cursos y mostrar filas de alumnos y cursos

    /**
     *
     */
    public Tabla() {
        initComponents();
        m.conectar();
        m.crearTablaCursos();
        m.insertarCursos();
        m.crearTablaAlumnos();
        for(int i=1;i<5;i++){
            String[] curso = m.devolverCurso(i).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
            model.addRow(new Object[]{curso[0], curso[1]});
        }
        insertarAlumnos(1, "Pedro", 7, 1);
        insertarAlumnos(2, "Marta", 6, 3);
        insertarAlumnos(3, "Pedro", 6, 1);
        insertarAlumnos(4, "Jorge", 5, 2);
        insertarAlumnos(5, "Marta", 7, 4);
    }
    
    //Método para vaciar las filas de una tabla del programa, no de la base de datos

    /**
     *
     * @param tabla
     */
    public void borrarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    //Método para insertar filas a la tabla alumnos desde el código

    /**
     *
     * @param id
     * @param nombre
     * @param nota
     * @param curso
     */
    public final void insertarAlumnos(int id, String nombre, int nota, int curso){
        m.insertarAlumno(id, nombre, nota, curso);
        String[] alumno = m.devolverAlumno(id).split(",");
        DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
        model.addRow(new Object[]{alumno[0], alumno[1], alumno[2], m.obtenerNombreCurso(Integer.parseInt(alumno[3]))});
        ids.add(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaA = new javax.swing.JTable();
        bAñadir = new javax.swing.JButton();
        tID = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tNota = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbConsulta = new javax.swing.JComboBox<>();
        tConsulta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bConsulta = new javax.swing.JButton();
        bMostrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bModificar = new javax.swing.JButton();
        tNombreM = new javax.swing.JTextField();
        tNotaM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Nota", "Curso"
            }
        ));
        jScrollPane1.setViewportView(tablaA);

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Nota");

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Nota", "Curso" }));

        jLabel4.setText("Inserción de filas");

        jLabel5.setText("Consulta de filas");

        bConsulta.setText("Consultar");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });

        bMostrar.setText("Mostrar");
        bMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Modificación de filas");

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre");

        jLabel8.setText("Nota");

        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        tablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tablaC);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bModificar)
                .addGap(212, 212, 212)
                .addComponent(bConsulta)
                .addGap(88, 88, 88))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bMostrar)
                            .addComponent(bBorrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tNotaM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(121, 121, 121)))))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(58, 58, 58))
                            .addComponent(tNota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(bAñadir)
                        .addGap(69, 69, 69))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(19, 19, 19)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tNota, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(bMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNotaM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento del botón Borrar, que elimina una fila de la tabla alumnos al seleccionarla
    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        int fila = tablaA.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        }
        else{
            int id = Integer.parseInt(tablaA.getValueAt(fila,0).toString());
            for (int i=0;i<ids.size();i++){
                if(ids.get(i)==id){
                    ids.remove(i);
                }
            }
            m.borrarAlumno(id);
            bMostrarActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    //Evento del botón Modificar, que modifica la fila seleccionada
    //con los datos de dos TextField
    //Se puede modificar el curso si se selecciona en la tabla cursos
    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        int filaA = tablaA.getSelectedRow();
        int filaC = tablaC.getSelectedRow();
        if(filaA == -1){
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        }
        else if (filaC == -1){
            String nombre = tNombreM.getText();
            int nota = Integer.parseInt(tNotaM.getText());
            int id = Integer.parseInt(tablaA.getValueAt(filaA,0).toString());
            m.modificarAlumno(nombre, nota, id);
            bMostrarActionPerformed(evt);
        }
        else{
            String nombre = tNombreM.getText();
            int nota = Integer.parseInt(tNotaM.getText());
            int id = Integer.parseInt(tablaA.getValueAt(filaA,0).toString());
            int curso = Integer.parseInt(tablaC.getValueAt(filaC,0).toString());
            m.modificarAlumnoCurso(nombre, nota, curso, id);
            bMostrarActionPerformed(evt);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    //Evento del botón Mostrar, que muestra todas las filas de la tabla alumnos y cursos
    //Usada para reiniciar la vista de la tabla después de las consultas
    private void bMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarActionPerformed
        borrarTabla(tablaA);
        for (Integer i : ids){
            String[] alumno = m.devolverAlumno(i).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
            model.addRow(new Object[]{alumno[0], alumno[1], alumno[2], m.obtenerNombreCurso(Integer.parseInt(alumno[3]))});
        }
        borrarTabla(tablaC);
        for(int i=1;i<5;i++){
            String[] curso = m.devolverCurso(i).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
            model.addRow(new Object[]{curso[0], curso[1]});
        }
    }//GEN-LAST:event_bMostrarActionPerformed

    //Evento del botón Consultar, que con ayuda de un ComboBox y un TextField
    //le permite buscar filas que tengan un campo específico con un valor específico
    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        borrarTabla(tablaA);
        String opcion = cbConsulta.getSelectedItem().toString();
        Object buscar = tConsulta.getText();
        switch (opcion){
            case "ID": opcion="id";
            break;
            case "Nombre": opcion="nombre";
            break;
            case "Nota": opcion="nota";
            break;
            case "Curso": opcion="curso";
            buscar = m.obtenerIdCurso((String) buscar);
            break;
            default: opcion="nombre";
            break;
        }
        ArrayList<String> alumnos = m.consultaAlumnos(opcion, buscar);
        for(int i=0; i<alumnos.size(); i++){
            int id = Integer.parseInt(alumnos.get(i).split(",")[0]);
            String[] alumno = m.devolverAlumno(id).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
            model.addRow(new Object[]{alumno[0], alumno[1], alumno[2], m.obtenerNombreCurso(Integer.parseInt(alumno[3]))});
        }
    }//GEN-LAST:event_bConsultaActionPerformed

    //Evento del botón Añadir, que inserta una nueva fila en la tabla alumnos
    //usando tres TextField y la tabla cursos para seleccionar el curso
    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        int fila = tablaC.getSelectedRow();
        int id, nota, curso;
        String nombre;
        id = Integer.parseInt(tID.getText());
        nombre = tNombre.getText();
        nota = Integer.parseInt(tNota.getText());
        for (Integer i : ids){
            if(id == i){
                JOptionPane.showMessageDialog(null, "El ID especificado ya existe");
                return;
            }
        }
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un curso");
        } else{
            curso = Integer.parseInt(tablaC.getValueAt(fila,0).toString());
            m.insertarAlumno(id, nombre, nota, curso);
            String[] alumno = m.devolverAlumno(id).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaA.getModel();
            model.addRow(new Object[]{alumno[0], alumno[1], alumno[2], m.obtenerNombreCurso(Integer.parseInt(alumno[3]))});
            ids.add(id);
        }
    }//GEN-LAST:event_bAñadirActionPerformed

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
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bMostrar;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tConsulta;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tNombreM;
    private javax.swing.JTextField tNota;
    private javax.swing.JTextField tNotaM;
    private javax.swing.JTable tablaA;
    private javax.swing.JTable tablaC;
    // End of variables declaration//GEN-END:variables
}
