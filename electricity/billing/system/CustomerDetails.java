package electricity.billing.system;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class CustomerDetails extends JFrame implements ActionListener{
   
    JTable table;
    JButton print;
    
    CustomerDetails() {
        super("Customer Details");
        
        setSize(1100,500);
        setLocation(150, 150);
        
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        print = new JButton("Print");
        print.addActionListener(this);
        add(print,"South");
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try {
            table.print();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new CustomerDetails();
    }
}
