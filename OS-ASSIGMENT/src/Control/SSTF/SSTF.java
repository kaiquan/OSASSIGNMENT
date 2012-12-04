package Control.SSTF;

import Control.Reader.Reader;

public class SSTF {
	Reader r;
	public SSTF(int current,int rawSequence[],Reader r){
		this.r=r;
		int n=rawSequence.length;
		int sstf[]=new int[n];
		for(int i=0;i<n;i++)
		{
			sstf[i]=rawSequence[i];
		}
		
		int ii=-1;
		for(int i=0;i<n;i++)
		{
			int minimum=Integer.MAX_VALUE;
			ii=i;
			for(int j=i; j<n;j++)
			{
				int distance=Math.abs(current-sstf[j]);
				if(distance<minimum)
				{
					ii=j;
					minimum=distance;
				}
			}
			int tmp=sstf[i];
			sstf[i]=sstf[ii];
			sstf[ii]=tmp;
			current=sstf[i];
		}
		output(sstf);
	}
	
	
	
	
	public void output(int sortedSequence[] ){
		String sequence="";
		String working1="";
		String working2="";
		int total=0;
		sequence+=r.getCurrent();
		int previous=r.getCurrent();
		
		for(int i=0; i<sortedSequence.length;i++)
		{
			int current=sortedSequence[i];
			sequence+=","+current;
			int d= Math.abs(previous-current);
			
			working1+="|"+previous+"-"+current+"|+";
			working2+=d+" + ";
			total+=d;
			previous=current;
		}
		
		System.out.println("Method\t: SSTF"+'\n'+"-----------------");
		System.out.println("Order of Access\t: "+sequence);
		System.out.println("Total Distance\t= "+working1.substring(0,working1.length()-1));
		System.out.println("              \t= "+working2.substring(0,working2.length()-2));
		System.out.println("              \t= "+total+'\n');
		
		
	}
}
