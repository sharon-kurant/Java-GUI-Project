package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.Library;

public class LibraryDB {
	
	private Library libraryDB = new Library();
	
	public LibraryDB() {
		if (new File("libraryDB.ser").exists())
		{
			libraryDB = getLibrary();
		}
		else saveLibraryDB();
	}
	
	public Library getLibrary() {
		
		try {
			FileInputStream fis = new FileInputStream(new File("libraryDB.ser"));
			ObjectInputStream ois = new ObjectInputStream (fis);
			
			libraryDB = (Library)ois.readObject();
			ois.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return libraryDB;
	}
	
	public void saveLibraryDB() {
		
		try {
			FileOutputStream fos = new FileOutputStream(new File ("libraryDB.ser"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(libraryDB);
			oos.close();
			this.libraryDB = getLibrary();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
