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

public class Mission {
    @Id
    @GeneratedValue
    int mid; //任务号

    int uid; //发布者id

    int state; //任务状态

    String mTitle; //任务标题

    String publishTime;//发布时间

    String missionInfo;//任务描述

    String label1;//分类标签

    String label2;

    String label3;

    String fileName; //文件

    double money; //酬金

    String existenceDate; //有效期

    String deadline;//截止日期

    int peopleAmount; //人数

    int changeNumber; //修改次数



}
