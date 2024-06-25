/*
 * Class Name : NewSubjectWindow
 * GUI class
 *
 * Version info : ~
 *

 */

// package
package com.sliit.gui.create;

// imports
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.sliit.dao.SubjectDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class implementation
public class NewSubjectWindow implements CreateWindow {

	// properties
	private JFrame frmAddValues;
	private JTextField txtId, txtModule, txtName;
	private JLabel lblHeader, lblId, lblName, lblModules, lblName1, lblName2, lblName3;
	private JButton btnEnterDetails;
	private JTextArea txtResult;
	private JPanel panelLogo, panelLogo2;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public NewSubjectWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		// frame methods
		frmAddValues = new JFrame();
		frmAddValues.setTitle("Add values");
		frmAddValues.setVisible(true);
		frmAddValues.setResizable(false);
		frmAddValues.setBounds(10, 10, 650, 700);
		frmAddValues.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddValues.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmAddValues.setIconImage(img.getImage());
		
        // header
		lblHeader = new JLabel("Add new values to Subject");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblHeader.setBounds(10, 11, 395, 50);
		frmAddValues.getContentPane().add(lblHeader);
		
		// input prompts
		lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblId.setBounds(69, 72, 106, 39);
		frmAddValues.getContentPane().add(lblId);
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblName.setBounds(69, 122, 106, 39);
		frmAddValues.getContentPane().add(lblName);
		
		lblModules = new JLabel("No of Modules :");
		lblModules.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblModules.setBounds(69, 172, 167, 39);
		frmAddValues.getContentPane().add(lblModules);
		
		// enter details button
		btnEnterDetails = new JButton("Enter Details");
		btnEnterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String moduleNum = txtModule.getText();
				
				int addedEntries = SubjectDao.getAddConfirmation(id, name, moduleNum);
				txtResult.setText(addedEntries + " entry/entries added...");
			}
		});
		btnEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnterDetails.setBounds(244, 509, 138, 39);
		frmAddValues.getContentPane().add(btnEnterDetails);
		
		// show results
		txtResult = new JTextArea();
		txtResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtResult.setText("Result...");
		txtResult.setBounds(115, 559, 407, 50);
		frmAddValues.getContentPane().add(txtResult);
		
		// logo
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(534, 0, 100, 100);
		frmAddValues.getContentPane().add(panelLogo);
		
		panelLogo2 = new JPanel();
		panelLogo2.setLayout(null);
		panelLogo2.setBounds(15, 15, 65, 65);
		panelLogo.add(panelLogo2);
		
		lblName1 = new JLabel("Western");
		lblName1.setBounds(2, 0, 46, 14);
		panelLogo2.add(lblName1);
		
		lblName2 = new JLabel("High");
		lblName2.setBounds(2, 11, 46, 14);
		panelLogo2.add(lblName2);
		
		lblName3 = new JLabel("School");
		lblName3.setBounds(2, 25, 46, 14);
		panelLogo2.add(lblName3);
		
		// taking inputs
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(115, 77, 290, 34);
		frmAddValues.getContentPane().add(txtId);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(154, 127, 290, 34);
		frmAddValues.getContentPane().add(txtName);
		
		txtModule = new JTextField();
		txtModule.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtModule.setColumns(10);
		txtModule.setBounds(238, 177, 290, 34);
		frmAddValues.getContentPane().add(txtModule);
	}

}
