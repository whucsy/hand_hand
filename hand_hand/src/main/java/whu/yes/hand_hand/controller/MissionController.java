package whu.yes.hand_hand.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.service.MissionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.eamon.open.status.Status;
import cc.eamon.open.status.StatusCode;
@RestController
@RequestMapping("/mission")
@Api(value = "MissionController",tags = "任务控制类")
public class MissionController {
    @Autowired
    private MissionService missionService;

    @GetMapping
    @ApiOperation(
            value = "获取所有任务",
            notes = "获取所有任务的信息"
    )
    public Status getAllMission(){
        Map<String,Object> data = new HashMap<>();
        data.put("value",missionService.getAllMission());
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @GetMapping(value = "/mid") //路径和获取所有书不同
    @ApiOperation(
            value = "按id获取单个任务",
            notes = "根据id获取单个任务信息，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query",dataType = "int")
    public Status getById(@RequestParam("mid") int mid){
        Map<String,Object> data = new HashMap<>();
        data.put("value",missionService.getMissionById(mid));
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @GetMapping(value = "/uid")
    @ApiOperation(
            value = "按uid获取任务",
            notes = "根据uid获取任务"
    )
    @ApiImplicitParam(value = "账号", name = "uid",paramType = "query",dataType = "int")
    public Status getByUid(@RequestParam("uid") int uid){
        Map<String,Object> data = new HashMap<>();
        data.put("value",missionService.getMissionByUid(uid));
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @PostMapping(value = "/")
    @ApiOperation(
            value = "新增一个任务",
            notes = "填写任务信息后，增加一个任务"
    )
    public Status insertMission(@RequestBody Mission mission){
        missionService.insertMission(mission);
        Map<String,Object> data = new HashMap<>();
        data.put("value",mission);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @PutMapping(value = "/")
    @ApiOperation(
            value = "更新任务",
            notes = "修改任务信息"
    )
    public Status updateMission(@RequestBody Mission mission){
        missionService.updateMission(mission);
        Map<String,Object> data = new HashMap<>();
        data.put("value",mission);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }


    @DeleteMapping(value = "/mid")
    @ApiOperation(
            value = "按mid删除一个任务",
            notes = "根据id删除单个任务"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query")
    public Status deleteById(@RequestParam("mid") int mid){
         missionService.deleteMission(mid);
        Map<String,Object> data = new HashMap<>();
        data.put("value",mid);
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }


    @GetMapping(value = "/page")
    @ApiOperation(
            value = "分页查询任务",
            notes = "根据页数和大小查询任务"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数", name = "page",paramType = "query",dataType = "int"),
            @ApiImplicitParam(value = "每页大小", name = "size",paramType = "query",dataType = "int"),
            @ApiImplicitParam(value = "标签", name = "label",paramType = "query"),
    }
    )
    public Status findByPage(@RequestParam("page")Integer page,
                                    @RequestParam(value = "size",defaultValue = "10") Integer size,
                                    @RequestParam("label") String label){
        Map<String,Object> data = new HashMap<>();
        data.put("value",missionService.findByPage(page-1,size,label));
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @GetMapping(value = "/key")
    @ApiOperation(
            value = "关键字搜素任务",
            notes = "根据关键字搜索任务标题和任务详情，返回的分页的任务列表"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页数", name = "page",paramType = "query",dataType = "int"),
            @ApiImplicitParam(value = "每页大小", name = "size",paramType = "query",dataType = "int"),
            @ApiImplicitParam(value = "关键字", name = "key",paramType = "query"),
    }
    )
    public Status findByKey(@RequestParam("page")Integer page,
                                    @RequestParam(value = "size",defaultValue = "10") Integer size,
                                    @RequestParam("key") String key){

        Map<String,Object> data = new HashMap<>();
        data.put("value",missionService.findByKey(page-1,size,key));
        return new Status(true,StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

}
