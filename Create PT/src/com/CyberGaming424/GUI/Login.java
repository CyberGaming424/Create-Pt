package com.CyberGaming424.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextArea userName, password;
	JButton login, newUser;
	JLabel acceptedOrDenied;
	JPanel panel = new JPanel();
	Scanner sc = new Scanner(System.in);
	ArrayList<String> userNames = new ArrayList<String>();
	ArrayList<String> passwords = new ArrayList<String>();
	boolean accepted;
	private Scanner users;
	int currentUser;


	public void createView(boolean openWindow) {
		if (openWindow == false) {

		} else {
			// Sets the name of the window to Click Me
			setTitle("Cyber Corp. Security");
			// Sets the default close operation aka when you click the X, it will close the
			// program
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			// Sets the size of the frame
			// Packs everything into the window
			
			// Make the window open in the center of the screen
			setLocationRelativeTo(null);
			// Sets Resizilbe to false
			setResizable(true);
			// Makes the window visible
			setVisible(true);

			readFile();

			getContentPane().add(panel);
			panel.setPreferredSize(new Dimension(400, 125));
			JLabel userText = new JLabel("Username: ");
			panel.add(userText);
			userName = new JTextArea();
			userName.setLineWrap(true);
			userName.setWrapStyleWord(true);
			userName.setPreferredSize(new Dimension(90, 20));
			panel.add(userText);
			panel.add(userName);
			JLabel passText = new JLabel("Password: ");
			panel.add(passText);
			password = new JTextArea();
			password.setLineWrap(true);
			password.setWrapStyleWord(true);
			password.setPreferredSize(new Dimension(90, 20));
			panel.add(password);
			login = new JButton("Submit");
			login.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					userCheck();
				}

			});
			newUser = new JButton("New User");
			newUser.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					NewUser addUser = new NewUser();
				}

			});
			panel.add(login);
			panel.add(newUser);
			acceptedOrDenied = new JLabel("Please enter you Username and password");
			panel.add(acceptedOrDenied);
			pack();
		}

	}

	void readFile() {
		try {
			users = new Scanner(new File("user&pass.txt"));
		} catch (Exception e) {
			System.out.println("File not found");

		}
		int step = 1;
		int index = 0;
		while (users.hasNext()) {
			switch (step) {
			case 1:
				if (!(userNames.isEmpty()) && users.next().equals(userNames.get(index))) {
					index++;
					step = 2;
					break;
				} else {
					userNames.add(users.next());
					step = 2;
					break;
				}
			case 2:
				if (!(passwords.isEmpty()) && users.next().equals(passwords.get(index))) {
					index++;
					step = 1;
					break;
				} else {
					passwords.add(users.next());
					step = 1;
					break;
				}
			}
		}

	}

	void userCheck() {
		String in = userName.getText();
		for (String users : userNames) {
			if (in.equals(users)) {
				currentUser = userNames.indexOf(users);
				passCheck();
			}

		}

	}

	void passCheck() {
		String in = password.getText();

		if (in.equals(passwords.get(currentUser))) {
			acceptedOrDenied.setText("Accepted!");

		} else {
			acceptedOrDenied.setText("Denied!");
		}

		panel.add(acceptedOrDenied);
	}

	void newUser() {
		JFrame newUser = new JFrame();
		JPanel panel = new JPanel();
		newUser.add(panel);
		newUser.setTitle("New User");
		newUser.setVisible(true);
		newUser.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// newUser.

	}

}
