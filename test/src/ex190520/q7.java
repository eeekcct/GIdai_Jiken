package ex190520;

import java.util.function.UnaryOperator;
import java.util.Arrays;


public class q7 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
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
	UnaryOperator<String> swapName = (String name) ->{return name.split(" ")[1]+name.split(" ")[0];};
	Arrays.stream(names).map(swapName).forEach(System.out::println);
 }
}
