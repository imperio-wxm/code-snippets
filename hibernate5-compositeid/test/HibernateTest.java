import com.wxmimperio.pojo.Score;
import com.wxmimperio.pojo.ScoreId;
import com.wxmimperio.pojo.Student;
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
        Score score = new Score();
        ScoreId scoreId = new ScoreId();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            //组合主键的对象
            scoreId.setStuId("0a111");
            scoreId.setObjectId("java程序001");
            score.setScoreId(scoreId);
            score.setScore(95.36);

            session.save(score);
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
    public void testBigObj() {
        Session session = null;
        Transaction transaction = null;
        ScoreId scoreId = new ScoreId();
        Student student = new Student();
        try {
            session = HibernateUtil.getSession();
            transaction = HibernateUtil.getTransaction(session);

            student.setName("bigwxmimperio");
            student.setAge(23);
            Blob blob = new SerialBlob("abcdefg".getBytes());
            Clob clob = new SerialClob("1234567".toCharArray());
            student.setImage(blob);
            student.setIntroduce(clob);

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