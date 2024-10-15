package com.eval.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.eval.ApplicationTest;

public class EvalObjNodeIndexLinkControllerTest extends ApplicationTest {
    @Autowired
    private EvalObjNodeIndexInputController ec;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(ec).build();
    }

    @Test
    public void testGetItem() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/eval/objindexlink/workshop"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        logger.info(mvcResult.getResponse().getContentAsString());

    }
}
