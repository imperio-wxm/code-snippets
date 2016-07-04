import com.wxmimperio.pojo.*;
import org.junit.Test;
import com.wxmimperio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;
import java.sql.Blob;
import java.sql.Clob;

/**
 * Created by wxmimperio on 2016/7/2.
 */
public class HibernateTest {
    @Test
    public void testHibernate() {
        Session session = null;
        Transaction transaction = null;

        Grade grade = new Grade();
        Student student = new Student();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);
            session.clear();

            grade.setName("基础");
            session.save(grade);
            student.setName("wxmimperio");
            student.setAge(23);
            student.setGrade(grade);

            session.save(student);
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