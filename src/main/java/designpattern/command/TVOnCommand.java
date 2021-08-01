package designpattern.command;

public class TVOnCommand implements Command {

	// 组合 TVReceiver
	TVReceiver tv;

	public TVOnCommand(TVReceiver tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		tv.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		tv.off();
	}
}
