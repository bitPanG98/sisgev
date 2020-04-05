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

/**
 *
 * @author SoftPanG - Company
 */
public class Empleado {

    private Long codigoEmpleado = null;
    private String dni = null;
    private String nombres = null;
    private String apellidos = null;
    private String telefono = null;
    private String direccion = null;
    private String email = null;
    private boolean estado = true;

    public Empleado() {

    }
    
    
    public Empleado(Long codigoEmpleado, String dni, String nombres, 
            String apellidos, String telefono, String direccion, 
            String email, boolean estado) {
        this.codigoEmpleado = codigoEmpleado;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
    }
    
    public Empleado(String dni, String nombres, String apellidos,
            String telefono, String direccion, String email, boolean estado) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
    }

    public Empleado(String dni, String nombres, String apellidos,
            String telefono, String direccion, String email, 
            boolean estado, Long codigoEmpleado) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.codigoEmpleado = codigoEmpleado;
    }

    public Long getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(Long codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{"
                + "codigoEmpleado=" + codigoEmpleado
                + ", dni=" + dni
                + ", nombres=" + nombres
                + ", apellidos=" + apellidos
                + ", telefono=" + telefono
                + ", direccion=" + direccion
                + ", email=" + email
                + ", estado=" + estado
                + '}';
    }

}
