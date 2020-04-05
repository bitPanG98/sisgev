package com.softpang.utils;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class DesignJInternal {

    /*private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
     private Dimension DimensionBarra = null;*/
    public DesignJInternal() {
    }

    /*------------- METODOS PARA MODIFICAR EL COMPORTAMIENTO DEL JINTERNALFRAME ----------------------*/
    public void quitBarraTitle(JInternalFrame view) {

        ((BasicInternalFrameUI) view.getUI()).setNorthPane(null);

        /*http://www.forosdelweb.com/f45/barra-superior-jinternalframe-935386/*/
        /*Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
         DimensionBarra = Barra.getPreferredSize();
         Barra.setSize(0, 0);
         Barra.setPreferredSize(new Dimension(0, 0));
         repaint();*/
    }

    public void quitBorder(JInternalFrame view) {
        view.setBorder(null);
    }

    public void quitBorder2(JInternalFrame view) {
        /*https://stackoverflow.com/questions/3620970/how-to-remove-the-borders-in-jinternalframe*/
        view.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    public void center(JInternalFrame viewInternal, JDesktopPane desktop) {
        int x = (desktop.getWidth() / 2) - (viewInternal.getWidth() / 2);
        int y = (desktop.getHeight() / 2) - (viewInternal.getHeight() / 2);
        viewInternal.setLocation(x, y);
    }

}
