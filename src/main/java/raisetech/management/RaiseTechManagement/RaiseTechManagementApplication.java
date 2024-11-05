package raisetech.management.RaiseTechManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RaiseTechManagementApplication {

  @Autowired
  private StudentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(RaiseTechManagementApplication.class, args);
  }

  /**
   *
   * @return 学生リスト
   */
  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return repository.search();
  }


}
