package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int reciver;

	private byte seen;

	@Temporal(TemporalType.TIMESTAMP)
	private Date seenDate;

	private String text;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Message() {
	}

	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getReciver() {
		return this.reciver;
	}

	public void setReciver(int reciver) {
		this.reciver = reciver;
	}

	public byte getSeen() {
		return this.seen;
	}

	public void setSeen(byte seen) {
		this.seen = seen;
	}

	public Date getSeenDate() {
		return this.seenDate;
	}

	public void setSeenDate(Date seenDate) {
		this.seenDate = seenDate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}