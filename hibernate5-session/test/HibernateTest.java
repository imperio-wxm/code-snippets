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
        User user = new User();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            //构造对象—瞬时状态
            user.setUsername("test1");
            user.setPassword("123456");
            //持久状态—User对象被session管理，并且id有值（oid）缓存可以识别
            session.save(user);
            //在插入之后运行更新操作
            /**
             * 脏数据检查：数据库中的数据和缓存中的数据不一致
             * 在持久状态下，当提交事务，清理缓存，发现session和数据库数据不一致时
             * 将会把session中数据更新到数据库中（通过oid判断数据是否已经存在）
             */
            user.setUsername("test2");
            /**
             * 在保存对象以后再次操作对象，会产生多条SQL语句，效率小较低
             */
            //清除缓存
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            //游离状态
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
        //此时user处于游离状态
        System.out.println("姓名：" + user.getUsername());
        user.setUsername("test3");
    }
}