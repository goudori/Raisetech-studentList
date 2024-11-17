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
  private String remark; // 備考(追加情報)
  private boolean deleted;// 削除フラグ(削除されているかの確認)


}
