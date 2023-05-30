import org.dstu.dao.*;
import org.dstu.domain.*;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();

        PortDao portDao = new PortDao();
        Port port = new Port();
        port.setCountry("RUSSIA");
        portDao.save(port);

        PlainDao plainDao = new PlainDao();
        Plain plain = new Plain();
        plain.setName("Fi332");
        plain.setMaxPassengers(23);
        plain.setMaxBags(55);
        plain.setCompany("IntFly");
        plain.setMaxHeight(20000);
        plain.setStewardessNumber(5);
        plain.setPort(port);
        plainDao.save(plain);

        ShipDao shipDao = new ShipDao();
        Ship ship = new Ship();
        ship.setName("Bug");
        ship.setMaxPassengers(500);
        ship.setMaxBags(1200);
        ship.setCaptainName("Ivan");
        ship.setLength(200);
        ship.setMaxSpeed(60);
        shipDao.save(ship);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}