package whu.yes.hand_hand.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="消息对象",description="消息对象")
public class Message {
    @Id
    @GeneratedValue
    @ApiModelProperty(value="消息号",name="messageId")
    int messageId;

    @ApiModelProperty(value="发送方id",name="sender")
    int sender;

    @ApiModelProperty(value="接收方id",name="receiver")
    int receiver;

    @ApiModelProperty(value="消息内容",name="content")
    String content;

    @ApiModelProperty(value="图片路径",name="picture")
    String picture;

    @ApiModelProperty(value="发送时间",name="time")
    String time;

    @ApiModelProperty(value="消息状态 0：未读，1：已读",name="state")
    int state;
}
