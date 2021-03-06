package proiectpbd;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class InsertAngajat extends javax.swing.JFrame {
	FerPrinc marca = new FerPrinc();
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Color c = new Color(110, 170, 40);

	/** Creates new form InsertMarca */
	public InsertAngajat() {
		initComponents();
		setTitle("Inserare Angajat");
		conn = marca.javaconnection();
		getContentPane().setBackground(c);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Nume :");

		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("Prenume :");

		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("Adresa :");

		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("Vechime :");

		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Sex :");
		jLabel5.setVisible(false);
		jTextField5.setVisible(false);

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proiectpbd/add.png"))); // NOI18N
		jButton1.setText("Inserare");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(35, 35, 35)
										.addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton1)
														.addGroup(layout.createSequentialGroup().addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel1)
																.addComponent(jLabel2).addComponent(jLabel3)
																.addComponent(jLabel4).addComponent(jLabel5))
																.addGap(22, 22, 22)
																.addGroup(layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(jTextField5)
																		.addComponent(jTextField4)
																		.addComponent(jTextField3)
																		.addComponent(jTextField2)
																		.addComponent(jTextField1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				107, Short.MAX_VALUE))))
										.addContainerGap(40, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(24, 24, 24)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(29, 29, 29).addComponent(jButton1).addContainerGap(63, Short.MAX_VALUE)));

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 288) / 2, (screenSize.height - 362) / 2, 288, 362);
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		try {
			String sql = "insert into masina (codm,marca,model,anfab,comb) values(?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, jTextField1.getText());
			pst.setString(2, jTextField2.getText());
			pst.setString(3, jTextField3.getText());
			pst.setString(4, jTextField4.getText());
			pst.setString(5, jTextField5.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Inserare Reusita!");

			jTextField1.setText("");
			jTextField2.setText("");
			jTextField3.setText("");
			jTextField4.setText("");
			jTextField5.setText("");

			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

		// TODO add your handling code here:
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new InsertAngajat().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	// End of variables declaration//GEN-END:variables
}
