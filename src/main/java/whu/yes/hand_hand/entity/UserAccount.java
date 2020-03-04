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

public class UserAccount {
    @Id
    @GeneratedValue
    int uid; //发布者id

    String phoneNumber;//电话号码

    String password;//密码

    String userName;//用户名

    int score;//积分

    int level;//等级

    String motto;//个性签名

    int balance;//余额

    String icon;//头像

}
