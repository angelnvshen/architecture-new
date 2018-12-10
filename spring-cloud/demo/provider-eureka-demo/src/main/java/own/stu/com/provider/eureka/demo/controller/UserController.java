package own.stu.com.provider.eureka.demo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import own.stu.com.provider.eureka.demo.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping(value = "/getUser/{id}")
  public User getUser(@PathVariable Long id) {

    HttpServletRequest request =
        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    System.out.println(request.getServerPort());
    User user = new User();
    user.setId(id);
    user.setName("张三");
    user.setAge(18);
    return user;
  }

  @GetMapping(value = "/getName")
  public String getName() {
    return "张三";
  }
}