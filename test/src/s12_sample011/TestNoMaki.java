package s12_sample011;

public class TestNoMaki {
    public static void main(String[] args) {
    	// 出来杉君をつくる
        Hidetoshi hidetoshi = new Hidetoshi();

        // のび太君をつくる
        Nobita nobita = new Nobita();
        Doraemon doraemon = new Doraemon();
        //Friend firend = new Draemon();
        nobita.setFriend(doraemon);

        //-----------------------
        // ママ通常時
        //-----------------------
        Shizuka shizuka = new Shizuka();
        nobita.setFriend(shizuka);
        System.out.println("");
        System.out.println("===================================");
        System.out.println("ママ、テストがあったことを知る。");
        System.out.println("===================================");
        System.out.println("昨日、テストがあったそうね。");

        System.out.println("\n出木杉君は何点だったの？");
        System.out.println( hidetoshi.getAverageScore() );

        System.out.println("\nのび太は何点だったの？");
        System.out.println( nobita.getAverageScore() );

        //-----------------------
        // ママ激怒
        //-----------------------
        System.out.println("");
        System.out.println("===================================");
        System.out.println("ママ、激怒。");
        System.out.println("===================================");
        System.out.println("怪しいわね。。。");

        System.out.println("\n出木杉君は何点だったの？");
        System.out.println( hidetoshi.getAverageScore() );

        System.out.println("\nのび太！嘘おっしゃい！本当は何点だったの！！");
        System.out.println( nobita.getAverageScore() );

        //-----------------------
        // ママ、のび太の将来を考える
        //-----------------------
        System.out.println("");
        System.out.println("===================================");
        System.out.println("ママ、のび太の将来を考える。");
        System.out.println("===================================");
        System.out.println("のび太、ママはのび太のことを心配しているの。");

        System.out.println("\n出木杉君は何点だったの？");
        System.out.println( hidetoshi.getAverageScore() );

        System.out.println("\nのび太は何点だったの。");
        System.out.println( nobita.getAverageScore() );

        //-----------------------
        // ママ、真実を知る
        //-----------------------
        System.out.println("");
        System.out.println("===================================");
        System.out.println("ママ、真実を知る。");
        System.out.println("===================================");
        System.out.println("わかったわ。で、本当は何点だったの。");

        System.out.println("\n出木杉君は何点だったの？");
        System.out.println( hidetoshi.getAverageScore() );

        System.out.println("\nのび太は何点だったの。");
        System.out.println( nobita.getAverageScore() );

    }
}
