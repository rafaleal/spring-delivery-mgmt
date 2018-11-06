package app.biker;

import app.enums.StatusCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = {"test"})
public class BikerRespositoryTest {

    @Autowired
    BikerRepository bikerRepository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull("the bikerRepository should be non-null",
                this.bikerRepository);
    }

    @Test
    public void testLoadingResultsInDatabase() {
        List<Biker> bikerList = this.bikerRepository.findAll();
        Assert.assertNotNull("there must be a response", bikerList);
        Assert.assertTrue(bikerList.size() == 2);
    }

    @Test
    public void testFindByStatusCode() {
        List<Biker> bikerList = this.bikerRepository.findByStatusCode(StatusCode.A);
        Assert.assertTrue(bikerList.size() != 0);
    }

    @Test
    public void testGetBikerSummary() {
        BikerSummaryDTO summary = this.bikerRepository.getBikerSummary(1L);
        Assert.assertNotNull(summary);
        Assert.assertEquals(new Long(1), summary.getId());
        Assert.assertEquals("Rodrigo Batelli Bento", summary.getName());
        Assert.assertEquals(new Long(1), summary.getTotalDeliveries());
        Assert.assertEquals(new BigDecimal("4.32"), summary.getTotalDistance());
        Assert.assertEquals(new BigDecimal("17.28"), summary.getTotalDue());
    }
}
