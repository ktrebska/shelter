package pl.edu.java.wszib.shelter.database.impl.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.java.wszib.shelter.database.IDogDAO;
import pl.edu.java.wszib.shelter.model.Dog;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class DogDAOImpl implements IDogDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Dog> getDogs() {
        Session session = this.sessionFactory.openSession();
        Query<Dog> query = session.createQuery("FROM pl.edu.java.wszib.shelter.model.Dog");
        List<Dog> result = query.getResultList();
        session.close();
        return result;
    }

    @Override
    public Dog getDogById(int dogId) {
        Session session = this.sessionFactory.openSession();
        Query<Dog> query = session.createQuery("FROM pl.edu.java.wszib.shelter.model.Dog WHERE id = :id");
        query.setParameter("id", dogId);
        try {
            Dog dog = query.getSingleResult();
            session.close();
            return dog;
        } catch (NoResultException e) {
            session.close();
            return null;
        }
    }

    @Override
    public void updateDog(Dog dog) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(dog);
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

}
