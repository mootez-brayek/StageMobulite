package Pi.Spring.Service;

import java.util.List;

import Pi.Spring.Entity.fetes;

public interface IfetesService {
	public List<fetes> GetAllfetes();
	public fetes Addfetes(fetes f);


}
