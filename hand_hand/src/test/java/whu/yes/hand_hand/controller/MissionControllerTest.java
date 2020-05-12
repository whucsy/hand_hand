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
class MissionControllerTest {

    @Autowired
    private MockMvc mockMvc;//模拟用代码发送http

    @Test
    void findByPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/mission/page")
                .param("page","1")
                .param("size","3")
                .param("label","all"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());//200
    }

    @Test
    void findByKey() {
    }
}