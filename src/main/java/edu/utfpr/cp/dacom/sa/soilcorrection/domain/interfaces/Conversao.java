package edu.utfpr.cp.dacom.sa.soilcorrection.domain.interfaces;

public interface Conversao<T, R> {

    public R converte(T valor);
}
