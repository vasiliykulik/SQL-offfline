package java.offline4.dao;

import java.offline4.entity.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Стрела on 02.12.2016.
 */
public interface ComponentDao {
    Collection<Component> gtByPrize(BigDecimal price) throws SQLException;
}
