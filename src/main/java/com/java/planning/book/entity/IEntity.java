package com.java.planning.book.entity;

import java.io.Serializable;

public interface IEntity<T> extends Serializable {
    T getId();
}
