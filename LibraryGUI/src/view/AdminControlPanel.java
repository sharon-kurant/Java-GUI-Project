package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import Utils.CollectionType;
import Utils.ItemType;
import Utils.UserSelected;
import Utils.UserType;

import javax.swing.event.ListSelectionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class AdminControlPanel extends JPanel{
	
	private UserSelected selected;
	private JButton readerModBtn;
	private JButton authorModBtn;
	private JButton librarianModBtn;
	private JButton bookModBtn;
	private JButton paperModBtn;
	private JButton encyclopediaModBtn;
	private JButton magazineModBtn;
	private JButton btnQueryGenerator;
	
	public AdminControlPanel() {
		setBorder(new TitledBorder(null, "Admin Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setToolTipText("");
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 782, 453);
		setLayout(null);
		
		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		readerModBtn = new JButton("Reader");
		readerModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveUser(UserType.Reader);
			}
		});
		readerModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		readerModBtn.setBackground(Color.ORANGE);
		readerModBtn.setBounds(66, 192, 130, 65);
		add(readerModBtn);
		
		authorModBtn = new JButton("Author");
		authorModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveUser(UserType.Author);
			}
		});
		authorModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		authorModBtn.setBackground(Color.ORANGE);
		authorModBtn.setBounds(66, 270, 130, 62);
		add(authorModBtn);
		
		librarianModBtn = new JButton("Librarian");
		librarianModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveUser(UserType.Librarian);
			}
		});
		librarianModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		librarianModBtn.setBackground(Color.ORANGE);
		librarianModBtn.setBounds(66, 345, 130, 65);
		add(librarianModBtn);
		
		bookModBtn = new JButton("Book");
		bookModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveItem(ItemType.Book);
			}
		});
		bookModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		bookModBtn.setBackground(Color.ORANGE);
		bookModBtn.setBounds(325, 192, 130, 65);
		add(bookModBtn);
		
		paperModBtn = new JButton("Paper");
		paperModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveItem(ItemType.Paper);
			}
		});
		paperModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		paperModBtn.setBackground(Color.ORANGE);
		paperModBtn.setBounds(325, 270, 130, 62);
		add(paperModBtn);
		
		encyclopediaModBtn = new JButton("Encyclopedia");
		encyclopediaModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveCollection(CollectionType.Encyclopedia);
			}
		});
		encyclopediaModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		encyclopediaModBtn.setBackground(Color.ORANGE);
		encyclopediaModBtn.setBounds(586, 192, 130, 65);
		add(encyclopediaModBtn);
		
		magazineModBtn = new JButton("Magazine");
		magazineModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2AddRemoveCollection(CollectionType.Magazine);
			}
		});
		magazineModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		magazineModBtn.setBackground(Color.ORANGE);
		magazineModBtn.setBounds(586, 270, 130, 62);
		add(magazineModBtn);
		
		JLabel lblCall2Action = new JLabel("Select the Object you want to Add/Remove");
		lblCall2Action.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCall2Action.setBounds(235, 126, 313, 25);
		add(lblCall2Action);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.adminControl2Login();
			}
		});
		button.setBounds(12, 15, 56, 25);
		add(button);
		
		btnQueryGenerator = new JButton("Query Generator 3000");
		btnQueryGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.adminControl2QueriesPanel();
			}
		});
		btnQueryGenerator.setFont(new Font("Stencil", Font.BOLD, 20));
		btnQueryGenerator.setBackground(new Color(64, 224, 208));
		btnQueryGenerator.setBounds(325, 348, 391, 62);
		add(btnQueryGenerator);
		
		JLabel lblOrGoOut = new JLabel("Or go to our brand new Query Generator 3000");
		lblOrGoOut.setEnabled(false);
		lblOrGoOut.setForeground(new Color(64, 224, 208));
		lblOrGoOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrGoOut.setBounds(240, 149, 301, 25);
		add(lblOrGoOut);
	}
	
	public void setUserSelected(UserSelected selected) {
		this.selected = selected;
		if (selected.equals(UserSelected.Admin)) {
			btnQueryGenerator.setBounds(325, 348, 391, 62);
			authorModBtn.setVisible(true);
			bookModBtn.setVisible(true);
			encyclopediaModBtn.setVisible(true);
			librarianModBtn.setVisible(true);
			magazineModBtn.setVisible(true);
			paperModBtn.setVisible(true);
			readerModBtn.setVisible(true);
			
		} if (selected.equals(UserSelected.Librarian)) {
			btnQueryGenerator.setBounds(66, 348, 650, 62);
			authorModBtn.setVisible(true);
			bookModBtn.setVisible(true);
			encyclopediaModBtn.setVisible(true);
			librarianModBtn.setVisible(false);
			magazineModBtn.setVisible(true);
			paperModBtn.setVisible(true);
			readerModBtn.setVisible(true);
		} 
		
	}
}
