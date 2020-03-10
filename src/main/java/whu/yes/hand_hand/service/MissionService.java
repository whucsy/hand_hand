package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.repository.MissionRepository;

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


    //新增一个任务
    public void insertMission(Mission mission){
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
    public Page<Mission> findByPage(Integer page, Integer size) {
        if (null == page) {
            page = 0;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "publishTime");
        Page<Mission> missions = missionRepository.findAll(pageable);
        return missions;
    }
}
