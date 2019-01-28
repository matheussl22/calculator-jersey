package com.calculator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RestCalculatorTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testCalcAdd() {
        ResultDto resultDto = target.path("rest-calculator/add/1/1/1").request().get(ResultDto.class);
        assertEquals( (Double) 3.0, resultDto.getResult());
    }

    @Test
    public void testCalcSubtract() {
        ResultDto resultDto = target.path("rest-calculator/subtract/10/5/1").request().get(ResultDto.class);
        assertEquals( (Double) 4.0, resultDto.getResult());
    }

    @Test
    public void testCalcMultiply() {
        ResultDto resultDto = target.path("rest-calculator/multiply/2/2/5").request().get(ResultDto.class);
        assertEquals( (Double) 20.0, resultDto.getResult());
    }

    @Test
    public void testCalcDivide() {
        ResultDto resultDto = target.path("rest-calculator/divide/10/2").request().get(ResultDto.class);
        assertEquals( (Double) 5.0, resultDto.getResult());
    }

    @Test
    public void testAddPercent() {
        ResultDto resultDto = target.path("rest-calculator/add-percent/1000/10").request().get(ResultDto.class);
        assertEquals( (Double) 1100.0, resultDto.getResult());
    }

    @Test
    public void testSubtractPercent() {
        ResultDto resultDto = target.path("rest-calculator/subtract-percent/1000/10").request().get(ResultDto.class);
        assertEquals( (Double) 900.0, resultDto.getResult());
    }

}
