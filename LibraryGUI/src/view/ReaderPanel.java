package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Exceptions.ReaderNotExistException;
import Model.ArithmeticMean;
import Model.Book;
import Model.GeometricMean;
import Model.HarmonicMean;
import Model.LibraryItem;
import Model.Paper;
import Model.Reader;
import Model.Recommender;
import Model.Review;
import Utils.CollectionType;
import Utils.ItemType;
import Utils.PanelType;
import Utils.ReviewState;
import Utils.UserSelected;
import Utils.UserType;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;;

public class ReaderPanel extends JPanel {
	
	private UserSelected selected;
	private JButton myBooksBtn;
	private JButton myPapersBtn;
	private JButton bookModBtn;
	private JButton addReviewBtn;
	private JButton recommenderBtn;
	private JButton changePicBtn;
	private JLabel lblProfilePic;
	private Reader reader;
	private JLabel lblHiUser;
	private ImageIcon defaultProfilePic;
	private JPanel panel;
	private JPanel myBooksPapersPanel;
	private JComboBox<String> removeBooksPapersComboBox;
	private JComboBox<String> addBooksPapersComboBox;
	private JList<String> myBookPaperList;
	private DefaultListModel<String> model;
	private JPanel EmptyPanel;
	private PanelType panelType;
	private JLabel lblMyBooksPapers;
	private JLabel lblAddBookPaper;
	private JLabel lblRemoveBookPaper;
	private JPanel ReviewPanel;
	private JLabel lblWriteYourReview;
	private JLabel lblBookpaper;
	private JLabel lblSentence;
	private JLabel lblRate;
	private JButton addRev;
	private JTextArea sentenceArea;
	private JComboBox<String> revComboBox;
	private JSlider slider;
	private ReviewState state;
	private JPanel recommendPanel;
	private JLabel label_2;
	private JLabel lblHowMuchRcommendations;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel lblBookpaper_1;
	private JLabel label_7;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel lblCalculation;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JComboBox<String> comboCalcRec;
	private JLabel lblFor_3;
	private JLabel lblFor_2;
	private JLabel lblFor_1;
	private JLabel lblFor;
	private JLabel lblAsPer;
	private JComboBox<String> comboAsPerRec;
	private JComboBox<String> comboItemRec;
	private JSlider kSliderRec;
	private JLabel lblWelcome;

	
	public ReaderPanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "user name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setToolTipText("");
		
		setBackground(Color.WHITE);
		setBounds(0, 0, 782, 453);
		setLayout(null);
		
		JLabel libraryLabelLogo = new JLabel("New label");
		libraryLabelLogo.setIcon(new ImageIcon(getClass().getResource("/LibraryLogo.png")));
		libraryLabelLogo.setBounds(286, 20, 210, 94);
		add(libraryLabelLogo);
		
