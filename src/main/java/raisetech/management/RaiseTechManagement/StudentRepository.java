package raisetech.management.RaiseTechManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  /**
   * 学生リストの取得
   *
   * @return 学生リスト
   */
  @Select("SELECT * FROM students")
  List<Student> search();
}
