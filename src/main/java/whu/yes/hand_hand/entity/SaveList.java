package whu.yes.hand_hand.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="收藏任务对象",description="收藏任务对象")
public class SaveList {
    @Id
    @GeneratedValue
    @ApiModelProperty(value="序号",name="sid")
    int sid;

    @ApiModelProperty(value="任务号",name="mid")
    int mid;

    @ApiModelProperty(value="用户账号",name="uid")
    int uid;

    @ApiModelProperty(value="时间",name="time")
    String time;
}
