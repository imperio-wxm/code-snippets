import com.wxmimperio.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by wxmimperio on 2016/7/2.
 */
public class HibernateTest {
    public static void main(String args[]) {
        //1.新建Configuration对象（是一个单例）
        Configuration cfg = new Configuration().configure("/config/hibernate.cfg.xml");

        ServiceRegistry registry = null;
        //是线程安全的，属于进程级别，在集群范围内也可以使用
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            //2.通过Configuration创建SessionFactory对象
            //hibernate3.x这种写法
            //SessionFactory sf = cfg.buildSessionFactory();
            registry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            //3.通过SessionFactory得到Session（理解为对connection对象的包装，里面有对数据库的CRUD操作）
            //Session是线程不安全的，生命周期非常短暂，常常与事务对应（称为一级缓存）
            //Session是 Transaction的一个工厂
            session = sessionFactory.openSession();//相当于jdbc中的connection

            //4.通过Session对象得到Transaction对象
            transaction = session.beginTransaction();//开启事务

            //5.保存数据
            User user = new User();
            user.setUsername("wxmimperio");
            user.setPassword("123456");
            //session.save(user);
            User user1 = (User) session.get(User.class, 1);
            System.out.println(user1.getId());

            //6.提交事务
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            //发生异常，回滚事务
            transaction.rollback();
        } finally {
            //7.关闭Session
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}