package com.calculator;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

/**
 * exposed at "rest-calculator" path
 */
@Path("rest-calculator")
public class RestCalculator {

    /**
     * Method handling the add operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param a the first number
     * @param b the second number
     * @param c the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/add/{a}/{b}/{c}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto add(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        ResultDto r = new ResultDto();
        r.setResult(a + b + c);
        return r;
    }

    /**
     * Method handling the subtract operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param a the first number
     * @param b the second number
     * @param c the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/subtract/{a}/{b}/{c}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto subtract(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        ResultDto r = new ResultDto();
        r.setResult(a - b - c);
        return r;
    }

    /**
     * Method handling the multiply operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param a a the first number
     * @param b b the second number
     * @param c c the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/multiply/{a}/{b}/{c}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto multiply(@PathParam("a") double a, @PathParam("b") double b, @PathParam("c") double c) {
        ResultDto r = new ResultDto();
        r.setResult(a * b * c);
        return r;
    }

    /**
     * Method handling the divide operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param a the first number
     * @param b the second number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/divide/{a}/{b}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto divide(@PathParam("a") double a, @PathParam("b") double b) {
        ResultDto r = new ResultDto();
        if (b > 0 && a > 0)
            r.setResult(a / b);
        else
            r.setResult(0.0);
        return r;
    }

    /**
     * Method handling the add operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param a a the first number
     * @param b b the second number percentage
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/add-percent/{a}/{b}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto addPercent(@PathParam("a") double a, @PathParam("b") double b) {
        ResultDto r = new ResultDto();
        r.setResult(a + (a * b / 100));
        return r;
    }

    /**
     * Method handling the subtract operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param a a the first number
     * @param b b the second number percentage
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/subtract-percent/{a}/{b}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public ResultDto subtractPercent(@PathParam("a") double a, @PathParam("b") double b) {
        ResultDto r = new ResultDto();
        r.setResult(a - (a * b / 100));
        return r;
    }

}