package Control.CSCAN;

import java.util.Arrays;

import Control.Reader.Reader;

public class CScan {

	Reader r;
	
	public CScan(int current, int previous,int rawSequence[],Reader r){
		this.r=r;
		int direction=0;
		int cScanSequence[] = null;
		//finding the direction of the arrow..
		if(previous>current){direction=0; };  // going towards zero
		if(previous<current){direction=1;}  // going away from zero
		cScanSequence=addHeadAndTail(rawSequence, r.getCylinders());
		
		//sorting the sequence in order
		Arrays.sort(cScanSequence);
		//sorts it in CScan methods
		CSCAN(cScanSequence,direction,r.getCurrent());
	}
	
	public int[]addHeadAndTail(int [] rawSequence,int tail){
		int arraylist[]= new int[rawSequence.length+2];
		for(int i=0; i<arraylist.length;i++){
			if(i==rawSequence.length)break;
			else arraylist[i]=rawSequence[i];
		}
		arraylist[arraylist.length-1]=0;
		arraylist[arraylist.length-2]=tail;
		rawSequence= new int[arraylist.length];
		for (int i=0; i<arraylist.length;i++){
			rawSequence[i]=arraylist[i];
		}
		return rawSequence;
	}
	
	
	public void CSCAN(int[]rawSequence, int direction,int current){
		int sortedSequence[]=new int[rawSequence.length];
		
		if(direction==0)//going towards zero direction
		{
			//finding where the first point will be from
			int startIndex = 1010;
			for(int i=0;i<rawSequence.length;i++){
				if(current<rawSequence[i]){startIndex=i; break;}
			}
			//sorting into CScan method
			int filledIndex=0;
			for(int i=startIndex-1;i>0;i--){
				sortedSequence[filledIndex]=rawSequence[i];
				filledIndex++;
			}
			for(int i=rawSequence.length-1; i>startIndex-1;i--){
				sortedSequence[filledIndex+1]=rawSequence[i];
				filledIndex++;
			}
		}
		
		if(direction==1)//going away from zero direction
		{
			//finding where the first point will be from
			int startIndex = 1010;
			for(int i=0;i<rawSequence.length;i++){
				if(current<rawSequence[i]){startIndex=i; break;}
				
			}
			
			//sorting into CScan method
			int filledIndex=0;
			for(int i=startIndex;i<rawSequence.length;i++){
				sortedSequence[filledIndex]=rawSequence[i];
				filledIndex++;
			}
			for(int i=0;i<startIndex;i++){
				sortedSequence[filledIndex]=rawSequence[i];
				filledIndex++;
			}
		}
		
		output(sortedSequence);
	}
	
	public void output(int sortedSequence[]){
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
		
		System.out.println("Method\t: CSCAN"+'\n'+"-----------------");
		System.out.println("Order of Access\t: "+sequence);
		System.out.println("Total Distance\t= "+working1.substring(0,working1.length()-1));
		System.out.println("              \t= "+working2.substring(0,working2.length()-2));
		System.out.println("              \t= "+total+'\n');
		
	}
	
}
