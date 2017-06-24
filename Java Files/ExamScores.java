public class ExamScores {
	public static void main(String[] args)
	{
		double[] score = { 98.0, 91.0, 84.5, 62.5, 25.0, 0.0 };
		
		double average = 0.0;
		
		System.out.println("\nThe exam scores are:");
		for(int i = 0; i < score.length; i++)
			System.out.printf("%.2f\n", score[i]);
			
		for(int j = 0; j < score.length; j++)
			scoreSum += score [j];
		
		average = scoreSum/ 
		
		System.out.println();
		System.out.printf("The average of the scores is: %.2f\n", average);
	}
}
