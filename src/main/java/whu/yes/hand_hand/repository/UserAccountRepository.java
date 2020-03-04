package whu.yes.hand_hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.yes.hand_hand.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
}
