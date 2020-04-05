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
import java.awt.Component;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author SoftPanG - Company
 * @description : Esta clase ofrece muchos métodos que son útiles para hacer
 * validaciones a componenetes.
 *
 */
public class Validate {

    /**
     * Establece visualizar lo que se escriba en un JPasswordFIeld.
     *
     * @param inputPassword es el JPasswordFIeld.
     */
    public static void showPassword(JPasswordField inputPassword) {

        char codeAscii = 0;
        inputPassword.setEchoChar(codeAscii);

    }

    /**
     * Establece ocultar lo que se escriba en un JPasswordFIeld, cambiando el
     * caracter ascii a mostrar.
     *
     * @param inputPassword es el JPasswordFIeld.
     */
    public static void hidePassword(JPasswordField inputPassword) {

        char codeAscii = 169;
        inputPassword.setEchoChar(codeAscii);

    }

    /**
     * Establece la longitud de caracteres a escribir en un JTextField.
     *
     * @param inputText es el JTextField a formatear.
     * @param evt evento del teclado [KeyReleased].
     * @param length es la longitud.
     */
    public static void lengthText(JTextField inputText, KeyEvent evt, int length) {

        int lengtInput = inputText.getText().length();
        if (lengtInput >= length) {
            evt.consume();
        }
    }

    /**
     * Verifica si un JTextField esta vacio.
     *
     * @param inputText es el JTextField a formatear.
     * @return true o false.
     */
    public static boolean isEmpty(JTextField inputText) {

        boolean empty = false;

        String valueInput = inputText.getText().trim().replaceAll(" ", "");
        if (valueInput.equals("")) {
            empty = true;
        } else {
            empty = false;
        }

        return empty;
    }

    /**
     * Verifica cuantos componenetes(JTextFields o JPasswordFields) que se
     * encuentran en un contenedor(JPanel) estan vacios.
     *
     * @param container es el contenedor de componentes(JPanel).
     * @return int emptyInputs, cantidad de componentes vacios.
     */
    public static int countInputsEmpty(Container container) {

        int emptyInputs = 0;

        for (Component component : container.getComponents()) {
            if (component instanceof JTextField || component instanceof JPasswordField) {
                String valueInputText = ((JTextField) component).getText().trim().replaceAll(" ", "");
                if (valueInputText.equals("")) {
                    emptyInputs += 1;
                }
            }
        }

        return emptyInputs;
    }

    /**
     * Verifica cuantos componenetes(JComboBoxs) que se encuentran en un
     * contenedor(JPanel) estan en el indice 0.
     *
     * @param container es el contenedor de componentes(JPanel).
     * @return int zeroIndexCombos, cantidad de JComboBoxs.
     */
    public static int countCombosIndexZero(Container container) {

        int zeroIndexCombos = 0;

        for (Component component : container.getComponents()) {
            if (component instanceof JComboBox) {
                int indexCombo = ((JComboBox) component).getSelectedIndex();
                if (indexCombo == 0) {
                    zeroIndexCombos += 1;
                }
            }
        }

        return zeroIndexCombos;
    }

    /**
     * Permite que los componentes(JTexfield o JPasswordField) que se encuentran
     * en un Container(JPanel), cambien su Background y Border si estan vacions
     * o no.
     *
     * @param container es el contenedor de componentes(JPanel).
     *
     */
    public static void paintInputsEmpty(final Container container) {

        for (Component component : container.getComponents()) {

            if (component instanceof JTextField) {

                ((JTextField) component).addFocusListener(new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {

                    }

                    @Override
                    public void focusLost(FocusEvent e) {

                        for (Component component : container.getComponents()) {

                            if (component instanceof JTextField
                                    || component instanceof JPasswordField) {

                                String valueInput = ((JTextField) component).getText().trim().replace(" ", "");
                                if (valueInput.equals("")) {
                                    ((JTextField) component).
                                            setBackground(new Color(255, 153, 153));
                                    ((JTextField) component).
                                            setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));
                                } else {
                                    ((JTextField) component).
                                            setBackground(Color.WHITE);
                                    ((JTextField) component).
                                            setBorder(BorderFactory.createLineBorder(
                                            new java.awt.Color(0, 204, 204), 1, true));
                                }
                            }

                        }

                    }
                });

            }

        }

    }

    /**
     * Establece que todo lo que se escriba en el componente JTextField,
     * JPasswordFIeld sean letras.
     *
     * @param evt el evento que produce al tipear [KeyTyped]
     */
    public static void writeLetters(KeyEvent evt) {

        char caracter = evt.getKeyChar();
        if ((caracter < 'a' || caracter > 'z') && (caracter < 'A' || caracter > 'Z')
                && caracter != evt.VK_SPACE) {
            evt.consume();
            //Toolkit.getDefaultToolkit().beep();
        }

    }

    /**
     * Establece que todo lo que se escriba en el componente JTextField,
     * JPasswordFIeld sean numeros.
     *
     * @param evt el evento que produce al tipear [KeyTyped]
     */
    public static void writeNumbers(KeyEvent evt) {

        char caracter = evt.getKeyChar();
        if (caracter < '0' || caracter > '9') {
            evt.consume();
            //Toolkit.getDefaultToolkit().beep();
        }

    }

    /**
     * Establece que todo lo que se escriba en el componente JTextField sean
     * numeros con un punto decimal.
     *
     * @param evt el evento que produce al tipear [KeyTyped].
     * @param inputText JTextField.
     */
    public static void writeNumberDecimal(KeyEvent evt, JTextField inputText) {

        char entrada = evt.getKeyChar();

        if (((entrada < '0') || (entrada > '9'))
                && (entrada != KeyEvent.VK_BACK_SPACE) && (entrada != '.')) {
            evt.consume();
        }

        if (entrada == '.' && inputText.getText().contains(".")) {
            evt.consume();
        }

    }

    /**
     * Establece que todo lo que se escriba en el componente JTextField sean
     * numeros con un punto decimal.
     *
     * @param evt el evento que produce al tipear [KeyTyped].
     * @param inputText JTextField.
     */
    public static void writeUpperLetters(JTextField inputText, KeyEvent evt) {
        String inputUpper = inputText.getText().toUpperCase();
        inputText.setText(inputUpper);
    }

    public static void clearInputs(Container contenedor) {

        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            }
        }

    }

    public static void resetIndexZeroCombo(Container contenedor) {

        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(0);
            }
        }

    }

    public static boolean successDNI(JTextField txtInputDNI) {

        boolean success = false;
        String inputDNI = txtInputDNI.getText();
        if (inputDNI.replaceAll(" ", "").trim().length() == 8) {
            success = true;
        }

        return success;
    }

    public static boolean successTelefono(JTextField inputTelefono) {

        boolean success = false;
        String valueInput = inputTelefono.getText();
        if (valueInput.replaceAll(" ", "").trim().length() == 9) {
            success = true;
        }

        return success;
    }

    public static boolean successPassword(JPasswordField inputPassword) {

        boolean success = false;
        char[] valueInput = inputPassword.getPassword();
        if (valueInput.length >= 8) {
            success = true;
        }

        return success;
    }

}
