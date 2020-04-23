package whu.yes.hand_hand.controller;

import cc.eamon.open.status.Status;
import cc.eamon.open.status.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.Message;
import whu.yes.hand_hand.service.MessageService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
@Api(value = "MessageController",tags = "消息控制类")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    @ApiOperation(
            value = "获取所有消息",
            notes = "获取所有消息的信息"
    )
    public Status getAllMessage(){
        Map<String,Object> data = new HashMap<>();
        data.put("value",messageService.getAllMessage());
        return new Status(true, StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @GetMapping(value = "/id") //路径和获取所有书不同
    @ApiOperation(
            value = "按id获取单个消息",
            notes = "根据id获取单个消息信息，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "消息编号", name = "id",paramType = "query",dataType = "int")
    public Status getById(@RequestParam("id") int id){
        Map<String,Object> data = new HashMap<>();
        data.put("value",messageService.getMessageById(id));
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @PostMapping(value = "/")
    @ApiOperation(
            value = "新增一个消息",
            notes = "新增一个消息"
    )
    public Status insertMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        Map<String,Object> data = new HashMap<>();
        data.put("value",message);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @PutMapping(value = "/")
    @ApiOperation(
            value = "更新消息",
            notes = "修改消息信息"
    )
    public Status updateMessage(@RequestBody Message message){
        messageService.updateMessage(message);
        Map<String,Object> data = new HashMap<>();
        data.put("value",message);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @DeleteMapping(value = "/id")
    @ApiOperation(
            value = "按id删除一条消息",
            notes = "按id删除一条消息"
    )
    @ApiImplicitParam(value = "消息号", name = "id",paramType = "query")
    public Status deleteById(@RequestParam("id") int id){
        messageService.deleteMessage(id);
        Map<String,Object> data = new HashMap<>();
        data.put("value",id);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

}
