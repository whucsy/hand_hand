package whu.yes.hand_hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.yes.hand_hand.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

}
