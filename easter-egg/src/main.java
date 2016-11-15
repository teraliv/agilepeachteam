/**
 * Created by aterikov on 11/3/16.
 * Changed by Ahana Ghosh
 * Changed by Sean O'Donnell 11/15/16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans="b";	//initlized to non-a and non-null value
		while(ans.compareTo("a")!=0)
		{
			System.out.println("Enter \"a\" for an easter egg.");
		    try 
		    {
		    	ans = br.readLine();
		    } 
		    catch (IOException e) 
		    {
				e.printStackTrace();
		    }
		}
		//replace name# with your name
		System.out.println("Agile Peach Team:\nAhana Ghosh\nSean O'Donnell\nName3\nName4\nName5");
	}

}




