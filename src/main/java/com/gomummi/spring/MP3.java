package com.gomummi.spring;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MP3 {

	private int id;
	@Size(min=2,max=15, message="{name.size.error}")
	private String name;
	@Size(min=2,max=15, message="{author.size.error}")
	private String author;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
