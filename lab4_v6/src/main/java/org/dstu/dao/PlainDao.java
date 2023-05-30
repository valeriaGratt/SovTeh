package org.dstu.dao;

import org.dstu.domain.Plain;
import org.hibernate.query.Query;

import java.util.List;

public class PlainDao  extends BaseDaoImpl<Plain, Integer> {
    public PlainDao() {
        super(Plain.class);
    }

    public List<Plain> getAllByCompany(String company) {
        Query q = getSession().createQuery("FROM Student WHERE Plain.company = \"" + company + "\"");
        return q.list();
    }
}