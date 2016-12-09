package hibernateoffline.dao;

import jdbc.dao.*;
import jdbc.entity.Component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Стрела on 02.12.2016.
 */
public class ComponentDaoImpl implements jdbc.dao.ComponentDao {


    @Override
    public Collection<Component> gtByPrize(BigDecimal price) throws SQLException {
        return null;
    }
}
