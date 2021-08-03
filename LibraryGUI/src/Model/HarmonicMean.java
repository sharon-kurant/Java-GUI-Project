package Model;

import java.io.Serializable;

public class HarmonicMean implements ScoreCalculator ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8304552599282671130L;

	@Override
	public double scoreCalc(LibraryItem item) {
		if (item == null)
			return 0;
		double avg=0.0;
		for (Review rev: item.getReviews()) {
			avg += (double)1/rev.getRate();
		}
		return item.getReviews().size()/avg;
	}

}
