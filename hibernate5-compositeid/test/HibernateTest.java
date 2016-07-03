import com.wxmimperio.pojo.Score;
import com.wxmimperio.pojo.ScoreId;
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
}