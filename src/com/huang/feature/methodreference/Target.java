package com.huang.feature.methodreference;

public class Target
{
    int attr = 0;

    public Target() {}
    
    public Target(int attr)
    {
        this.attr = attr;
    }

    public int compareTo(Target another) {
        return this.attr - another.attr;
    }
 
    public static int compare(Target one, Target another) {
        return one.attr - another.attr;
    }
}
