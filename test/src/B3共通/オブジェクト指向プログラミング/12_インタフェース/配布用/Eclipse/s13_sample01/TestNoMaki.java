package s13_sample01;

public class TestNoMaki {
    public static void main(String[] args) {
        Nobita nobita = new Nobita();

        Doraemon doraemon=new Doraemon();
        Shizuka shizuka=new Shizuka();
        Dorami dorami=new Dorami();
        Teacher teacher= new Teacher();

        nobita.setFriend( doraemon );
        System.out.println( nobita.getAverageScore()+"\n" );

        nobita.setFriend( shizuka );
        System.out.println( nobita.getAverageScore()+"\n" );
        
        nobita.setFriend( dorami );
        System.out.println( nobita.getAverageScore()+"\n" );

        nobita.setFriend( teacher );
        System.out.println( nobita.getAverageScore()+"\n" );
    }
}
