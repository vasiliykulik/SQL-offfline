package java.hibernate;


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
        Configuration configuration = new Configuration();
                /*есть методы addFile, setProperty (
                много 1 часть пропертей относится к Connection(user, dialect), настройки кешей, и настройки
                маппингов - то ради чего мы его используем. Открытые XML, или забитые гвоздями Аннотации)*/


    }
}
