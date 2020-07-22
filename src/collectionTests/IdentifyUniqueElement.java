package collectionTests;



import java.util.ArrayList;



//	Use a temporary ArrayList to help iterated through an array
//	Identify the unique element from that array



public class IdentifyUniqueElement
{
	public static void main(String[] args)
	{
		int					ar[]	= {4, 5, 5, 5, 4, 6, 6, 9, 4};
		ArrayList<Integer>	al		= new ArrayList<Integer>();

		for(int i = 0; i < ar.length; i++)
		{
			int k = 0;

			if(!al.contains(ar[i]))
			{
				al.add(ar[i]);
				k++;

				for(int j = i + 1; j < ar.length; j++)
				{
					if(ar[i] == ar[j])
					{
						k++;
					}
				}

				// System.out.println(ar[i]);
				// System.out.println(k);
				if(k == 1)
					System.out.println(ar[i] + " is the unique number");
			}
		}
	}
}