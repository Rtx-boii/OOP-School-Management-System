/*
 * Class Name : ExaminationWindow
 * GUI class
 *
 * Version info : ~
 *

 */

// package
package com.sliit.gui.general;

// imports
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sliit.dao.ExaminationDao;
import com.sliit.entity.Examination;
import com.sliit.entity.User;
import com.sliit.gui.create.NewExaminationWindow;
import com.sliit.gui.update.EditExaminationWindow;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;

// class implementation
public class ExaminationWindow implements EntityWindow {

	// properties
	private JFrame frmExamination;
	private JTextField txtEnterTheValue;
	private JLabel lblEntity, lblName, lblAccType, lblEdit, lblName1, lblName2, lblName3;
	private JButton btnDashboard, btnClassroom, btnUser, btnPrincipal, btnStudent, btnTeacher, btnSearch, btnEditDetails, btnDeleteEntries, btnSubject, btnAddExam, btnRefresh, btnLaboratory;
	private JComboBox<String> comboBoxSelect;
	private JPanel panelLogo, panelLogo2, panel;
	private Vector<String> columnNames;
	private ArrayList<Examination> itemList;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private ImageIcon img;

	/**
	 * Create the application.
	 */
	public ExaminationWindow(User user) {
		initialize(user);
		
		// column names
		columnNames = new Vector<>();
        columnNames.add("Examination ID");
        columnNames.add("Subject Name");
        columnNames.add("Exam Type");
        columnNames.add("Duration");

        // create table model
        model = new DefaultTableModel(columnNames, 0) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };

        // create table and scroll pane
        table = new JTable(model);
        scrollPane = new JScrollPane(table);

