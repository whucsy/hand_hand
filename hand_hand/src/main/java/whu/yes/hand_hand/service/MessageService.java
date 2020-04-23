package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Message;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.repository.MessageRepository;
import whu.yes.hand_hand.util.DateUtil;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    //查询全部消息
    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

    //按消息id查询消息
    public Message getMessageById(int id){
        return messageRepository.findById(id).get();
    }


    //新增一个消息
    public void insertMessage(Message message){
        //自动获取日期
        message.setTime(DateUtil.getDate());
        messageRepository.save(message);
    }

    //修改消息
    public void updateMessage(Message message){
        messageRepository.save(message);
    }

    //按id删除消息
    public void deleteMessage(int id){
        messageRepository.deleteById(id);
    }

}
