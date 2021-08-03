package Model;

import java.io.Serializable;

public class ArithmeticMean implements ScoreCalculator ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5568113033077492751L;

	@Override
	public double scoreCalc(LibraryItem item) {
		if (item == null)
			return 0;
		double avg=0.0;
		for (Review rev: item.getReviews()) {
			avg += rev.getRate();
		}
		//System.out.println("score: "+item.getName()+"   "+avg/item.getReviews().size());
		
		return avg/item.getReviews().size();
	}

}
