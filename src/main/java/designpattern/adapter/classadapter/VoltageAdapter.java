package designpattern.adapter.classadapter;

//适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {

	@Override
	public int output5V() {
		// TODO Auto-generated method stub
		//
		int srcV = output220V();
		int dstV = srcV / 44 ; //ת�� 5v
		return dstV;
	}

}
