package appopublisher;

import java.util.ArrayList;

public interface AppoPublish {
	
	public void appoBooking(ArrayList<String> array, String dId, String pId);
	public void appoList();
	public void editAppo(int id,String [] array,String dId, String pId);

}
