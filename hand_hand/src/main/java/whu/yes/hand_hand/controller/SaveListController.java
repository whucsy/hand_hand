package whu.yes.hand_hand.controller;

import cc.eamon.open.status.Status;
import cc.eamon.open.status.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.SaveList;
import whu.yes.hand_hand.service.SaveListService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/saveList")
@Api(value = "SaveListController",tags = "收藏列表控制类")

public class SaveListController {

    @Autowired
    private SaveListService saveListService;

    @GetMapping
    @ApiOperation(
            value = "获取所有收藏列表",
            notes = "获取所有收藏列表"
    )
    public List<SaveList> getAllSaveList(){
        return saveListService.getAllSaveList();
    }

    @GetMapping(value = "/id")
    @ApiOperation(
            value = "按id获取收藏列表",
            notes = "按id获取一个收藏列表"
    )
    public SaveList getSaveListById(@RequestParam("id")int id){
        return saveListService.getSaveListById(id);
    }

    @GetMapping(value = "/uid")
    @ApiOperation(
            value = "按uid获取收藏的任务",
            notes = "根据uid获取收藏的任务"
    )
    @ApiImplicitParam(value = "账号", name = "uid",paramType = "query",dataType = "int")
    public Status getByUid(@RequestParam("uid") int uid){
        Map<String,Object> data = new HashMap<>();
        data.put("value",saveListService.getMissionByUid(uid));
        return new Status(true, StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @PostMapping
    @ApiOperation(
            value = "增加一个收藏",
            notes = "增加一个收藏"
    )
    public void insertSaveList(@RequestBody SaveList saveList){
        saveListService.insertSaveList(saveList);
    }

    @PutMapping
    @ApiOperation(
            value = "更新一个收藏",
            notes = "更新一个收藏"
    )
    public void updateSaveList(@RequestBody SaveList saveList){
        saveListService.updateSaveList(saveList);
    }

    @DeleteMapping
    @ApiOperation(
            value = "按id删除一个收藏",
            notes = "根据id删除一个收藏，id为整数"
    )
    public void deleteSaveList(@RequestParam("id") int id){
        saveListService.deleteSaveList(id);
    }



}
