package ex190520;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.Arrays;
import java.io.*;


public class q8 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] names={
				  "クボ リョウガ",
				  "アワヅ チヒロ",
				  "イノウエ トシヒコ",
				  "オオバ マサシ",
				  "オカジマ イヅル",
				  "カサハラ ユウキ",
				  "カンダ ハヅキ",
				  "コンノ シカ",
				  "サトウ カスミ",
				  "スズキ シオリ",
				  "スズキ リク",
				  "ノモト シンゴ",
				  "ミツモト ダイチ",
				  "モンデン タイキ",
				  "モリタ コウヘイ",
				  "アベ ダイスケ",
				  "アマノ ユウキ",
				  "アライ コウキ",
				  "イマムラ コウイチロウ",
				  "オオヤ リョウ",
				  "オビヤ シュウヘイ",
				  "カキザワ タケヒロ",
				  "カナザワ ヒロキ",
				  "カワノ マサキ",
				  "ゴンザレズ ロベルト",
				  "サトウ タイチ",
				  "サワダ ヒカル",
				  "シゲタ タイジュ",
				  "シバタ リュウセイ",
				  "タカノ ハジメ",
				  "タダ チサト",
				  "タテヤマ ハヤト",
				  "トウウ タツロウ",
				  "ナカガワ ケイト",
				  "ナガタ コウヘイ",
				  "ナガタ ユウダイ",
				  "ニイハラ セイヤ",
				  "ハセガワ カズキ",
				  "ハラダ ムネノリ",
				  "フジオカ ユタカ",
				  "マシモ トシチカ",
				  "ミカミ コウヘイ",
				  "ミズカミ リョウスケ",
				  "ミドウ カイト",
				  "メンディオラ エリアス",
				  "ヤマグチ ダイキ",
				  "ヤマサカ ソラ",
				  "ヤマモト ユウタ"};
	Predicate<String> startWithInitial = (String name) ->{return name.startsWith(str);};
	long val = Arrays.stream(names).filter(startWithInitial).count();
	System.out.println("名前が["+str+"]で始まる人は"+val+"人いました。");
	Arrays.stream(names).filter(startWithInitial).forEach(System.out::println);
 }
}
