package com.jordanlake.GUI;

import java.awt.Dimension;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NewUser extends JFrame {

	private static final long serialVersionUID = -5104754267736656850L;
	JButton submit;
	JTextArea user, password, confirmPassword;
	JPanel newUserPanel = new JPanel();
	File users;

	public NewUser() {
		try {
			users = new File("user&pass.txt");
		} catch (Exception e) {
			System.out.println("File not found");

		}
		//users.
		createView();
		// Sets the name of the window to Click Me
		setTitle("New User");
		// Sets the default close operation aka when you click the X, it will close the
		// program
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// Sets the size of the frame
		// Packs everything into the window
		pack();
		// Make the window open in the center of the screen
		setLocationRelativeTo(null);
		// Sets Resizilbe to false
		setResizable(true);
		// Makes the window visible
		setVisible(true);
	}

	private void createView() {
		getContentPane().add(newUserPanel);
		newUserPanel.setPreferredSize(new Dimension(400, 150));
		JLabel userText = new JLabel("User: ");
		newUserPanel.add(userText);
		user = new JTextArea();
		newUserPanel.add(newUserPanel);
		JLabel passText = new JLabel("Password: ");
		newUserPanel.add(passText);
		password = new JTextArea();
		newUserPanel.add(password);
		JLabel confirmPassText = new JLabel("Please confirm password: ");
		newUserPanel.add()
		
		
		
	}

}
