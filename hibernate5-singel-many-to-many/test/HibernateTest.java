import com.wxmimperio.pojo.*;
import com.wxmimperio.pojo.Function;
import org.junit.Test;
import com.wxmimperio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/7/2.
 */
public class HibernateTest {
    @Test
    public void testCreateDB() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            //游离状态
            HibernateUtil.closeSession();
            HibernateUtil.closeSessionFactory();
        }
    }

    @Test
    public void testSave() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            Function f1 = new Function("用户管理", "user_manager", "userAction");
            Function f2 = new Function("角色管理", "role_manager", "roleAction");
            Function f3 = new Function("系统管理", "sys_manager", "sysAction");
            Function f4 = new Function("权限管理", "prev_manager", "prevAction");

            //系统管理员拥有四种管理
            Role role1 = new Role();
            role1.setName("admin");
            role1.getFunctions().add(f1);
            role1.getFunctions().add(f2);
            role1.getFunctions().add(f3);
            role1.getFunctions().add(f4);

            //VIP只有两种管理
            Role role2 = new Role();
            role2.setName("VIP");
            role2.getFunctions().add(f1);
            role2.getFunctions().add(f2);

            session.save(role1);
            session.save(role2);

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