package own.stu.com.consumereurekademo.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

  private long id;
  private String name;
  private int age;
}
