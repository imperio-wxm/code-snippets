import com.wxmimperio.pojo.*;
import org.junit.Test;
import com.wxmimperio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Iterator;

/**
 * Created by wxmimperio on 2016/7/2.
 */
public class HibernateTest {
    @Test
    public void testHibernate() {
        Session session = null;
        Transaction transaction = null;
        Person person = new Person();
        IdCard idCard = new IdCard();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            idCard.setCode("1234567890");
            person.setName("wxmimperio");
            person.setAge(23);
            person.setIdCard(idCard);

            session.save(person);

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