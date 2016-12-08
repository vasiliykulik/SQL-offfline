package java.offline4;

import java.offline4.entity.Component;

import java.sql.*;

/**
 * Created by Стрела on 02.12.2016.
 * Создаем обычный проект
 * Папочку lib
 * качаем 9.3-1102.jdbc41
 * Add to lib
 * project Structure - Modules - Dependencies
 * те зделали без Maven (он ведь еще и для сборки используется)
 */

public class PingConnection {
    // 7. Вынесем в static блок(что бы выполнился один раз)
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // 8.       e.printStackTrace(); можно заменить на
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        // 1. Регистрируем драйве 2. Создаем Connection
        // 3. Class.forName - загружает классы в ClassLoader (есть класс и его метаинформация (его методы))
        // 4. PingConnection.class.
        // 5. Class.forName - принудительная загрузка класса в память
        // 6. Driver.
        // 9. создаем Connection 10. checked exceptions(ожидаемые) - обязательно или прокидываются или catch.
        // Все методы JDBC бросает Exception
        // 11. unchecked (неожидаемые) - деление на ноль(Arithmetic), BoundOfException
        // можете сделать через системную переменную -D
        // 12. java.awt.* - лучше не пользуйтесь Wilcard
        // 13. Connection - суровая штука (открытие socket, запрос БД, его надо постоянно держать,
        // у БД есть параметр мах кол во соединений). Большинство БД закрывает Connection когда заканчивается ссесия.
        // Если Connection не закрывать БД - упадет.
        // Обычно подключаетесь к БД - и смотрите активные сессии - например 10 - и если они не уменьшаются - значит
        // ResultSet - в oracle создается временный курсор который возвращает SELECT (например мах 100 Set )
        // c preparedStatment тоже самое - закрывать нужно всегда (try with Resources) - учите себя не забывать
        //
        System.out.println(System.getProperty("username") + ":" + System.getProperty("password"));
        // System.out.println(System.getProperties());
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/offline", System.getProperty("username"), System.getProperty("password"));
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM component");
            // итератор находится на -1 позиции
            // есть такой метод .wasnull
            // PreparedStatment - параметризированный запрос - передаются через ?
            // Параметры JDBC - передаются начиная с 1, а не с 0
            // Объект Connection - зачем его создавать или дергать - если можно создать один на application
            // 80% - он не threadsafe
            // если вы выполняете transaction - вы делаете нужные вещи - и какой то парень запихивает данные - и вы коммитите - то вы не сказать что будет закоммичено
            // Каждый раз когда мы закрываем Connection - он не закрывается физически. Мы просто закрываем сессию и возвращает в пул
            //
            while (resultSet.next()) {
                Component component = new Component();
                component.setId(resultSet.getInt("ID"));
                component.setName(resultSet.getString("NAME"));
                component.setPrice(resultSet.getDouble("PRICE"));
                System.out.println(component);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
