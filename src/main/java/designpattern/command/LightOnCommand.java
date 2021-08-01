package designpattern.command;

public class LightOnCommand implements Command {

	//组合LightReceiver
	
	LightReceiver light;
	
	public LightOnCommand(LightReceiver light) {
		super();
		this.light = light;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//调用接收者的方法
		light.on();
	}

	

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		// 调用接收者的方法
		light.off();
	}

}
