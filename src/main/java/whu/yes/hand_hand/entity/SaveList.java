package whu.yes.hand_hand.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SaveList {
    @Id
    @GeneratedValue
    int sid;

    int mid;

    int uid;

    String time;
}
