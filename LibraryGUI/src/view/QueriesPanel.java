package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Model.ArithmeticMean;
import Model.Author;
import Model.Encyclopedia;
import Model.Magazine;
import Utils.Topic;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class QueriesPanel extends JPanel{
	private JButton readerModBtn;
	private JButton authorModBtn;
	private JButton bookModBtn;
	private JButton paperModBtn;
	private JButton encyclopediaModBtn;
	private JButton magazineModBtn;
	
	private JPanel bookQueryPanel;
	private JPanel readerQueryPanel;
	private JPanel encyclopediaQueryPanel;
	private JPanel authorQueryPanel;
	private JPanel paperQueryPanel;
	private JPanel magazineQueryPanel;
	private Topic t;
	private Author a;
	
	
	
	public QueriesPanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Query Generator 3000", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
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
				readerModBtn.setVisible(false);
				authorModBtn.setVisible(true);
				bookModBtn.setVisible(true);
				paperModBtn.setVisible(true);
				magazineModBtn.setVisible(true);
				encyclopediaModBtn.setVisible(true);
				readerQueryPanel.setVisible(true);
				authorQueryPanel.setVisible(false);
				bookQueryPanel.setVisible(false);
				paperQueryPanel.setVisible(false);
				encyclopediaQueryPanel.setVisible(false);
				magazineQueryPanel.setVisible(false);
			}
		});
		readerModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		readerModBtn.setBackground(Color.ORANGE);
		readerModBtn.setBounds(66, 192, 130, 65);
		add(readerModBtn);
		
		authorModBtn = new JButton("Author");
		authorModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerModBtn.setVisible(true);
				authorModBtn.setVisible(false);
				bookModBtn.setVisible(true);
				paperModBtn.setVisible(true);
				magazineModBtn.setVisible(true);
				encyclopediaModBtn.setVisible(true);
				readerQueryPanel.setVisible(false);
				authorQueryPanel.setVisible(true);
				bookQueryPanel.setVisible(false);
				paperQueryPanel.setVisible(false);
				encyclopediaQueryPanel.setVisible(false);
				magazineQueryPanel.setVisible(false);
			}
		});
		authorModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		authorModBtn.setBackground(Color.ORANGE);
		authorModBtn.setBounds(66, 317, 130, 62);
		add(authorModBtn);
		
		bookModBtn = new JButton("Book");
		bookModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerModBtn.setVisible(true);
				authorModBtn.setVisible(true);
				bookModBtn.setVisible(false);
				paperModBtn.setVisible(true);
				magazineModBtn.setVisible(true);
				encyclopediaModBtn.setVisible(true);
				readerQueryPanel.setVisible(false);
				authorQueryPanel.setVisible(false);
				bookQueryPanel.setVisible(true);
				paperQueryPanel.setVisible(false);
				encyclopediaQueryPanel.setVisible(false);
				magazineQueryPanel.setVisible(false);			}
		});
		bookModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		bookModBtn.setBackground(Color.ORANGE);
		bookModBtn.setBounds(325, 192, 130, 65);
		add(bookModBtn);
		
		paperModBtn = new JButton("Paper");
		paperModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerModBtn.setVisible(true);
				authorModBtn.setVisible(true);
				bookModBtn.setVisible(true);
				paperModBtn.setVisible(false);
				magazineModBtn.setVisible(true);
				encyclopediaModBtn.setVisible(true);
				readerQueryPanel.setVisible(false);
				authorQueryPanel.setVisible(false);
				bookQueryPanel.setVisible(false);
				paperQueryPanel.setVisible(true);
				encyclopediaQueryPanel.setVisible(false);
				magazineQueryPanel.setVisible(false);			}
		});
		paperModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		paperModBtn.setBackground(Color.ORANGE);
		paperModBtn.setBounds(325, 317, 130, 62);
		add(paperModBtn);
		
		encyclopediaModBtn = new JButton("Encyclopedia");
		encyclopediaModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerModBtn.setVisible(true);
				authorModBtn.setVisible(true);
				bookModBtn.setVisible(true);
				paperModBtn.setVisible(true);
				magazineModBtn.setVisible(true);
				encyclopediaModBtn.setVisible(false);
				readerQueryPanel.setVisible(false);
				authorQueryPanel.setVisible(false);
				bookQueryPanel.setVisible(false);
				paperQueryPanel.setVisible(false);
				encyclopediaQueryPanel.setVisible(true);
				magazineQueryPanel.setVisible(false);			}
		});
		encyclopediaModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		encyclopediaModBtn.setBackground(Color.ORANGE);
		encyclopediaModBtn.setBounds(586, 192, 130, 65);
		add(encyclopediaModBtn);
		
		magazineModBtn = new JButton("Magazine");
		magazineModBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerModBtn.setVisible(true);
				authorModBtn.setVisible(true);
				bookModBtn.setVisible(true);
				paperModBtn.setVisible(true);
				magazineModBtn.setVisible(false);
				encyclopediaModBtn.setVisible(true);
				readerQueryPanel.setVisible(false);
				authorQueryPanel.setVisible(false);
				bookQueryPanel.setVisible(false);
				paperQueryPanel.setVisible(false);
				encyclopediaQueryPanel.setVisible(false);
				magazineQueryPanel.setVisible(true);			}
		});
		magazineModBtn.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		magazineModBtn.setBackground(Color.ORANGE);
		magazineModBtn.setBounds(586, 318, 130, 62);
		add(magazineModBtn);
		
		JLabel lblCall2Action = new JLabel("Welcome to Query Generator 3000");
		lblCall2Action.setHorizontalAlignment(SwingConstants.CENTER);
		lblCall2Action.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCall2Action.setBounds(260, 128, 261, 30);
		add(lblCall2Action);
		
		JButton button = new JButton("<--");
		button.setBackground(Color.ORANGE);
		button.setMargin(new Insets(0, 13, 0, 0));
		button.setIcon(new ImageIcon(getClass().getResource("/backArrow.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.QueriesPanell2AdminControl();
			}
		});
		button.setBounds(12, 15, 56, 25);
		add(button);
		
		JLabel lblChooseYourFavourite = new JLabel("Choose your favourite query type");
		lblChooseYourFavourite.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseYourFavourite.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseYourFavourite.setBounds(275, 148, 235, 30);
		add(lblChooseYourFavourite);
		
		readerQueryPanel = new JPanel();
		readerQueryPanel.setBackground(Color.WHITE);
		readerQueryPanel.setVisible(false);
		readerQueryPanel.setBounds(12, 192, 249, 112);
		add(readerQueryPanel);
		readerQueryPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Best K Readers");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (MainFrame.getLibrary().getBestReaders(1) == null) {
					JOptionPane.showMessageDialog(null, "There are no readers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, "How many readers?" , "Best K Readers", JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
				int length = MainFrame.getLibrary().getBestReaders(k).toString().length();
				String out =MainFrame.getLibrary().getBestReaders(k).toString().substring(1, length-1);
				JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Readers":"Reader"), JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(0, 0, 113, 40);
		readerQueryPanel.add(btnNewButton_2);
		
		JButton btnAllReaders = new JButton("All Readers");
		btnAllReaders.setBackground(Color.ORANGE);
		btnAllReaders.setForeground(Color.BLACK);
		btnAllReaders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getReaders() == null)
					JOptionPane.showMessageDialog(null, "There are no readers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					int length = MainFrame.getLibrary().getReaders().toString().length();
					String out = MainFrame.getLibrary().getReaders().toString().substring(1, length -1);
					JOptionPane.showMessageDialog(null, out, "All Readers" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnAllReaders.setBounds(136, 0, 113, 40);
		readerQueryPanel.add(btnAllReaders);
		
		bookQueryPanel = new JPanel();
		bookQueryPanel.setBackground(Color.WHITE);
		bookQueryPanel.setVisible(false);
		bookQueryPanel.setBounds(266, 192, 249, 112);
		add(bookQueryPanel);
		bookQueryPanel.setLayout(null);
		
		JButton btnBestKBooks = new JButton("Best K Books");
		btnBestKBooks.setBackground(Color.ORANGE);
		btnBestKBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getBestBooks(1, new ArithmeticMean()) == null)
					JOptionPane.showMessageDialog(null, "There are no books in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
					Integer k = (Integer) JOptionPane.showInputDialog(null, "How many books?" , "Best K Books", JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
					int length = MainFrame.getLibrary().getBestBooks(k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestBooks(k, new ArithmeticMean()).toString().substring(1, length-1);
					JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Books":"Book"), JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnBestKBooks.setBounds(136, 0, 113, 40);
		bookQueryPanel.add(btnBestKBooks);
		
		JButton btnBestByTopic = new JButton("Best Book");
		btnBestByTopic.setBackground(Color.ORANGE);
		btnBestByTopic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (MainFrame.getLibrary().getBestBook(new ArithmeticMean()) != null)
					JOptionPane.showMessageDialog(null, MainFrame.getLibrary().getBestBook(new ArithmeticMean()), "Best Book", JOptionPane.PLAIN_MESSAGE);
				else JOptionPane.showMessageDialog(null, "There are no books in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBestByTopic.setBounds(0, 0, 113, 40);
		bookQueryPanel.add(btnBestByTopic);
		
		JButton btnBestByTopic_2 = new JButton("Best By Topic");
		btnBestByTopic_2.setBackground(Color.ORANGE);
		btnBestByTopic_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(250, 32);
		        panel.setLayout(new FlowLayout());
		        JLabel lbl = new JLabel("Choose topic:");
		        panel.add(lbl);
		        final JComboBox<Topic> topics = new JComboBox<Topic>();
				topics.setModel(new DefaultComboBoxModel<Topic>(Topic.values()));
				topics.setBounds(147, 282, 116, 22);
				t = (Topic)topics.getSelectedItem();
				topics.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						t = (Topic)topics.getSelectedItem();
					}
				});
				panel.add(topics);
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, panel, "Best K Books By Topic" ,JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
				
		        if (MainFrame.getLibrary().getBestAuthorBooks(a, k, new ArithmeticMean()) != null) {
		        	int length= MainFrame.getLibrary().getBestTopicBooks(t, k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestTopicBooks(t, k, new ArithmeticMean()).toString().substring(1, length-1);
		        	JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Books":"Book" + " of " +t.toString().toLowerCase()), JOptionPane.PLAIN_MESSAGE);
		        }else JOptionPane.showMessageDialog(null, "There are no " + t.toString().toLowerCase() +" books in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBestByTopic_2.setBounds(0, 40, 113, 40);
		bookQueryPanel.add(btnBestByTopic_2);
		
		JButton btnBestByAuthor = new JButton("Best By Author");
		btnBestByAuthor.setBackground(Color.ORANGE);
		btnBestByAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(250, 32);
		        panel.setLayout(new FlowLayout());
		        JLabel lbl = new JLabel("Choose author:");
		        panel.add(lbl);
		        final JComboBox<Author> authors = new JComboBox<Author>();
		        Author[] authArray = (Author[]) MainFrame.getLibrary().getAuthors().toArray(new Author[MainFrame.getLibrary().getAuthors().size()]);
				authors.setModel(new DefaultComboBoxModel<Author>(authArray));
				authors.setBounds(147, 282, 116, 22);
				a = (Author)authors.getSelectedItem();
				authors.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						a = (Author)authors.getSelectedItem();
					}
				});
				panel.add(authors);
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, panel, "Best K Books By Author" ,JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
				
		        if (MainFrame.getLibrary().getBestAuthorBooks(a, k, new ArithmeticMean()) != null) {
		        	int length= MainFrame.getLibrary().getBestAuthorBooks(a, k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestAuthorBooks(a, k, new ArithmeticMean()).toString().substring(1, length-1);
		        	JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Books":"Book" + " of " +a), JOptionPane.PLAIN_MESSAGE);
		        }else JOptionPane.showMessageDialog(null, "There are no " + a.toString().toLowerCase() +" books in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);

			}
		});
		btnBestByAuthor.setBounds(136, 40, 113, 40);
		bookQueryPanel.add(btnBestByAuthor);
		
		JButton btnAllBooks_1 = new JButton("All Books");
		btnAllBooks_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getBooks() == null)
					JOptionPane.showMessageDialog(null, "There are no books in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					int length = MainFrame.getLibrary().getBooks().toString().length();
					String out = MainFrame.getLibrary().getBooks().toString().substring(1, length -1);
					JOptionPane.showMessageDialog(null, out, "All Books" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnAllBooks_1.setBackground(Color.ORANGE);
		btnAllBooks_1.setBounds(68, 79, 113, 33);
		bookQueryPanel.add(btnAllBooks_1);
		
		encyclopediaQueryPanel = new JPanel();
		encyclopediaQueryPanel.setBackground(Color.WHITE);
		encyclopediaQueryPanel.setVisible(false);
		encyclopediaQueryPanel.setBounds(521, 192, 249, 112);
		add(encyclopediaQueryPanel);
		encyclopediaQueryPanel.setLayout(null);
		
		JButton btnAllTopics_1 = new JButton("All Topics");
		btnAllTopics_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encyclopedia[] encs = (Encyclopedia[]) MainFrame.getLibrary().getAllEncyclopedias().toArray(new Encyclopedia[MainFrame.getLibrary().getAllEncyclopedias().size()]);
				Encyclopedia chosen = null;
				if (encs!=null) {
					chosen = (Encyclopedia) JOptionPane.showInputDialog(null, "All Encyclopedia Topics", "Choose Encyclopedia" ,JOptionPane.QUESTION_MESSAGE, null, encs, encs[0]);
					int length = MainFrame.getLibrary().getEncyclopideaTopics(chosen).toString().length();
					String out = MainFrame.getLibrary().getEncyclopideaTopics(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Topics in " + chosen.getName() + " encyclopedia", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no books in " + chosen.getName() + " encyclopedia", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllTopics_1.setBackground(Color.ORANGE);
		btnAllTopics_1.setBounds(136, 0, 113, 40);
		encyclopediaQueryPanel.add(btnAllTopics_1);
		
		JButton btnAllBooks = new JButton("All Books");
		btnAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encyclopedia[] encs = (Encyclopedia[]) MainFrame.getLibrary().getAllEncyclopedias().toArray(new Encyclopedia[MainFrame.getLibrary().getAllEncyclopedias().size()]);
				Encyclopedia chosen = null;
				if (encs!=null) {
					chosen = (Encyclopedia) JOptionPane.showInputDialog(null, "All Encyclopedia Books", "Choose Encyclopedia" ,JOptionPane.QUESTION_MESSAGE, null, encs, encs[0]);
					int length = MainFrame.getLibrary().getEncyclopideaBooks(chosen).toString().length();
					String out = MainFrame.getLibrary().getEncyclopideaBooks(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Books in " + chosen.getName() + " encyclopedia", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no books in " + chosen.getName() + " encyclopedia", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllBooks.setBackground(Color.ORANGE);
		btnAllBooks.setBounds(0, 0, 113, 40);
		encyclopediaQueryPanel.add(btnAllBooks);
		
		JButton btnAllAuthors_1 = new JButton("All Authors");
		btnAllAuthors_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Encyclopedia[] encs = (Encyclopedia[]) MainFrame.getLibrary().getAllEncyclopedias().toArray(new Encyclopedia[MainFrame.getLibrary().getAllEncyclopedias().size()]);
				Encyclopedia chosen = null;
				if (encs!=null) {
					chosen = (Encyclopedia) JOptionPane.showInputDialog(null, "All Encyclopedia Authors", "Choose Encyclopedia" ,JOptionPane.QUESTION_MESSAGE, null, encs, encs[0]);
					int length = MainFrame.getLibrary().getEncyclopideaAuthors(chosen).toString().length();
					String out = MainFrame.getLibrary().getEncyclopideaAuthors(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Authors of " + chosen.getName() + " encyclopedia", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no books in " + chosen.getName() + " encyclopedia", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllAuthors_1.setBackground(Color.ORANGE);
		btnAllAuthors_1.setBounds(0, 53, 113, 40);
		encyclopediaQueryPanel.add(btnAllAuthors_1);
		
		JButton btnAllEncyclopedias = new JButton("All Encyclopedias");
		btnAllEncyclopedias.setBackground(Color.ORANGE);
		btnAllEncyclopedias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Encyclopedia> encs = MainFrame.getLibrary().getAllEncyclopedias();
				if (encs!=null) {
					int length = encs.toString().length();
					String out = encs.toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Ecyclopedias", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no encyclopedias in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllEncyclopedias.setBounds(136, 53, 113, 40);
		encyclopediaQueryPanel.add(btnAllEncyclopedias);
		
		authorQueryPanel = new JPanel();
		authorQueryPanel.setBackground(Color.WHITE);
		authorQueryPanel.setVisible(false);
		authorQueryPanel.setBounds(12, 317, 249, 112);
		add(authorQueryPanel);
		authorQueryPanel.setLayout(null);
		
		JButton btnAllAuthors_2 = new JButton("All Authors");
		btnAllAuthors_2.setBackground(Color.ORANGE);
		btnAllAuthors_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getAuthors() == null)
					JOptionPane.showMessageDialog(null, "There are no authors in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					int length = MainFrame.getLibrary().getAuthors().toString().length();
					String out = MainFrame.getLibrary().getAuthors().toString().substring(1, length -1);
					JOptionPane.showMessageDialog(null, out, "All Authors" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnAllAuthors_2.setBounds(136, 0, 113, 40);
		authorQueryPanel.add(btnAllAuthors_2);
		
		JButton btnBestAuthors = new JButton("Best K Authors");
		btnBestAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getBestReaders(1) == null) {
					JOptionPane.showMessageDialog(null, "There are no authors in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, "How many authors?" , "Best K Authors", JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
				int length = MainFrame.getLibrary().getBestAuthors(k).toString().length();
				String out =MainFrame.getLibrary().getBestAuthors(k).toString().substring(1, length-1);
				JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Authors":"Author"), JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnBestAuthors.setBackground(Color.ORANGE);
		btnBestAuthors.setBounds(0, 0, 113, 40);
		authorQueryPanel.add(btnBestAuthors);
		
		paperQueryPanel = new JPanel();
		paperQueryPanel.setBackground(Color.WHITE);
		paperQueryPanel.setVisible(false);
		paperQueryPanel.setBounds(266, 317, 249, 112);
		add(paperQueryPanel);
		paperQueryPanel.setLayout(null);
		
		JButton btnBestKPapers = new JButton("Best K Papers");
		btnBestKPapers.setBackground(Color.ORANGE);
		btnBestKPapers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getBestPapers(1, new ArithmeticMean()) == null)
					JOptionPane.showMessageDialog(null, "There are no papers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
					Integer k = (Integer) JOptionPane.showInputDialog(null, "How many papers?" , "Best K Papers", JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
					int length = MainFrame.getLibrary().getBestPapers(k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestPapers(k, new ArithmeticMean()).toString().substring(1, length-1);
					JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Papers":"Paper"), JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnBestKPapers.setBounds(136, 0, 113, 40);
		paperQueryPanel.add(btnBestKPapers);
		
		JButton btnBestPaper = new JButton("Best Paper");
		btnBestPaper.setBackground(Color.ORANGE);
		btnBestPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getBestPaper(new ArithmeticMean()) != null)
					JOptionPane.showMessageDialog(null, MainFrame.getLibrary().getBestPaper(new ArithmeticMean()), "Best Paper", JOptionPane.PLAIN_MESSAGE);
				else JOptionPane.showMessageDialog(null, "There are no papers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnBestPaper.setBounds(0, 0, 113, 40);
		paperQueryPanel.add(btnBestPaper);
		
		JButton btnBestByTopic_3 = new JButton("Best By Topic");
		btnBestByTopic_3.setBackground(Color.ORANGE);
		btnBestByTopic_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(250, 32);
		        panel.setLayout(new FlowLayout());
		        JLabel lbl = new JLabel("Choose topic:");
		        panel.add(lbl);
		        final JComboBox<Topic> topics = new JComboBox<Topic>();
				topics.setModel(new DefaultComboBoxModel<Topic>(Topic.values()));
				topics.setBounds(147, 282, 116, 22);
				t = (Topic)topics.getSelectedItem();
				topics.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						t = (Topic)topics.getSelectedItem();
					}
				});
				panel.add(topics);
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, panel, "Best K Papers By Topic" ,JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
				
		        if (MainFrame.getLibrary().getBestTopicPapers(t, k, new ArithmeticMean()) != null) {
		        	int length= MainFrame.getLibrary().getBestTopicPapers(t, k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestTopicPapers(t, k, new ArithmeticMean()).toString().substring(1, length-1);
		        	JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Papers":"Paper" + " of " +t.toString().toLowerCase()), JOptionPane.PLAIN_MESSAGE);
		        }else JOptionPane.showMessageDialog(null, "There are no " + t.toString().toLowerCase() +" papers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);

			}
		});
		btnBestByTopic_3.setBounds(0, 40, 113, 40);
		paperQueryPanel.add(btnBestByTopic_3);
		
		JButton btnBestByAuthor_1 = new JButton("Best By Author");
		btnBestByAuthor_1.setBackground(Color.ORANGE);
		btnBestByAuthor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setSize(250, 32);
		        panel.setLayout(new FlowLayout());
		        JLabel lbl = new JLabel("Choose author:");
		        panel.add(lbl);
			    final JComboBox<Author> authors = new JComboBox<Author>();
			    Author[] authArray = (Author[]) MainFrame.getLibrary().getAuthors().toArray(new Author[MainFrame.getLibrary().getAuthors().size()]);
			    authors.setModel(new DefaultComboBoxModel<Author>(authArray));
				authors.setBounds(147, 282, 116, 22);
				a = (Author)authors.getSelectedItem();
				authors.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						a = (Author)authors.getSelectedItem();
					}
				});
				panel.add(authors);
				Integer[] kInts = {1, 2, 3, 4,5,6,7,8,9};
				Integer k = (Integer) JOptionPane.showInputDialog(null, panel, "Best K Papers By Author" ,JOptionPane.QUESTION_MESSAGE, null, kInts, kInts[0]);
					
			    if (MainFrame.getLibrary().getBestAuthorPapers(a, k, new ArithmeticMean()) != null) {
		        	int length= MainFrame.getLibrary().getBestAuthorPapers(a, k, new ArithmeticMean()).toString().length();
					String out =MainFrame.getLibrary().getBestAuthorPapers(a, k, new ArithmeticMean()).toString().substring(1, length-1);
					JOptionPane.showMessageDialog(null, out, "Best " + (k>1 ?  k + " Papers":"Paper" + " of " +a), JOptionPane.PLAIN_MESSAGE);
			    }else JOptionPane.showMessageDialog(null, "There are no " + a.toString().toLowerCase() +" papers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
			
		});
		btnBestByAuthor_1.setBounds(136, 40, 113, 40);
		paperQueryPanel.add(btnBestByAuthor_1);
		
		JButton btnAllPapers_1 = new JButton("All Papers");
		btnAllPapers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (MainFrame.getLibrary().getPapers() == null)
					JOptionPane.showMessageDialog(null, "There are no papers in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				else {
					int length = MainFrame.getLibrary().getPapers().toString().length();
					String out = MainFrame.getLibrary().getPapers().toString().substring(1, length -1);
					JOptionPane.showMessageDialog(null, out, "All Papers" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnAllPapers_1.setBackground(Color.ORANGE);
		btnAllPapers_1.setBounds(66, 79, 113, 33);
		paperQueryPanel.add(btnAllPapers_1);
		
		magazineQueryPanel = new JPanel();
		magazineQueryPanel.setBackground(Color.WHITE);
		magazineQueryPanel.setVisible(false);
		magazineQueryPanel.setBounds(521, 317, 249, 112);
		add(magazineQueryPanel);
		magazineQueryPanel.setLayout(null);
		
		JButton btnAllTopics = new JButton("All Topics");
		btnAllTopics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Magazine[] mags = (Magazine[]) MainFrame.getLibrary().getAllMagazines().toArray(new Magazine[MainFrame.getLibrary().getAllMagazines().size()]);
				Magazine chosen = null;
				if (mags!=null) {
					chosen = (Magazine) JOptionPane.showInputDialog(null, "All Magazine Topics", "Choose Magazine" ,JOptionPane.QUESTION_MESSAGE, null, mags, mags[0]);
					int length = MainFrame.getLibrary().getMagazineTopics(chosen).toString().length();
					String out = MainFrame.getLibrary().getMagazineTopics(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Topics in " + chosen.getName() + " magazine", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no papers in " + chosen.getName() + " magazine", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no magazines in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllTopics.setBackground(Color.ORANGE);
		btnAllTopics.setBounds(136, 0, 113, 40);
		magazineQueryPanel.add(btnAllTopics);
		
		JButton btnAllPapers = new JButton("All Papers");
		btnAllPapers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Magazine[] mags = (Magazine[]) MainFrame.getLibrary().getAllMagazines().toArray(new Magazine[MainFrame.getLibrary().getAllMagazines().size()]);
				Magazine chosen = null;
				if (mags!=null) {
					chosen = (Magazine) JOptionPane.showInputDialog(null, "All Magazine Books", "Choose Magazine" ,JOptionPane.QUESTION_MESSAGE, null, mags, mags[0]);
					int length = MainFrame.getLibrary().getMagazinePapers(chosen).toString().length();
					String out = MainFrame.getLibrary().getMagazinePapers(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Papers in " + chosen.getName() + " magazine", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no papers in " + chosen.getName() + " magazine", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no magazines in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllPapers.setBackground(Color.ORANGE);
		btnAllPapers.setBounds(0, 0, 113, 40);
		magazineQueryPanel.add(btnAllPapers);
		
		JButton btnAllAuthors = new JButton("All Authors");
		btnAllAuthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Magazine[] mags = (Magazine[]) MainFrame.getLibrary().getAllMagazines().toArray(new Magazine[MainFrame.getLibrary().getAllMagazines().size()]);
				Magazine chosen = null;
				if (mags!=null) {
					chosen = (Magazine) JOptionPane.showInputDialog(null, "All Magazine Books", "Choose Magazine" ,JOptionPane.QUESTION_MESSAGE, null, mags, mags[0]);
					int length = MainFrame.getLibrary().getMagazineAuthors(chosen).toString().length();
					String out = MainFrame.getLibrary().getMagazineAuthors(chosen).toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Authors of " + chosen.getName() + " magazine", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no papers in " + chosen.getName() + " magazine", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no magazines in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllAuthors.setBackground(Color.ORANGE);
		btnAllAuthors.setBounds(0, 53, 113, 40);
		magazineQueryPanel.add(btnAllAuthors);
		
		JButton btnAllMagazines = new JButton("All Magazines");
		btnAllMagazines.setBackground(Color.ORANGE);
		btnAllMagazines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Magazine> mags = MainFrame.getLibrary().getAllMagazines();
				if (mags!=null) {
					int length = mags.toString().length();
					String out = mags.toString().substring(1, length-1);
					if (out.length() != 0)
						JOptionPane.showMessageDialog(null, out , "Magazines", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "There are no magazines in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "There are no magazines in the library", "Whoops!",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAllMagazines.setBounds(136, 53, 113, 40);
		magazineQueryPanel.add(btnAllMagazines);
		
	}
}
