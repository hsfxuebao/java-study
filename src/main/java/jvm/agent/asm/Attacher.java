package jvm.agent.asm;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class Attacher {

    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException,
            AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("61576");
        vm.loadAgent("/Users/hsfxuebao/IdeaProjects/java-study/out/testagent/testagent.jar");
    }
}