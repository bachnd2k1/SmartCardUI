package com.mycompany.market;

import javax.swing.JFrame;

/**
 *
 * @author ZZ
 */
public class Main {

    public static HomeForm hf = new HomeForm();
    public static Database connection = new Database();

    public static void main(String[] args) {
        HomeForm cf = new HomeForm();
        JFrame frame = new JFrame("HomeForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the panel to the frame
        frame.getContentPane().add(cf);

        // Set any desired properties or customize the JFrame
        // Pack the components and make the frame visible
        frame.pack();
        frame.setVisible(true);
    }

}
