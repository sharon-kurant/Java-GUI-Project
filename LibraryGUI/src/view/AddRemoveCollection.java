package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Model.Author;
import Model.Book;
import Model.Encyclopedia;
import Model.LibraryCollection;
import Model.LibraryItem;
import Model.Magazine;
import Model.Paper;
import Utils.CollectionType;
import javax.swing.JComboBox;

public class AddRemoveCollection extends JPanel {
	
	private JTextField nameAdd;
	private JLabel lblAddCollec;
	private JLabel lblRemoveCollec;
	private CollectionType type;
	private JComboBox<String> comboBoxRemovable;
	private JLabel lblAddItemTo;
	private JLabel lblItem;
	private JButton btnAddItem;
	private JComboBox<String> comboBoxAddItem;
	private JComboBox<String> comboBoxAdd2Collection;
	
	public AddRemoveCollection() {
		setBorder(new TitledBorder(null, "Add/Remove collection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setBounds(0, 0, 782, 453);
		setLayout(null);

		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.ORANGE);
		panel_3.setBounds(386, 133, 10, 273);
		add(panel_3);

		lblAddCollec = new JLabel("Add Collection");
		lblAddCollec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCollec.setBounds(59, 133, 150, 20);
		add(lblAddCollec);

		lblRemoveCollec = new JLabel("Remove Collection");
		lblRemoveCollec.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoveCollec.setBounds(447, 133, 176, 20);
		add(lblRemoveCollec);

		JLabel lblNameAdd = new JLabel("Name:");
		lblNameAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameAdd.setBounds(59, 181, 56, 16);
		add(lblNameAdd);

		nameAdd = new JTextField();
		nameAdd.setBounds(127, 179, 126, 22);
		add(nameAdd);
		nameAdd.setColumns(10);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameAdd.getText();
				if (type.equals(CollectionType.Encyclopedia) && !MainFrame.getLibrary().addEncyclopedia(new Encyclopedia(name))) {
					JOptionPane.showMessageDialog(null, type + " " + name + " already exists");
				}
				else if (type.equals(CollectionType.Magazine) && !MainFrame.getLibrary().addMagazine(new Magazine(name))) {
					JOptionPane.showMessageDialog(null, type + " " + name + " already exists");
				}
				else {
					JOptionPane.showMessageDialog(null, type+" " + name + " added");
					MainFrame.save();
					refreshCombobox();
				}
				nameAdd.setText("");
			}
		});
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setBackground(Color.ORANGE);
		btnRegister.setBounds(156, 220, 97, 25);
		add(btnRegister);

		JLabel lblNameRmv = new JLabel("Name:");
		lblNameRmv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameRmv.setBounds(447, 181, 56, 16);
		add(lblNameRmv);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) comboBoxRemovable.getSelectedItem();
				if (!MainFrame.getLibrary().removeCollection(new LibraryCollection(name))) {
					JOptionPane.showMessageDialog(null, type+" " + name + " doesn't exist");
				} else {
					JOptionPane.showMessageDialog(null, type +" " + name + " removed");
					MainFrame.save();
					refreshCombobox();
				}
			}
		});
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setBackground(Color.ORANGE);
		btnRemove.setBounds(548, 381, 97, 25);
		add(btnRemove);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.addRemoveCollection2AdminControl();
			}
		});
		button.setBounds(12, 15, 56, 25);
		add(button);
		
		comboBoxRemovable = new JComboBox<String>();
		comboBoxRemovable.setBackground(Color.ORANGE);
		comboBoxRemovable.setBounds(515, 181, 130, 22);
		add(comboBoxRemovable);
		
		lblAddItemTo = new JLabel("Add Book To Encyclopedia");
		lblAddItemTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddItemTo.setBounds(59, 267, 226, 20);
		add(lblAddItemTo);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(59, 300, 56, 16);
		add(label);
		
		lblItem = new JLabel("item:");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItem.setBounds(69, 341, 56, 16);
		add(lblItem);
		
		btnAddItem = new JButton("Add item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemToCollection();
				MainFrame.save();
				setItemsComboBox();
			}
		});
		btnAddItem.setForeground(Color.BLACK);
		btnAddItem.setBackground(Color.ORANGE);
		btnAddItem.setBounds(156, 381, 97, 25);
		add(btnAddItem);
		
		comboBoxAdd2Collection = new JComboBox<String>();
		comboBoxAdd2Collection.setBackground(Color.ORANGE);
		comboBoxAdd2Collection.setBounds(127, 298, 126, 22);
		comboBoxAdd2Collection.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setItemsComboBox();
			}
		});
		add(comboBoxAdd2Collection);
		
		comboBoxAddItem = new JComboBox<String>();
		comboBoxAddItem.setBackground(Color.ORANGE);
		comboBoxAddItem.setBounds(127, 339, 126, 22);
		add(comboBoxAddItem);
	}
	
	protected void addItemToCollection() {
		if (this.type.equals(CollectionType.Encyclopedia)) {
			if (comboBoxAdd2Collection != null) {
				Encyclopedia enc = MainFrame.getLibrary().getEncyclopidea((String)comboBoxAdd2Collection.getSelectedItem());
				if (comboBoxAddItem.getSelectedItem() != null) {
					String name = (String) comboBoxAddItem.getSelectedItem();
					Book b = MainFrame.getLibrary().getBookByName(name);
					if (!enc.getItems().containsKey(b.getName())) {
						MainFrame.getLibrary().addCollectionItem(enc, b);
						comboBoxAddItem.removeItem(name);
						JOptionPane.showMessageDialog(null, "Book: " + name + " added succefully to Encyclopedia: " + enc.getName());
						return;
					} else JOptionPane.showMessageDialog(null, "Book: " + name + " already in Encyclopedia: " + enc.getName());
				} else JOptionPane.showMessageDialog(null, "Please select a book if exists");
			} else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library");
		}
		else if (this.type.equals(CollectionType.Magazine)) {
			if (comboBoxAdd2Collection != null) {
				Magazine mag = MainFrame.getLibrary().getMagazine((String)comboBoxAdd2Collection.getSelectedItem());
				if (comboBoxAddItem.getSelectedItem() != null) {
					String name = (String) comboBoxAddItem.getSelectedItem();
					Paper p = MainFrame.getLibrary().getPaperByName(name);
					if (!mag.getItems().containsKey(p.getName())) {
						MainFrame.getLibrary().addCollectionItem(mag, p);
						comboBoxAddItem.removeItem(name);
						JOptionPane.showMessageDialog(null, "Paper: " + name + " added succefully to Magazine: " + mag.getName());
					} else JOptionPane.showMessageDialog(null, "Paper: " + name + " already in Magazine: " + mag.getName());
				} else JOptionPane.showMessageDialog(null, "Please select a paper if exists");
			} else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library");
		}
	}

	public void setCollectionType(CollectionType type) {
		this.type = type;
		setBorderAndLabelsMethod();
		refreshCombobox();
		setItemsComboBox();
	}
	
	private void setItemsComboBox() {
		comboBoxAddItem.removeAllItems();
		if (this.type.equals(CollectionType.Encyclopedia) && MainFrame.getLibrary().getAllEncyclopedias().size()>=0) {
			Encyclopedia enc = MainFrame.getLibrary().getEncyclopidea((String)comboBoxAdd2Collection.getSelectedItem());
			if (enc==null)
				return;
			for (Book b: MainFrame.getLibrary().getBooks()) {
				if (!MainFrame.getLibrary().getEncyclopidea(enc.getName()).getItems().containsKey(b.getName())) {
					comboBoxAddItem.addItem(b.getName());
				}
			}
		}else if (this.type.equals(CollectionType.Magazine) && MainFrame.getLibrary().getAllMagazines().size()>=0) {
			Magazine mag = MainFrame.getLibrary().getMagazine((String)comboBoxAdd2Collection.getSelectedItem());
			if (mag==null)
				return;
			for (Paper p: MainFrame.getLibrary().getPapers()) {
				if (!MainFrame.getLibrary().getMagazine(mag.getName()).getItems().containsKey(p.getName())) {
					comboBoxAddItem.addItem(p.getName());
				}
			}
		}
	}

	private void setBorderAndLabelsMethod() {
		String s = "Add/Remove " + this.type;
		setBorder(new TitledBorder(null, s, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblAddItemTo.setText("Add " + (this.type == CollectionType.Encyclopedia ? "Book" : "Paper") + " To " + this.type);
		lblItem.setText(this.type == CollectionType.Encyclopedia ? "Book" : "Paper");
		btnAddItem.setText("Add " + (this.type == CollectionType.Encyclopedia ? "Book" : "Paper"));
		lblAddCollec.setText("Add "+ this.type.toString());
		lblRemoveCollec.setText("Remove "+ this.type.toString());
		refreshCombobox();
	}
	
	private CollectionType getCollectionType() {
		return this.type;
	}
	// refresh the combobox to show the new or removed information
	private void refreshCombobox() {
		if (MainFrame.getLibrary().getAllEncyclopedias().size()>=0 && this.type.equals(CollectionType.Encyclopedia)) {
			comboBoxRemovable.removeAllItems();
			comboBoxAdd2Collection.removeAllItems();
			for (Encyclopedia e : MainFrame.getLibrary().getAllEncyclopedias()) {
				comboBoxAdd2Collection.addItem(e.getName());
				comboBoxRemovable.addItem(e.getName());
			}
		} else if (MainFrame.getLibrary().getAllMagazines().size()>=0 && this.type.equals(CollectionType.Magazine)) {
			comboBoxRemovable.removeAllItems();
			comboBoxAdd2Collection.removeAllItems();
			for (Magazine m : MainFrame.getLibrary().getAllMagazines()) {
				comboBoxAdd2Collection.addItem(m.getName());
				comboBoxRemovable.addItem(m.getName());
			}
		}
	}
	
}
