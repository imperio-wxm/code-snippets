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

    @Test
    public void testOne2Many() {
        Session session = null;
        Transaction transaction = null;

        Grade grade = new Grade();
        Student2 student2_1 = new Student2();
        Student2 student2_2 = new Student2();
        Subject subject = new Subject();

        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            student2_1.setName("student2_1");
            student2_1.setAge(20);
            student2_2.setName("student2_2");
            student2_2.setAge(19);

            subject.setName("课程001");
            subject.getStudent2s().add(student2_1);
            subject.getStudent2s().add(student2_2);

            session.save(student2_1);
            session.save(student2_2);
            session.save(subject);

            //session.save(student);
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