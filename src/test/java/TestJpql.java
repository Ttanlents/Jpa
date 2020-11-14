import com.yjf.entity.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/11 11:26
 * @Description
 */
public class TestJpql {
 private EntityManager entityManager= Persistence.createEntityManagerFactory("mysqlUnit").createEntityManager();

    //jpql语法：
      //1.自定义的面向对象方式编写sql,语句语法,会根据方言生成对应的sql语句
    //2.不支持select *  ,自动查询所有字段  from 实体类名
    //3.支持占位符查询，?1 ?2 或者  ：变量名方式
    //支持排序 去重
    @Test //查询
    public void jpqa1(){
        String sql="from User";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        List<User> resultList = query.getResultList();
    }

    @Test  //分页查询
    public void jpqa2() {
        String sql = "from User";
        TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List<User> resultList = query.getResultList();
        resultList.forEach(n -> {
            System.out.println(n);
        });
    }

        @Test  //条件查询
        public void jpqa3() {
            String sql = "from User user where user.name like concat('%',?1,'%') ";
           // String sql = "from User user where user.name like concat('%',:name,'%') ";
            TypedQuery<User> query = entityManager.createQuery(sql, User.class);
           query.setParameter(1,"t");
           //query.setParameter("name","t");
            List<User> resultList = query.getResultList();
            resultList.forEach(n -> {
                System.out.println(n);
            });
        }


}
