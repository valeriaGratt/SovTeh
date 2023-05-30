package org.dstu.dao;

import org.dstu.domain.Port;

public class PortDao extends BaseDaoImpl<Port, Integer> {
    public PortDao() {
        super(Port.class);
    }
}