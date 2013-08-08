package assignment1;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		int falseCount = 0;
		
		if ((this.numRows==0) || (m.numRows==0))
			return false;
		
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				if(data[i][j]!= m.data[i][j])
					falseCount++;
		
		
//		if (m.toString().equals(this.toString()))
//			return true;
			if (falseCount > 0)
				return false;
			else
			return true; // placeholder
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String matrixOut = "";
		
		for (int x = 0;x < numRows;x++)
		{
			for (int y = 0; y < numColumns; y++)
				matrixOut+=data[x][y]+" ";
			
			matrixOut+="\n";	
		}
		return matrixOut ; // placeholder
	}
	
	public Matrix times(Matrix m)
	{
		//this is left side m is right side
		if (this.numRows != m.numColumns)
		{
			System.out.println("These are not compatible matrices to multiply.\n");
			return null;
		}
		
		int output[][] = new int[this.numRows][m.numColumns];
		
		for (int x = 0; x < numRows; x++)
			for (int y = 0; y < m.numColumns; y++)
				for (int z = 0; z < numColumns; z++)
					output[x][y]+= data[x][z] * m.data[z][y];
				
	
		return new Matrix(output); 
	}
	
	public Matrix plus(Matrix m)
	{
		int output[][] = new int[numRows][numColumns];
	
	    if((this.numColumns != m.numColumns) || (this.numRows != m.numRows))
		{
			System.out.println("These are not compatible matrices to add.\n");
			return null;
		}
		
		else 
			for(int i=0; i < numRows; i++) 
			{
				for(int j=0; j < numColumns; j++)
					output[i][j]=data[i][j] + m.data[i][j];
		
			}
	    
		return new Matrix(output); 
	}
}
