/*
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
package com.softpang.sisgev;

import com.softpang.models.Empleado;
import com.softpang.models.manager.ManagerDataBase;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author SoftPanG
 * @date 04-mar-2020 20:56:40
 *
 */
public class SISGEV {

    public static void main(String[] args) {
        Empleado e = null;

        ManagerDataBase mdb = new ManagerDataBase();
        
        Font font = new Font("Verdana", Font.PLAIN, 10);
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = img.createGraphics();
        FontMetrics metrics = graphics.getFontMetrics(font);
        
        int width = metrics.stringWidth("Hello world!");
        int hth = metrics.stringWidth("Hello world!");
        System.out.println("------ "+width+" -- "+hth);
                    String mensaje = ""
                    + "<html> "
                    + " <body> "
                    + "<b style = \" font-size : 12; color :red; \"> "
                    + " Edinson  <br> Panta Garcia"
                    + "</b> "
                    + " </body> "
                    + "</html>";
                  
        Rectangle2D bounds = metrics.getStringBounds("Hello World \n tg!", null);
        
        int widthInPixels = (int) bounds.getWidth();
        int heightInPixels = (int) bounds.getHeight();
        System.out.println("mm "+widthInPixels);
        System.out.println("mm "+heightInPixels);
        
        Rectangle2D bounds1 = metrics.getStringBounds(mensaje, null);
        int wiPixels = (int) bounds1.getWidth();
        int hePixels = (int) bounds1.getHeight();
        System.out.println("- "+wiPixels+ "  - "+hePixels);
        

    }

}
