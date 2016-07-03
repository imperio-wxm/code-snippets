import com.wxmimperio.pojo.User;
import com.wxmimperio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by wxmimperio on 2016/7/2.
 */
public class HibernateTest {
    @Test
    public void testHibernate() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            //构造对象—瞬时状态
            User user = new User();
            user.setUsername("test1");
            user.setPassword("123456");
            //持久状态—User对象被session管理，并且id有值（oid）缓存可以识别
            session.save(user);
            //在插入之后运行更新操作
            /**
             * 脏数据检查：数据库中的数据和缓存中的数据不一致
             */
            user.setUsername("test2");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            //游离状态
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }
}