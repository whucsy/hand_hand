package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.repository.UserAccountRepository;

import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    //查询全部账户
    public List<UserAccount> getAllAccount(){
        return userAccountRepository.findAll();
    }

    //按mid查询账户
    public UserAccount getAccountById(int id){
        return userAccountRepository.findById(id).get();
    }


    //新增一个账户
    public void insertAccount(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    //更新账户
    public void updateAccount(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }

    //按uid删除账户
    public void deleteAccount(int id){
        userAccountRepository.deleteById(id);
    }

    //按积分降序排名
    public List<UserAccount> rankByScore(Integer size) {

        PageRequest pageable = PageRequest.of(0, size, Sort.Direction.DESC, "score");
        return userAccountRepository.rankByScore(pageable);
    }
    //查询自己的排名
    public int getRank(int uid){
        return userAccountRepository.getRank(uid);
    }

}
