package whu.yes.hand_hand.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(value="接收任务对象",description="接收任务对象")
public class ReceiveList{
    @Id
    @GeneratedValue
    @ApiModelProperty(value="序号",name="rid")
    int rid;

    @ApiModelProperty(value="任务号",name="mid")
    int mid;

    @ApiModelProperty(value="用户账号",name="uid")
    int uid;

    @ApiModelProperty(value="注意：不需要了，后面会删除",name="state")
    int state;

}
