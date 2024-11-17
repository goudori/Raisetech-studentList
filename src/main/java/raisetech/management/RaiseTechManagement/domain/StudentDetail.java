package raisetech.management.RaiseTechManagement.domain;

import java.util.List;
import lombok.Data;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;

/**
 * 学生の詳細情報クラス
 */
@Data
public class StudentDetail {

  private Student student;

  private List<StudentCourse> studentCourse;

  private String remark;

  private boolean deleted;

}
