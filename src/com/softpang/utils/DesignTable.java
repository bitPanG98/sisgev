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
package com.softpang.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SoftPanG - Company
 */
public class DesignTable {

    /**
     * Le asigna los titulos de las columnas de la tabla.
     *
     * @param table la tabla
     * @param titles nombres de las columnas
     * @param widths los anchos de las columnas.
     */
    public static void titlesTable(String[] titles, JTable table,
            DefaultTableModel modelTable) {

        modelTable.setColumnIdentifiers(titles);
        table.setModel(modelTable);
    }

    /**
     * Le asigna el ancho de las columnas.
     *
     * @param table la tabla a formatear
     * @param titles nombres de las columnas
     * @param widthsTitles los anchos de las columnas.
     */
    public static void resizingTitles(JTable table,
            String[] titles, int[] widthsTitles) {

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < titles.length; i++) {
            table.getColumn(titles[i]).setPreferredWidth(widthsTitles[i]);
            if (table.getColumnName(i).equals("DNI")
                    || table.getColumnName(i).equals("Telefono")
                    || table.getColumnName(i).equals("Estado")) {
                table.getColumn(titles[i]).setMaxWidth(widthsTitles[i]);
            }
            table.getColumn(titles[i]).setMinWidth(widthsTitles[i]);
        }

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Devuelve el item seleccionado de la tabla
     *
     * @param tabla
     * @return
     */
    public static int getItemSeleccionado(JTable tabla) {

        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento", "Atención", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        int index = tabla.convertRowIndexToModel(filaSeleccionada);
        int id = Integer.parseInt(tabla.getModel().getValueAt(index, 0).toString());

        return id;
    }

    public static void lookTable(JTable table) {

        table.getTableHeader().setBackground(new Color(84, 153, 199));
        table.getTableHeader().setFont(new Font("Times new roman", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.BLACK);

    }

    public static void centrar_datoss(JTable table) {

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        modelocentrar.setBackground(Color.red);
        modelocentrar.setForeground(Color.GRAY);
        table.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);

        table.setRowHeight(35);
        table.setGridColor(Color.gray);

    }

    public static void setAlignCellData(JTable table,
            String align, int column[]) {

        DefaultTableCellRenderer renderDefault = new DefaultTableCellRenderer();

        switch (align) {
            case "center":
                renderDefault.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "rigth":
                renderDefault.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case "left":
                renderDefault.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            default:
                renderDefault.setHorizontalAlignment(SwingConstants.CENTER);
                break;
        }
        try {
            for (int i = 0; i < column.length; i++) {
                table.getColumnModel().getColumn(column[i]).setCellRenderer(renderDefault);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("--> Indice sobre pasa");
        }

    }

    public static void setCellColor(JTable table,
            String color, int column[]) {

        DefaultTableCellRenderer renderDefault = new DefaultTableCellRenderer();
        switch (color) {
            case "center":
                renderDefault.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "rigth":
                renderDefault.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case "left":
                renderDefault.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            default:
                renderDefault.setHorizontalAlignment(SwingConstants.CENTER);
                break;
        }

        table.getColumnModel().getColumn(3).setCellRenderer(renderDefault);

    }
}
