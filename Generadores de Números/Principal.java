import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Principal extends JFrame implements ActionListener{
	//elementos usados en constraints
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    
    //declaración de elementos GUI
	JPanel Env = new JPanel(new CardLayout());
	
	JPanel main = new JPanel();
	JButton one = new JButton("Cuadrados Medios"); 
	JButton two = new JButton("Congruencial Lineal"); 
	JButton three = new JButton("Congruencial Multiplicativo"); 
	JButton four = new JButton("Congruencial Mixto "); 
	
	JPanel calculo = new JPanel(new GridBagLayout());
	GridBagConstraints con = new GridBagConstraints();
	
	JLabel sem = new JLabel("Ingrese la semilla: ");
	JTextField tsem = new JTextField(1); 
	JLabel rep = new JLabel("Numero de repeticiones: "); 
	JTextField trep = new JTextField(1); 
	JLabel va = new JLabel("Valor de a: ");
	JTextField tva = new JTextField(1); 
	JLabel vm = new JLabel ("Valor de m: "); 
	JTextField tvm= new JTextField(1); 
	JLabel vc = new JLabel("Valor de c: "); 
	JTextField tvc = new JTextField(1);
	JTextArea tRes = new JTextArea("Números generados: ");
	JButton Calcular = new JButton("Calcular");
	JButton atras = new JButton("Atrás");
	int opcion=0;
	
	public Principal(){
		//setup main frame
		super("Proyecto de Métodos Numéricos");
		setSize(600,500); 
		setResizable(true);
		
		//setup main panel 
		main.setLayout(new GridLayout(2,2,5,5));
		main.add(one); 
		main.add(two); 
		main.add(three); 
		main.add(four);  
				
		//setup calculo panel 
		calculo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tRes.setEditable(false);
		if(shouldFill){
			con.fill = GridBagConstraints.HORIZONTAL;
		}
		
		if(shouldWeightX){
			con.weightx=0.5;
		}
		con.fill= GridBagConstraints.HORIZONTAL;
		con.gridx = 0; 
		con.gridy=0;
		calculo.add(sem,con);
		con.fill= GridBagConstraints.HORIZONTAL;
		con.gridx=1; 
		con.gridy =0;
		con.gridwidth=1;
		calculo.add(tsem,con);
		
		con.gridx = 0; 
		con.gridy=1; 
		calculo.add(rep, con);
		con.gridx = 1; 
		con.gridy=1; 
		con.gridwidth=1;
		calculo.add(trep, con);
		
		con.gridx = 0; 
		con.gridy=2; 
		calculo.add(va, con);
		con.gridx = 1; 
		con.gridy=2; 
		con.gridwidth=1;
		calculo.add(tva, con);
		
		con.gridx = 0; 
		con.gridy=3; 
		calculo.add(vm, con);
		con.gridx = 1; 
		con.gridy=3; 
		con.gridwidth=1;
		calculo.add(tvm, con);
		
		con.gridx = 0; 
		con.gridy=4; 
		calculo.add(vc, con);
		con.gridx = 1; 
		con.gridy=4; 
		con.gridwidth=1;
		calculo.add(tvc, con);
		
		con.gridx=0; 
		con.gridy=5; 
		con.gridheight=1; 
		con.gridwidth=1;
		con.ipady= 30; 
		con.insets = new Insets(10,0,0,0);
		calculo.add(Calcular, con);
		
		con.gridx=1; 
		con.gridy=5; 
		con.gridheight=1; 
		con.gridwidth=1; 
		calculo.add(atras, con);
		
		con.gridx= 0; 
		con.gridy= 6; 
		con.weightx=0.0;
		con.ipady=100;
		con.gridwidth=3;
		con.gridheight=20;
		calculo.add(tRes, con);
		
		//añadir a cardlayout para switching
		Env.add(main); 
		Env.add(calculo);
		
		//acciones de botones
		one.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				main.setVisible(false);
				tva.setEditable(false);
				tvc.setEditable(false);
				tvm.setEditable(false);
				calculo.setVisible(true);
				opcion=1;
			}
		});
		two.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				main.setVisible(false);
				tva.setEditable(true);
				tvc.setEditable(true);
				tvm.setEditable(true);
				calculo.setVisible(true);
				opcion =2;
			}
		});
		three.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				main.setVisible(false);
				tva.setEditable(true);
				tvm.setEditable(true);
				tvc.setEditable(false);
				calculo.setVisible(true);
				opcion =3;
			}
		});
		four.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				main.setVisible(false);
				tva.setEditable(true);
				tvc.setEditable(true);
				tvm.setEditable(true);
				calculo.setVisible(true);
				opcion =4;
			}
		});
		atras.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				tva.setText("");
				tvc.setText("");
				tvm.setText("");
				tsem.setText("");
				trep.setText("");
				tRes.setText("");
				calculo.setVisible(false);
				main.setVisible(true);
				opcion =0;
			}
		});
		Calcular.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int repeticiones = 0;
				int num =0;
				int a = 0;
				int m = 0;
				int c = 0;
				String r;
				switch(opcion){
				case 1: //Cuadrados 
						repeticiones = Integer.parseInt(trep.getText());
						num = Integer.parseInt(tsem.getText());
						Cuadrados cu = new Cuadrados();
						r=" ";
						for(int i=0; i<repeticiones; i++){
							num=cu.Calcular(num);
							r= (r+"Random " +(i+1)+ ": "+cu.num()+'\n');
						}
						tRes.setText(r);
						num=0;
						repeticiones=0;
						break;
				case 2: //Congruencial lineal
					repeticiones = Integer.parseInt(trep.getText());
					num = Integer.parseInt(tsem.getText());
					a =Integer.parseInt(tva.getText()); 
					m = Integer.parseInt(tvm.getText()); 
					c = Integer.parseInt(tvc.getText()); 
					r=" ";
					ConLineal cl = new ConLineal();
					for(int n=0; n<repeticiones; n++){
						r=(r+"Random " + (n+1)+": " + cl.Calcular(a, c, m, num)+'\n');
						num= cl.num();
					}
					tRes.setText(r);
					num=0; 
					a=0;
					m=0;
					c=0;
					repeticiones=0;
					break;
				case 3: //Congruencial multiplicativo
					repeticiones = Integer.parseInt(trep.getText());
					num = Integer.parseInt(tsem.getText());
					a =Integer.parseInt(tva.getText());
					m = Integer.parseInt(tvm.getText()); 
					r ="";
					ConMult cm = new ConMult(); 
					for(int s = 0; s<repeticiones; s++){	
						r=(r+"Random " + (s+1) +" : " + cm.Calcular(a, m, num)+'\n');
						num = cm.num();
					}
					tRes.setText(r);
					num=0;
					a=0;
					m=0;
					repeticiones=0;
					break; 
				case 4: //Congruencial mixto 
					repeticiones = Integer.parseInt(trep.getText());
					num = Integer.parseInt(tsem.getText());
					a =Integer.parseInt(tva.getText());
					m = Integer.parseInt(tvm.getText()); 
					c = Integer.parseInt(tvc.getText()); 
					r="";
					ConMix ci= new ConMix(); 
					r= (ci.resHull(m, c, a)+'\n');
					for(int o=0; o<repeticiones; o++){
						r=(r+"Random "+ (o+1) + ": "+ ci.Calcular(a, c, m, num)+'\n');
						num = ci.num();
					}
					tRes.setText(r);
					num=0;
					a=0;
					m=0;
					c=0;
					repeticiones=0;
					break; 
				}
			}
		});	
		add(Env);
		//Listeners
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) { 
		//instancia GUI
		new Principal(); 
	}
	//no usado pero necesario
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}

