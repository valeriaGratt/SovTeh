package org.dstu.dao;

import org.dstu.domain.Ship;

public class ShipDao  extends BaseDaoImpl <Ship, Integer> {
    public ShipDao() {
        super(Ship.class);
    }
}