        // showing items of the table
		itemList = ExaminationDao.getAll();
		try {
			getTable(itemList);
		} catch (Exception exp) {
			JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(User user) {
		// frame methods
		frmExamination = new JFrame();
		frmExamination.setTitle("School Information Management System");
		frmExamination.setVisible(true);
		frmExamination.setResizable(false);
		frmExamination.setBounds(10, 10, 1080, 720);
		frmExamination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExamination.getContentPane().setLayout(null);
		
		// icon
		img = new ImageIcon("src/logo.png");
        frmExamination.setIconImage(img.getImage());
		
        // header
		lblEntity = new JLabel("Examination");
		lblEntity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblEntity.setBounds(133, 36, 198, 48);
		frmExamination.getContentPane().add(lblEntity);
		
		// dashboard button
		btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DashboardWindow(user);
				frmExamination.dispose();
			}
		});
		btnDashboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDashboard.setBounds(10, 127, 181, 48);
		frmExamination.getContentPane().add(btnDashboard);
		
		// access other entity windows
		btnClassroom = new JButton("Classroom");
		btnClassroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassroomWindow(user);
				frmExamination.dispose();
			}
		});
		btnClassroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClassroom.setBounds(10, 257, 181, 48);
		frmExamination.getContentPane().add(btnClassroom);
		
		btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWindow(user);
				frmExamination.dispose();
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUser.setBounds(10, 316, 181, 48);
		frmExamination.getContentPane().add(btnUser);
		
		btnLaboratory = new JButton("Laboratory");
		btnLaboratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LaboratoryWindow(user);
				frmExamination.dispose();
			}
		});
		btnLaboratory.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLaboratory.setBounds(10, 375, 181, 48);
		frmExamination.getContentPane().add(btnLaboratory);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrincipalWindow(user);
				frmExamination.dispose();
			}
		});
		btnPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrincipal.setBounds(10, 434, 181, 48);
		frmExamination.getContentPane().add(btnPrincipal);
		
		btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentWindow(user);
				frmExamination.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setBounds(10, 493, 181, 48);
		frmExamination.getContentPane().add(btnStudent);
		
		btnSubject = new JButton("Subject");
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SubjectWindow(user);
				frmExamination.dispose();
			}
		});
		btnSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubject.setBounds(10, 552, 181, 48);
		frmExamination.getContentPane().add(btnSubject);
		
		btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherWindow(user);
				frmExamination.dispose();
			}
		});
		btnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTeacher.setBounds(10, 611, 181, 48);
		frmExamination.getContentPane().add(btnTeacher);
		
		// search input
		txtEnterTheValue = new JTextField();
		txtEnterTheValue.setToolTipText("Search ...");
		txtEnterTheValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterTheValue.setBounds(241, 127, 404, 48);
		frmExamination.getContentPane().add(txtEnterTheValue);
		txtEnterTheValue.setColumns(10);
		
		// select search criteria
		comboBoxSelect = new JComboBox<String>();
		comboBoxSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxSelect.addItem("ID");
		comboBoxSelect.addItem("Type");
		comboBoxSelect.setToolTipText("Select an option ...");
		comboBoxSelect.setName("");
		comboBoxSelect.setBounds(662, 127, 155, 48);
		frmExamination.getContentPane().add(comboBoxSelect);
		
		// search button
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = comboBoxSelect.getSelectedIndex();
				String searchInput = txtEnterTheValue.getText();
				
				if (searchInput.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text to search!", "Error", 0);
				} else {
					if (selectedItem == 0) {
						Examination exam = ExaminationDao.getById(searchInput);

						try {
							getTable(exam);
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
						}
					} else {
						itemList = ExaminationDao.getByType(searchInput);
						
						try {
							getTable(itemList);
						} catch (Exception exp) {
							JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
						}
					}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(827, 127, 199, 48);
		frmExamination.getContentPane().add(btnSearch);
		
		// user info
		lblName = new JLabel("User Name : " + user.getName());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(690, 11, 253, 37);
		frmExamination.getContentPane().add(lblName);
		
		lblAccType = new JLabel("Account type : " + user.getAccountType());
		lblAccType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccType.setBounds(690, 49, 253, 37);
		frmExamination.getContentPane().add(lblAccType);
		
		// edit
		lblEdit = new JLabel("Edit :");
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEdit.setBounds(241, 204, 63, 37);
		frmExamination.getContentPane().add(lblEdit);
		
		// add button
		btnAddExam = new JButton("Add Examination");
		btnAddExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewExaminationWindow();
			}
		});
		btnAddExam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddExam.setBounds(302, 198, 199, 48);
		frmExamination.getContentPane().add(btnAddExam);
		
		// edit button
		btnEditDetails = new JButton("Edit Details");
		btnEditDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditExaminationWindow(itemList);
			}
		});
		btnEditDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditDetails.setBounds(572, 198, 199, 48);
		frmExamination.getContentPane().add(btnEditDetails);
		
		// delete button
		btnDeleteEntries = new JButton("Delete Entries");
		btnDeleteEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// confirm prompt
				int input = JOptionPane.showConfirmDialog(null, "Confirm Deletion?\\n(Warning : Edit references before deleting!)", "Delete Entries", 0);
				int deletedRowCount = 0;

				// if input is yes
				if (input == 0) {
					// delete the rows inside table model
					for (int row=0; row<model.getRowCount(); row++) {
						String idValue = (String) model.getValueAt(row, 0);
						deletedRowCount += ExaminationDao.getDeleteConfirmation(idValue);
					}
					
					// display the number of deleted entries
					JOptionPane.showMessageDialog(null, "Number of rows deleted : " + deletedRowCount, "Deletion Confirmation", 1);
				}
			}
		});
		btnDeleteEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteEntries.setBounds(827, 198, 199, 48);
		frmExamination.getContentPane().add(btnDeleteEntries);
		
		// logo
		panelLogo = new JPanel();
		panelLogo.setLayout(null);
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBounds(10, 7, 100, 100);
		frmExamination.getContentPane().add(panelLogo);
		
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
		
		// refresh button
		btnRefresh = new JButton("Load/Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList = ExaminationDao.getAll();
				
				try {
					getTable(itemList);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(null, "Error : No results found!", "Error", 0);
				}
			}
		});
		btnRefresh.setBounds(341, 51, 110, 33);
		frmExamination.getContentPane().add(btnRefresh);
	}
	
	// retrieve table method for many items
	public <E> void getTable(ArrayList<E> itemList) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmExamination.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add items in list to rows
        for (E item : itemList) {
            Vector<String> row = new Vector<>();
            row.add(((Examination) item).getId());
            row.add(((Examination) item).getSubject().getName());
            row.add(((Examination) item).getExamType());
            row.add(String.valueOf(((Examination) item).getDuration()));

            // add row to table model
            model.addRow(row);
        }
	}
	
	// retrieve table method for one item
	public void getTable(Examination exam) {
		// panel to display table
		panel = new JPanel();
		panel.setBounds(240, 257, 786, 402);
		frmExamination.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// set row count as 0 and add scroll pane
		model.setRowCount(0);
        panel.add(scrollPane, BorderLayout.CENTER);

        // add info in object to row
        Vector<String> row = new Vector<>();
        row.add(exam.getId());
        row.add(exam.getSubject().getName());
        row.add(exam.getExamType());
        row.add(String.valueOf(exam.getDuration()));

        // add row to table model
        model.addRow(row);
	}

}
