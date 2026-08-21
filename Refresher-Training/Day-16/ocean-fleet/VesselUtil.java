import java.util.List;
import java.util.ArrayList;
public class VesselUtil {
	private List<Vessel> vesselList;

	public VesselUtil(List<Vessel> vesselList) {
		super();
		this.vesselList = vesselList;
	}
	public VesselUtil() {
		
	}

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	
	//addperformance
	
	public void addVesselPerformance (Vessel vessel) {
		vesselList.add(vessel);
	}
	
	//retrieve vessel 
	
	public Vessel getVesselById(String vesselId) {
		for(Vessel v : vesselList) {
			if(v.getVesselId().equals(vesselId)) {
				return v;
			}
		}
		
		return null;
	}
	
	//retrieve high performance vessels
	public List<Vessel> getHighPerformanceVessels(){
		List<Vessel> list = new ArrayList<>();
		double max = 0;
		for(Vessel v : vesselList) {
			max = Math.max(max, v.getAverageSpeed());
			
		}
		for(Vessel v : vesselList) {
			if(max == v.getAverageSpeed()) {
				list.add(v);
			}
			
		}
		
		return list;
	}
	
}
