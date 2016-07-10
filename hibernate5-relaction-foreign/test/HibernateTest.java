import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wxmimperio.pojo.*;
import org.junit.Test;
import com.wxmimperio.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    @Test
    public void testone2one() {
        Session session = null;
        Transaction transaction = null;
        Student student = new Student();
        Student student1 = new Student();
        StudentCard studentCard = new StudentCard();
        StudentCard studentCard1 = new StudentCard();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            student.setName("wxmimperio");
            student.setAge(25);
            student.setStudentCard(studentCard);
            studentCard.setCode("1234567890");
            studentCard.setStudent(student);

            student1.setName("test");
            student1.setAge(30);
            student1.setStudentCard(studentCard1);
            studentCard1.setCode("abcdefg");
            studentCard1.setStudent(student1);

            session.save(student);
            session.save(student1);

            //从学生的一端取数据
            student = (Student)session.get(Student.class, 1);
            System.out.println("student_name=" + student.getName() +
                    " stucard=" + student.getStudentCard().getCode());

            //从学生卡的一端取数据
            studentCard = (StudentCard)session.get(StudentCard.class, 2);
            System.out.println("stucard=" + studentCard.getCode() +
                    " student_name=" + studentCard.getStudent().getName());

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