package com.apress.springrecipes.board.dao;

import java.util.List;

import com.apress.springrecipes.board.domain.Message;

public interface MessageBoardDao {
	public List<Message> listMessages();
    public void postMessage(Message message);
    public void deleteMessage(int id);
    public Message findMessageById(int messageId);


}
