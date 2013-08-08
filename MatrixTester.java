/*
 * Here is a starting point for your Matrix tester. You will have to fill in the rest of "main" with
 * more code to sufficiently test your Matrix class. We will be using our own MatrixTester for grading. 
*/
package assignment1;

public class MatrixTester {
	public static void main(String[] args)
	{			
		Matrix M1 = new Matrix(new int[][]
		                                 {{1, 2, 3},
										  {2, 5, 6}});
		
		Matrix M2 = new Matrix(new int[][]
		                                 {{4, 5},
										  {3, 2},
										  {1, 1}});
		
		// this is the known correct result of multiplying M1 by M2
		Matrix referenceMultiply = new Matrix(new int[][]
		                                                {{13, 12},
														 {29, 26}});
		
		
		
		/* 
		 * Note that none of the tests below will be correct until you have implemented all methods.
		 * This is just one example of a test, you must write more tests and cover all cases.
		 */
		
		// get the matrix computed by your times method
		Matrix computedMultiply = M1.times(M2);
		
		// exercises your toString method
		System.out.println("Computed result for M1 * M2:\n" + computedMultiply); 
		
		// exercises your .equals method, and makes sure that your computed result is the same as the known correct result
		if(!referenceMultiply.equals(computedMultiply)) 
			System.out.println("Should be:\n" + referenceMultiply);
		
		//TODO: fill in more tests that fully exercise all of your methods
		
		
		//toString testing----------------------------------------------------------------
		System.out.println("toString testing...");
		
		//3x4 matrix(length x width)
		Matrix tsTestOne = new Matrix(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}});
		System.out.println("to string test 1: \n" + tsTestOne.toString());
		
		//1x2 matrix
		Matrix tsTestTwo = new Matrix(new int[][]{{1,45}});
		System.out.println("to string test 2: \n" + tsTestTwo.toString());
		
		//3x3 test with large numbers
		Matrix tsTestThree = new Matrix(new int[][]{{134254,234523,23456},{234327849,233454234,2342323},{34224,24224,32423}});
		System.out.println("to string test 3: \n" + tsTestThree.toString());

											
		//7x1 matrix 
		Matrix tsTestFour = new Matrix(new int[][]{{18},{19},{20},{21},{22},{23},{24}});
		System.out.println("to string test 4: \n" + tsTestFour.toString());
		
		//Empty matrix
		Matrix tsFive = new Matrix(new int[0][0]);
		System.out.println("to string test 5: \n" + tsFive.toString());
		
		
		
		
		
		//Equals testing----------------------------------------------------------------
		System.out.println(".equals testing...");
		
		Matrix eqOne = new Matrix(new int[][] {{153, 162},{249, 28}});
	
		//If the same matrix is sent in twice
		System.out.println(eqOne.equals(eqOne));
		
		//Comparing 2x2 and 3x3
		Matrix eqTwo = new Matrix(new int[][] {{2, 1,233},{249, 28,1},{1,2,3}});
		System.out.println(eqOne.equals(eqTwo));
		
		//Comparing empty to 2x2
		System.out.println(tsFive.equals(eqOne));
		
		
		
		
		//Addition testing------------------------------------------------------------
		System.out.println("addition testing...");
		
		//Pretty simple case
		Matrix addOne = new Matrix(new int[][] {{1,2,3},{1,2,3}});
		Matrix addTwo = new Matrix(new int[][] {{1,2,3},{1,2,3}});
		Matrix firstTotal = new Matrix(new int[][] {{2,4,6},{2,4,6}});
		Matrix firstComputed = addOne.plus(addTwo);
		System.out.println("Computed result for these two is:\n" + firstComputed); 
		if(!firstTotal.equals(firstComputed)) 
			System.out.println("Should be:\n" + firstTotal);

		//Dimensions that don't work, should produce error message.
		Matrix addThree = new Matrix(new int[][] {{1,2,4},{123,32,234}});
		Matrix addFour = new Matrix(new int[][] {{1,3,4},{1,3,56},{123,241,422}});
		System.out.println("This should return null and an error message. ");
		Matrix errorOut = addThree.plus(addFour);

		
		//Testing with negative numbers
		Matrix addFive = new Matrix(new int[][] {{-12,2,4},{1,2,3},{4,5,6}});
		Matrix addSix = new Matrix(new int[][] {{12,3,123},{-1,123,412},{1,2,3}});
		Matrix thirdTotal = new Matrix(new int[][] {{0,5,127},{0,125,415},{5,7,9}});
		Matrix thirdComputed = addFive.plus(addSix);
		System.out.println("Computed result for these two is:\n" + thirdComputed); 
		if(!thirdTotal.equals(thirdComputed)) 
			System.out.println("Should be:\n" + thirdTotal);
		
		//Testing with an empty matrix, should error
		Matrix addSeven = new Matrix(new int[0][0]);
		Matrix addEight = new Matrix(new int[][]{{1,2,3},{4,5,6}});
		Matrix errorOutTwo = addSeven.plus(addEight);
	
		
		//Testing two empty matrices, should just be 0
		Matrix addNine = new Matrix(new int[0][0]);
		Matrix addTen = new Matrix(new int[0][0]);
		System.out.println("2 empty arrays...");
		System.out.println(addNine.plus(addTen).toString());
	
		
		
		
		//Multiplication testing-------------------------------
		
		//Basic scenario
		Matrix multOne = new Matrix(new int[][] {{1,2,3},{4,5,6}});
		Matrix multTwo = new Matrix(new int[][] {{2,5},{4,6},{8,9}});
		Matrix firstOut = multOne.times(multTwo);
		Matrix firstAnswer = new Matrix (new int[][]{{34,44},{76,104}});
		System.out.println("multOne * multTwo output is: \n" + firstOut);
		
		if (!firstAnswer.equals(firstOut))
			System.out.println("Answer should have been:\n" + firstAnswer );
		
		
		//Invalid dimensions, should yield an error
		Matrix multThree = new Matrix(new int[][] {{132,435}});
		Matrix multFour = new Matrix(new int[][] {{234,432,1},{2342,5345,345},{1,2,3}});
		System.out.println("Testing incompatible dimensions, should give an error...");
		Matrix secondOut = multThree.times(multFour);
		
		//Large dimensions
		Matrix multFive = new Matrix(new int[][]  {{1,2,3,4},{123,456,789,1},{10,20,30,40},{200,444,555,666},{80,90,10,35}});
		Matrix multSix = new Matrix(new int[][] {{1,2,3,4,5},{23,46,55,1,0},{100,354,400,87,3},{10,9,8,7,5}});
		Matrix thirdOut = multFive.times(multSix);
		Matrix thirdAnswer = new Matrix(new int[][]{{387,1192,1345,295,34},{89521,300537,341057,69598,2987},{3870,11920,13450,2950,340},
				{72572,223288,252348,54191,5995},{3500,8155,9470,1525,605}});
		System.out.println("multFive * multSix output is: \n" + thirdOut);
		
		if (!thirdAnswer.equals(thirdOut))
			System.out.println("Answer should have been: \n" + thirdAnswer);
		
		//Sending an empty array
		Matrix multSeven = new Matrix(new int[0][0]);
		Matrix multEight = new Matrix(new int[][]{{1,2,3},{4,5,6},{9,3,4}});
		System.out.println("Attempting to multiply an empty matrix with a populated matrix...");
		Matrix fourOut = multSeven.times(multEight);
	}
}

