/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class QuantitySelectionForm extends JFrame {

    private Product selectedProduct;
    private JTextField quantityTextField;
    private JButton selectButton;

    private QuantitySelectionListener selectionListener;

    public QuantitySelectionForm(Product selectedProduct, QuantitySelectionListener selectionListener) {
        this.selectedProduct = selectedProduct;
        this.selectionListener = selectionListener;

        quantityTextField = new JTextField(10);
        selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectButtonClicked();
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel productLabel = new JLabel("Product: " + selectedProduct.getName());
        panel.add(productLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(20, 0, 0, 0); // Add top padding of 10 pixels
        panel.add(new JLabel("Quantity:"), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(20, 10, 0, 0);
        panel.add(quantityTextField, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(selectButton, gbc);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void selectButtonClicked() {
        // Set the quantity
        String quantityText = quantityTextField.getText();
//        int quantity = Integer.parseInt(quantityText);
        selectedProduct.setQuantity(quantityText);

        // Call the listener with the selected product
        selectionListener.onQuantitySelected(selectedProduct);

        // Close the form
        dispose();
    }

}
