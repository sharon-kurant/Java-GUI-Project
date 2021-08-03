package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Exceptions.LibrarianNotExistException;
import Exceptions.ReaderNotExistException;
import Model.Librarian;
import Model.LibraryUser;
import Model.Reader;
import Utils.UserSelected;
import javax.swing.border.TitledBorder;

public class LoginPanel extends JPanel {
	
	private JTextField txtId;
	private JPasswordField passwordField;
	private JButton btnSubmit;
	private UserSelected selected;
	private JLabel lblCredentials;
	
	public LoginPanel() {
		setBorder(new TitledBorder(null, "Login user", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setBackground(Color.WHITE);
		setBounds(0, 0, 782, 453);
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(411, 221, 116, 22);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lblName = new JLabel("ID:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(269, 224, 56, 16);
		add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(269, 289, 73, 16);
		add(lblPassword);
		
		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		btnSubmit.setBackground(Color.ORANGE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkIfAdmin()) {
					String pass = String.valueOf(passwordField.getPassword());
					checkCreds(selected, txtId.getText(), pass);

				}
				passwordField.setText("");
				txtId.setText("");
			}
		});
		btnSubmit.setBounds(344, 359, 97, 25);
		add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(411, 287, 116, 22);
		add(passwordField);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.login2WelcomeScreen();
			}
		});
		button.setBounds(12, 16, 56, 25);
		add(button);
		
		lblCredentials = new JLabel("Please enter your credetials");
		lblCredentials.setFont(new Font("Ink Free", Font.BOLD, 18));
		lblCredentials.setBounds(273, 156, 237, 22);
		add(lblCredentials);
	}
	
	//---------Checks user ID and password
	
	protected void checkCreds(UserSelected select, String Id, String pass) {
		try {
			if (MainFrame.getLibrary().checkCreds(selected, Id, pass) instanceof Reader) {
				Reader r = (Reader) MainFrame.getLibrary().checkCreds(selected, Id, pass);
				popWelcomeMessage(Id);
				MainFrame.login2ReaderPanel(r);
			} else if (MainFrame.getLibrary().checkCreds(selected, Id, pass) instanceof Librarian) {
				Librarian l = (Librarian) MainFrame.getLibrary().checkCreds(selected, Id, pass);
				popWelcomeMessage(Id);
				MainFrame.login2AdminControl(selected);
			}
		} catch (ReaderNotExistException e) {
			JOptionPane.showMessageDialog(null, "Can't find reader, check id and password");
		}catch (LibrarianNotExistException e) {
			JOptionPane.showMessageDialog(null, "Can't find librarian, check id and password");
		}
	}
	
	//-------Pops welcome message from checkCreds()
	
	private void popWelcomeMessage(String Id) {
		if (selected.equals(UserSelected.Reader)) {
			try {
				Reader reader = MainFrame.getLibrary().getReaderById(Id);
				JOptionPane.showMessageDialog(null, "Welcome back " + reader.getfName() + " " + reader.getlName());
			} catch (ReaderNotExistException e) { //never gets here
			}
		} if (selected.equals(UserSelected.Librarian)) {
			try {
				Librarian librarian = MainFrame.getLibrary().getLibrarianById(Id);
				JOptionPane.showMessageDialog(null, "Welcome back " + librarian.getfName() + " " + librarian.getlName());
			} catch (LibrarianNotExistException e) {
				JOptionPane.showMessageDialog(null, "Not Welcome back"); //never gets here

			}
		}
		
	}
	
	//---------Sets the user type selected = Reader/Librarian
	//---------Animates the Credentials label to change colors
	
	protected void setUserSelected(UserSelected selected) {
		this.selected = selected;
		setLabeledBorder();
		passwordField.setText("");
		txtId.setText("");
		final AtomicInteger i = new AtomicInteger(0);
		Timer tm = new Timer(750, null);
		tm.addActionListener((e) -> {
			if (i.getAndIncrement()%2 == 0) {
				lblCredentials.setForeground(Color.ORANGE);
			} else lblCredentials.setForeground(Color.BLACK);
            
            if (i.get() >= 10) {
                tm.stop();
            }
        });
        tm.start();
	}
	
	//------Sets labeled borders
	
	private void setLabeledBorder() {
		if (this.selected.equals(UserSelected.Reader)) {
			setBorder(new TitledBorder(null, "Reader Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		if (this.selected.equals(UserSelected.Librarian)) {
			setBorder(new TitledBorder(null, "Librarian Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
	}
	
	//---------Checks if the user input matches the Admin credentials
	
	protected boolean checkIfAdmin() {
		if (String.valueOf(txtId.getText()).equals("Admin") && String.valueOf(passwordField.getPassword()).equals("Admin")) {
			JOptionPane.showMessageDialog(null, "Admin Signed In Successfully");
			MainFrame.login2AdminControl(UserSelected.Admin);
			return true;
		}
		return false;
	}
	
}
