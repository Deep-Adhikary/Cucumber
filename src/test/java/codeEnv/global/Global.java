package codeEnv.global;

import java.util.Stack;

public class Global {
    private static Stack<String> logger=new Stack<String>();
    public static void  push(String details){
        logger.push(details);
    }
    public static void show(){
        System.out.println(logger);
       // logger.forEach(step->System.out.println(step));
    }
}
