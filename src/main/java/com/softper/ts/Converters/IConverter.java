package com.softper.ts.Converters;

public interface IConverter<E, R> {
    E fromResouce(R resource);
    R fromEntity(E entity);
}
