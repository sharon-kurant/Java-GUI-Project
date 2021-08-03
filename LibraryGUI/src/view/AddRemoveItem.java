package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Exceptions.itemAlreadyExistException;
import Exceptions.itemNotExistException;
import Model.Author;
import Model.Book;
import Model.Encyclopedia;
import Model.Magazine;
import Model.Paper;
import Utils.AcademicBook;
import Utils.BookSize;
import Utils.CollectionType;
import Utils.ItemType;
import Utils.PaperValue;
import Utils.Topic;;

public class AddRemoveItem extends JPanel {
	
	private JLabel lblAddItem;
	private JLabel lblRemoveItem;
	private JLabel lblUniversity;
	private JLabel lblBookSize;
	private JLabel lblPaperValue;
	private JTextField itemNameAdd;
	private JTextField itemUniversityAdd;
	private JComboBox<PaperValue> comboBoxPaperValue;
	private JComboBox<String> authorAdd;
	private JComboBox<BookSize> bookSizeAdd;
	private JComboBox<Topic> topicAdd;
	private JRadioButton rdbtnAcademic;
	private JRadioButton rdbtnNonacademic;
	private ItemType type;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> comboBoxRemovable;
	
	public AddRemoveItem() {
		
		setBorder(new TitledBorder(null, "Add/Remove item", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(0, 0, 782, 453);
		setBackground(Color.WHITE);
		
		setLayout(null);
		
		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.addRemoveItem2AdminControl();
			}
		});
		button.setBounds(12, 15, 56, 25);
		add(button);
		
		lblAddItem = new JLabel("Add item");
		lblAddItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddItem.setBounds(59, 133, 100, 20);
		add(lblAddItem);
		
