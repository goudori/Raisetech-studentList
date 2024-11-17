package raisetech.management.RaiseTechManagement.Controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;
import raisetech.management.RaiseTechManagement.domain.StudentDetail;

/**
 * 学生情報を学生詳細情報に変換するクラス
 */
@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();

    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();

      // 学生情報のフィールドを学生詳細情報にコピーする
      studentDetail.setStudent(student);
      studentDetail.setRemark(student.getRemark());
      studentDetail.setDeleted(student.isDeleted());

      // 学生に関連コース情報をフィルタリングとして設定
      List<StudentCourse> convertStudentCourse = studentCourses.stream()
          .filter(studentCourse -> student.getId().equals(studentCourse.getStudent_id()))
          .collect(Collectors.toList());
      studentDetail.setStudentCourse(convertStudentCourse);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }
}
