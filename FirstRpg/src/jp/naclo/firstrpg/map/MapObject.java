package jp.naclo.firstrpg.map;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import jp.naclo.firstrpg.ShareInfo;

public class MapObject {
	protected int box_x, box_y;
	protected BufferedImage objImg[];
	protected int animeCount;
	protected RpgMap myMap;
	public MapObject(){};
	public MapObject(int bx, int by, String objName, RpgMap map){
		myMap = map;
		box_x = bx;
		box_y = by;
		animeCount = 0;
		//objNameに従ってロード
		BufferedReader ibr = null;
		try {
			ibr = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResource("media/map/obj/" + objName + "/obj.txt").openStream()));
			String line = ibr.readLine();

			if(line.indexOf("objData") >= 0){
				int imgNum = Integer.parseInt(line.split(" ", 0)[1]);
				objImg = new BufferedImage[imgNum];
			}else{	//ファイルエラー
				JOptionPane.showMessageDialog(null, "エラー");
				System.exit(0);
			}
			for (int i = 0; i < objImg.length; i++) {
				objImg[i] = ImageIO.read(getClass().getClassLoader().getResource("media/map/obj/" + objName + "/"+ i + ".png"));
			}
			ibr.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "エラー");
			System.exit(0);
		}

	}

	public void draw(ShareInfo sinfo, int player_x, int player_y){
		int x = box_x * MAP_CONST.MAP_BOX_SIZE - (player_x - 5 * MAP_CONST.MAP_BOX_SIZE);
		int y = box_y * MAP_CONST.MAP_BOX_SIZE - (player_y - 5 * MAP_CONST.MAP_BOX_SIZE);
		sinfo.g.drawImage(objImg[(animeCount / 10) % objImg.length], x, y, null);
		animeCount++;
	}
}
