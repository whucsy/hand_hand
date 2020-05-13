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
class ReceiveListControllerTest {

    @Autowired
    private MockMvc mockMvc;//模拟用代码发送http

    @Test
    void getReceiveListById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/receiveList/id")
                .param("id","19"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void insertCompetitor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/receiveList/compete")
                .param("mid","10")
                .param("uid","15"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void findCompetitor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/receiveList/competitor")
                .param("mid","10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }
}