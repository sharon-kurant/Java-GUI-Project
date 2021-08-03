package Model;
import java.io.Serializable;
import java.lang.Math;

public class GeometricMean implements ScoreCalculator ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8596230545326780707L;

	@Override
	public double scoreCalc(LibraryItem item) {
		if (item == null)
			return 0;
		double avg=1.0;
		for (Review rev: item.getReviews()) {
			avg *= rev.getRate();
		}
		return Math.pow(avg, 1/(double)item.getReviews().size());
	}

}
