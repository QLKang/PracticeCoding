

public class UglyNumber{

	public int nthUglyNumber(int n){

		int k = 0;
		int m2=0, m3=0, m5=0;
		int i2=1, i3=1, i5=1;
		int min = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		while( k < n ){

			k++;

			m2 = i2*2;
			m3 = i3*3;
			m5 = i5*5;
			min = Math.min(Math.min(m2, m3), m5);			
			if(min == m2){
				i2++;
			}
			if(min == m3){
				i3++;
			}
			if(min == m5){
				i5++;
			}

		}
		
		return min;
	}	

}
