
  package com.arat.webworks.security;
  
  import java.util.List;
  
  import org.springframework.cloud.openfeign.FeignClient; import
  org.springframework.web.bind.annotation.RequestMapping;
  
  import com.arat.webworks.security.beans.RolesBean;
  
  //@FeignClient(name="security-roles-backend")
  //@FeignClient(name="netflix-zuul-api-gateway-server")
  
  @FeignClient(name="roleservice") public interface RolesUIProxy {
  
  @RequestMapping("/allRoles/json") public List<RolesBean> getAllRolesJson(); }
 