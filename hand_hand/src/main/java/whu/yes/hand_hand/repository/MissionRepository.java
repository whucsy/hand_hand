package whu.yes.hand_hand.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import whu.yes.hand_hand.entity.Mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

    //展示带有条件的分页查询
    @Query(value = "from Mission  where label1=:label or label2=:label or label3 =:label")
    List<Mission> findByPageAndLabel(Pageable pageable, @Param("label")String label);

    //展示分页查询
    @Query(value = "from Mission")
    List<Mission> findByPage(Pageable pageable);

    //按关键字搜索的分页查询
    @Query(value = "from Mission  where mTitle like %:key% or missionInfo like %:key% ")
    List<Mission> findByKey(Pageable pageable, @Param("key")String key);

    //按用户ID查询
    List<Mission> findByUid(int uid);
}
