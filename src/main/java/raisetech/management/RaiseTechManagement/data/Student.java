package raisetech.management.RaiseTechManagement.data;

import lombok.Data;


/**
 * 学生情報のデータ型
 */
@Data
public class Student {


  private String id;
  private String name;
  private String nickname;
  private String kanaName;
  private String email;
  private String area;
  private int age;
  private String sex;


}
