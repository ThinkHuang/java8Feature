package com.huang.feature.function;

/**
 * 函数式接口声明
 * @author huangyejun
 *
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
public interface Converter<F, T>
{
    T convert(F from);
}
