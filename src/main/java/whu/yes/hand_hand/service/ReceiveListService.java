package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whu.yes.hand_hand.entity.ReceiveList;
import whu.yes.hand_hand.repository.ReceiveListRepository;

import java.util.List;

@Service
public class ReceiveListService {
    @Autowired
    private ReceiveListRepository receiveListRepository;

    //查询全部
    public List<ReceiveList> getAllReceiveList(){
        return receiveListRepository.findAll();
    }

    //按id查询
    public ReceiveList getReceiveListById(int id){
        return receiveListRepository.findById(id).get();
    }


    //新增
    public void insertReceiveList(ReceiveList receiveList){
        receiveListRepository.save(receiveList);
    }

    //更新
    public void updateReceiveList(ReceiveList receiveList){
        receiveListRepository.save(receiveList);
    }

    //删除
    public void deleteReceiveList(int id){
        receiveListRepository.deleteById(id);
    }
}
