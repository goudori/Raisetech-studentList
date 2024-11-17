package raisetech.management.RaiseTechManagement.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.management.RaiseTechManagement.Controller.converter.StudentConverter;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;
import raisetech.management.RaiseTechManagement.domain.StudentDetail;
import raisetech.management.RaiseTechManagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  /**
   * 全学生を検索する
   *
   * @return 学生リスト
   */
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCourseList();

    return converter.convertStudentDetails(
        students, studentCourses);
  }


  /**
   * 全てのコースを検索する
   *
   * @return 学生が受講しているコースリスト
   */
  @GetMapping("/studentsCourseList")
  public List<StudentCourse> getStudentCourseList() {
    return service.searchStudentCourseList();
  }

  /**
   * 30歳の学生を検索する
   *
   * @return 30歳の学生リスト
   */
  @GetMapping("/studentList/age30")
  public List<Student> getStudentListByAge() {
    return service.searchStudentListByAge();
  }

  /**
   * Javaコースを検索する
   *
   * @return Javaコースリスト
   */
  @GetMapping("/studentsCourseList/java")
  public List<StudentCourse> getStudentCourseListByJavaCourse() {
    return service.searchStudentCourseListBYJavaCourse();
  }

  /**
   * 学生とコースの関連情報を検索する
   *
   * @return 学生とコースの関連情報リスト
   */
  @GetMapping("/studentCourseRelations")
  public List<StudentCourse> getStudentCourseRelations() {
    return service.searchStudentCourseRelation();
  }


  /**
   * 学生のremarkとdeletedを検索する
   *
   * @return 学生のremarkとdeletedのリスト
   */
  @GetMapping("/studentRemarkDeletedList")
  public List<Student> getStudentRemarkDeletedList() {
    return service.searchStudentList();
  }
}
