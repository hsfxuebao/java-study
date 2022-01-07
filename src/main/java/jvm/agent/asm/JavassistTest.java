package jvm.agent.asm;


import java.io.IOException;

import javassist.*;
import jvm.agent.asm.Base;

public class JavassistTest {

    public static void main(String[] args) throws NotFoundException, CannotCompileException,
            IllegalAccessException, InstantiationException, IOException {

        new Base().process();

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("jvm.agent.asm.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/hsfxuebao/Desktop");
        Base h = (Base)c.newInstance();
        h.process();
    }
}