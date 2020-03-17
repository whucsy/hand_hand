package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.ReceiveList;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.entity.UserInfo;
import whu.yes.hand_hand.repository.MissionRepository;
import whu.yes.hand_hand.repository.ReceiveListRepository;
import whu.yes.hand_hand.repository.UserAccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveListService {
    @Autowired
    private ReceiveListRepository receiveListRepository;
    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;

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

    //添加竞争者
    public void insertCompetitor(int uid,int mid){
        Mission mission = missionRepository.findById(mid).get();
        if(mission.getState() == 0){
            mission.setState(1);
            missionRepository.save(mission);
        }
        ReceiveList receiveList = new ReceiveList();
        receiveList.setMid(mid);
        receiveList.setUid(uid);
        receiveListRepository.save(receiveList);
    }

    //根据任务id查询竞选人
    public List<UserAccount> findCompetitor(int mid){
       List<ReceiveList> receiveLists = receiveListRepository.findByMid(mid);
       int uid;
       List<UserAccount> userAccounts = new ArrayList<>();
       for (ReceiveList receiveList : receiveLists){
           uid = receiveList.getUid();
           userAccounts.add(userAccountRepository.findById(uid).get());
       }
       return userAccounts;

    }
}
