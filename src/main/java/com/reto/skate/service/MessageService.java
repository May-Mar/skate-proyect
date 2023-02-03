package com.reto.skate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Message;
import com.reto.skate.repository.MessageRepository;

@Service
public class MessageService {
   
    @Autowired
    public MessageRepository messageRepository;

    public List<Message> obtenerMessageCompleta(){
        return messageRepository.obtenerMessageCompleta();

    }

    public Optional<Message> obtenerMessageId(Integer id){
        return messageRepository.obtenerMessageId(id);
    }

    public Message salvarMessage(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.salvarMessage(message);
        }
        else{
            Optional <Message> messageAuxiliar = messageRepository.obtenerMessageId(message.getIdMessage());
            if(messageAuxiliar.isEmpty()){
                return messageRepository.salvarMessage(message);
            }
            else{
                return message;
            }
        }

    }
    
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> messageAuxiliar= messageRepository.obtenerMessageId(message.getIdMessage());
            if(!messageAuxiliar.isEmpty()){
                if(message.getMessageText()!=null){
                    messageAuxiliar.get().setMessageText(message.getMessageText());
                }
                messageRepository.salvarMessage(messageAuxiliar.get());
                return messageAuxiliar.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(Integer messageId){
        boolean flag=false;
        Optional<Message> messageAuxiliar = messageRepository.obtenerMessageId(messageId);
        if(messageAuxiliar.isPresent()){
            messageRepository.delete(messageAuxiliar.get());
            flag=true;
        }
        return flag;
    } 
}
