package whu.yes.hand_hand.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.service.UserAccountService;

import java.util.List;

@RestController
@RequestMapping("/userAccount")
@Api(value = "UserAccountController",tags = "账户控制类")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    @ApiOperation(
            value = "获取所有账户",
            notes = "获取所有账户信息"
    )
    public List<UserAccount> getAllAccount(){
        return userAccountService.getAllAccount();
    }

    @GetMapping(value = "/uid")
    @ApiOperation(
            value = "按id获取单个账户",
            notes = "根据id获取单个账户，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "账号",name = "uid",paramType = "query")
    public UserAccount getAccountById(@RequestParam("uid") int uid){
        return userAccountService.getAccountById(uid);
    }

    @PostMapping
    @ApiOperation(
            value = "增加一个账户",
            notes = "增加一个账户"
    )
    public void insertAccount(@RequestBody UserAccount userAccount){
        userAccountService.insertAccount(userAccount);
    }

    @PutMapping
    @ApiOperation(
            value = "修改一个账户",
            notes = "修改一个账户"
    )
    public void updateAccount(@RequestBody UserAccount userAccount){
        userAccountService.updateAccount(userAccount);
    }

    @DeleteMapping
    @ApiOperation(
            value = "按id删除单个账户",
            notes = "根据id删除单个账户"
    )
    @ApiImplicitParam(value = "账号",name = "uid",paramType = "query")
    public void deleteAccountById(@RequestParam("uid") int id){
        userAccountService.deleteAccount(id);
    }

    @GetMapping(value = "/ranks")
    @ApiOperation(
            value = "按积分排行",
            notes = "根据积分降序排行"
    )
    @ApiImplicitParam(value = "排名的人数", name = "size",paramType = "query")

    public List<UserAccount> rankByScore(@RequestParam("size") Integer size){
        return userAccountService.rankByScore(size);
    }

    @GetMapping(value = "/rank")
    @ApiOperation(
            value = "查询自己的排行",
            notes = "查询自己的排名"
    )
    @ApiImplicitParam(value = "用户id", name = "uid",paramType = "query")

    public int getRank(@RequestParam("uid") int uid){
        return userAccountService.getRank(uid);
    }


}
