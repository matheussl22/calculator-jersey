package com.calculator;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

public class CacheController {
    public static Response build(ResultDto resultDto) {
        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(300);
        cacheControl.setNoStore(true);
        cacheControl.setPrivate(true);

        Response.ResponseBuilder builder = Response.ok(resultDto, "application/json");
        builder.cacheControl(cacheControl);

        return builder.build();
    }
}
