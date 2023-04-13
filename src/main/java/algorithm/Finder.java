package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Persona> personas;

	public Finder(List<Persona> p) {
		personas = p;
	}

	public F Find(OPTION OPTION) {
		List<F> tr = new ArrayList<F>();

		for ( int i = 0; i < personas.size() - 1; i++) {
			for ( int j = i + 1; j < personas.size(); j++) {
				F r = new F();
				if ( personas.get(i).getBirthDate().getTime() < personas.get(j).getBirthDate().getTime()) {
					r.P1 = personas.get(i);
					r.P2 = personas.get(j);
				} else {
					r.P1 = personas.get(j);
					r.P2 = personas.get(i);
				}
				r.D = r.P2.getBirthDate().getTime() - r.P1.getBirthDate().getTime();
				tr.add(r);
			}
		}

		if (tr.size() < 1) {
			return new F();
		}

		F answer = tr.get(0);
		for (F result : tr) {
			switch ( OPTION ) {
				case One :
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two :
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
