package com.huang.feature.optional;

import java.util.Optional;

/**
 * 用来防止产生NPE
 * @author huangyejun
 *
 */
public class Optionals
{
    public static void main(String[] args)
    {
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));//为空返回fallback
        
        optional.ifPresent(s -> System.out.println(s.charAt(0)));
    }
}
