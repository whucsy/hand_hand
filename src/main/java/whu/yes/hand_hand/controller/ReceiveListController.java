package whu.yes.hand_hand.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.ReceiveList;
import whu.yes.hand_hand.service.ReceiveListService;

import java.util.List;

@RestController
@RequestMapping("/receiveList")
@Api(value = "ReceiveListController",tags = "接受任务列表控制类")

public class ReceiveListController {
    @Autowired
    private ReceiveListService receiveListService;

    @GetMapping
    @ApiOperation(
            value = "获取接受任务列表",
            notes = "获取接受任务列表"
    )
    public List<ReceiveList> getAllReceiveList(){
        return receiveListService.getAllReceiveList();
    }

    @GetMapping(value = "/id")
    @ApiOperation(
            value = "按id获取接收表",
            notes = "按id获取接收表"
    )
    @ApiImplicitParam(value = "接收列表id", name = "id",paramType = "query",dataType = "int")
    public ReceiveList getReceiveListById(@RequestParam("id") int id){
        return receiveListService.getReceiveListById(id);
    }

    @PostMapping
    @ApiOperation(
            value = "增加接收列表",
            notes = "增加接收列表"
    )
    public void insertReceiveLis(@RequestBody ReceiveList receiveList){
        receiveListService.insertReceiveList(receiveList);
    }

    @PutMapping
    @ApiOperation(
            value = "更新接收列表",
            notes = "更新接收列表"
    )
    public void updateReceiveLis(@RequestBody ReceiveList receiveList){
        receiveListService.updateReceiveList(receiveList);
    }

    @DeleteMapping
    @ApiOperation(
            value = "按id删除接收列表",
            notes = "根据id删除接收列表"
    )
    @ApiImplicitParam(value = "接收列表id", name = "id",paramType = "query",dataType = "int")
    public void deleteReceiveListById(@RequestParam("id") int id){
        receiveListService.deleteReceiveList(id);
    }
}
