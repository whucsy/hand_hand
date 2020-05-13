package whu.yes.hand_hand.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//运行测试时，启动springboot
@AutoConfigureMockMvc
class UserAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;//模拟用代码发送http

    @Test
    void getManager() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userAccount/manager"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void rankByScore() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userAccount/ranks")
                .param("size","5"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void getRank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/userAccount/rank")
                .param("uid","15"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/userAccount/login")
                .param("phoneNumber","13618593273")
                .param("password","csy666"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }
}