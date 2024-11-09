package raisetech.management.RaiseTechManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;
import raisetech.management.RaiseTechManagement.repository.StudentRepository;

@SpringBootApplication
@RestController
public class RaiseTechManagementApplication {



  public static void main(String[] args) {
    SpringApplication.run(RaiseTechManagementApplication.class, args);
  }




}
