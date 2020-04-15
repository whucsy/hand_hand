package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.ReceiveList;
import whu.yes.hand_hand.entity.SaveList;
import whu.yes.hand_hand.repository.MissionRepository;
import whu.yes.hand_hand.repository.ReceiveListRepository;
import whu.yes.hand_hand.repository.SaveListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaveListService {
    @Autowired
    private SaveListRepository saveListRepository;
    @Autowired
    private MissionRepository missionRepository;

    //查询全部
    public List<SaveList> getAllSaveList(){
        return saveListRepository.findAll();
    }

    //按id查询
    public SaveList getSaveListById(int id){
        return saveListRepository.findById(id).get();
    }

    //按uid查询收藏的任务
    public List<Mission> getMissionByUid(int id){
        List<SaveList> saveLists =  saveListRepository.findByUid(id);
        if (!saveLists.isEmpty()){
        List<Mission> missions = new ArrayList<>();
        Mission mission;
        for (SaveList saveList : saveLists){
            mission = missionRepository.findById(saveList.getMid()).get();
            missions.add(mission);
        }
        return missions;
        }
        else{
            return null;
        }
    }


    //新增
    public void insertSaveList(SaveList saveList){
        saveListRepository.save(saveList);
    }

    //更新
    public void updateSaveList(SaveList saveList){
        saveListRepository.save(saveList);
    }

    //删除
    public void deleteSaveList(int id){
        saveListRepository.deleteById(id);
    }
}
