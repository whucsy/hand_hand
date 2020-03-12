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

import java.util.List;

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
    public List<Mission> getAllMission(){
        return missionService.getAllMission();
    }

    @GetMapping(value = "/mid") //路径和获取所有书不同
    @ApiOperation(
            value = "按id获取单个任务",
            notes = "根据id获取单个任务信息，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query",dataType = "int")
    public Mission getById(@RequestParam("mid") int mid){
        return missionService.getMissionById(mid);
    }

    @PostMapping(value = "/")
    @ApiOperation(
            value = "新增一个任务",
            notes = "填写任务信息后，增加一个任务"
    )
    public void insertMission(@RequestBody Mission mission){
        missionService.insertMission(mission);
    }

    @PutMapping(value = "/")
    @ApiOperation(
            value = "更新任务",
            notes = "修改任务信息"
    )
    public void updateMission(@RequestBody Mission mission){
        missionService.updateMission(mission);
    }


    @DeleteMapping(value = "/mid")
    @ApiOperation(
            value = "按mid删除一个任务",
            notes = "根据id删除单个任务"
    )
    @ApiImplicitParam(value = "任务编号", name = "mid",paramType = "query")
    public void deleteById(@RequestParam("mid") int mid){
         missionService.deleteMission(mid);
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
    public List<Mission> findByPage(@RequestParam("page")Integer page,
                                    @RequestParam(value = "size",defaultValue = "10") Integer size,
                                    @RequestParam("label") String label){

        return missionService.findByPage(page-1,size,label);
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
    public List<Mission> findByKey(@RequestParam("page")Integer page,
                                    @RequestParam(value = "size",defaultValue = "10") Integer size,
                                    @RequestParam("key") String key){

        return missionService.findByKey(page-1,size,key);
    }

}
