package com.ms.zuulproxy.ui.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class CustomZuulPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().containsKey("error.status_code");
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.get("error.exception");

            if (e != null && e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException)e;

                // Remove error code to prevent further error handling in follow up filters
                ctx.remove("error.status_code");

                // Populate context with new response values
                ctx.setResponseBody("Overriding Zuul Exception Body");
                ctx.getResponse().setContentType("application/json");
                ctx.setResponseStatusCode(500); //Can set any error code as excepted
            }
        }
        catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
