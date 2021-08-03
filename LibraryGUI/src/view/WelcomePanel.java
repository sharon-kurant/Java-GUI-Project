package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import Utils.UserSelected;
import Utils.UserType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class WelcomePanel extends JPanel{
	
	private JButton readerBtn;
	private JButton librarianBtn;

	public WelcomePanel() {
		
		setBounds(0, 0, 782, 453);
		setBackground(Color.WHITE);

		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		readerBtn = new JButton("Reader");
		readerBtn.setBounds(335, 248, 115, 25);

		readerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainFrame.welcome2LoginScreen(UserSelected.Reader);
				
			}
		});
		readerBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		readerBtn.setBackground(Color.ORANGE);

		librarianBtn = new JButton("Librarian");
		librarianBtn.setBounds(335, 318, 115, 25);
		
		librarianBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MainFrame.welcome2LoginScreen(UserSelected.Librarian);
				
			}
		});
		
		librarianBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		librarianBtn.setBackground(Color.ORANGE);
		
		JLabel lblSignInAs = new JLabel("Sign in as:");
		lblSignInAs.setBounds(344, 181, 92, 16);
		lblSignInAs.setFont(new Font("Snap ITC", Font.PLAIN, 15));

		JLabel lbladminCanSign = new JLabel("*Admin can sign in from both");
		lbladminCanSign.setBounds(0, 437, 169, 16);
		setLayout(null);
		add(lblSignInAs);
		add(readerBtn);
		add(librarianBtn);
		add(lbladminCanSign);
	}
	
}
