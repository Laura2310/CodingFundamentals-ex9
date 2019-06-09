public class Student {
    private String nume;
    private String[] materii;
    private int[][] note;

    public Student(String nume, String[] materii, int[][] note) {
        this.nume = nume;
        this.materii = materii;
        this.note = note;  // notele le citim ca un array de array cu notele de la mai multe materii
    }

    int[] calculeazaMediile(){
        int[] medii = new int[materii.length];
        for(int i=0;i<note.length;i++){
            int sum=0;
            for(int j=0;j<note[i].length;j++){
                sum+=note[i][j]; //suma lor
            }
            medii[i]=(int)Math.round((double)sum/note[i].length);
        }
        return medii;
    }

        private boolean esteCorigent(){
        int[] medii=calculeazaMediile();
        for(int i=0;i<medii.length;i++) {
            if (medii[i]<5) return true;
        }
        return false;
    }

    public void mediaAnuala(){
        if(esteCorigent())
            System.out.println("Elevul "+ nume+" este corigent");
        else {
            int[] medii = calculeazaMediile();
            int sum =0;
            for(int medie:medii)
                sum+=medie;
            System.out.println("Media anuala"+ (int)Math.round((double)sum/medii.length));
        }
    }
    public String toString(){
        String output = "Elevul " + nume + " are mediile:\n";
        int[] medii = calculeazaMediile();
        for(int i=0;i<materii.length;i++){
            output+="\t"+materii[i]+" : " +medii[i]+"\n";
        }
        return output;
    }
}
