package whu.yes.hand_hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.yes.hand_hand.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Integer> {

}
