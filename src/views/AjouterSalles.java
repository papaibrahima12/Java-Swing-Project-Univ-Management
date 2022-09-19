package views;
import javax.swing.*;

import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;

import autre.ButtonInfo;
import dao.AdminDAO;
import models.Salle;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * cette classe permet de créer une classe
 */
public class AjouterSalles extends JPanel {
	private final JTextField nom;
	private final JTextField capacite;

	/**
	 * Create the panel.
	 */
	public AjouterSalles() {
		setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(140, Short.MAX_VALUE))
		);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setAutoscrolls(true);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 425, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 212, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel lblNewLabel_1 = new JLabel("Nom Salle :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1_1 = new JLabel("Capacite du salle :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1_2 = new JLabel("Projecteur :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1_3 = new JLabel("Statut  :");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1_4 = new JLabel("Type de salle :");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));

		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD, 15));
		nom.setForeground(new Color(0, 0, 0));
		nom.setColumns(10);

		capacite = new JTextField();
		capacite.setForeground(Color.BLACK);
		capacite.setFont(new Font("Tahoma", Font.BOLD, 15));
		capacite.setColumns(10);

		String[] isExist = {"Oui", "Non"};
		projecteur = new JComboBox<>(isExist);
		projecteur.setBackground(new Color(255, 255, 255));
		projecteur.setFont(new Font("Tahoma", Font.BOLD, 15));
		// TODO Auto-generated method stub
		projecteur.addActionListener(this::jcomboActionPerformed);

		String[] typeSalle = {"TD", "TP", "Conference", "Cours"};
		type = new JComboBox<>(typeSalle);
		type.setForeground(Color.BLACK);
		type.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnNewButton = new JButton("Effacer\r\n");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));

		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jButton2ActionPerformed(e);

			}
		});
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnregistrer.setBackground(new Color(0, 0, 128));

		JButton enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton2ActionPerformed(e);
			}
		});
		enregistrer.setBackground(new Color(0, 0, 128));
		enregistrer.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_2))
//						.addGroup(gl_panel_2.createSequentialGroup()
//								.addContainerGap()
//								.addComponent(lblNewLabel_1_3))
						.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_1_4))
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(capacite, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(projecteur, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
//								.addComponent(isBusy, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(type, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(nom, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(enregistrer)
								.addComponent(btnEnregistrer, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
					)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(capacite, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(projecteur))
//					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
//						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
//						.addComponent(isBusy))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(type))
					.addGap(68)
					.addComponent(enregistrer)
					.addGap(101)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEnregistrer, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel = new JLabel("Ajouter une nouvelle Salle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if( nom.getText().equals("")||capacite.getText().equals("")){
            ButtonInfo bi = new ButtonInfo(new JFrame(), true);
            bi.pan.setBackground(Color.red);
            bi.titre1.setText("Erreur de champs vides");
            bi.titre2.setText("Tous les champs doivent �tre remplis");
            bi.titre3.setText("");
            bi.setVisible(true);
        }else{
			Salle salle = new Salle(nom.getText(),Integer.parseInt(capacite.getText()), Objects.requireNonNull(projecteur.getSelectedItem()).toString(), Objects.requireNonNull(type.getSelectedItem()).toString());
            AdminDAO ad = new AdminDAO();
            ad.ajouterSalle(salle);
            nom.setText("");
            capacite.setText("");
        }

	}
	public void jcomboActionPerformed(ActionEvent e) {

	}

	private final JComboBox<String> projecteur;
	private final JComboBox<String> type;
 }//GEN-LAST:event_jButton1ActionPerformed
	