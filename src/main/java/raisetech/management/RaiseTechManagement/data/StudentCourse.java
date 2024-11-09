package raisetech.management.RaiseTechManagement.data;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 学生が受講しているコースの型を取得する
 */
@Data
public class StudentCourse {

  private String student_id;
  private String id;
  private String course_name;
  private LocalDateTime course_start_at;
  private LocalDateTime course_end_at;

}
