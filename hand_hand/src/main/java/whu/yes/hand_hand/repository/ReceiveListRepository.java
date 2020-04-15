package whu.yes.hand_hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.yes.hand_hand.entity.ReceiveList;

import java.util.List;

public interface ReceiveListRepository extends JpaRepository<ReceiveList,Integer> {

    List<ReceiveList> findByMid(int mid);

}
