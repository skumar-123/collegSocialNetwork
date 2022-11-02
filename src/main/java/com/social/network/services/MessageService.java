package com.social.network.services;

import com.social.network.dao.MessageRepository;
import com.social.network.entities.Message;
import com.social.network.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    public List<Message> findAllRecentMessages(Long id) {
        List<Message> msg = messageRepository.findAllRecentMessages(id);
        Map<User, Message> map = new HashMap<>();
        msg.forEach(m -> {

            User user = m.getSender().getId().equals(id) ? m.getReceiver() : m.getSender();
           // map.put(user,);
        });
        //return map.values();
        return null;
    }
}
