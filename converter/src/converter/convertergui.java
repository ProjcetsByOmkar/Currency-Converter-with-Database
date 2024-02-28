package converter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
//import javax.swing.table.DefaultTableModel;


public class convertergui {
	
	 public static void main(String[] args) throws Exception {
		
		final JFrame f = new JFrame("My Java Frame");
		
		JLabel L = new JLabel("Enter the number: ");
		
		final JTextField t = new JTextField("");
		
		JButton b = new JButton("Dollar to Rupee");
		
		JButton b1 = new JButton("Rupee to Dollar");
		
		JButton b2 = new JButton("Clear logs");
		
//		JButton b3 = new JButton("Show logs");
		
		final JLabel l = new JLabel("This is were the output will be displayed.");
		
		JPanel p = new JPanel();
		
		f.setVisible(true);
		
		f.setSize(700,700);
		
		f.setResizable(true);
		
		f.add(p);
		
		p.setBounds(70,350,500,200);
		
		f.add(t);
		
		L.setBounds(70,50,200,50);
		
		f.add(L);
		
		t.setBounds(180,50,200,50);
		
		f.add(b);
		
		b.setBounds(70,150,200,50);
		
		f.add(b1);
		
		b1.setBounds(300,150, 200, 50);
		
		b2.setBounds(70,250, 200, 50);
		
//		b3.setBounds(300,250, 200, 50);
		
		f.add(b2);
		
//		f.add(b3);
		
		p.add(l);
		
		p.setVisible(true);
		
		p.setBackground(Color.gray);
		
		f.setLayout(null);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in = t.getText();
				
				double amt = Double.parseDouble(in);
				
				l.setText(amt+" Dollar to Rupee is "+amt*80+" Rupee.");
				
				try {
					String name = l.getText();
					
					Class.forName("org.postgresql.Driver");
					Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Calculator","postgres","Omkar123");
					
					String sql = "Insert into logs(conv) values ('"+ name +"');";
					PreparedStatement statement = connect.prepareStatement(sql);
					statement.executeUpdate();
					t.setText("");
					
					connect.close();
					
				}
				catch(Exception h) {
					System.out.println(h.toString());
				}
				
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String in = t.getText();
				
				double amt = Double.parseDouble(in);
				
				l.setText(amt+" Rupee to Dollar is "+ amt/80 +" Dollar");
				
				try {
					String name = l.getText();
					
					Class.forName("org.postgresql.Driver");
					Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Calculator","postgres","Omkar123");
					
					String sql = "Insert into logs(conv) values ('"+ name +"');";
					PreparedStatement statement = connect.prepareStatement(sql);
					statement.executeUpdate();
					t.setText("");
					
					connect.close();
					
				}
				catch(Exception h) {
					System.out.println(h.toString());
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Calculator","postgres","Omkar123");
					
					String sql = "Delete from logs;";
					PreparedStatement statement = connect.prepareStatement(sql);
					statement.executeUpdate();
					t.setText("");
					
					connect.close();
					
				}
				catch(Exception h) {
					System.out.println(h.toString());
				}
			}
		});
//		b3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JTable jt = new JTable();
//				JPanel p1 = new JPanel();
//				f.add(p1);
//				p1.setVisible(true);
//				p1.setBounds(70,350,500,200);
//				p1.setBackground(Color.gray);
//				p1.add(jt);
//				
//				
//				try {
//					Class.forName("org.postgresql.Driver");
//					Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Calculator","postgres","Omkar123");
//					
//					Statement stmt = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
//					ResultSet rs = stmt.executeQuery("Select * from logs");
//					rs.next();
//					t.setText("");
//					ResultSetMetaData rsmd = rs.getMetaData();
//					int columnsNumber = rsmd.getColumnCount();
//					while (rs.next()) {
//					    for (int i = 1; i <= columnsNumber; i++) {
//					        if (i > 1) System.out.print(",  ");
//					        String columnValue = rs.getString(i);
//					        System.out.print(columnValue + " " );
//					        System.out.println("");
//						    String tbdata[] = {columnValue};
//						    DefaultTableModel model = (DefaultTableModel) jt.getModel();
//						    model.addRow(tbdata);
//					    }
////					    String column = rs.getString(1);
//					}
//					
//					connect.close();
//				}
//				catch(Exception h) {
//					System.out.println(h.toString());
//				}
//			}
//		});
	 }

}
