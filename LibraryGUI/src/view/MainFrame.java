package view;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Controller.LibraryDB;
import Exceptions.ReaderNotExistException;
import Model.Library;
import Model.Reader;
import Utils.CollectionType;
import Utils.ItemType;
import Utils.UserSelected;
import Utils.UserType;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LibraryDB libraryDB;
	private static WelcomePanel welcomePanel;
	private static LoginPanel loginPanel;
	private static AdminControlPanel adminControlPanel;
	private static AddRemoveUser addRemoveUser;
	private static AddRemoveItem addRemoveItem;
	private static AddRemoveCollection addRemoveCollection;
	private static QueriesPanel queriesPanel;
	private static ReaderPanel readerPanel;
	
	//--------------------Constructor--------------
	
	public MainFrame() {
		super("Library1");
		setIconImage(new ImageIcon(getClass().getResource("/LibrarySmall.png")).getImage());
		getContentPane().setLayout(new CardLayout(0, 0));
		setSize(788,488);
		welcomePanel= new WelcomePanel();
		add(welcomePanel);
		loginPanel = new LoginPanel();
		add(loginPanel);
		loginPanel.setVisible(false);
		adminControlPanel = new AdminControlPanel();
		add(adminControlPanel);
		adminControlPanel.setVisible(false);
		addRemoveUser = new AddRemoveUser();
		add(addRemoveUser);
		addRemoveUser.setVisible(false);
		addRemoveItem = new AddRemoveItem();
		add(addRemoveItem);
		addRemoveItem.setVisible(false);
		addRemoveCollection = new AddRemoveCollection();
		add(addRemoveCollection);
		addRemoveCollection.setVisible(false);
		queriesPanel = new QueriesPanel();
		add(queriesPanel);
		queriesPanel.setVisible(false);
		readerPanel= new ReaderPanel();
		add(readerPanel);
		readerPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		
		libraryDB = new LibraryDB();

		MainFrame mf= new MainFrame();
		mf.setResizable(false);
		mf.setLocationRelativeTo(null);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	//----------------------------------Methods to save and get the Library Instance--------------------------------
	
	public static void save() {
		libraryDB.saveLibraryDB();
	}
	
	public static Library getLibrary() {
		return libraryDB.getLibrary();
	}
	
	//--------------------------------------------- Methods to set the current panel-----------------------------
	
	public static void welcome2LoginScreen(UserSelected selected) {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(true);
		loginPanel.setUserSelected(selected);
	}

	public static void login2WelcomeScreen() {
		loginPanel.setVisible(false);
		welcomePanel.setVisible(true);
	}
	
	public static void login2AdminControl(UserSelected selected) {
		loginPanel.setVisible(false);
		adminControlPanel.setVisible(true);
		adminControlPanel.setUserSelected(selected);
	}
	

	public static void adminControl2Login() {
		adminControlPanel.setVisible(false);
		loginPanel.setVisible(true);
	}
	
	public static void adminControl2AddRemoveUser(UserType type) {
		adminControlPanel.setVisible(false);
		addRemoveUser.setVisible(true);
		addRemoveUser.setUserType(type);
	}

	public static void addRemoveUser2AdminControl() {
		addRemoveUser.setVisible(false);
		adminControlPanel.setVisible(true);
	}

	public static void addRemoveItem2AdminControl() {
		addRemoveItem.setVisible(false);
		adminControlPanel.setVisible(true);
	}
	
	public static void adminControl2AddRemoveItem(ItemType type) {
		adminControlPanel.setVisible(false);
		addRemoveItem.setVisible(true);
		addRemoveItem.setItemType(type);
	}

	public static void addRemoveCollection2AdminControl() {
		addRemoveCollection.setVisible(false);
		adminControlPanel.setVisible(true);
	}
	public static void adminControl2AddRemoveCollection(CollectionType type) {
		adminControlPanel.setVisible(false);
		addRemoveCollection.setVisible(true);
		addRemoveCollection.setCollectionType(type);
	}

	public static void QueriesPanell2AdminControl() {
		queriesPanel.setVisible(false);
		adminControlPanel.setVisible(true);

	}

	public static void adminControl2QueriesPanel() {
		adminControlPanel.setVisible(false);
		queriesPanel.setVisible(true);

	}

	public static void login2ReaderPanel(Reader reader) throws ReaderNotExistException {
		loginPanel.setVisible(false);
		readerPanel.setVisible(true);
		readerPanel.setReader(reader);
	}

	public static void ReaderPanel2WelcomePanel() {
		readerPanel.setVisible(false);
		welcomePanel.setVisible(true);
	}


}
