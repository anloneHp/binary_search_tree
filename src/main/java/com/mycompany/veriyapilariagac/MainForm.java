/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veriyapilariagac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anıl
 */
public class MainForm extends JFrame {

    private BinarySearchTree bst;
    private JTextField inputField, searchField, minField, maxField, traversalField;
    private JPanel treePanel;
    private List<JLabel> labels;

    public MainForm() {
        bst = new BinarySearchTree();
        labels = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("İkili Arama Ağacı");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(5);
        searchField = new JTextField(5);
        minField = new JTextField(5);
        maxField = new JTextField(5);
        traversalField = new JTextField(20);

        JButton addButton = new JButton("Ekle");
        JButton searchButton = new JButton("Ara");
        JButton minButton = new JButton("Min Bul");
        JButton maxButton = new JButton("Max Bul");
        JButton inorderButton = new JButton("InOrder");
        JButton preorderButton = new JButton("PreOrder");
        JButton postorderButton = new JButton("PostOrder");

        inputPanel.add(new JLabel("Sayı:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);
        inputPanel.add(new JLabel("Arama:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);
        inputPanel.add(new JLabel("Min:"));
        inputPanel.add(minField);
        inputPanel.add(minButton);
        inputPanel.add(new JLabel("Max:"));
        inputPanel.add(maxField);
        inputPanel.add(maxButton);

        JPanel traversalPanel = new JPanel(new FlowLayout());
        traversalPanel.add(preorderButton);
        traversalPanel.add(inorderButton);
        traversalPanel.add(postorderButton);
        traversalPanel.add(new JLabel("Dolaşma:"));
        traversalPanel.add(traversalField);

        treePanel = new JPanel();
        treePanel.setPreferredSize(new Dimension(800, 300));
        treePanel.setLayout(null);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(treePanel, BorderLayout.CENTER);
        mainPanel.add(traversalPanel, BorderLayout.SOUTH);

        add(mainPanel);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(inputField.getText());
                bst.insert(value);
                displayTree();
                inputField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(searchField.getText());
                boolean found = bst.search(value);
                treePath(found);
                searchField.setText("");
            }
        });

        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = bst.findMin();
                minField.setText(String.valueOf(min));
            }
        });

        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int max = bst.findMax();
                maxField.setText(String.valueOf(max));
            }
        });

        inorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> result = new ArrayList<>();
                bst.inorder(result);
                traversalField.setText(result.toString());
            }
        });

        preorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> result = new ArrayList<>();
                bst.preorder(result);
                traversalField.setText(result.toString());
            }
        });

        postorderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> result = new ArrayList<>();
                bst.postorder(result);
                traversalField.setText(result.toString());
            }
        });
    }

    private void displayTree() {
        treePanel.removeAll();
        labels.clear();
        drawNode(bst.getRoot(), 400, 30, 200);
        treePanel.revalidate();
        treePanel.repaint();
    }

    private void drawNode(TreeNode node, int x, int y, int gap) {
        if (node == null) return;

        JLabel label = new JLabel(String.valueOf(node.value));
        label.setBounds(x, y, 40, 30);
        labels.add(label);
        treePanel.add(label);

        if (node.left != null) {
            drawNode(node.left, x - gap, y + 50, gap / 2);
        }

        if (node.right != null) {
            drawNode(node.right, x + gap, y + 50, gap / 2);
        }
    }

    private void treePath(boolean found) {
        if (!found) {
            JOptionPane.showMessageDialog(this, "Eleman bulunamadı.");
            return;
        }

        for (JLabel label : labels) {
            label.setForeground(Color.BLACK);
        }

        for (TreeNode node : bst.getPath()) {
            for (JLabel label : labels) {
                if (label.getText().equals(String.valueOf(node.value))) {
                    label.setForeground(Color.RED);
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Eleman bulundu.");
    }
    
}
