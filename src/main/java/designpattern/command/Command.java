package designpattern.command;


//  命令  接口
public interface Command {

	//ִ 执行动作  操作
	public void execute();
	//撤销动作
	public void undo();
}
