import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV
{
	public static void main(String[] args) throws Exception
	{
		String splitBy = ",";
		BufferedReader br = new BufferedReader(new FileReader("test.csv"));
		
		while((line = br.readLine()) != null)
		{
			String[] b = line.split(splitBy);
			System.out.println(b[0]);
		}
		br.close();
	}
}