		lblRemoveItem = new JLabel("Remove item");
		lblRemoveItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoveItem.setBounds(447, 134, 130, 20);
		add(lblRemoveItem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(386, 133, 10, 273);
		add(panel_1);
		
		JLabel lblItemName = new JLabel("Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblItemName.setBounds(59, 178, 56, 16);
		add(lblItemName);
		
		JLabel lblTopic = new JLabel("Topic:");
		lblTopic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTopic.setBounds(59, 220, 56, 16);
		add(lblTopic);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuthor.setBounds(59, 262, 56, 16);
		add(lblAuthor);
		
		lblBookSize = new JLabel("Book size:");
		lblBookSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookSize.setBounds(59, 306, 66, 16);
		add(lblBookSize);
		
		rdbtnAcademic = new JRadioButton("Academic");
		rdbtnAcademic.setSelected(true);
		buttonGroup.add(rdbtnAcademic);
		rdbtnAcademic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAcademic.setBackground(Color.WHITE);
		rdbtnAcademic.setBounds(55, 342, 99, 25);
		rdbtnAcademic.setActionCommand("ACADEMIC");
		add(rdbtnAcademic);
		
		rdbtnNonacademic = new JRadioButton("Non-Academic");
		buttonGroup.add(rdbtnNonacademic);
		rdbtnNonacademic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNonacademic.setBackground(Color.WHITE);
		rdbtnNonacademic.setBounds(158, 342, 121, 25);
		rdbtnNonacademic.setActionCommand("NON_ACADEMIC");
		add(rdbtnNonacademic);
		
		JButton btnRegisterItem = new JButton("Register");
		btnRegisterItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = itemNameAdd.getText();
				Topic topic = (Topic) topicAdd.getSelectedItem();
				String authorName = authorAdd.getSelectedItem().toString();
				Author author = (Author) MainFrame.getLibrary().getAuthorByName(authorName.split(" ")[0], authorName.split(" ")[1]);
				if (type.equals(ItemType.Book)) {
					try {
						BookSize size = (BookSize) bookSizeAdd.getSelectedItem();
						String ab = buttonGroup.getSelection().getActionCommand().toUpperCase();
						AcademicBook academic = AcademicBook.valueOf(ab);
						MainFrame.getLibrary().addItem(new Book(name,topic,author,size, academic));
						JOptionPane.showMessageDialog(null, "Book "+ "''" + name+ "''" + " added");
					} catch (itemAlreadyExistException e1) {
						JOptionPane.showMessageDialog(null, "Book "+ "''" + name+ "''" + " already exists");
					}
					
				}else {
					try {
						PaperValue value = (PaperValue) comboBoxPaperValue.getSelectedItem();
						String uni = itemUniversityAdd.getText();
						MainFrame.getLibrary().addItem(new Paper(name,topic,author,value,uni));
						
						JOptionPane.showMessageDialog(null, "Paper "+ "''" + name+ "''" + " added");
					} catch (itemAlreadyExistException e1) {
						JOptionPane.showMessageDialog(null, "Paper "+ "''" + name+ "''" + " already exists");
					}
					itemUniversityAdd.setText("");
				}
				itemNameAdd.setText("");
				MainFrame.save();
				refreshCombobox();
			}
		});
				
		btnRegisterItem.setBackground(Color.ORANGE);
		btnRegisterItem.setForeground(Color.BLACK);
		btnRegisterItem.setBounds(176, 381, 97, 25);
		add(btnRegisterItem);
		
		itemNameAdd = new JTextField();
		itemNameAdd.setColumns(10);
		itemNameAdd.setBounds(147, 178, 126, 22);
		add(itemNameAdd);
		
		bookSizeAdd = new JComboBox<BookSize>();
		bookSizeAdd.setBackground(Color.ORANGE);
		bookSizeAdd.setModel(new DefaultComboBoxModel<BookSize>(BookSize.values()));
		bookSizeAdd.setBounds(147, 304, 126, 22);
		add(bookSizeAdd);
		
		topicAdd = new JComboBox<Topic>();
		topicAdd.setBackground(Color.ORANGE);
		topicAdd.setModel(new DefaultComboBoxModel<Topic>(Topic.values()));
		topicAdd.setBounds(147, 220, 126, 22);
		add(topicAdd);
		
		authorAdd = new JComboBox<String>();
		authorAdd.setBackground(Color.ORANGE);
		authorAdd.setBounds(147, 264, 126, 22);
		add(authorAdd);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(447, 174, 56, 16);
		add(label);
		
		JButton btnRemoveItem = new JButton("Remove");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) comboBoxRemovable.getSelectedItem();
				if (type.equals(ItemType.Book)) {
					try {
						MainFrame.getLibrary().removeItem(new Book(name));
						JOptionPane.showMessageDialog(null, "Book "+ "''" + name+ "''" + " removed");
					} catch (itemNotExistException e1) {
						JOptionPane.showMessageDialog(null, "Book "+ "''" + name+ "''" + " doesn't exist");
					}
					
				}else {
					try {
						MainFrame.getLibrary().removeItem(new Paper(name));
						JOptionPane.showMessageDialog(null, "Paper "+ "''" + name+ "''" + " removed");
					} catch (itemNotExistException e1) {
						JOptionPane.showMessageDialog(null, "Paper "+ "''" + name+ "''" + " doesn't exist");
					}
				}
				MainFrame.save();
				refreshCombobox();
			}
		});
		btnRemoveItem.setForeground(Color.BLACK);
		btnRemoveItem.setBackground(Color.ORANGE);
		btnRemoveItem.setBounds(558, 381, 97, 25);
		add(btnRemoveItem);
		
		lblPaperValue = new JLabel("Paper value:");
		lblPaperValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaperValue.setBounds(59, 305, 76, 16);
		add(lblPaperValue);
		
		comboBoxPaperValue = new JComboBox<PaperValue>();
		comboBoxPaperValue.setModel(new DefaultComboBoxModel<PaperValue>(PaperValue.values()));
		comboBoxPaperValue.setBackground(Color.ORANGE);
		comboBoxPaperValue.setBounds(147, 304, 126, 22);
		add(comboBoxPaperValue);
		
		lblUniversity = new JLabel("University:");
		lblUniversity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUniversity.setBounds(59, 347, 75, 16);
		add(lblUniversity);
		
		itemUniversityAdd = new JTextField();
		itemUniversityAdd.setColumns(10);
		itemUniversityAdd.setBounds(147, 342, 126, 22);
		add(itemUniversityAdd);
		
		comboBoxRemovable = new JComboBox<String>();
		comboBoxRemovable.setBackground(Color.ORANGE);
		comboBoxRemovable.setBounds(525, 176, 130, 22);
		add(comboBoxRemovable);
		
	}
	
	//Sets the ItemType enum and the relevant fields
	public void setItemType(ItemType type) {
		this.type = type;
		setBorderAndLabelsMethod();
		if (type.equals(ItemType.Book)) {
			itemUniversityAdd.setVisible(false);
			comboBoxPaperValue.setVisible(false);
			lblPaperValue.setVisible(false);
			lblUniversity.setVisible(false);
			
			bookSizeAdd.setVisible(true);
			lblBookSize.setVisible(true);
			rdbtnAcademic.setVisible(true);
			rdbtnNonacademic.setVisible(true);
		} else {
			bookSizeAdd.setVisible(false);
			lblBookSize.setVisible(false);
			rdbtnAcademic.setVisible(false);
			rdbtnNonacademic.setVisible(false);
			
			itemUniversityAdd.setVisible(true);
			comboBoxPaperValue.setVisible(true);
			lblPaperValue.setVisible(true);
			lblUniversity.setVisible(true);
			
		}
		
	}
	
	private void setBorderAndLabelsMethod() {
		String s = "Add/Remove " + this.type;
		setBorder(new TitledBorder(null, s, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblAddItem.setText("Add "+ this.type);
		lblRemoveItem.setText("Remove "+ this.type);
		if (MainFrame.getLibrary().getAuthors().size()>0) {
			authorAdd.removeAllItems();
			for (Author a : MainFrame.getLibrary().getAuthors()) {
				authorAdd.addItem(a.getfName() + " " + a.getlName());
			}
		}
		refreshCombobox();
	}

	
	// refresh the combobox to show the new or removed information
	private void refreshCombobox() {
		if (MainFrame.getLibrary().getBooks().size()>=0 && this.type.equals(ItemType.Book)) {
			comboBoxRemovable.removeAllItems();
			for (Book b : MainFrame.getLibrary().getBooks()) {
				comboBoxRemovable.addItem(b.getName());
			}
		} else if (MainFrame.getLibrary().getPapers().size()>=0 && this.type.equals(ItemType.Paper)) {
			comboBoxRemovable.removeAllItems();
			for (Paper p : MainFrame.getLibrary().getPapers()) {
				comboBoxRemovable.addItem(p.getName());
			}
		}
	}		
	

	private ItemType getItemType() {
		return this.type;
	}
	
}
