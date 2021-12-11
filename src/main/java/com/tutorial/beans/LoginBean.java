package com.tutorial.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@NoArgsConstructor
@Component
@ManagedBean
@SessionScoped
public class LoginBean {

  private String username;
  private String password;

  private static final Logger log = LoggerFactory.getLogger(LoginBean.class);

  public String login(){
   log.info("user connected {}", this.getUsername());
    if("imad".equals(this.getUsername())){
      log.info("retrieve data of user connected ");
        return "index";
    }
    else{
      log.error("login not valid in DB");
      return "login";
    }
  }

  public String logout(){
    SecurityContextHolder.clearContext();
    return "login";
  }
}
