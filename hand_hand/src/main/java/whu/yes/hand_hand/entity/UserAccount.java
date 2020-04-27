package whu.yes.hand_hand.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="账户对象",description="账户对象")
@Table(name = "user_account",uniqueConstraints=@UniqueConstraint(columnNames="phone_number"))
public class UserAccount {
    @Id
    @GeneratedValue
    @ApiModelProperty(value="用户账号",name="uid")
    int uid;

    @Column(name = "phone_number")
    @ApiModelProperty(value="电话号码",name="phoneNumber")
    String phoneNumber;

    @ApiModelProperty(value="密码",name="password")
    String password;

    @ApiModelProperty(value="用户名",name="userName")
    String userName;

    @ApiModelProperty(value="积分",name="score")
    int score;

    @ApiModelProperty(value="等级",name="level")
    int level;

    @ApiModelProperty(value="个性签名",name="motto")
    String motto;

    @ApiModelProperty(value="余额",name="balance")
    int balance;

    @ApiModelProperty(value="头像",name="icon")
    String icon;

    @ApiModelProperty(value="性别",name="gender")
    int gender;


    @ApiModelProperty(value="用户角色,0 普通用户；1管理员",name="role")
    int role;

}
