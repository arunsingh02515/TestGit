package com.apress.springrecipes.board.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apress.springrecipes.board.domain.Message;
@Repository
//@Transactional 
public class MessageBoardDaoImp implements MessageBoardDao{
   
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Message> listMessages(){
		//testing purpose
		int messageid= 3;
		Message m=findMessageById(messageid);
		if(m!=null){
		System.out.println(m.getTitle());
		System.out.println(m.getId());
		}
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Message.class).setCacheable(true);
		List<Message> results = crit.list();
		//this.sessionFactory.getCurrentSession().s
		return results;//this.sessionFactory.getCurrentSession().createQuery("from MESSAGE").setCacheable(true).list();
	}
    public void postMessage(Message message){
    	this.sessionFactory.getCurrentSession().save(message);
    }
    public void deleteMessage(int id){
    	Message message = (Message) sessionFactory.getCurrentSession().load(
				Message.class, id);
        if (null != message) {
        	this.sessionFactory.getCurrentSession().delete(message);
        }
    }
    public Message findMessageById(int messageId){
    	Message message = (Message) sessionFactory.getCurrentSession().get(
				Message.class, messageId);
    	return message;
    }
	
}
