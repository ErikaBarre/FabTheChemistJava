package fab.the.chemist.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LambdaSwing {

	public static void main(String[] args) {
		
		JButton monBouton = new JButton("Incrementer");
		
		monBouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				  System.out.println("clic");
			}
		});
		
		
		monBouton.addActionListener(event -> System.out.println("clic"));
		
	}

}
