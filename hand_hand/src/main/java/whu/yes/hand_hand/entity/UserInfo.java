package whu.yes.hand_hand.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value="用户信息对象",description="用户信息对象")
public class UserInfo {
    @Id
    @ApiModelProperty(value="用户账号",name="uid")
    int uid;

    @ApiModelProperty(value="真实姓名",name="realName")
    String realName;

    @ApiModelProperty(value="身份证",name="idNumber")
    String idNumber;

    @ApiModelProperty(value="年龄",name="age")
    int age;

    @ApiModelProperty(value="学校",name="school")
    String school;

    @ApiModelProperty(value="学号",name="stuentNo")
    String stuentNo;

    @ApiModelProperty(value="学历",name="education")
    String education;

    @ApiModelProperty(value="公司",name="company")
    String company;

    @ApiModelProperty(value="位置",name="location")
    String location;

    @ApiModelProperty(value="地址",name="address")
    String address;

    @ApiModelProperty(value="用户类型",name="userType")
    int userType;
}
