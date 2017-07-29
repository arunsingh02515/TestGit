package com.apress.springrecipes.board.domain;

import javax.persistence.Column;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="message")

@Entity(name="MESSAGE")
@Table(name="MESSAGE")
public class Message {

	 @Id
	 @Column(name="ID")
	 //@GeneratedValue
    private int id;
   
	 @Column(name="TITLE")
    private String title;
    
	 @Column(name="BODY")
    private String body;

   

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

   /* public void setAuthor(String author) {
        this.author = author;
    }*/

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
