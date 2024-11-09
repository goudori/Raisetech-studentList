package raisetech.management.RaiseTechManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import raisetech.management.RaiseTechManagement.data.Student;
import raisetech.management.RaiseTechManagement.data.StudentCourse;

/**
 * 受講生情報を扱うリポジトリ
 * <p>
 * 全件検索や単一条件での検索、コース情報の検索が行えるクラスです。
 */
@Mapper
public interface StudentRepository {

  /**
   * 学生リストの取得
   *
   * @return 学生リストの検索
   */
  @Select("SELECT * FROM students")
  List<Student> search();

  /**
   * 学生が受講しているコースリストの検索
   *
   * @return コースリスト
   */
  @Select("SELECT * FROM students_courses")
  @Results({
      @Result(property = "student_id", column = "student_id"),
      @Result(property = "id", column = "id"),
      @Result(property = "course_name", column = "course_name"),
      @Result(property = "course_start_at", column = "course_start_at"),
      @Result(property = "course_end_at", column = "course_end_at")
  })
  List<StudentCourse> searchCourse();
}
