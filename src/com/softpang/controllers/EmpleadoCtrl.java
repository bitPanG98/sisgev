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
package com.softpang.controllers;

import com.softpang.models.EmpleadoDAO;
import com.softpang.utils.DesignJInternal;
import com.softpang.views.FormEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author SoftPanG - Company
 */
public class EmpleadoCtrl {

    private FormEmpleado viewEmpleado = null;
    private EmpleadoDAO empleadoDao = null;
    private DesignJInternal designInternalFrame = null;

    public EmpleadoCtrl() {
    }

    public EmpleadoCtrl(FormEmpleado viewEmpleado, EmpleadoDAO empleadoDao) {
        this.viewEmpleado = viewEmpleado;
        this.empleadoDao = empleadoDao;

        initComponentes();
    }

    private void initComponentes() {
        initEventosComponentes();
    }

    private void initEventosComponentes() {
        initEventoBotones();
        initEventoTeclas();
        initEventoJTree();
    }

    private void initEventoBotones() {

        ActionListener eventActionBoton = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Object identificadorBoton = e.getSource();
                if (identificadorBoton == viewEmpleado.botonGuardar) {

                } else if (identificadorBoton == viewEmpleado.botonModificar) {

                } else if (identificadorBoton == viewEmpleado.botonEliminar) {

                } else if (identificadorBoton == viewEmpleado.botonImprimir) {

                } else if (identificadorBoton == viewEmpleado.botonCerrar) {

                } else if (identificadorBoton == viewEmpleado.checkEstado) {
                    JOptionPane.showMessageDialog(null, "Jola");
                } else {

                }

            }

        };

        this.viewEmpleado.botonGuardar.addActionListener(eventActionBoton);
        this.viewEmpleado.botonModificar.addActionListener(eventActionBoton);
        this.viewEmpleado.botonEliminar.addActionListener(eventActionBoton);
        this.viewEmpleado.botonImprimir.addActionListener(eventActionBoton);
        this.viewEmpleado.botonCerrar.addActionListener(eventActionBoton);
        this.viewEmpleado.checkEstado.addActionListener(eventActionBoton);

    }

    private void initEventoTeclas() {

        KeyListener eventKeyText = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        
        this.viewEmpleado.txtDNI.addKeyListener(eventKeyText);
        this.viewEmpleado.txtNombre.addKeyListener(eventKeyText);
        this.viewEmpleado.txtApellidos.addKeyListener(eventKeyText);
        this.viewEmpleado.txtTelefono.addKeyListener(eventKeyText);
        this.viewEmpleado.txtDireccion.addKeyListener(eventKeyText);
        this.viewEmpleado.txtEmail.addKeyListener(eventKeyText);
    }

    private void initEventoJTree() {

    
    }

}
