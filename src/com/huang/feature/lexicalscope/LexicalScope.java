package com.huang.feature.lexicalscope;

/**
 * 词法作用域
 * 1、内部定义不会覆盖外部定义，调用比较清晰。
 * 2、不会掩盖外部类成员，包括从Object中继承过来的方法。
 */
public class LexicalScope {
    
    Runnable r1 = () -> { int i = 2; System.out.println("this.i=" + this.i + ",i=" + i); };
    Runnable r2 = () -> { System.out.println(toString()); };
    
    Runnable r3 = new Runnable() {
        
        @Override
        public void run() {
            System.out.println(this); 
        }
    };
    
    Runnable r4 = new Runnable() {
        
        @Override
        public void run() {
            System.out.println(toString());
        }
    };
    
    public String toString() {  return "Hello, world"; }
    
    public int i = 1;
    
    public static void main(String... args) {
      new LexicalScope().r1.run();
      new LexicalScope().r2.run();
      new LexicalScope().r3.run();
      new LexicalScope().r4.run();
    }
}
