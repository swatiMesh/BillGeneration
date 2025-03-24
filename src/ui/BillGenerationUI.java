package ui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import db.DBConnection;
import models.Product;
import utils.PDFGenerator;
import java.awt.event.*;
import java.util.ArrayList;

public class BillGenerationUI extends JFrame {
    private JTextField nameField, contractField, addressField;
    private JTextField productNameField, quantityField, priceField;
    private JTable table;
    private JLabel totalLabel;
    private DefaultTableModel model;
    private ArrayList<Product> productList = new ArrayList<>();

    public BillGenerationUI() {
        setTitle("Bill Generation");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel buyerLabel = new JLabel("Buyer Details:");
        buyerLabel.setBounds(20, 10, 100, 30);
        add(buyerLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 10, 150, 25);
        add(nameField);

        contractField = new JTextField();
        contractField.setBounds(120, 40, 150, 25);
        add(contractField);

        addressField = new JTextField();
        addressField.setBounds(120, 70, 150, 25);
        add(addressField);

        JButton addProductBtn = new JButton("Add Product");
        addProductBtn.setBounds(20, 110, 120, 30);
        add(addProductBtn);

        JButton generateBillBtn = new JButton("Generate Bill");
        generateBillBtn.setBounds(160, 110, 120, 30);
        add(generateBillBtn);

        String[] columns = { "Product", "Quantity", "Price", "Total" };
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20, 160, 400, 100);
        add(pane);

        totalLabel = new JLabel("Total: 0");
        totalLabel.setBounds(20, 280, 150, 30);
        add(totalLabel);

        addProductBtn.addActionListener(e -> addProduct());
        generateBillBtn.addActionListener(e -> PDFGenerator.generatePDF(nameField.getText(), contractField.getText(), addressField.getText(), productList));
    }

    private void addProduct() {
        String name = productNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        Product product = new Product(name, quantity, price);
        productList.add(product);

        model.addRow(new Object[] { name, quantity, price, product.getTotalPrice() });

        double total = productList.stream().mapToDouble(Product::getTotalPrice).sum();
        totalLabel.setText("Total: " + total);
    }

    public static void main(String[] args) {
        new BillGenerationUI().setVisible(true);
    }
}
