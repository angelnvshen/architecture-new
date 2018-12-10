package own.stu.com.consumereurekademo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import own.stu.com.consumereurekademo.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/getUser/{id}")
  public User getUser(@PathVariable Long id) {

    HttpServletRequest request =
        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    System.out.println(request.getServerPort());
    return restTemplate.getForObject("http://provider-eureka-demo/user/getUser/" + id, User.class);
  }
}