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

            /**
             * 1.先生成student的两条数据，但是subject的外键是空的
             * 2.生成subject数据
             * 3.更新student的subject外键
             *
             * 如果student的外键设置不能为空，则先保存subject（一的一端）然后保存student（多的一端）
             */
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

            //取数据
            Subject subject1 = (Subject)session.get(Subject.class, 1);
            System.out.println("subject name=" + subject1.getName());
            System.out.println("多的一端数据：");
            Iterator<Student2> iterator = subject1.getStudent2s().iterator();
            while (iterator.hasNext()) {
                Student2 tempStudent = iterator.next();
                System.out.println("name=" + tempStudent.getName() + " age=" + tempStudent.getAge());
            }
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