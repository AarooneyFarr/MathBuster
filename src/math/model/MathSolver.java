package math.model;

public abstract class MathSolver 
{
	private String name;

	public MathSolver(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return this.name;
	}
	
	
}
