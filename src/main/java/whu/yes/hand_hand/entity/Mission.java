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
@ApiModel(value="任务对象",description="任务对象")
public class Mission {
    @Id
    @GeneratedValue
    @ApiModelProperty(value="任务号",name="mid")
    int mid;

    @ApiModelProperty(value="发布者id",name="uid")
    int uid;

    @ApiModelProperty(value="任务状态 0:竞选中  1：进行中  2：已完成  3：失败任务",name="state")
    int state;

    @ApiModelProperty(value="任务标题",name="mTitle")
    String mTitle;

    @ApiModelProperty(value="发布时间",name="publishTime")
    String publishTime;

    @ApiModelProperty(value="任务描述",name="missionInfo")
    String missionInfo;

    @ApiModelProperty(value="分类标签1",name="label1")
    String label1;

    @ApiModelProperty(value="分类标签2",name="label2")
    String label2;

    @ApiModelProperty(value="分类标签3",name="label3")
    String label3;

    @ApiModelProperty(value="文件路径",name="fileName")
    String fileName;

    @ApiModelProperty(value="酬金",name="money")
    double money;

    @ApiModelProperty(value="有效期",name="existenceDate")
    String existenceDate;

    @ApiModelProperty(value="截止日期",name="deadline")
    String deadline;

    @ApiModelProperty(value="人数",name="peopleAmount")
    int peopleAmount;

    @ApiModelProperty(value="修改次数",name="changeNumber")
    int changeNumber;





}
