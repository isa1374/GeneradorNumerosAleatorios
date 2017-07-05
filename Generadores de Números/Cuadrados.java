import java.util.Stack; 
public class Cuadrados {
	String nume;
	public int Calcular(int num){
		int n= num;
		Stack aux = new Stack();
		String en="";
		char[] arr;
		n = n * n;
		arr= new StringBuilder(Double.toString(n)).reverse().toString().toCharArray();
		//fill stack
		for (int m=0; m<arr.length; m++){
			aux.add(arr[m]);
		}
		//adding zeros
		while(aux.size()<8){
			aux.add('0');
		}
		for(int i=7; i>=0; i--){;
			en = en + aux.elementAt(i).toString();
		}
		nume = "." + en.substring(0,4);
		//convert to num
		return n = Integer.parseInt(en.substring(0,4));
	}
	public String num(){
		return nume;
	}
}
