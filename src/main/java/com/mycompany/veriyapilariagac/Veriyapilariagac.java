/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.veriyapilariagac;

import javax.swing.SwingUtilities;

/**
 *
 * @author Anıl
 */
public class Veriyapilariagac {

    public static void main(String[] args) {
           SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
