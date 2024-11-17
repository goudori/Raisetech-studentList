package raisetech.management.RaiseTechManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
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
      @Result(property = "id", column = "id"),
      @Result(property = "name", column = "name"),
      @Result(property = "nickname", column = "nickname"),
      @Result(property = "kanaName", column = "kanaName"),
      @Result(property = "email", column = "email"),
      @Result(property = "area", column = "area"),
      @Result(property = "age", column = "age"),
      @Result(property = "sex", column = "sex"),
      @Result(property = "remark", column = "remark"), // remark フィールドの設定
      @Result(property = "deleted", column = "deleted")
  })
  List<StudentCourse> searchCourse();

  /**
   * 学生とコースの関連情報を検索する
   *
   * @return 学生とコースの関連情報
   */
  @Select(
      "SELECT s.id as student_id, s.name as student_name, c.course_name, c.course_start_at, c.course_end_at "
          +
          "FROM students s " +
          "JOIN students_courses c ON s.id = c.student_id")
  @Results({
      @Result(property = "student_id", column = "student_id"),
      @Result(property = "course_name", column = "course_name"),
      @Result(property = "course_start_at", column = "course_start_at"),
      @Result(property = "course_end_at", column = "course_end_at")
  })
  List<StudentCourse> searchStudentCourseRelation();

  /**
   * 学生の remark を更新する
   *
   * @param id 学生の ID
   * @param remark 更新する remark の内容
   */
  @Update("UPDATE students SET remark = #{remark} WHERE id = #{id}")
  void updateRemark(int id, String remark);


  /**
   * 学生を削除する
   * @param id 学生id
   * @param deleted 削除フラグ
   */
  @Update("UPDATE students SET deleted = true WHERE id = #{id}")
  void updateDeleted(int id, boolean deleted);
}


