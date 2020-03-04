package whu.yes.hand_hand.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserInfo {
    @Id
    int uid;

    String realName; //真实姓名

    String idNumber; //身份证

    int age;//年龄

    String school; //学校

    String stuentNo;//学号

    String education; //学历

    String company; //公司

    String location;//位置

    String address; //地址

    int userType; //用户类型
}
