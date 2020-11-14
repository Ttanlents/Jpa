import com.yjf.entity.User;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author 余俊锋
 * @date 2020/11/11 10:32
 * @Description
 */

public class TestJpa {
    @Test
    public void demo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysqlUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User();
        user.setName("tom");
        user.setId(1);
        //1.new 游离态  新增
        //2.持久态   更新，删除
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }
}
