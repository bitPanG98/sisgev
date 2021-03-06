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
package com.softpang.models.manager;

import com.softpang.utils.Message;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SoftPanG - Company
 */
public class ConnectionDataBase {
    
    private Connection conn = null;
    private String connector = "com.mysql.jdbc.Driver";
    private String server = "127.0.0.1";
    private String user = "root";
    private String password = "";
    private String database = "sigev";
    private String host = "jdbc:mysql://" + server + ":3306/" + database;
    
    public Connection getConectionDB() {
        
        try {
            
            Class.forName(connector);
            conn = DriverManager.getConnection(host, user, password);
            conn.setAutoCommit(false);
            if (conn != null) {
                Message.showMessageExito("[!] Conexion exitosa " + database + " ..!!");
            }
            
        } catch (ClassNotFoundException ex) {
            Message.showMessageWarning("Debe cargar el driver MYSQL, para establecer la conexion..!!");
        } catch (SQLException ex) {
            Message.showMessageWarning("Ocurrio la siguiente excepcion -> "
                    + "[" + ex.getErrorCode() + "]" + ex.getMessage());
            System.out.println("codigo " + ex.getErrorCode());
        }
        
        return conn;
    }
    
    public void closeConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Ocurrio la siguiente excepcion al cerrar la conexion con la databse");
                ex.printStackTrace();
            }
        }
    }
    
}
