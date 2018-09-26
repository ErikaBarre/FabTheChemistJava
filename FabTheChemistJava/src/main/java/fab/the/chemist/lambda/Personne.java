package fab.the.chemist.lambda;

public class Personne {

	
	public Personne() {
		super();
	}
	
	public Personne(String string, String string2) {
		super();
	}

	public Personne(String string, String string2, int i) {
		super();
	}

	public Personne(String string, String string2, int i, int j) {
		super();
	}

	String nom;
	String prenom;
	int age;
	int taille;

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