		lblHiUser = new JLabel("Hi user name");
		lblHiUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHiUser.setBounds(260, 128, 261, 30);
		add(lblHiUser);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogout.setBackground(Color.ORANGE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.ReaderPanel2WelcomePanel();
			}
		});
		btnLogout.setBounds(12, 15, 78, 25);
		add(btnLogout);
		
		JLabel lblChooseYourFavourite = new JLabel("Have a look at your profile");
		lblChooseYourFavourite.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourFavourite.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseYourFavourite.setBounds(275, 148, 235, 30);
		add(lblChooseYourFavourite);
		
		lblProfilePic = new JLabel();
        lblProfilePic.setSize(120, 120);
        lblProfilePic.setLocation(596, 20);
        lblProfilePic.setText("Profile Picture");
        Image toSet = new ImageIcon(getClass().getResource("/LibraryLogo.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        defaultProfilePic = new ImageIcon(toSet);
        lblProfilePic.setIcon(defaultProfilePic);
        add(lblProfilePic);
        
		changePicBtn= new JButton();
		changePicBtn.setBackground(new Color(255, 215, 0));
		changePicBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		changePicBtn.setSize(120, 20);
		changePicBtn.setLocation(596, 140);
		changePicBtn.setText("Change Picture");
        changePicBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setProfilePicture();
                MainFrame.save();
            }
        });
        add(changePicBtn);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, Color.ORANGE));
        menuPanel.setBounds(5, 187, 210, 261);
        add(menuPanel);
        menuPanel.setLayout(null);
        
        myBooksBtn = new JButton("My Books");
        myBooksBtn.setBounds(12, 8, 186, 30);
        menuPanel.add(myBooksBtn);
        myBooksBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EmptyPanel.setVisible(false);
        		ReviewPanel.setVisible(false);
        		recommendPanel.setVisible(false);
        		panelType = PanelType.Book;
        		try {
					setMyBooksAndPapers();
				} catch (ReaderNotExistException e1) {
					e1.printStackTrace();
				}
        		myBooksPapersPanel.setVisible(true);
        	}
        });
        myBooksBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        myBooksBtn.setBackground(Color.ORANGE);
        
        myPapersBtn = new JButton("My Papers");
        myPapersBtn.setBounds(12, 51, 186, 30);
        menuPanel.add(myPapersBtn);
        myPapersBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EmptyPanel.setVisible(false);
        		recommendPanel.setVisible(false);
        		ReviewPanel.setVisible(false);
        		panelType = PanelType.Paper;
        		try {
					setMyBooksAndPapers();
				} catch (ReaderNotExistException e1) {
					e1.printStackTrace();
				}
        		myBooksPapersPanel.setVisible(true);
        	}
        });
        myPapersBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        myPapersBtn.setBackground(Color.ORANGE);
        
        addReviewBtn = new JButton("Add Review");
        addReviewBtn.setBounds(12, 94, 186, 30);
        menuPanel.add(addReviewBtn);
        addReviewBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		state = ReviewState.Add;
        		EmptyPanel.setVisible(false);
        		recommendPanel.setVisible(false);
        		myBooksPapersPanel.setVisible(false);
        		ReviewPanel.setVisible(true);
        		lblWriteYourReview.setText("Write your review");
        		sentenceArea.setText("");
        		slider.setValue(5);
        		try {
					setReviewComboBox();
				} catch (ReaderNotExistException e1) {
					e1.printStackTrace();
				}
        	}
        });
        addReviewBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        addReviewBtn.setBackground(Color.ORANGE);
        
        bookModBtn = new JButton("Change Review");
        bookModBtn.setBounds(12, 137, 186, 30);
        menuPanel.add(bookModBtn);
        bookModBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		state = ReviewState.Change;
        		EmptyPanel.setVisible(false);
        		myBooksPapersPanel.setVisible(false);
        		recommendPanel.setVisible(false);
        		ReviewPanel.setVisible(true);
        		lblWriteYourReview.setText("Choose a review to change");
        		try {
					setReviewComboBox();
				} catch (ReaderNotExistException e1) {
					e1.printStackTrace();
				}
        	}
        });
        bookModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 19));
        bookModBtn.setBackground(Color.ORANGE);
        
        recommenderBtn = new JButton("Recommender");
        recommenderBtn.setBounds(12, 223, 186, 30);
        menuPanel.add(recommenderBtn);
        recommenderBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		EmptyPanel.setVisible(false);
        		myBooksPapersPanel.setVisible(false);
        		ReviewPanel.setVisible(false);
        		recommendPanel.setVisible(true);
        		final AtomicInteger i = new AtomicInteger(0);
        		Timer tm = new Timer(450, null);
        		tm.addActionListener((e2) -> { //Action event for color animation
        			if (i.getAndIncrement()%2 == 0) {
        				lblWelcome.setForeground(Color.CYAN);
        			} else {
        				lblWelcome.setForeground(Color.ORANGE);
        			}
                            			
                    if (i.get() >= 10) {
                        tm.stop();
                    }
                });
                tm.start();
        	}
        });
        recommenderBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
        recommenderBtn.setBackground(Color.ORANGE);
        
        panel = new JPanel();
        panel.setBounds(215, 187, 561, 261);
        add(panel);
        panel.setLayout(new CardLayout(0, 0));
        
        myBooksPapersPanel = new JPanel();
        myBooksPapersPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, Color.ORANGE));
        myBooksPapersPanel.setBackground(Color.WHITE);
        panel.add(myBooksPapersPanel, "name_269999644987599");
        myBooksPapersPanel.setLayout(null);
        myBooksPapersPanel.setVisible(false);
        
        lblMyBooksPapers = new JLabel("My Books/Papers");
        lblMyBooksPapers.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMyBooksPapers.setBounds(12, 8, 189, 30);
        myBooksPapersPanel.add(lblMyBooksPapers);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.ORANGE);
        panel_1.setBounds(275, 13, 10, 240);
        myBooksPapersPanel.add(panel_1);
        
        lblAddBookPaper = new JLabel("Add Paper/Book");
        lblAddBookPaper.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAddBookPaper.setBounds(297, 8, 189, 30);
        myBooksPapersPanel.add(lblAddBookPaper);
        
        lblRemoveBookPaper = new JLabel("Remove Books/Papers");
        lblRemoveBookPaper.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblRemoveBookPaper.setBounds(297, 126, 189, 30);
        myBooksPapersPanel.add(lblRemoveBookPaper);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(297, 51, 47, 19);
        myBooksPapersPanel.add(lblName);
        
        JLabel label = new JLabel("Name:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label.setBounds(297, 169, 47, 19);
        myBooksPapersPanel.add(label);
        
        addBooksPapersComboBox = new JComboBox<String>();
        addBooksPapersComboBox.setBounds(356, 50, 137, 22);
        myBooksPapersPanel.add(addBooksPapersComboBox);
        
        removeBooksPapersComboBox = new JComboBox<String>();
        removeBooksPapersComboBox.setBounds(356, 168, 137, 22);
        myBooksPapersPanel.add(removeBooksPapersComboBox);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String name = (String)addBooksPapersComboBox.getSelectedItem();
        		if (name==null)
        			return;
        		model.addElement(name);
        		addBooksPapersComboBox.removeItem(name);
        		removeBooksPapersComboBox.addItem(name);
        		if (panelType.equals(PanelType.Book))
        			MainFrame.getLibrary().readItem(reader, new Book(name));
        		else if (panelType.equals(PanelType.Paper))
        			MainFrame.getLibrary().readItem(reader, new Paper(name));
        		MainFrame.save();
        	}
        });
        btnAdd.setBackground(Color.ORANGE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAdd.setBounds(405, 88, 88, 25);
        myBooksPapersPanel.add(btnAdd);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name = (String) removeBooksPapersComboBox.getSelectedItem();
        		if (name==null)
        			return;
        		model.removeElement(name);
        		addBooksPapersComboBox.addItem(name);
        		removeBooksPapersComboBox.removeItem(name);
        		if (panelType.equals(PanelType.Book)) {
        			MainFrame.getLibrary().unreadItem(reader, new Book(name));
        		}
        		else if (panelType.equals(PanelType.Paper)) {
        			MainFrame.getLibrary().unreadItem(reader, new Paper(name));
        		}
        		MainFrame.save();
        	}
        });
        
        btnRemove.setBackground(Color.ORANGE);
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRemove.setBounds(405, 203, 88, 25);
        myBooksPapersPanel.add(btnRemove);
        
        model = new DefaultListModel<String>();
        
        myBookPaperList = new JList<String>(model);
        myBookPaperList.setBackground(Color.LIGHT_GRAY);
        myBookPaperList.setBounds(12, 51, 209, 202);
        myBookPaperList.setAutoscrolls(true);     
        myBooksPapersPanel.add(myBookPaperList);
        
        
        EmptyPanel = new JPanel();
        EmptyPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, Color.ORANGE));
        panel.add(EmptyPanel, "name_338027978160500");
        
        ReviewPanel = new JPanel();
        ReviewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, Color.ORANGE));
        ReviewPanel.setBackground(Color.WHITE);
        ReviewPanel.setVisible(false);
        panel.add(ReviewPanel, "name_357673472321500");
        ReviewPanel.setLayout(null);
        
        lblWriteYourReview = new JLabel("new/change review");
        lblWriteYourReview.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblWriteYourReview.setBounds(12, 8, 230, 30);
        ReviewPanel.add(lblWriteYourReview);
        
        lblBookpaper = new JLabel("Book/Paper:");
        lblBookpaper.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblBookpaper.setBounds(12, 51, 84, 19);
        ReviewPanel.add(lblBookpaper);
        
        lblSentence = new JLabel("Sentence:");
        lblSentence.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSentence.setBounds(12, 96, 74, 19);
        ReviewPanel.add(lblSentence);
        
        lblRate = new JLabel("Rate:");
        lblRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRate.setBounds(310, 51, 52, 19);
        ReviewPanel.add(lblRate);
        
        addRev = new JButton("Add");
        addRev.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					addReview();
				} catch (ReaderNotExistException e2) {
					e2.printStackTrace();
				}
        		MainFrame.save();
        		try {
					setReviewComboBox();
				} catch (ReaderNotExistException e1) {
					e1.printStackTrace();
				}
        		if (state.equals(ReviewState.Change)) {
        			try {
						setReviewToChange();
					} catch (ReaderNotExistException e1) {
						e1.printStackTrace();
					}
        		}
        	}
        });
        addRev.setFont(new Font("Tahoma", Font.BOLD, 13));
        addRev.setBackground(Color.ORANGE);
        addRev.setBounds(439, 218, 84, 30);
        ReviewPanel.add(addRev);
        
        revComboBox = new JComboBox<String>();
        revComboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if (state.equals(ReviewState.Change)) {
        			try {
						setReviewToChange();
					} catch (ReaderNotExistException e) {
						e.printStackTrace();
					}
        			MainFrame.save();
        		}
        	}
        });
        revComboBox.setBackground(Color.ORANGE);
        revComboBox.setBounds(90, 51, 189, 22);
        ReviewPanel.add(revComboBox);
        
        slider = new JSlider();
        slider.setForeground(new Color(0, 0, 0));
        slider.setBackground(new Color(255, 255, 255));
        slider.setValue(5);
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(1);
        slider.setMaximum(10);
        slider.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        slider.setBounds(360, 40, 163, 44);
        ReviewPanel.add(slider);
        
        sentenceArea = new JTextArea();
        sentenceArea.setLineWrap(true);
        sentenceArea.setFont(new Font("Courier New", Font.BOLD, 14));
        sentenceArea.setBounds(90, 96, 189, 152);
        sentenceArea.setBorder(new LineBorder(Color.BLACK));
        ReviewPanel.add(sentenceArea);
        
        recommendPanel = new JPanel();
        recommendPanel.setBackground(Color.WHITE);
        recommendPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, Color.ORANGE));
        panel.add(recommendPanel, "name_62549750722800");
        recommendPanel.setLayout(null);
        
        lblWelcome = new JLabel("Welcome to your Recommender");
        lblWelcome.setForeground(Color.ORANGE);
        lblWelcome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        lblWelcome.setBounds(93, 10, 375, 41);
        recommendPanel.add(lblWelcome);
        
        JLabel lblNewLabel_1 = new JLabel("Search for your best fitted books and papers");
        lblNewLabel_1.setForeground(Color.ORANGE);
        lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        lblNewLabel_1.setBounds(76, 50, 409, 30);
        recommendPanel.add(lblNewLabel_1);
        
        JLabel label_1 = new JLabel("Welcome to your Recommender");
        label_1.setForeground(Color.RED);
        label_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        label_1.setBounds(92, 10, 380, 41);
        recommendPanel.add(label_1);
        
        label_2 = new JLabel("Search for your best fitted books and papers");
        label_2.setForeground(Color.RED);
        label_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        label_2.setBounds(75, 50, 409, 30);
        recommendPanel.add(label_2);
        
        JLabel label_3 = new JLabel("Welcome to your Recommender");
        label_3.setForeground(Color.RED);
        label_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        label_3.setBounds(94, 10, 380, 41);
        recommendPanel.add(label_3);
        
        JLabel label_4 = new JLabel("Welcome to your Recommender");
        label_4.setForeground(Color.RED);
        label_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        label_4.setBounds(93, 11, 380, 41);
        recommendPanel.add(label_4);
        
        JLabel label_5 = new JLabel("Welcome to your Recommender");
        label_5.setForeground(Color.RED);
        label_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
        label_5.setBounds(93, 9, 380, 41);
        recommendPanel.add(label_5);
        
        label_11 = new JLabel("Search for your best fitted books and papers");
        label_11.setForeground(Color.RED);
        label_11.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        label_11.setBounds(77, 50, 409, 30);
        recommendPanel.add(label_11);
        
        label_12 = new JLabel("Search for your best fitted books and papers");
        label_12.setForeground(Color.RED);
        label_12.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        label_12.setBounds(76, 51, 409, 30);
        recommendPanel.add(label_12);
        
        label_13 = new JLabel("Search for your best fitted books and papers");
        label_13.setForeground(Color.RED);
        label_13.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
        label_13.setBounds(76, 49, 409, 30);
        recommendPanel.add(label_13);
        
        lblHowMuchRcommendations = new JLabel("How Much?");
        lblHowMuchRcommendations.setForeground(Color.ORANGE);
        lblHowMuchRcommendations.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblHowMuchRcommendations.setBounds(38, 136, 105, 30);
        recommendPanel.add(lblHowMuchRcommendations);
        
        JLabel lblHowMuch = new JLabel("How Much?");
        lblHowMuch.setBackground(Color.WHITE);
        lblHowMuch.setForeground(Color.BLACK);
        lblHowMuch.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblHowMuch.setBounds(37, 136, 105, 30);
        recommendPanel.add(lblHowMuch);
        
        JLabel lblHowMuch_1 = new JLabel("How Much?");
        lblHowMuch_1.setForeground(Color.BLACK);
        lblHowMuch_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblHowMuch_1.setBounds(39, 136, 105, 30);
        recommendPanel.add(lblHowMuch_1);
        
        JLabel lblHowMuch_2 = new JLabel("How Much?");
        lblHowMuch_2.setForeground(Color.BLACK);
        lblHowMuch_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblHowMuch_2.setBounds(38, 137, 105, 30);
        recommendPanel.add(lblHowMuch_2);
        
        JLabel lblHowMuch_3 = new JLabel("How Much?");
        lblHowMuch_3.setForeground(Color.BLACK);
        lblHowMuch_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblHowMuch_3.setBounds(38, 135, 105, 30);
        recommendPanel.add(lblHowMuch_3);
        
        lblBookpaper_1 = new JLabel("Book/Paper");
        lblBookpaper_1.setForeground(Color.ORANGE);
        lblBookpaper_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblBookpaper_1.setBounds(38, 94, 110, 30);
        recommendPanel.add(lblBookpaper_1);
        
        label_7 = new JLabel("Book/Paper");
        label_7.setForeground(Color.BLACK);
        label_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_7.setBounds(37, 94, 110, 30);
        recommendPanel.add(label_7);
        
        label_14 = new JLabel("Book/Paper");
        label_14.setForeground(Color.BLACK);
        label_14.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_14.setBounds(39, 94, 110, 30);
        recommendPanel.add(label_14);
        
        label_15 = new JLabel("Book/Paper");
        label_15.setForeground(Color.BLACK);
        label_15.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_15.setBounds(38, 95, 110, 30);
        recommendPanel.add(label_15);
        
        label_16 = new JLabel("Book/Paper");
        label_16.setForeground(Color.BLACK);
        label_16.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_16.setBounds(38, 93, 110, 30);
        recommendPanel.add(label_16);
        
        comboItemRec = new JComboBox<String>();
        comboItemRec.setBackground(Color.ORANGE);
        comboItemRec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboItemRec.setModel(new DefaultComboBoxModel<String>(new String[] {"Book", "Paper"}));
        comboItemRec.setBounds(156, 99, 85, 22);
        recommendPanel.add(comboItemRec);
        
        lblCalculation = new JLabel("Calculation");
        lblCalculation.setForeground(Color.ORANGE);
        lblCalculation.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblCalculation.setBounds(39, 217, 104, 30);
        recommendPanel.add(lblCalculation);
        
        label_17 = new JLabel("Calculation");
        label_17.setForeground(Color.BLACK);
        label_17.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_17.setBounds(38, 217, 104, 30);
        recommendPanel.add(label_17);
        
        label_18 = new JLabel("Calculation");
        label_18.setForeground(Color.BLACK);
        label_18.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_18.setBounds(40, 217, 104, 30);
        recommendPanel.add(label_18);
        
        label_19 = new JLabel("Calculation");
        label_19.setForeground(Color.BLACK);
        label_19.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_19.setBounds(39, 218, 104, 30);
        recommendPanel.add(label_19);
        
        label_20 = new JLabel("Calculation");
        label_20.setForeground(Color.BLACK);
        label_20.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        label_20.setBounds(39, 216, 104, 30);
        recommendPanel.add(label_20);
        
        comboCalcRec = new JComboBox<String>();
        comboCalcRec.setModel(new DefaultComboBoxModel<String>(new String[] {"Arithmetic", "Geometric", "Harmonic"}));
        comboCalcRec.setBackground(Color.ORANGE);
        comboCalcRec.setBounds(157, 222, 85, 22);
        recommendPanel.add(comboCalcRec);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setText("<html><center>"+"GENERATE"+"<br>"+"NOW!</center></html>");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//Takes all the fields and combobox selection relevant and returns the corresponding recommender output
        		if (MainFrame.getLibrary().getItems() == null) {
        			JOptionPane.showMessageDialog(null, "Nothing to recommend");
        			return;
        		}
        		try {
					resetReader(reader);
				} catch (ReaderNotExistException e) {
					e.printStackTrace();
				}
        		Recommender rec = Recommender.getInstance();
        		String item = (String)comboItemRec.getSelectedItem();
        		String asPer = (String) comboAsPerRec.getSelectedItem();
        		String calc = (String) comboCalcRec.getSelectedItem();
        		int k = kSliderRec.getValue();
        		String out = "";
        		if (item == "Book" && asPer == "Topic" && calc == "Arithmetic") {
        			for (Book b: rec.recommendBooksByTopic(reader, k, new ArithmeticMean(), MainFrame.getLibrary().getItems())) {
        				System.out.println(b.getTopic());
        				out += b.getName() + ":      Topic: " +b.getTopic() +"\n";
        			}
        		}else if (item == "Book" && asPer == "Topic" && calc == "Geometric") {
        			for (Book b: rec.recommendBooksByTopic(reader, k, new GeometricMean(), MainFrame.getLibrary().getItems())) {
        				System.out.println(b.getTopic());
        				out += b.getName() + ":      Topic: " +b.getTopic() +"\n";
        			}
        		}else if (item == "Book" && asPer == "Topic" && calc == "Harmonic") {
        			for (Book b: rec.recommendBooksByTopic(reader, k, new HarmonicMean(), MainFrame.getLibrary().getItems())) {
        				System.out.println(b.getTopic());
        				out += b.getName() + ":      Topic: " +b.getTopic() +"\n";
        			}
        		}else if (item == "Book" && asPer == "Author" && calc == "Arithmetic") {
        			for (Book b: rec.recommendBooksByAuthor(reader, k, new ArithmeticMean(), MainFrame.getLibrary().getItems())) {
        				out += b.getName() + ":      " +b.getAuthor() +b.getTopic()+"\n";
        			}
        		}else if (item == "Book" && asPer == "Author" && calc == "Geometric") {
        			for (Book b: rec.recommendBooksByAuthor(reader, k, new GeometricMean(), MainFrame.getLibrary().getItems())) {
        				out += b.getName() + ":      " +b.getAuthor() +"\n";
        			}
        		}else if (item == "Book" && asPer == "Author" && calc == "Harmonic") {
        			for (Book b: rec.recommendBooksByAuthor(reader, k, new HarmonicMean(), MainFrame.getLibrary().getItems())) {
        				out += b.getName() + ":      " +b.getAuthor() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Topic" && calc == "Arithmetic") {
        			System.out.println("Im in");
        			for (Paper p: rec.recommendPapersByTopic(reader, k, new ArithmeticMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":       Topic: " +p.getTopic() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Topic" && calc == "Geometric") {
        			for (Paper p: rec.recommendPapersByTopic(reader, k, new GeometricMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":       Topic: " +p.getTopic() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Topic" && calc == "Harmonic") {
        			for (Paper p: rec.recommendPapersByTopic(reader, k, new HarmonicMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":       Topic: " +p.getTopic() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Author" && calc == "Arithmetic") {
        			for (Paper p: rec.recommendPapersByAuthor(reader, k, new ArithmeticMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":      " +p.getAuthor() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Author" && calc == "Geometric") {
        			for (Paper p: rec.recommendPapersByAuthor(reader, k, new GeometricMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":      " +p.getAuthor() +"\n";
        			}
        		}else if (item == "Paper" && asPer == "Author" && calc == "Harmonic") {
        			for (Paper p: rec.recommendPapersByAuthor(reader, k, new HarmonicMean(), MainFrame.getLibrary().getItems())) {
        				out += p.getName() + ":      " +p.getAuthor() +"\n";
        			}
        		}
        		if (out == "")
        			return;
        		JOptionPane.showMessageDialog(null, out);
        	}
        });
        btnNewButton.setBackground(Color.ORANGE);
        btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 28));
        btnNewButton.setBounds(330, 97, 181, 150);
        recommendPanel.add(btnNewButton);
        
        lblFor_3 = new JLabel("As Per");
        lblFor_3.setForeground(Color.ORANGE);
        lblFor_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblFor_3.setBounds(39, 176, 104, 30);
        recommendPanel.add(lblFor_3);
        
        lblFor_2 = new JLabel("As Per");
        lblFor_2.setForeground(Color.BLACK);
        lblFor_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblFor_2.setBounds(38, 176, 104, 30);
        recommendPanel.add(lblFor_2);
        
        lblFor_1 = new JLabel("As Per");
        lblFor_1.setForeground(Color.BLACK);
        lblFor_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblFor_1.setBounds(40, 176, 104, 30);
        recommendPanel.add(lblFor_1);
        
        lblFor = new JLabel("As Per");
        lblFor.setForeground(Color.BLACK);
        lblFor.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblFor.setBounds(39, 177, 104, 30);
        recommendPanel.add(lblFor);
        
        lblAsPer = new JLabel("As Per");
        lblAsPer.setForeground(Color.BLACK);
        lblAsPer.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
        lblAsPer.setBounds(39, 175, 104, 30);
        recommendPanel.add(lblAsPer);
        
        comboAsPerRec = new JComboBox<String>();
        comboAsPerRec.setModel(new DefaultComboBoxModel<String>(new String[] {"Author", "Topic"}));
        comboAsPerRec.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboAsPerRec.setBackground(Color.ORANGE);
        comboAsPerRec.setBounds(156, 181, 85, 22);
        recommendPanel.add(comboAsPerRec);
        
        kSliderRec = new JSlider();
        kSliderRec.setBackground(Color.WHITE);
        kSliderRec.setSnapToTicks(true);
        kSliderRec.setMajorTickSpacing(1);
        kSliderRec.setPaintLabels(true);
        kSliderRec.setValue(5);
        kSliderRec.setMaximum(9);
        kSliderRec.setMinimum(1);
        kSliderRec.setBounds(155, 131, 85, 35);
        recommendPanel.add(kSliderRec);
        EmptyPanel.setVisible(true);
	}
	
	//--------Sets the current review selected in the change review panel
	
	protected void setReviewToChange() throws ReaderNotExistException {
		resetReader(this.reader);
		String itemName = (String) revComboBox.getSelectedItem();
		LibraryItem item = MainFrame.getLibrary().getItem(itemName);
		if (item == null) {
			return;
		}
		for (Review rev: item.getReviews()) {
			if ((rev.getfName() + " " + rev.getlName()).equals(this.reader.getfName()+ " " + this.reader.getlName())) {
				sentenceArea.setText(rev.getReviewSentence());
				slider.setValue(rev.getRate());
			}
		}
	}
	
	//--------Add new Review
	
	protected void addReview() throws ReaderNotExistException {
		if (revComboBox.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "You haven't read anything yet!");
			return;
		}
		Pattern p = Pattern.compile("[a-zA-Z0-9_]+.*$");
		Matcher m = p.matcher(sentenceArea.getText());
		if (!(!sentenceArea.getText().isEmpty() && m.matches())) {
			JOptionPane.showMessageDialog(null, "Sentence is invalid! \nPlease use only alphanumeric characters");
			return;
		}
		
		Review review = new Review(this.reader.getfName(), this.reader.getlName(), (String)revComboBox.getSelectedItem(), sentenceArea.getText(), slider.getValue());
		
		if (state.equals(ReviewState.Change)) {
			changeReview(this.reader.getfName() + " " +this.reader.getlName());
			setReviewToChange();
			return;
		}
		
		if (MainFrame.getLibrary().getBookByName((String)revComboBox.getSelectedItem()) != null) {
			Book book = MainFrame.getLibrary().getBookByName((String)revComboBox.getSelectedItem()); //Get Real Book
			if (MainFrame.getLibrary().makeReview(book, review)) {
				JOptionPane.showMessageDialog(null, "Thank you for your review!");
				sentenceArea.setText("");
				slider.setValue(5);
				revComboBox.removeItem((String)revComboBox.getSelectedItem());
//			}else if(state.equals(ReviewState.Change)) {
//				changeReview(this.reader.getfName() + " " +this.reader.getlName());
//				setReviewToChange();
			} else {
				JOptionPane.showMessageDialog(null, "You already reviewed " +book.getName() + " \nOnly one review allowed");
			}
			
		}else if (MainFrame.getLibrary().getPaperByName((String)revComboBox.getSelectedItem()) != null) {
			Paper paper =MainFrame.getLibrary().getPaperByName((String)revComboBox.getSelectedItem()); //Get Real Paper
			if (MainFrame.getLibrary().makeReview(paper, review)) {
				JOptionPane.showMessageDialog(null, "Thank you for your review!");
				sentenceArea.setText("");
				slider.setValue(5);
//			}else if(state.equals(ReviewState.Change)) {
//				changeReview(this.reader.getfName() + " " +this.reader.getlName());
//				setReviewToChange();
			} else {
				JOptionPane.showMessageDialog(null, "You already reviewed " +paper.getName() + " \nOnly one review allowed");
			}
		}
	}
	
	//----------Changes the Review
	
	private void changeReview(String readerName) throws ReaderNotExistException {
		resetReader(this.reader);
		String itemName = (String) revComboBox.getSelectedItem();
		LibraryItem item = MainFrame.getLibrary().getItem(itemName);
		if (item == null) {
			return;
		}
		for (Review rev: item.getReviews()) {
			if ((rev.getfName() + " " + rev.getlName()).equals(readerName)) {
				rev.setReviewSentence(sentenceArea.getText());
				rev.setRate(slider.getValue());
				JOptionPane.showMessageDialog(null, "Review for " + rev.getBookName() + " changed successfully");
				MainFrame.save();
			}
		}
		
	}
	//----------Sets review combobox
	
	protected void setReviewComboBox() throws ReaderNotExistException {
		resetReader(this.reader);
		revComboBox.removeAllItems();
		if (this.state.equals(ReviewState.Add)) {
			addRev.setText("Add");
			for (LibraryItem li : MainFrame.getLibrary().getReaderById(this.reader.getId()).getItems().values()) {
				if (!MainFrame.getLibrary().getReaderReviewedItems(this.reader).contains(li.getName()))
					revComboBox.addItem(li.getName());
			}
		}else if (this.state.equals(ReviewState.Change)) {
			addRev.setText("Change");
			for (String str : MainFrame.getLibrary().getReaderReviewedItems(this.reader)) {
				revComboBox.addItem(str);
			}
		}
	}
	
	//---------Sets Reader books and papers

	protected void setMyBooksAndPapers() throws ReaderNotExistException {
		if (this.panelType.equals(PanelType.Book)) {
			model.clear();
			removeBooksPapersComboBox.removeAllItems();
			addBooksPapersComboBox.removeAllItems();
			for (Book book: MainFrame.getLibrary().getBooks()) {
	        	addBooksPapersComboBox.addItem(book.getName());
	        }
			lblMyBooksPapers.setText("My Books");
			lblAddBookPaper.setText("Read Book");
			lblRemoveBookPaper.setText("Unread Book");
			if (MainFrame.getLibrary().getReaderById(this.reader.getId()).getItems() != null) {
				for (LibraryItem li : MainFrame.getLibrary().getReaderById(this.reader.getId()).getItems().values()) {
					if (li instanceof Book) {
						removeBooksPapersComboBox.addItem(li.getName());
						model.addElement(li.getName());
						addBooksPapersComboBox.removeItem(li.getName());
					}
				}
				myBookPaperList = new JList<String>(model);
			}
		}else if (this.panelType.equals(PanelType.Paper)) {
			model.clear();
			addBooksPapersComboBox.removeAllItems();
			removeBooksPapersComboBox.removeAllItems();
			for (Paper paper: MainFrame.getLibrary().getPapers()) {
	        	addBooksPapersComboBox.addItem(paper.getName());
	        }
			lblMyBooksPapers.setText("My Papers");
			lblAddBookPaper.setText("Read Paper");
			lblRemoveBookPaper.setText("Unread Paper");
			if (MainFrame.getLibrary().getReaderById(this.reader.getId()).getItems() != null) {
				model.clear();
				for (LibraryItem li : MainFrame.getLibrary().getReaderById(this.reader.getId()).getItems().values()) {
					if (li instanceof Paper) {
						removeBooksPapersComboBox.addItem(li.getName());
						model.addElement(li.getName());
						addBooksPapersComboBox.removeItem(li.getName());
					}
				}
				myBookPaperList = new JList<String>(model);
			}
		} 
	}
	//---------Sets the profile picture with JFileChooser
	private void setProfilePicture() {
		JFileChooser chooser= new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", ".jpg", ".gif" , ".png");
		chooser.addChoosableFileFilter(filter);
		int result = chooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			MainFrame.getLibrary().setReaderProfilePath(this.reader.getfName() + " " + this.reader.getlName(), path);
			lblProfilePic.setIcon(resizeImage(path));
		}else if (result == JFileChooser.CANCEL_OPTION) {
			
		}
	}
	
	//-------resize the image to fit the box
	
	private ImageIcon resizeImage(String path) {
		ImageIcon myImage = new ImageIcon(path);
		Image img = myImage.getImage();
		Image myImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon toReturn = new ImageIcon(myImg);	
		return toReturn;
	}
	
	//--------Resets the reader
	public void resetReader(Reader reader) throws ReaderNotExistException {
		this.reader = MainFrame.getLibrary().getReaderById(reader.getId());
	}
	
	//--------Initiates the reader and labels
	public void setReader(Reader reader) throws ReaderNotExistException {
		this.reader = MainFrame.getLibrary().getReaderById(reader.getId());
		String name = reader.getfName() + " " + reader.getlName();
		lblHiUser.setText("Hi " + name);
		setBorder(new TitledBorder(null, name, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		if (MainFrame.getLibrary().getReaderProfilePath(name) != null)
			lblProfilePic.setIcon(resizeImage(MainFrame.getLibrary().getReaderProfilePath(name)));
		else lblProfilePic.setIcon(defaultProfilePic);
		myBooksPapersPanel.setVisible(false);
		EmptyPanel.setVisible(true);
	}
}
