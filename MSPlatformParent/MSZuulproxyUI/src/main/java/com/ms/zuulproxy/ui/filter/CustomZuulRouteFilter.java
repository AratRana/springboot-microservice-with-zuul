package com.ms.zuulproxy.ui.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomZuulRouteFilter extends ZuulFilter {
    //private static Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println("RouteFilter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }
}
