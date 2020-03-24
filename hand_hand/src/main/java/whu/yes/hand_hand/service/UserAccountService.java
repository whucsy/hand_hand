package whu.yes.hand_hand.service;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import whu.yes.hand_hand.entity.Mission;
import whu.yes.hand_hand.entity.UserAccount;
import whu.yes.hand_hand.repository.UserAccountRepository;
import springfox.documentation.annotations.Cacheable;

import java.util.*;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    private Map<String, UserDetails> tokenMap = new HashMap<>();


    @Cacheable("user")
    public UserDetails getUserFromToken(String token) {
        if(token == null) {
            return null;
        }
        return tokenMap.get(token);
    }

    //登出
    public void logout(String token) {
        tokenMap.remove(token);
    }

    //查询全部账户
    public List<UserAccount> getAllAccount() {
        return userAccountRepository.findAll();
    }

    //按token查询账户
    public UserAccount getAccountById(String token) {
        //根据token查询用户uid
        int uid = Integer.parseInt(tokenMap.get(token).getUsername());
        //根据id查询账户信息
        return userAccountRepository.findById(uid).get();
    }

    //查询所有管理员
    public List<UserAccount> getAccountByRole(int role) {
        return userAccountRepository.getByRole(role);
    }


    //新增一个账户
    public void insertAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    //更新账户
    public void updateAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
    }

    //按uid删除账户
    public void deleteAccount(int uid) {
        userAccountRepository.deleteById(uid);
    }

    //按积分降序排名
    public List<UserAccount> rankByScore(Integer size) {

        PageRequest pageable = PageRequest.of(0, size, Sort.Direction.DESC, "score");
        return userAccountRepository.rankByScore(pageable);
    }

    //查询自己的排名
    public int getRank(int uid) {
        return userAccountRepository.getRank(uid);
    }


    //登陆
    //并设置权限
    /*
     * 1.pom.xml权限管理包
     * 2.在/config/添加webSecurityConfig.java
     * 3.赋予角色
     * 4.返回token字符串
     * 5.封装token为JSON
     */
    public String login(String phoneNumber, String password) {
        UserAccount userAccount = userAccountRepository.getByPhoneNumber(phoneNumber).get(0);
        int uid = userAccount.getUid();
        //用户名密码正确
        if (userAccount.getPhoneNumber().equals(phoneNumber) && userAccount.getPassword().equals(password)) {
            UserDetails userDetails;
            if (userAccount.getRole() == 0) {
                //普通用户 0
                userDetails = createUser(String.valueOf(uid),password,new String[]{"user"});
            } else {
                //管理员 1
                userDetails = createUser(String.valueOf(uid),password,new String[]{"manager","user"});
            }
            //创建用户token
            String token = UUID.randomUUID().toString();
            tokenMap.put(token, userDetails);
            return token;
        }
        //不正确
        else {
            return null;
        }
    }

    /**
     * 直接调用，用于权限管理(封装了uid)
     *
     * @author  xsy
     *
     */
        private UserDetails createUser (String userName, String password, String[]roles){
            return new UserDetails() {

                //private static final long serialVersionUID = 6905138725952656074L;

                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    Collection<GrantedAuthority> authorities = new ArrayList<>();

//                //这是增加了一种名为query的权限，可以使用 @hasAuthority("query") 来判断
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("query");
//                authorities.add(authority);

                    //这是增加到xxx角色，可以用hasRole("xxx")来判断；需要注意所有的角色在这里增加时必须以ROLE_前缀，使用时则没有ROLES_前缀
                    for (String role : roles) {
                        SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_" + role);
                        authorities.add(sga);
                    }
                    return authorities;
                }

                @Override
                public String getPassword() {
                    return password;
                }

                @Override
                public String getUsername() {
                    return userName;
                }


                @Override
                public boolean isAccountNonExpired() {
                    return false;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return false;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    return false;
                }

            };
        }
    }
