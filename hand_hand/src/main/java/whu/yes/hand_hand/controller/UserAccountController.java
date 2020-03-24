package whu.yes.hand_hand.controller;

import cc.eamon.open.status.Status;
import cc.eamon.open.status.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.service.UserAccountService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/manager")
    @ApiOperation(
            value = "获取所有管理员",
            notes = "获取所有管理员"
    )
    public Status getManager(){
        Map<String,Object> data = new HashMap<>();
        data.put("value",userAccountService.getAccountByRole(1));
        return new Status(true, StatusCode.getCode("SUCCESS"),data,StatusCode.getMsg("SUCCESS"));
    }

    @GetMapping(value = "/token")
    @ApiOperation(
            value = "按token获取单个账户",
            notes = "根据token获取单个账户，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "token字符串",name = "token",paramType = "query")
    public UserAccount getAccountById(@RequestParam("token") String token){
        return userAccountService.getAccountById(token);
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


    //@PreAuthorize("hasRole('manager')")
    @DeleteMapping
    @ApiOperation(
            value = "按id删除单个账户",
            notes = "根据id删除单个账户"
    )
    @ApiImplicitParam(value = "用户id",name = "uid",paramType = "query")
    public void deleteAccountById(@RequestParam("uid") int uid){
        userAccountService.deleteAccount(uid);
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

    @PostMapping(value = "/login")
    @ApiOperation(
            value = "登陆",
            notes = "根据电话号码和密码验证登陆，返回token字符串"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(value = "手机号", name = "phoneNumber",paramType = "query"),
            @ApiImplicitParam(value = "密码", name = "password",paramType = "query"),
    }
    )
    public Object login(@RequestParam("phoneNumber")String phoneNumber,
                                 @RequestParam("password") String password){
        String token = userAccountService.login(phoneNumber,password);
        //构造json字符串
        String json = "{\"token\":"+"\""+token+"\"}";
        //转化为json对象
        return JSONObject.fromObject(json);
    }
}
