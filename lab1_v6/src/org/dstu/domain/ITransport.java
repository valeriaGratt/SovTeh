package org.dstu.domain;

import java.io.Serializable;

public interface ITransport extends Serializable {
    default void print() {
        System.out.println(toString());
    }
}
