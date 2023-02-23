package Chapter14.IndexMaker;

import java.util.Arrays;
public class testFile{
    public static void main(String[] args){
        System.out.println("\nTesting merge()...");
        System.out.println(Arrays.toString(merge(new String[] {"a","e","f"},new String[]{"b","d","z"}))+" should be [a,b,d,e,f,z]");

    }
    public static String[] merge(String[] list1, String[] list2)
	{
		String[] temp = new String[list1.length + list2.length];
		int oneCount = 0;
		int twoCount = 0;
		while(oneCount < list1.length && twoCount < list2.length)
		{
			if(list1[oneCount].compareTo(list2[twoCount]) < 0)
			{
				temp[oneCount + twoCount] = list1[oneCount];
				oneCount++;
			}
			else
			{
				temp[oneCount + twoCount] = list2[twoCount];
				twoCount++;
			}
		}
		//Determine which still has more then copy the leftovers into temp
		if(oneCount < list1.length)
		{
			for(int i = oneCount; i < list1.length; i++)
			{
				temp[i + twoCount] = list1[i];
			}
		}
		else if(twoCount < list2.length)
		{
			for(int i = twoCount; i < list2.length; i++)
			{
				temp[i + oneCount] = list2[i];
			}
		}
		return temp;		
	}

    
}