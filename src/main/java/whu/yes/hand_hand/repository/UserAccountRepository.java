package whu.yes.hand_hand.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.UserAccount;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

    @Query(value = "from UserAccount")
    List<UserAccount> rankByScore(Pageable pageable);

}
