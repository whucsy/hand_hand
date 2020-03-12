package whu.yes.hand_hand.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.UserAccount;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

    @Query(value = "from UserAccount")
    List<UserAccount> rankByScore(Pageable pageable);

    List<UserAccount> getByPhoneNumber(String phoneNumber);


    @Query(value = "select count(*)+1 from user_account where score > (select score from user_account where uid = ?)",nativeQuery = true)
    int getRank(int uid);

}
