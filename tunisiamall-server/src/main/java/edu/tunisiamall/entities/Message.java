package edu.tunisiamall.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private byte seen;

	@Temporal(TemporalType.TIMESTAMP)
	private Date seenDate;

	private String text;

	@ManyToOne
	@JoinColumn(name="idUserSender_FK")
	private User user;

	@ManyToOne
	@JoinColumn(name="idUserReciver_fk")
	private User receiver;
	
	
	public Message() {
	}
	
	public Message(User src, User dest, String text) {
		this.user = src;
		this.receiver = dest;
		this.text = text;
		this.date = new Date();
		this.seen = 0;
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

	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User reciver) {
		this.receiver = reciver;
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

	@Override
	public int hashCode() {
		return idMessage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (idMessage != other.idMessage)
			return false;
		return true;
	}

	
}