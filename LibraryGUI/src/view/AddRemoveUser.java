package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Exceptions.AuthorAlreadyExistException;
import Exceptions.AuthorNotExistException;
import Exceptions.LibrarianAlreadyExistException;
import Exceptions.LibrarianNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.ReaderNotExistException;
import Model.Author;
import Model.Encyclopedia;
import Model.Librarian;
import Model.Magazine;
import Model.Reader;
import Utils.CollectionType;
import Utils.Topic;
import Utils.UserType;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddRemoveUser extends JPanel{
	
	private JTextField firstNameFieldAdd;
	private JTextField lastNameFieldAdd;
	private JTextField idFieldAdd;
	private JTextField passwordFieldAdd;
	private JLabel lblId;
	private JLabel lblPassword_1;
	private UserType type;
	private JComboBox<Topic> comboBox;
	private JLabel lblTopic;
	private JLabel lblRemoveUser;
	private JLabel lblAddUser;
	private JComboBox<String> comboBoxRemovable;
	private JLabel lblNameRmv;
	
	public AddRemoveUser() {
		setBorder(new TitledBorder(null, "Add/Remove user", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 782, 453);
		setLayout(null);
		
		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		lblAddUser = new JLabel("Add User");
		lblAddUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddUser.setBounds(59, 133, 110, 20);
		add(lblAddUser);
		
		firstNameFieldAdd = new JTextField();
		firstNameFieldAdd.setBounds(147, 184, 126, 22);
		add(firstNameFieldAdd);
		firstNameFieldAdd.setColumns(10);
		
		JLabel lblFName = new JLabel("First Name:");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFName.setBounds(59, 186, 76, 16);
		add(lblFName);
		
		JLabel lblLName = new JLabel("Last Name:");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLName.setBounds(59, 238, 76, 16);
		add(lblLName);
		
		lastNameFieldAdd = new JTextField();
		lastNameFieldAdd.setColumns(10);
		lastNameFieldAdd.setBounds(147, 236, 126, 22);
		add(lastNameFieldAdd);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(59, 284, 56, 16);
		add(lblId);
		
		idFieldAdd = new JTextField();
		idFieldAdd.setColumns(10);
		idFieldAdd.setBounds(147, 282, 126, 22);
		add(idFieldAdd);
		
		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword_1.setBounds(59, 329, 76, 16);
		add(lblPassword_1);
		
		passwordFieldAdd = new JTextField();
		passwordFieldAdd.setColumns(10);
		passwordFieldAdd.setBounds(147, 327, 126, 22);
		add(passwordFieldAdd);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fName = firstNameFieldAdd.getText();
				String lName = lastNameFieldAdd.getText();
				String regexId = "\\d+";
				String regexAlpha = "^[a-zA-Z]+$";
				
				if (type.equals(UserType.Author)) {
					System.out.println(fName.matches(regexAlpha));
					if (!fName.matches(regexAlpha) || !lName.matches(regexAlpha)) {
						JOptionPane.showMessageDialog(null, "Numbers or symbols in your name? Sorry, but that's invalid.");
						return;
					}
					Topic topic = (Topic) comboBox.getSelectedItem();
					Author author = new Author(fName,lName,topic);
					try {
						MainFrame.getLibrary().addAuther(author);
						JOptionPane.showMessageDialog(null, "Author " + author.getfName() + " " + author.getlName() + " added succesfully");
					} catch (AuthorAlreadyExistException e1) {
						JOptionPane.showMessageDialog(null, "Author " + author.getfName() + " " + author.getlName() + " Exists!");
					}
				}
				else {
					String id = idFieldAdd.getText();
					String pass = passwordFieldAdd.getText();
					if (!fName.matches(regexAlpha) || !lName.matches(regexAlpha)) {
						JOptionPane.showMessageDialog(null, "Numbers or symbols in your name? Sorry, but that's invalid.");
						return;
					} else if (!id.matches(regexId)) {
						JOptionPane.showMessageDialog(null, "Please enter numbers in the ID field.");
						return;
					}
					if (type.equals(UserType.Reader)) {
						Reader reader = new Reader(fName,lName,id,pass);
						try {
							MainFrame.getLibrary().addReader(reader);
							JOptionPane.showMessageDialog(null, "Reader " + reader.getfName() + " " + reader.getlName() + " added succesfully");
						} catch (ReaderAlreadyExistException e1) {
							JOptionPane.showMessageDialog(null, "Reader " + reader.getfName() + " " + reader.getlName() + " Exists!");
						}
					} else {
						Librarian librarian = new Librarian(fName,lName,id,pass);
						try {
							MainFrame.getLibrary().addLibrarian(librarian);
							JOptionPane.showMessageDialog(null, "Librarian " + librarian.getfName() + " " + librarian.getlName() + " added succesfully");
						} catch (LibrarianAlreadyExistException e1) {
							JOptionPane.showMessageDialog(null, "Librarian " + librarian.getfName() + " " + librarian.getlName() + " Exists!");
						}
					} 
				}
				MainFrame.save();
				firstNameFieldAdd.setText("");
				lastNameFieldAdd.setText("");
				idFieldAdd.setText("");
				passwordFieldAdd.setText("");
				refreshCombobox();
			}
		});
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.setBounds(176, 381, 97, 25);
		add(btnRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(386, 133, 10, 273);
		add(panel);
		
		lblRemoveUser = new JLabel("Remove User");
		lblRemoveUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoveUser.setBounds(447, 133, 145, 20);
		add(lblRemoveUser);
		
		lblNameRmv = new JLabel("User");
		lblNameRmv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameRmv.setBounds(447, 186, 76, 16);
		add(lblNameRmv);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) comboBoxRemovable.getSelectedItem();
				
				if (type.equals(UserType.Reader)) {
					try {
						MainFrame.getLibrary().removeReader(name);
						MainFrame.save();
						JOptionPane.showMessageDialog(null, "Reader "+name+" removed");
					} catch (ReaderNotExistException e1) {
						JOptionPane.showMessageDialog(null, "Reader "+name+" does'nt exist");
					}
				} else if (type.equals(UserType.Author)) {
					try {
						MainFrame.getLibrary().removeAuthor(name);
						MainFrame.save();
						JOptionPane.showMessageDialog(null, "Author "+name+" removed");
					} catch (AuthorNotExistException e1) {
						JOptionPane.showMessageDialog(null, "Author "+name+ " does'nt exist");
					}
				} else if (type.equals(UserType.Librarian)) {
					try {
						MainFrame.getLibrary().removeLibrarian(name);
						MainFrame.save();
						JOptionPane.showMessageDialog(null, "Librarian "+name+" removed");
					} catch (LibrarianNotExistException e1) {
						JOptionPane.showMessageDialog(null, "Librarian "+name+ " does'nt exist");
					}
				}refreshCombobox();
			}
		});
		btnRemove.setBackground(Color.ORANGE);
		btnRemove.setBounds(568, 381, 97, 25);
		add(btnRemove);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.addRemoveUser2AdminControl();
			}
		});
		button.setBounds(12, 15, 56, 25);
		add(button);
		
		comboBox = new JComboBox<Topic>();
		comboBox.setBackground(Color.ORANGE);
		comboBox.setModel(new DefaultComboBoxModel<Topic>(Topic.values()));
		comboBox.setBounds(147, 282, 116, 22);
		add(comboBox);
		
		lblTopic = new JLabel("Topic:");
		lblTopic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTopic.setBounds(59, 285, 56, 16);
		add(lblTopic);
		
		comboBoxRemovable = new JComboBox<String>();
		comboBoxRemovable.setBackground(Color.ORANGE);
		comboBoxRemovable.setBounds(535, 184, 130, 22);
		add(comboBoxRemovable);
	}

	private void setBorderAndLabelsMethod() {
		String s = "Add/Remove " + this.type;
		setBorder(new TitledBorder(null, s, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblAddUser.setText("Add " + this.type);
		lblRemoveUser.setText("Remove " + this.type);
		lblNameRmv.setText(this.type + ":");
	}
	

	public void setUserType(UserType type) {
		this.type = type;
		setBorderAndLabelsMethod();
		refreshCombobox();
		if (type.equals(UserType.Author)) {
			idFieldAdd.setVisible(false);
			passwordFieldAdd.setVisible(false);
			lblId.setVisible(false);
			lblPassword_1.setVisible(false);
			
			comboBox.setVisible(true);
			lblTopic.setVisible(true);
			
		} else {
			idFieldAdd.setVisible(true);
			passwordFieldAdd.setVisible(true);
			lblId.setVisible(true);
			lblPassword_1.setVisible(true);
			
			comboBox.setVisible(false);
			lblTopic.setVisible(false);
		}
	}
	
	private UserType getUserType() {
		return this.type;
	}
	
	private void refreshCombobox() {
		if (MainFrame.getLibrary().getReaders().size()>=0 && this.type.equals(UserType.Reader)) {
			comboBoxRemovable.removeAllItems();
			for (Reader r : MainFrame.getLibrary().getReaders()) {
				comboBoxRemovable.addItem(r.getfName()+ " " + r.getlName());
			}
		} else if (MainFrame.getLibrary().getAuthors().size()>=0 && this.type.equals(UserType.Author)) {
			comboBoxRemovable.removeAllItems();
			for (Author a : MainFrame.getLibrary().getAuthors()) {
				comboBoxRemovable.addItem(a.getfName()+ " " + a.getlName());
			}
		}else {
			comboBoxRemovable.removeAllItems();
			for (Librarian l : MainFrame.getLibrary().getLibrarians()) {
				comboBoxRemovable.addItem(l.getfName()+ " " + l.getlName());
			}
		}
	}
}
