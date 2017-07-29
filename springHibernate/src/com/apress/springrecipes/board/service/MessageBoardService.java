package com.apress.springrecipes.board.service;

import java.util.List;

import com.apress.springrecipes.board.domain.Message;

public interface MessageBoardService {

    public List<Message> listMessages();
    public void postMessage(Message message);
    public void deleteMessage(int messageId);
   public Message findMessageById(int messageId);
}
