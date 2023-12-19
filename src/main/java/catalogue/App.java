package catalogue;
import catalogue.CatalogueEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) {
        // Configurare Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Deschide o sesiune
        Session session = sessionFactory.openSession();

        // Începe o tranzacție
        Transaction transaction = session.beginTransaction();

        try {
            // Operații CRUD aici

            // Exemplu: Salvare entitate în baza de date
            CatalogueEntity catalogue = new CatalogueEntity();
            // setează proprietăți...
            session.save(catalogue);

            // Alte operații CRUD aici...

            // Commit tranzacție
            transaction.commit();
        } catch (Exception e) {
            // În caz de erori, anulează tranzacția
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Închide sesiunea
            session.close();
        }
    }
}