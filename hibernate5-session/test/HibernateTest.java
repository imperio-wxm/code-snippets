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
            //session.save(user);
            //在插入之后运行更新操作
            /**
             * 脏数据检查：数据库中的数据和缓存中的数据不一致
             * 在持久状态下，当提交事务，清理缓存，发现session和数据库数据不一致时
             * 将会把session中数据更新到数据库中（通过oid判断数据是否已经存在）
             */
            //user.setUsername("test2");
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

    @Test
    public void testGet() {
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            /**
             * get后变为持久状态,get会立刻查询该对象
             * 范围从session—》sessionFactory—》数据库
             * get对象如果找不到，是不会抛异常的，会返回一个空对象
             */
            user = (User) session.get(User.class, 1);
            System.out.println("姓名：" + user.getUsername());
            System.out.println("This is get...");
            transaction.commit();

            //clear是清除session缓存中的所有对象
            session.clear();
            //evict是清除指定对象
            session.evict(user);
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }

    @Test
    public void testLoad() {
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            /**
             * load后变为持久状态,get会立刻查询该对象
             * 范围从session—》sessionFactory—》数据库
             * load对象如果找不到，会抛出异常
             * 在3.x中，load不会立即查找对象，只在使用的时候才会查
             * 会产生一个代理对象
             */
            user = (User) session.load(User.class, 1);
            System.out.println("姓名：" + user.getUsername());
            System.out.println("This is load...");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }

    @Test
    public void testDelete() {
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            /**
             * 手动构造一个对象，凭借主键是可以删除该对象的，但是不建议
             * user.setPassword("123456");
             * user.setUsername("test4");
             * session.delete(user);
             */
            //先获取对象，然后删除
            user = (User) session.get(User.class, 1);
            session.delete(user);
            System.out.println("This is delete...");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }

    @Test
    public void testUpdate() {
        Session session = null;
        Transaction transaction = null;
        User user = new User();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            user = (User) session.get(User.class, 1);
            user.setPassword("abcd");
            session.update(user);
            System.out.println("This is update...");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }
}