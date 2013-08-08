package assignment1;

import junit.framework.TestCase;

public class matrixTestcase extends TestCase 
{
	Matrix eqOne,eqTwo,tsFive,addOne,addTwo,firstTotal,addFive,addSix,secondTotal,addNine,addTen,thirdTotal,multOne,multTwo,multAnswerOne,
	multFive,multSix,multAnswerTwo;

	protected void setUp() throws Exception 
	{
		super.setUp();
		
		eqOne = new Matrix(new int[][] {{153, 162},{249, 28}});
		eqTwo = new Matrix(new int[][] {{2, 1,233},{249, 28,1},{1,2,3}});
		tsFive = new Matrix(new int[0][0]);
		addOne = new Matrix(new int[][] {{1,2,3},{1,2,3}});
		addTwo = new Matrix(new int[][] {{1,2,3},{1,2,3}});
		firstTotal = new Matrix(new int[][] {{2,4,6},{2,4,6}});
		addFive = new Matrix(new int[][] {{-12,2,4},{1,2,3},{4,5,6}});
		addSix = new Matrix(new int[][] {{12,3,123},{-1,123,412},{1,2,3}});
		secondTotal = new Matrix(new int[][] {{0,5,127},{0,125,415},{5,7,9}});
		addNine = new Matrix(new int[0][0]);
		addTen = new Matrix(new int[0][0]);
		multOne = new Matrix(new int[][] {{1,2,3},{4,5,6}});
		multTwo = new Matrix(new int[][] {{2,5},{4,6},{8,9}});
		multAnswerOne = new Matrix (new int[][]{{34,44},{76,104}});
		multFive = new Matrix(new int[][]  {{1,2,3,4},{123,456,789,1},{10,20,30,40},{200,444,555,666},{80,90,10,35}});
		multSix = new Matrix(new int[][] {{1,2,3,4,5},{23,46,55,1,0},{100,354,400,87,3},{10,9,8,7,5}});
		multAnswerTwo = new Matrix(new int[][]{{387,1192,1345,295,34},{89521,300537,341057,69598,2987},{3870,11920,13450,2950,340},
				{72572,223288,252348,54191,5995},{3500,8155,9470,1525,605}});
		
		
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	
	public void testEquals1()
	{
		assertTrue((eqOne.equals(eqOne)));
	}
	public void testEquals2()
	{
		assertFalse(eqOne.equals(eqTwo));
	}
	public void testEquals3()
	{
		assertFalse(tsFive.equals(eqOne));
	}
	public void testAdd1()
	{
		Matrix total = addOne.plus(addTwo);
		assertEquals(firstTotal,total);
	}
	public void testAdd2()
	{
		Matrix total = addFive.plus(addSix);
		assertEquals(secondTotal,total);
	}
	/*
	 * This one fails but the message doesn't really make sense to me...
	 * 	junit.framework.AssertionFailedError: expected:<> but was:<>
	 * Its two empty arrays which seems to be what it reads, but it is saying that it is an error.
	 * I'll come in and ask about it during TA hours, so just leaving this commented out for now...
	 */
	public void testAdd3()
	{
		Matrix total = addNine.plus(addTen);
		assertEquals(addTen, total);
	}
	public void testMult1()
	{
		Matrix total = multOne.times(multTwo);
		assertEquals(multAnswerOne, total);
	}
	public void testMulti2()
	{
		Matrix total = multFive.times(multSix);
		assertEquals(multAnswerTwo,total);
	}
}
