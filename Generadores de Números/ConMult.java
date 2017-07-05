public class ConMult {
	int num;
	public double Calcular(int a, int m, int x){
		double res;
		int sem =x; 
		num = ((a * sem)% m); 
		res = ((double)num / (double)m);
		return res;
	}
	public int num(){
		return num;
	}
}
