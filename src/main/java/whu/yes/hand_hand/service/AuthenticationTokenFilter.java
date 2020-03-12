package whu.yes.hand_hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    UserAccountService userAccountService;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authToken = null;

        // 下面的代码从Http Header的Authorization中获取token，也可以从其他header,cookie等中获取，看客户端怎么传递token
        String requestHeader = httpServletRequest.getHeader("Authorization");
        if (requestHeader != null /*&& requestHeader.startsWith("Bearer ")*/) {
            authToken = requestHeader;//.substring(7);
        }
        if (authToken != null) {
            UserDetails user;
            //查询token对应的用户
            user = userAccountService.getUserFromToken(authToken);
            if(user != null) {
                // 把user设置到SecurityContextHolder内，以spring使用
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
