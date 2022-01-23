package pl.edu.java.wszib.shelter.database.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.java.wszib.shelter.database.IFinishedRequestDAO;
import pl.edu.java.wszib.shelter.model.FinishedRequest;

import java.util.List;

@Repository
public class FinishedRequestDAOImpl implements IFinishedRequestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addFinishedRequest(FinishedRequest finishedRequest) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(finishedRequest);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<FinishedRequest> getFinishedRequestsByUserId(int userId) {
        Session session = this.sessionFactory.openSession();
        Query<FinishedRequest> query = session.createQuery("FROM pl.edu.java.wszib.shelter.model.FinishedRequest WHERE user_id = :userId");
        query.setParameter("userId", userId);
        List<FinishedRequest> result = query.getResultList();
        session.close();
        return result;
    }
}
