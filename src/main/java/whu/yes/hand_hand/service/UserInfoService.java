package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.entity.UserInfo;
import whu.yes.hand_hand.repository.UserInfoRepository;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    //查询全部账户信息
    public List<UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    //按mid查询账户信息
    public UserInfo getUserInfoById(int id){
        return userInfoRepository.findById(id).get();
    }


    //新增一个账户
    public void insertUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    //更新账户
    public void updateUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }

    //按mid删除任务
    public void deleteUserInfo(int id){
        userInfoRepository.deleteById(id);
    }
}
