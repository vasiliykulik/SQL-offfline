package hibernateoffline;


import hibernateoffline.entity.Component;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Стрела on 09.12.2016.
 */
public class HibernateTestConnection {
    /*Hibernate состоит из двух частей:
    * Session как Connection в JDBC
    * SessionFactory как DataSource*/
    public static void main(String[] args) {
        /*SessionFactory как делалось раньше
        * Configuration может передаваться через .xml, .properties, bean (Spring), b руками: */
        /*Configuration configuration = new Configuration().addAnnotatedClass(Component.class)*/ - /*через аннотацию*/
        Configuration configuration = new Configuration().addAnnotatedClass(Component.class)
                /*есть методы addFile, setProperty (
                много 1 часть пропертей относится к Connection(user, dialect), настройки кешей, и настройки
                маппингов - то ради чего мы его используем. Открытые XML, или забитые гвоздями Аннотации)*/
                .configure("hibernate.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
        try (Session session = sessionFactory.openSession()) {
            session.createNativeQuery("select 1 from public.component").list();
            System.out.println(Component.class,);
        }}

        // f можно делать через Service

    }
}
