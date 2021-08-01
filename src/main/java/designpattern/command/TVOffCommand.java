package designpattern.command;

public class TVOffCommand implements Command {

	// 组合TVReceiver

	TVReceiver tv;


	public TVOffCommand(TVReceiver tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		tv.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		tv.on();
	}
}
