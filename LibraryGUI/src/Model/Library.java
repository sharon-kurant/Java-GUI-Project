package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Exceptions.AuthorAlreadyExistException;
import Exceptions.AuthorNotExistException;
import Exceptions.LibrarianAlreadyExistException;
import Exceptions.LibrarianNotExistException;
import Exceptions.ReaderAlreadyExistException;
import Exceptions.ReaderNotExistException;
import Exceptions.itemAlreadyExistException;
import Exceptions.itemNotExistException;
import Utils.Topic;
import Utils.UserSelected;

public class Library implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9063648479884770447L;
	private static Library LIBRARY;
	private HashMap<String, LibraryUser> users;
	private HashMap<String, LibraryItem> items;
	private HashMap<String, LibraryCollection> collecs;
	private Recommender recommender;
	private HashMap<String, LibraryUser> creds;
	private HashMap<String, String> profilePicMap;
	
	public static Library getInstance() {
		if (LIBRARY == null) {
			LIBRARY= new Library();
		}
		return LIBRARY;
	}
	
	public Library() {
		super();
		this.users = new HashMap<String, LibraryUser>();
		this.items = new HashMap<String, LibraryItem>();
		this.collecs = new HashMap<String, LibraryCollection>();
		this.creds = new HashMap<String, LibraryUser>();
		this.recommender = new Recommender();
		this.profilePicMap = new HashMap<String, String>();
	}
	
	//---------------------------------------Get Book/Paper by Name-------------------------------------
	
	public Book getBookByName(String name) {
		if (name == null)
			return null;
		if (items.containsKey(name) && (items.get(name) instanceof Book)) {
			return (Book) items.get(name);
		}
		else return null;
	}
	
	public Paper getPaperByName(String name) {
		if (name == null)
			return null;
		if (items.containsKey(name) && (items.get(name) instanceof Paper)) {
			return (Paper) items.get(name);
		}
		else return null;
	}

	//---------------------------------------ADD/REMOVE READER & LIBRARIAN CREDENTIALS-------------------------------------

	public boolean setReaderProfilePath(String readerName, String path) {
		if (path == null)
			return false;
		profilePicMap.put(readerName, path);
		return true;
	}
	
	public String getReaderProfilePath(String readerName) {
		if (readerName == null)
			return null;
		if (profilePicMap.get(readerName) != null) {
			return profilePicMap.get(readerName);
		}
		return null;
	}
	
	
	//---------------------------------------ADD/REMOVE READER & LIBRARIAN CREDENTIALS-------------------------------------
	
	public boolean addReaderCred(Reader reader) {
		return creds.put(reader.getId(), reader)==null;
	}
	
	public boolean addLibrarianCred(Librarian librarian) {
		return creds.put(librarian.getId(), librarian)==null;
	}
	
	public boolean removeReaderCred(Reader reader) {
		return creds.remove(reader.getId()) !=null;
	}
	
	public boolean removeLibrarianCred(Librarian librarian) {
		return creds.remove(librarian.getId()) !=null;
	}
	
	//---------------------------------------Get READER & LIBRARIAN BY ID-------------------------------------
	
	public Reader getReaderById(String Id) throws ReaderNotExistException {
		Reader reader = null;
		if (!creds.containsKey(Id) || !(creds.get(Id) instanceof Reader))
			throw new ReaderNotExistException("Wrong Id");	
		reader = (Reader)creds.get(Id);
		return reader;
	}
	
	public Librarian getLibrarianById(String Id) throws LibrarianNotExistException {
		Librarian librarian = null;
		if (!creds.containsKey(Id) || !(creds.get(Id) instanceof Librarian))
			throw new LibrarianNotExistException("Wrong Id");	
		librarian = (Librarian)creds.get(Id);
		return librarian;
	}
	
	//---------------------------------------CHECK READER & LIBRARIAN CREDENTIALS-------------------------------------
	
	public LibraryUser checkCreds(UserSelected type, String Id, String pass) throws LibrarianNotExistException, ReaderNotExistException{

		if (type.equals(UserSelected.Reader) || type.equals(UserSelected.Admin)) {
			if (creds.get(Id) != null && creds.get(Id) instanceof Reader) {
				Reader toReturn = (Reader) creds.get(Id);
				if (toReturn.getId().equals(Id) && toReturn.getPassword().equals(pass))
					return toReturn;
			}throw new ReaderNotExistException("Id or password are wrong");

		} if (type.equals(UserSelected.Librarian) || type.equals(UserSelected.Admin)){
			if (creds.get(Id) != null && creds.get(Id) instanceof Librarian) {
				Librarian toReturn = (Librarian) creds.get(Id);
				if (toReturn.getId().equals(Id) && toReturn.getPassword().equals(pass))
					return toReturn;

			}throw new LibrarianNotExistException("Id or password are wrong");
		}
		return null;
	}
	
	//---------------------------------------ADD/REMOVE READER-------------------------------------
	public boolean addReader(Reader reader) throws ReaderAlreadyExistException {
		if (reader == null)
			return false;
		String name = reader.getfName() + " " + reader.getlName();
		if (users.containsKey(name) || creds.containsKey(reader.getId())) {
			throw new ReaderAlreadyExistException(name);
		}
		return users.put(name, reader)==null && addReaderCred(reader);
	}
	
	public boolean removeReader(Reader reader) throws ReaderNotExistException{
		if (reader == null)
			return false;
		String name = reader.getfName() + " " + reader.getlName();
		if (!users.containsKey(name)) {
			throw new ReaderNotExistException(name);
		}
		return users.remove(name)!=null && removeReaderCred(reader);
	}
	
	public boolean removeReader(String name) throws ReaderNotExistException{
		if (name == null)
			return false;
		if (!users.containsKey(name)) {
			throw new ReaderNotExistException(name);
		}
		Reader toRemove = (Reader) users.get(name);
		return users.remove(name)!=null && removeReaderCred(toRemove);
	}

	//---------------------------------------ADD/REMOVE AUTHOR-------------------------------------
	
	public Author getAuthorByName(String authorFirstName, String authorLastName) {
		return (Author) users.get(authorFirstName + " " + authorLastName);
	}
	
	public boolean addAuther(Author author) throws AuthorAlreadyExistException {
		if (author == null)
			return false;
		String name = author.getfName() + " " + author.getlName();
		if (users.containsKey(name)) {
			throw new AuthorAlreadyExistException(name);
		}
		return users.put(name, author)==null;
	}

	public boolean removeAuthor(Author author) throws AuthorNotExistException{
		if (author == null)
			return false;
		String name = author.getfName() + " " + author.getlName();
		if (!users.containsKey(name)) {
			throw new AuthorNotExistException(name);
		}
		return users.remove(name)!=null;
	}
	
	public boolean removeAuthor(String name) throws AuthorNotExistException{
		if (name == null)
			return false;
		if (!users.containsKey(name)) {
			throw new AuthorNotExistException(name);
		}
		return users.remove(name)!=null;
	}
	
	//---------------------------------------ADD/REMOVE Librarian-------------------------------------
	
	public Librarian getLibrarianByName(String authorFirstName, String authorLastName) {
		return (Librarian) users.get(authorFirstName + " " + authorLastName);
	}
	
	public boolean addLibrarian(Librarian librarian) throws LibrarianAlreadyExistException {
		if (librarian == null)
			return false;
		String name = librarian.getfName() + " " + librarian.getlName();
		if (users.containsKey(name) || creds.containsKey(librarian.getId())) {
			throw new LibrarianAlreadyExistException(name);
		}
		return users.put(name, librarian)==null && addLibrarianCred(librarian);
	}

	public boolean removeLibrarian(Librarian librarian) throws LibrarianNotExistException{
		if (librarian == null)
			return false;
		String name = librarian.getfName() + " " + librarian.getlName();
		if (!users.containsKey(name)) {
			throw new LibrarianNotExistException(name);
		}
		return users.remove(name)!=null && removeLibrarianCred(librarian);
	}
	
	public boolean removeLibrarian(String name) throws LibrarianNotExistException{
		if (name == null)
			return false;
		if (!users.containsKey(name)) {
			throw new LibrarianNotExistException(name);
		}
		Librarian toRemove = (Librarian) users.get(name);
		return users.remove(name)!=null && removeLibrarianCred(toRemove);
	}
	
	//---------------------------------------ADD/REMOVE Book-------------------------------------


	public boolean addItem(Book book) throws itemAlreadyExistException {
		if (book == null)
			return false;
		String name = book.getName();
		String authorName = book.getAuthor().getfName() + " " +book.getAuthor().getlName();
		if (items.containsKey(name)) {
			throw new itemAlreadyExistException(name);
		}
		Author author = (Author) users.get(authorName);
		return items.put(name, book)==null && author.addItem(book);
	}
	
	public boolean removeItem(Book book) throws itemNotExistException {
		if (book == null)
			return false;
		Book toRemove=null;
		String name = book.getName();
		if (items.get(name) instanceof Book)
			toRemove = (Book) items.get(name);
		//TODO
		if (toRemove == null) {
			throw new itemNotExistException(name);
		}
		String authorName = toRemove.getAuthor().getfName() + " " +toRemove.getAuthor().getlName();
		Author author = (Author) users.get(authorName);
		return author.removeItem(toRemove) && items.remove(name)!=null;
	}
	//---------------------------------------ADD/REMOVE Paper-------------------------------------

	public boolean addItem(Paper paper) throws itemAlreadyExistException {
		if (paper == null)
			return false;
		String name = paper.getName();
		if (items.containsKey(name)) {
			throw new itemAlreadyExistException(name);
		}
		String authorName = paper.getAuthor().getfName() + " " + paper.getAuthor().getlName();
		Author author = (Author) users.get(authorName);
		return items.put(name, paper)==null && author.addItem(paper);
	}
	

	public boolean removeItem(Paper paper) throws itemNotExistException {
		if (paper == null)
			return false;
		String name = paper.getName();
		Paper toRemove = null;
		if (items.get(name) instanceof Paper)
			toRemove = (Paper) items.get(paper.getName());
		if (toRemove == null) {
			throw new itemNotExistException(name);
		}
		String authorName = toRemove.getAuthor().getfName() + " " +toRemove.getAuthor().getlName();
		Author author = (Author) users.get(authorName);
		return author.removeItem(toRemove) && items.remove(name)!=null ;
	}
	//---------------------------------------READ BOOK/Paper-------------------------------------

	public boolean readItem(Reader reader, Book book) {
		if (reader == null || book == null)
			return false;
		Reader toCheck = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		if (items.get(book.getName()) instanceof Paper)
			return false;
		Book realBook = (Book) items.get(book.getName());
		if (toCheck == null || realBook == null)
			return false;
		return toCheck.addItem(realBook) && realBook.addReader(toCheck);
	}
	
	public boolean readItem(Reader reader, Paper paper) {
		if (reader == null|| paper == null)
			return false;
		Reader toCheck = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		if (items.get(paper.getName()) instanceof Book)
			return false;
		Paper realPaper = (Paper) items.get(paper.getName());
		if (toCheck == null || realPaper == null)
			return false;
		if (toCheck.getItems().containsKey(realPaper.getName()))
			return false;
		return toCheck.addItem(realPaper) && realPaper.addReader(toCheck);
	}
	//---------------------------------------Remove BOOK/Paper-------------------------------------

	public boolean unreadItem(Reader reader, Book book) {
		if (reader == null || book == null)
			return false;
		Reader toCheck = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		if (items.get(book.getName()) instanceof Paper)
			return false;
		Book realBook = (Book) items.get(book.getName());
		if (toCheck == null || realBook == null)
			return false;
		if (!toCheck.getItems().containsKey(realBook.getName()))
			return false;
		return toCheck.removeItem(realBook) && realBook.removeReader(toCheck);
	}
	
	public boolean unreadItem(Reader reader, Paper paper) {
		if (reader == null|| paper == null)
			return false;
		Reader toCheck = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		if (items.get(paper.getName()) instanceof Book)
			return false;
		Paper realPaper = (Paper) items.get(paper.getName());
		if (toCheck == null || realPaper == null)
			return false;
		if (!toCheck.getItems().containsKey(realPaper.getName()))
			return false;
		return toCheck.removeItem(realPaper) && realPaper.removeReader(toCheck);
	}
	
	//---------------------------------------get reviews by reader-------------------------------------
	
	
	public ArrayList<String> getReaderReviewedItems(Reader reader){
		if (reader == null)
			return null;
		ArrayList<String> toReturn = new ArrayList<String>();
		String name = reader.getfName()+ " " + reader.getlName();
		for (LibraryItem item: reader.getItems().values()) {
			if (item.isReviewByReader(name))
				toReturn.add(item.getName());
		}
		return toReturn;
	}
	
	//---------------------------------------MAKE REVIEW FOR BOOK/Paper-------------------------------------

	public boolean makeReview(Book book, Review review) {
		if (review == null|| book == null)
			return false;
		Book toCheck = (Book) items.get(book.getName());
		if (toCheck == null)
			return false;
		return toCheck.addReview(review);
	}
	
	public boolean makeReview(Paper paper, Review review) {
		if (review == null|| paper == null)
			return false;
		Paper toCheck = (Paper) items.get(paper.getName());
		if (toCheck == null)
			return false;
		if (toCheck.getReviews().contains(review))
			return false;
		return toCheck.getReviews().add(review);
	}
	//==============================================GET BEST BOOK/PAPER=====================================
	public TreeSet<LibraryItem> makeTree(ScoreCalculator score){
		TreeSet<LibraryItem> tree = new TreeSet<LibraryItem>((new Comparator<LibraryItem>() {
			@Override
			public int compare(LibraryItem i1, LibraryItem i2) {
				if (i1.getAvgRate(score) > i2.getAvgRate(score))
					return 1;
				else if (i1.getAvgRate(score) < i2.getAvgRate(score))
					return -1;
				else
					return i1.toString().compareTo(i2.toString());
			}
		}));
		return tree;
	}
	
	public Book getBestBook(ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		for (LibraryItem item: items.values() ) {
			if (item instanceof Book)
				tree.add(item);
		}
		return (Book) tree.last();
	}
	public Paper getBestPaper(ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		for (LibraryItem item: items.values() ) {
			if (item instanceof Paper)
				tree.add(item);
		}
		return (Paper) tree.last();
	}
	//==============================================GET BEST K BOOKS/PAPERS=====================================
	public ArrayList<Book> getBestBooks(int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		for (LibraryItem item: items.values() ) {
			if (item instanceof Book)
				tree.add(item);
		}
		ArrayList<Book> bestK = new ArrayList<Book>();
		while (k>0 && !tree.isEmpty()) {
			if (tree.last() instanceof Book) {
				bestK.add((Book) tree.pollLast());
				k--;
			} else tree.pollLast();
		}
		return bestK;
	}
	public ArrayList<Paper> getBestPapers(int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		for (LibraryItem item: items.values() ) {
			if (item instanceof Paper)
				tree.add(item);
		}
		ArrayList<Paper> bestK = new ArrayList<Paper>();
		while (k>0 && !tree.isEmpty()) {
			if (tree.last() instanceof Paper) {
				bestK.add((Paper) tree.pollLast());
				k--;
			} else tree.pollLast();
		}
		return bestK;
	}
	//==============================================GET BEST AUTHOR BOOKS/PAPERS=====================================
	public ArrayList<Book> getBestAuthorBooks(Author author, int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		Author toCheck = (Author) users.get(author.getfName()+" "+author.getlName());
		if (toCheck == null)
			return null;
		for (LibraryItem book: toCheck.getItems().values()) {
			if (book instanceof Book)
				tree.add((Book)book);
		}
		ArrayList<Book> bestK = new ArrayList<Book>();
		while (k>0 && !tree.isEmpty()) {
				bestK.add((Book) tree.pollLast());
				k--;
			}
		return bestK;
	}
	
	public ArrayList<Paper> getBestAuthorPapers(Author author, int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		Author toCheck = (Author) users.get(author.getfName()+" "+author.getlName());
		if (toCheck == null)
			return null;
		for (LibraryItem paper: toCheck.getItems().values()) {
			if (paper instanceof Paper)
				tree.add((Paper)paper);
		}
		ArrayList<Paper> bestK = new ArrayList<Paper>();
		while (k>0 && !tree.isEmpty()) {
				bestK.add((Paper) tree.pollLast());
				k--;
			}
		return bestK;
	}
	
	//==============================================GET BEST BY TOPIC BOOKS/PAPERS=====================================

	public ArrayList<Book> getBestTopicBooks(Topic bookTopic, int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		ArrayList<Book> bestK = new ArrayList<Book>();
		for (LibraryItem book: items.values()) {
			if (book instanceof Book && book.getTopic().equals(bookTopic))
				tree.add(book);
		}
		if (tree.isEmpty())
			return null;
		while (k>0 && !tree.isEmpty()) {
			
			bestK.add((Book) tree.pollLast());
			k--;
		}
		return bestK;
	}
	public ArrayList<Paper> getBestTopicPapers(Topic bookTopic, int k, ScoreCalculator score) {
		TreeSet<LibraryItem> tree = makeTree(score);
		ArrayList<Paper> bestK = new ArrayList<Paper>();
		for (LibraryItem paper: items.values()) {
			if (paper instanceof Paper && paper.getTopic()==bookTopic)
				tree.add(paper);
		}
		if (tree.isEmpty())
			return null;
		while (k>0 && !tree.isEmpty()) {
			bestK.add((Paper) tree.pollLast());
			k--;
		}
		return bestK;
	}
	
	//==============================================GET BEST AuthorS/ReaderS=====================================

	public ArrayList<Reader> getBestReaders(int k) {
		TreeSet<LibraryUser> tree = new TreeSet<LibraryUser>(new Comparator<LibraryUser>() {
			@Override
			public int compare(LibraryUser lu1, LibraryUser lu2) {
				if (lu1.getItems().size()>lu2.getItems().size())
					return 1;
				if (lu1.getItems().size()<lu2.getItems().size())
					return -1;
				return 0;
			}
		});
		for (LibraryUser lu: users.values()) {
			if (lu instanceof Reader) 
				tree.add(lu);
		}
		if (tree.isEmpty())
			return null;
		ArrayList<Reader> bestK = new ArrayList<Reader>();
		while (k>0 && !tree.isEmpty()) {
			bestK.add((Reader) tree.pollLast());
			k--;
		}
		return bestK;
	}

	public ArrayList<Author> getBestAuthors(int k) {
		TreeSet<Author> tree = new TreeSet<Author>(new Comparator<Author>() {
			@Override
			public int compare(Author a1, Author a2) {
				return (a1.NumReaders()-a2.NumReaders());
			}
		});
		for (LibraryUser lu: users.values()) {
			if (lu instanceof Author) 
				tree.add((Author) lu);
		}
		if (tree.isEmpty())
			return null;
		
		ArrayList<Author> bestK = new ArrayList<Author>();
		while (k>0 && !tree.isEmpty()) {
			bestK.add((Author) tree.pollLast());
			k--;
		}
		return bestK;
	}
	
	//==============================================Add LibraryCollection=====================================

	public boolean addCollection(LibraryCollection collection) {
		if (collection==null) 
			return false;
		if (collecs.containsKey(collection.getName())) {
			return false;
		}
		return collecs.put(collection.getName(), collection) == null;
	}
	
	public boolean addEncyclopedia(Encyclopedia encyc) {
		if (encyc==null) 
			return false;
		if (collecs.containsKey(encyc.getName())) {
			return false;
		}
		return collecs.put(encyc.getName(), encyc) == null;
	}
	
	public boolean addMagazine(Magazine mag) {
		if (mag==null) 
			return false;
		if (collecs.containsKey(mag.getName())) {
			return false;
		}
		return collecs.put(mag.getName(), mag) == null;
	}
	
	public boolean removeCollection(LibraryCollection collection) {
		if (collection==null) 
			return false;
		if (!collecs.containsKey(collection.getName())) {
			return false;
		}
		return collecs.remove(collection.name) != null;
	}

	public boolean addCollectionItem(LibraryCollection collection, LibraryItem item) {
		collection = collecs.get(collection.getName());
		if (collection == null || item == null)
			return false;
		
		if (collecs.containsKey(collection.getName())) 
			if (collection.addItemToCollection(item)) {
				return true;
			}
		return false;
	}
	
	//==============================================Get encyclopedia books/ Magazine papers=====================================

	
	public Encyclopedia getEncyclopidea(String encyclopediaName) {
		return (Encyclopedia) collecs.get(encyclopediaName);
	}

	public Collection<LibraryItem> getEncyclopideaBooks(Encyclopedia encyc) {
		Encyclopedia enc = getEncyclopidea(encyc.getName());
		return enc.getItems().values();
	}

	public Magazine getMagazine(String magazineName) {
		return (Magazine) collecs.get(magazineName);
	}

	public Collection<LibraryItem> getMagazinePapers(Magazine magazine) {
		Magazine mag = getMagazine(magazine.getName());
		return mag.getItems().values();
	}
	//==============================================Get encyclopedia books/ Magazine Topics=====================================

	public HashSet<Topic> getEncyclopideaTopics(Encyclopedia encyc) {
		encyc = getEncyclopidea(encyc.getName());
		HashSet<Topic> topics = new HashSet<Topic>();
		for (LibraryItem book: encyc.getItems().values()) {
			topics.add(book.getTopic());
		}
		return topics;
	}

	public HashSet<Topic> getMagazineTopics(Magazine magazine) {
		magazine = getMagazine(magazine.getName());
		HashSet<Topic> topics = new HashSet<Topic>();
		for (LibraryItem paper: magazine.getItems().values()) {
			topics.add(paper.getTopic());
		}
		return topics;
	}
	
	//==============================================Get encyclopedia books/ Magazine Authors=====================================


	public Set<Author> getEncyclopideaAuthors(Encyclopedia encyc) {
		return encyc.getAuthors();
	}

	public Set<Author> getMagazineAuthors(Magazine magazine) {
		return magazine.getAuthors();
	}

	public ArrayList<Author> getAuthors() {
		ArrayList<Author> authors = new ArrayList<Author>();
		for (LibraryUser user: users.values()) {
			if (user instanceof Author)
				authors.add((Author) user);
		}
		return authors;
	}
	
	//==============================================Get Library readers========================================

	public ArrayList<Reader> getReaders() {
		ArrayList<Reader> readers = new ArrayList<Reader>();
		for (LibraryUser user: users.values()) {
			if (user instanceof Reader)
				readers.add((Reader) user);
		}
		return readers;
	}

	//==============================================Get Library librarians========================================
	
	public ArrayList<Librarian> getLibrarians() {
		ArrayList<Librarian> librarians = new ArrayList<Librarian>();
		for (LibraryUser user: users.values()) {
			if (user instanceof Librarian)
				librarians.add((Librarian) user);
		}
		return librarians;
	}
	
	//==============================================Get Library books========================================
	public ArrayList<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<Book>();
		for (LibraryItem book: items.values()) {
			if (book instanceof Book)
				books.add((Book) book);
		}
		return books;
	}
	//==============================================Get Library papers========================================
	public ArrayList<Paper> getPapers() {
		ArrayList<Paper> papers = new ArrayList<Paper>();
		for (LibraryItem paper: items.values()) {
			if (paper instanceof Paper)
				papers.add((Paper) paper);
		}
		return papers;
	}
	//==============================================Recommend Methods========================================
	public ArrayList<Book> recommendBooksByTopic(Reader reader, int k, ScoreCalculator score) {
		reader = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		return recommender.recommendBooksByTopic(reader, k, score, items);
	}

	public ArrayList<Paper> recommendPapersByTopic(Reader reader, int k, ScoreCalculator score) {
		reader = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		return recommender.recommendPapersByTopic(reader, k, score, items);
	}
	
	public ArrayList<Book> recommendBooksByAuthor(Reader reader, int k, ScoreCalculator score) {
		reader = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		return recommender.recommendBooksByAuthor(reader, k, score, items);
	}
	
	public ArrayList<Paper> recommendPapersByAuthor(Reader reader, int k, ScoreCalculator score) {
		reader = (Reader) users.get(reader.getfName() + " " + reader.getlName());
		return recommender.recommendPapersByAuthor(reader, k, score, items);
	}

	public ArrayList<Encyclopedia> getAllEncyclopedias() {
		ArrayList<Encyclopedia> encyclopedias = new ArrayList<Encyclopedia>();
		for (LibraryCollection e : collecs.values()) {			
			if (e instanceof Encyclopedia) {
				encyclopedias.add((Encyclopedia) e);
			}
		}
		return encyclopedias;
	}

	public ArrayList<Magazine> getAllMagazines() {
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		for (LibraryCollection l : collecs.values()) {
			if (l instanceof Magazine)
				magazines.add((Magazine) l);
		}
		return magazines;
	}
	
	public HashMap<String, LibraryItem> getItems(){
		return this.items;
	}

	public LibraryItem getItem(String name) {
		if (name == null)
			return null;
		if (items.get(name) == null)
			return null;
		return items.get(name);
	}
	
}
