/*
 * Class Name : TeacherDao
 * Data Access Object class
 *
 * Version info : ~
 *

 */

// package
package com.sliit.dao;

// imports
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sliit.entity.Subject;
import com.sliit.entity.Teacher;

// class implementation
public class TeacherDao {
    
    // show all
    public static ArrayList<Teacher> getAll() {
        // create the returning list
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher;";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data are taken
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Teacher teacher = new Teacher();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);

                // object is added to the list
                list.add(teacher);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by id
    public static Teacher getById(String pId) {
        // create returning object
        Teacher teacher = new Teacher();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE teacher_id = '" + pId + "';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);
            }

            // return object
            return teacher;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }

    // search by name
    public static ArrayList<Teacher> getByName(String name) {
        // create the returning list
        ArrayList<Teacher> list = new ArrayList<Teacher>();

        try {
            // getting the resultset using CommonDao
            String query = "SELECT * FROM teacher WHERE teacher_f_name LIKE '%" + name + "%' or teacher_l_name LIKE '%" + name + "%';";
            ResultSet rslt = CommonDao.getResultSet(query);

            while (rslt.next()) {
                // column data
                String id = rslt.getString("teacher_id");
                String firstName = rslt.getString("teacher_f_name");
                String lastName = rslt.getString("teacher_l_name");
                String subjectId = rslt.getString("sub_id");
                String email = rslt.getString("t_email");
                String contact = rslt.getString("t_contact");
                String qualification = rslt.getString("qualification");
                String address = rslt.getString("t_address");
                String gender = rslt.getString("gender");

                // using Data Access Objects to create specific objects
                Teacher teacher = new Teacher();
                Subject sub = SubjectDao.getById(subjectId);

                // setters are called
                teacher.setId(id);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setEmail(email);
                teacher.setContact(contact);
                teacher.setQualification(qualification);
                teacher.setSubject(sub);
                teacher.setAddress(address);
                teacher.setGender(gender);

                // add object to ArrayList
                list.add(teacher);
            }

            // return list
            return list;
        } catch (SQLException e) {
            // show error message on JOptionPane
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", 0);
            
            // returns null if the above list is not returned
            return null;
        }
    }
    
    // return the number of added entries
    public static int getAddConfirmation(String id, String fName, String lName, String subject, String email, String contact, String qualification, String address, String gender) {
    	int addedEntries = 0;
    	
    	// getting the number of added entries
    	String query = "INSERT INTO teacher VALUES ('" + id + "', '" + fName + "', '" + lName + "', (SELECT sub_id FROM subject WHERE sub_name = '" + subject + "'),'" + email + "', '" + contact + "', '" + qualification + "', '" + address + "', '" + gender + "');";
    	addedEntries = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return addedEntries;
    }
    
    // return the number of edited entries
    public static int getEditConfirmation(String id, String fName, String lName, String subject, String email, String contact, String qualification, String address, String gender) {
    	int editedEntires = 0;
    	
    	// getting the number of edited entries
    	String query = "UPDATE teacher SET teacher_f_name = '" + fName + "', teacher_l_name = '" + lName + "', sub_id = (SELECT sub_id FROM subject WHERE sub_name = '" + subject + "'), t_email = '" + email + "', t_contact = '" + contact + "', qualification = '" + qualification + "', t_address = '" + address + "', gender = '" + gender + "'  where teacher_id = '" + id + "';";
    	editedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return editedEntires;
    }
    
    // return the number of deleted entries
    public static int getDeleteConfirmation(String pId) {
    	int deletedEntires = 0;
    	
    	// getting the number of deleted entries
    	String query = "DELETE FROM teacher WHERE teacher_id = '" + pId + "';";
    	deletedEntires = CommonDao.getInsertUpdateDeleteStatus(query);
    	
    	return deletedEntires;
    }

}