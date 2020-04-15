package whu.yes.hand_hand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whu.yes.hand_hand.entity.SaveList;

import java.util.List;

public interface SaveListRepository extends JpaRepository<SaveList,Integer> {

    List<SaveList> findByUid(int uid);
}
