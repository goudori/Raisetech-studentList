package raisetech.management.RaiseTechManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;
import raisetech.management.RaiseTechManagement.repository.StudentRepository;

/**
 * @Service →このクラスがサービスである
 */
@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public List<StudentCourse> searchStudentCourseList() {
    return repository.searchCourse();
  }

  /**
   * 年齢30歳の学生を検索する
   *
   * @return 30歳の学生リスト
   */
  public List<Student> searchStudentListByAge() {
    return repository.search().stream()
        .filter(student -> student.getAge() == 30)
        .collect(Collectors.toList());
  }

  /**
   * Javaコースを検索する
   * @return Javaコースリスト
   */
  public List<StudentCourse> searchStudentCourseListBYJavaCourse() {
    return repository.searchCourse().stream()
        .filter(course -> "Java_course".equals(course.getCourse_name()))
        .collect(Collectors.toList());
  }

  /**
   * 学生とコースの関連情報を検索する
   *
   * @return 学生とコースの関連情報
   */
  public List<StudentCourse> searchStudentCourseRelation() {
    return repository.searchStudentCourseRelation();
  }

}
