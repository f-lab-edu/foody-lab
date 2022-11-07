package app.foodylab.adaptor.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import app.foodylab.OrderDTOFixture;
import app.foodylab.OrderFixture;
import app.foodylab.adaptor.PayRequest;
import app.foodylab.application.payment.service.PayService;
import app.foodylab.domain.coupon.Coupon;
import app.foodylab.domain.coupon.CouponType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PayControllerTest {

    private static MockMvc mockMvc;
    private GsonBuilder builder = new GsonBuilder();

    @BeforeAll
    public static void setUpMockMvc() {
        mockMvc = MockMvcBuilders
            .standaloneSetup(new PayController(mock(PayService.class)))
            .build();
    }

    @Test
    void test1() throws Exception {
        Coupon coupon = Coupon.of(10000L, "할인쿠폰", CouponType.PRICE);
        PayRequest request = new PayRequest(OrderDTOFixture.DUMMY, "kakao", coupon);
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        String s = mapper.writeValueAsString(request);
//        mockMvc.perform(post("/pay").contentType(MediaType.APPLICATION_JSON)
//                .content(s)
//            )
//            .andExpect(status().isOk());
    }
}
