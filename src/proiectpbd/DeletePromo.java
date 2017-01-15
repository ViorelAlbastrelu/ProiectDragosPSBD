/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectpbd;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author bL0nDu
 */
public class DeletePromo {
   static Container cp=new Container();
   static JLabel label1;
   static JFrame fereastra;
   static JTextField text1;
   static JButton buton1;
   JPanel jp1=new JPanel();
   FerPrinc  promo=new FerPrinc();
Connection conn=null;
PreparedStatement pst=null;
ResultSet rs=null;
Color c=new Color(0,102,153),c1=new Color(255,255,255);

public DeletePromo(){
 conn=promo.javaconnection();
 fereastra=new JFrame("Stergere Promotie");
 cp=fereastra.getContentPane();
 fereastra.setLayout(null);
 cp.setBackground(c);
 

label1=new JLabel("Introduceti Codul Promotiei :");
label1.setBounds(10,50,200,30);
label1.setForeground(c1);
cp.add(label1);

text1=new JTextField("");
text1.setHorizontalAlignment(text1.LEADING);
text1.setBounds(175,50,100,30);
cp.add(text1);

buton1=new JButton("Sterge");
buton1.setBounds(180,100,100,30);
buton1.addActionListener(new DeletePromo.buton());
cp.add(buton1);
       

//fereastra.pack();
fereastra.setSize(300,200);
fereastra.setResizable(false);
fereastra.setLocation(300,150);
fereastra.setVisible(true);
fereastra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
   }
   
public class buton implements ActionListener {

public void actionPerformed(ActionEvent e) {
    try{String sql="delete from promotie where codprom=?";
   pst=conn.prepareStatement(sql);
   pst.setString(1,text1.getText());
   pst.executeUpdate();
   JOptionPane.showMessageDialog(null,"Stergere Reusita!");
       
   }catch(Exception ex){JOptionPane.showMessageDialog(null,ex);}}
}

public static void main(String args[])
    {//new DeletePromo();
    }
    
}
