package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.repository.MissionRepository;
import whu.yes.hand_hand.util.DateUtil;

import java.util.Date;
import java.util.List;

@Service
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;

    //查询全部任务
    public List<Mission> getAllMission(){
        return missionRepository.findAll();
    }

    //按mid查询任务
    public Mission getMissionById(int id){
        return missionRepository.findById(id).get();
    }

    //按uid查询任务
    public List<Mission> getMissionByUid(int uid){
        return missionRepository.findByUid(uid);
    }

    //新增一个任务
    public void insertMission(Mission mission){
        mission.setPublishTime(DateUtil.getDate());
        missionRepository.save(mission);
    }

    //更新任务
    public void updateMission(Mission mission){
        missionRepository.save(mission);
    }

    //按mid删除任务
    public void deleteMission(int id){
        missionRepository.deleteById(id);
    }

    //分页查找
    public List<Mission> findByPage(Integer page, Integer size,String label) {
        if(page == null){
            page = 0;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "publishTime");
        if (label.equals("all")) {
            return missionRepository.findByPage(pageable);
        }
        else {
            return missionRepository.findByPageAndLabel(pageable, label);
        }
    }

    //关键字搜素
    public List<Mission> findByKey(Integer page, Integer size,String key){
        if(page == null){
            page = 0;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "publishTime");
        return missionRepository.findByKey(pageable,key);
    }

    //按属性排序并分页
    public List<Mission> sort(Integer page, Integer size,String property,Boolean desc,String label){
        if(page == null){
            page = 0;
        }
        if (label.equals("all") && desc) {
            PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, property);
            return missionRepository.findByPage(pageable);
        }
        else if(label.equals("all") && !desc){
            PageRequest pageable = PageRequest.of(page, size, Sort.Direction.ASC, property);
            return missionRepository.findByPage(pageable);
        }
        else if(desc){
            PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, property);
            return missionRepository.findByPageAndLabel(pageable,label);
        }
        else {
            PageRequest pageable = PageRequest.of(page, size, Sort.Direction.ASC, property);
            return missionRepository.findByPageAndLabel(pageable,label);
        }
    }


}
