package entities;

import java.io.Serializable;

public class Message implements Serializable {
	String messageContent;

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Message() {
	
	}
	
	
}
