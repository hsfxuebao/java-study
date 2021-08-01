package designpattern.command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 使用命令模式完成通过遥控器，对点灯的操作
		
		//创建点灯的对象  接受者
		LightReceiver lightReceiver = new LightReceiver();
		
		//创建点灯的开关命令
		LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
		LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
		
		//遥控器
		RemoteController remoteController = new RemoteController();
		
		//给遥控器设置命令，比如 no = 0 是电灯的开关操作
		remoteController.setCommand(0, lightOnCommand, lightOffCommand);
		
		System.out.println("--------按下灯的开按钮-----------");
		remoteController.onButtonWasPushed(0);
		System.out.println("--------按下灯的关按钮-----------");
		remoteController.offButtonWasPushed(0);
		System.out.println("--------按下灯的撤销按钮-----------");
		remoteController.undoButtonWasPushed();
		
		
		System.out.println("=========遥控器操作电视机==========");
		
		TVReceiver tvReceiver = new TVReceiver();
		
		TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
		TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
		
		//给遥控器设置命令 no = 1 表示电视剧的开关操作
		remoteController.setCommand(1, tvOnCommand, tvOffCommand);
		
		System.out.println("--------按下电视机的开按钮-----------");
		remoteController.onButtonWasPushed(1);
		System.out.println("--------按下电视机的关按钮-----------");
		remoteController.offButtonWasPushed(1);
		System.out.println("--------按下电视机的撤销按钮-----------");
		remoteController.undoButtonWasPushed();

	}

}
