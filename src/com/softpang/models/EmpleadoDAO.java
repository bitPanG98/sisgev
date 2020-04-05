/*

 SISGEV v1.0.1 - source code for SISGEV application
 Copyright (C) 2020 softpang

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
    
 Redistribution and use in source and binary forms, with or without modification,
 are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice,
 this list of conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.

 3. Neither the name of the copyright holder nor the names of its contributors
 may be used to endorse or promote products derived from this software without
 specific prior written permission. 

 */
package com.softpang.models;

import com.softpang.models.Empleado;
import com.softpang.models.manager.ManagerDAO;
import com.softpang.utils.Message;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SoftPanG - Company
 */
public class EmpleadoDAO implements ManagerDAO<Empleado> {

    private Connection conn = null;
    private CallableStatement callSta = null;
    private PreparedStatement prepaSta = null;
    private ResultSet resSta = null;

    public EmpleadoDAO() {
    }

    public EmpleadoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String insert(Empleado miEmpleado) {

        String mensaje = null;
        String queryInsert = "INSERT INTO empleado VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            prepaSta = conn.prepareCall(queryInsert);
            prepaSta.setString(1, miEmpleado.getDni());
            prepaSta.setString(2, miEmpleado.getNombres());
            prepaSta.setString(3, miEmpleado.getApellidos());
            prepaSta.setString(4, miEmpleado.getTelefono());
            prepaSta.setString(5, miEmpleado.getDireccion());
            prepaSta.setString(6, miEmpleado.getEmail());
            prepaSta.setBoolean(7, miEmpleado.getEstado());

            prepaSta.executeUpdate();
            conn.commit();

            mensaje = "exito";

        } catch (SQLException ex) {

            mensaje = "[" + String.valueOf(ex.getErrorCode()) + "]->" + ex.getMessage();
            try {
                conn.rollback();
                closeResources();
            } catch (SQLException ex1) {
                closeResources();
            }

        } finally {
            closeResources();
        }

        return mensaje;
    }

    @Override
    public String update(Empleado miEmpleado) {

        String mensaje = null;
        String queryUpdate = "UPDATE empleado "
                + "SET dni=?, nombres=?, apellidos=?, telefono=?, direccion=?, email=?, estado=? "
                + "WHERE codigo_empleado=?";

        try {

            prepaSta = conn.prepareCall(queryUpdate);
            prepaSta.setString(1, miEmpleado.getDni());
            prepaSta.setString(2, miEmpleado.getNombres());
            prepaSta.setString(3, miEmpleado.getApellidos());
            prepaSta.setString(4, miEmpleado.getTelefono());
            prepaSta.setString(5, miEmpleado.getDireccion());
            prepaSta.setString(6, miEmpleado.getEmail());
            prepaSta.setBoolean(7, miEmpleado.getEstado());
            prepaSta.setLong(8, miEmpleado.getCodigoEmpleado());

            prepaSta.executeUpdate();
            conn.commit();

            mensaje = "exito";

        } catch (SQLException ex) {

            mensaje = "[" + String.valueOf(ex.getErrorCode()) + "]->" + ex.getMessage();
            try {
                conn.rollback();
                closeResources();
            } catch (SQLException ex1) {
                closeResources();
            }

        } finally {
            closeResources();
        }

        return mensaje;
    }

    @Override
    public String unsubscribe(Empleado miEmpleado) {

        String mensaje = null;
        String queryUnsubscribe = "UPDATE empleado "
                + "SET estado=? "
                + "WHERE codigo_empleado=?";

        try {

            prepaSta = conn.prepareCall(queryUnsubscribe);
            prepaSta.setBoolean(1, miEmpleado.getEstado());
            prepaSta.setLong(2, miEmpleado.getCodigoEmpleado());

            prepaSta.executeUpdate();
            conn.commit();

            mensaje = "exito";

        } catch (SQLException ex) {

            mensaje = "[" + String.valueOf(ex.getErrorCode()) + "]->" + ex.getMessage();
            try {
                conn.rollback();
                closeResources();
            } catch (SQLException ex1) {
                closeResources();
            }

        } finally {
            closeResources();
        }

        return mensaje;
    }

    @Override
    public ArrayList<Empleado> loadAll(int level) {

        String queryLoadAll = null;
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        switch (level) {
            case 1:
                queryLoadAll = "SELECT * FROM empleado";
                break;

            case 2:
                queryLoadAll = "SELECT * FROM empleado WHERE estado = 1";
                break;

            case 3:
                queryLoadAll = "SELECT * FROM empleado WHERE estado = 0";
                break;

            default:
                queryLoadAll = "SELECT * FROM empleado";
                break;
        }

        try {

            prepaSta = conn.prepareCall(queryLoadAll);
            resSta = prepaSta.executeQuery();

            while (resSta.next()) {
                listaEmpleados.add(new Empleado(resSta.getLong(1), resSta.getString(2),
                        resSta.getString(3), resSta.getString(4), resSta.getString(5),
                        resSta.getString(6), resSta.getString(7), resSta.getBoolean(8)));
            }

        } catch (SQLException ex) {
            System.out.println("-->" + ex);
            closeResources();
        }

        return listaEmpleados;
    }

    @Override
    public ArrayList<Empleado> findBy(String optionFind, String inputFind) {

        String queryLoadAll = null;
        ArrayList<Empleado> listaEmpleados = null;

        try {
            queryLoadAll = "SELECT * FROM empleado WHERE estado = 1";

            prepaSta = conn.prepareCall(queryLoadAll);
            resSta = prepaSta.executeQuery();
            while (resSta.next()) {
                listaEmpleados.add(new Empleado(resSta.getLong(1), resSta.getString(2),
                        resSta.getString(3), resSta.getString(4), resSta.getString(5),
                        resSta.getString(6), resSta.getString(7), resSta.getBoolean(8)));
            }

        } catch (SQLException ex) {
            closeResources();
        }

        return listaEmpleados;

    }

    @Override
    public void setTableArrayList(JTable table, DefaultTableModel modelTable,
            ArrayList<Empleado> miList) {

        int countRows = table.getRowCount();
        for (int i = 0; i < countRows; i++) {
            modelTable.removeRow(0);
        }

        Object registers[] = new Object[8];
        for (Empleado miEmpleado : miList) {

            String mensaje = ""
                    + "<html> "
                    + " <body> "
                    + "     <b style = \" font-size : 12; color :green; text-align:center; \"> "
                    + "" + miEmpleado.getNombres()+" <br> "
                    + "     </b> "
                    + " </body> "
                    + "</html>";
            registers[0] = miEmpleado.getCodigoEmpleado();
            registers[1] = miEmpleado.getDni();
           // registers[2] = miEmpleado.getNombres();
            registers[2] = mensaje;
            registers[3] = miEmpleado.getApellidos()+"\n ed";
            registers[4] = miEmpleado.getTelefono();
            registers[5] = miEmpleado.getDireccion();
            registers[6] = miEmpleado.getEmail();
            registers[7] = (miEmpleado.getEstado()) ? "Activo" : "Inactivo";

            modelTable.addRow(registers);
        }

        table.setModel(modelTable);

    }

    private void closeResources() {
        try {
            if (conn != null) {
                conn.close();
            } else if (callSta != null) {
                callSta.close();
            } else if (prepaSta != null) {
                prepaSta.close();
            } else if (resSta != null) {
                resSta.close();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

}
