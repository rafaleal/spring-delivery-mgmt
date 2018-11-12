package app.biker;

import app.biker.dto.BikerCreationDTO;
import app.enums.StatusCode;
import app.util.EndpointConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles(value = {"test"})
@Rollback
@Transactional
public class BikerControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BikerRepository bikerRepository;

    private RestTemplate restTemplate;
    private String jsonDateFormatPattern = "yyyy-MM-dd HH:mm:ss";
    private MockRestServiceServer mockServer;
    private MockMvc mockMvc;
    private MediaType applicationJsonMediaType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    private MediaType vndErrorMediaType = MediaType.parseMediaType("application/vnd.error");

    @Before
    public void setup() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());

        this.restTemplate = new RestTemplate();
        this.restTemplate.setMessageConverters(converters);

        this.mockServer = MockRestServiceServer.createServer(this.restTemplate);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGettingAllBikersSummary() throws Exception {
        this.mockMvc.perform(get(EndpointConstants.API_V1 + EndpointConstants.API_LIST_ALL_BIKERS_SUMMARY))
                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Rodrigo Batelli Bento")))
                .andExpect(jsonPath("$[0].address", is("Rua Guy de Maupassant, 131")))
                .andExpect(jsonPath("$[0].cpf", is("123.456.789-00")))
                .andExpect(jsonPath("$[0].phone", is("+5541997202120")))
                .andExpect(jsonPath("$[1].name", is("Lincoln Schelske")));
    }

    @Test
    public void testCreateBiker() throws Exception {

        BikerCreationDTO dto = bikerCreationDTO();
        final AtomicLong newBikerId = new AtomicLong();

        MvcResult mvcResult = this.mockMvc.perform(post(EndpointConstants.API_V1 + EndpointConstants.API_NEW_BIKER)
                .content(objectMapper.writeValueAsBytes(dto))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath(".fullName").value("Thiago Syen"))
                .andExpect(jsonPath(".address").value("Rua São Salvador, 666"))
                .andExpect(jsonPath(".cpf").value("666.666.666.-66"))
                .andExpect(jsonPath(".email").value( "syen@gmail.com"))
                .andExpect(jsonPath(".phone").value("+5541993625748"))
                .andReturn();

        mockServer.verify();

        String[] location = mvcResult.getResponse().getHeader("Location").split("/");
        newBikerId.set(Long.parseLong(location[location.length-1]));

        String locationUri = mvcResult.getResponse().getHeader("Location");
        Assert.assertTrue(locationUri.contains("/biker/" + newBikerId.get()));

        Optional<Biker> optionalBiker = bikerRepository.findById(newBikerId.get());
        Biker newBiker;

        if (optionalBiker.isPresent()) {
            newBiker = optionalBiker.get();
            Assert.assertEquals("Thiago Syen", newBiker.getFullName());
            Assert.assertEquals("Rua São Salvador, 666", newBiker.getAddress());
            Assert.assertEquals("666.666.666.-66", newBiker.getCpf());
            Assert.assertEquals("syen@gmail.com", newBiker.getEmail());
            Assert.assertEquals("+5541993625748", newBiker.getPhone());
            Assert.assertEquals(StatusCode.A, newBiker.getStatusCode());
        }

    }

    private BikerCreationDTO bikerCreationDTO() {
        BikerCreationDTO dto = new BikerCreationDTO();
        dto.setFullName("Thiago Syen");
        dto.setAddress("Rua São Salvador, 666");
        dto.setCpf("666.666.666.-66");
        dto.setEmail("syen@gmail.com");
        dto.setPhone("+5541993625748");

        return dto;
    }

}
