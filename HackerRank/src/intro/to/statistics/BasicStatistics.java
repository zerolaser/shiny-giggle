package intro.to.statistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**************************
 * mean,mode,median and standard deviaton
 * @author vamshi
 *
 */
public class BasicStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double mean=0.0,
			   median=0.0,
			   sd= 0.0;
		
		int mode,
			count =0,
				element,
				index=0,maxCount=0;
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		//int[] arr = new int[n];
		List<Integer> arr = new ArrayList<Integer>();
 		for(int i=0; i<n; i++)
		{
			arr.add(input.nextInt());
			//mean
			mean+= arr.get(i);
		}
		mean= mean /n;
		mean = new BigDecimal(mean).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(mean);
		Collections.sort(arr);
		//median 
		if(n%2!=0)
		{
			median = Double.valueOf(arr.get((n-1)/2));
		}
		else
		{
			median = ((arr.get((n/2)-1) + arr.get(n/2)))/2.0;
		}
		System.out.println(median);
		//mode 
		Collections.reverse(arr);
		element = arr.get(0);
		for(int i=1;i <n;i++)
		{
			if(element == arr.get(i))
			{
				count++;
			}
			else
			{
				if(count>=maxCount&&count!=0)
				{
					maxCount = count;
					count =0;
					index = i-1;
				}
				else
				{
					count =0;
					element = arr.get(i);
				}
			}
			
		}
		if(maxCount == 0)
		{
			mode = arr.get(n-1);
		}
		else
		{
			mode = arr.get(index);
		}
		System.out.println(mode);
		//standard Deviation
		for(int i=0; i<n;i++)
		{
			sd+=Math.pow(((double)arr.get(i) - mean),2);
		}
		sd= Math.sqrt(sd/n);
		sd = new BigDecimal(sd).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(sd);
	}

}
