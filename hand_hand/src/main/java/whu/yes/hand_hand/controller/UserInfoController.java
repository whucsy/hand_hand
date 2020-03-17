package whu.yes.hand_hand.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.entity.UserInfo;
import whu.yes.hand_hand.service.UserInfoService;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
@Api(value = "UserInfoController",tags = "用户信息控制类")

public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    @ApiOperation(
            value = "获取所有用户",
            notes = "获取所有用户信息"
    )
    public List<UserInfo> getAllUserInfo(){
        return userInfoService.getAllUserInfo();
    }

    @GetMapping(value = "/uid")
    @ApiOperation(
            value = "按id获取单个用户信息",
            notes = "根据id获取单个用户信息，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "",name = "uid",paramType = "query")
    public UserInfo getUserInfoById(@RequestParam("uid") int uid){
        return userInfoService.getUserInfoById(uid);
    }

    @PostMapping
    @ApiOperation(
            value = "增加一个用户信息",
            notes = "增加一个用户信息"
    )
    public void insertUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.insertUserInfo(userInfo);
    }

//    @PutMapping
//    @ApiOperation(
//            value = "修改一个用户信息",
//            notes = "修改一个用户信息"
//    )
//    public void updateUserInfo(@RequestBody UserInfo userInfo){
//        userInfoService.updateUserInfo(userInfo);
//    }

    @DeleteMapping
    @ApiOperation(
            value = "按id删除单个用户信息",
            notes = "根据id删除单个用户信息"
    )
    @ApiImplicitParam(value = "账号",name = "uid",paramType = "query")
    public void deleteUserInfoById(@RequestParam("uid") int id){
        userInfoService.deleteUserInfo(id);
    }
}
