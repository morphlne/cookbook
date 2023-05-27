package io.pan.cookbook.validation.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static io.pan.cookbook.validation.TestUtil.asJson;
import static io.pan.cookbook.validation.TestUtil.consistentPeriod;
import static io.pan.cookbook.validation.TestUtil.inconsistentPeriod;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PeriodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void consistentPeriod_post_statusIs200() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/period")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(asJson(consistentPeriod()))
                )
                .andExpect(status().isOk());
    }

    @Test
    public void inconsistentPeriod_post_statusIs400() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/period")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(asJson(inconsistentPeriod()))
                )
                .andExpect(status().isBadRequest());
    }

}
