package org.mall.javabrains.messanger.Service;

import java.util.List;

import java.util.*;

import org.mall.javabrains.messanger.database.DatabaseClass;
import org.mall.javabrains.messanger.model.Message;



public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	/*
	 * public List<Message> getAllMessages() {
	 * 
	 * Message m1 =new Message (1L,"hello" ,"Mall");
	 * 
	 * 
	 * Message m2 =new Message (2L,"hallo" ,"kumar");
	 * 
	 * Message m3 =new Message (3L,"hii" ,"Mall");
	 * 
	 * 
	 * List<Message> list =new ArrayList<>();
	 * 
	 * list.add(m1); list.add(m2); list.add(m3);
	 * 
	 * return list; }
	 */

	
	public MessageService()
	{
		
	}	static {
		messages.put(1L,new Message (1L,"hello" ,"Mall"));
		
		messages.put(2L,new Message (2L,"hi" ,"kall"));
		
	}
	
	
	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message removeMessage(long id)

	{
		return messages.remove(id);

	}

	public Message updateMessage(Message message)

	{
		if (message.getId() <= 0) {
			return null;

		}
		messages.put(message.getId(), message);

		return message;
	}

	public Message addMessage(Message message)

	{
		message.setId(messages.size() + 1);

		messages.put(message.getId(), message);

		return message;
	}

}
