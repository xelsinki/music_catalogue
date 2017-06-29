package com.gomummi.spring;

// Tarkista kumpi on oikea java.util.List vai java.awt.List
import java.util.List;

public interface MP3DAO {

	public void insert(MP3 mp3);

	public void insertWithJDBC(MP3 mp3);
	
	public List<MP3> getAll();

	public abstract MP3 find(int id);

	void delete(MP3 mp3);

	void delete(int id);
	

	MP3 getMP3ByID(int id);

	List<MP3> getMP3ListByName(String name);

	List<MP3> getMP3ListByAuthor(String author);

	
	
}
