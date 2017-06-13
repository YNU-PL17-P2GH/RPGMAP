package jp.naclo.firstrpg.map;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import jp.naclo.firstrpg.ShareInfo;

public class MapChip {
	private BufferedImage mapChipImags[];
	private int chipX[];
	private int chipY[];
	public MapChip(String mapName){
		//ファイルからロードに
		BufferedReader ibr = null;
		try {
			ibr = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResource("media/map/" + mapName + "/chip.txt").openStream()));
			String line = ibr.readLine();

			if(line.indexOf("chipData") >= 0){
				int imgNum = Integer.parseInt(line.split(" ", 0)[1]);
				mapChipImags = new BufferedImage[imgNum];
				chipX = new int[imgNum];
				chipY = new int[imgNum];
			}else{	//ファイルエラー
				JOptionPane.showMessageDialog(null, "エラー");
				System.exit(0);
			}
			String x_y[];
			for (int i = 0; i < mapChipImags.length; i++) {
				mapChipImags[i] = ImageIO.read(getClass().getClassLoader().getResource("media/map/" + mapName + "/"+ i + ".png"));
				x_y = ibr.readLine().split(" ", 0);
				chipX[i] = Integer.parseInt(x_y[0]);
				chipY[i] = Integer.parseInt(x_y[1]);
			}
			ibr.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "エラー");
			System.exit(0);
		}
	}

	public void drawChip(ShareInfo sinfo, int x, int y, int chipID){
		int i = 0;
		while(chipID >= (chipX[i] * chipY[i])){
			chipID = chipID - (chipX[i] * chipY[i]);
			i++;
		}
		sinfo.g.drawImage(mapChipImags[i], x, y, x + MAP_CONST.MAP_BOX_SIZE, y + MAP_CONST.MAP_BOX_SIZE,
				(chipID % chipX[i]) * MAP_CONST.MAP_CHIP_SIZE, (chipID / chipX[i]) * MAP_CONST.MAP_CHIP_SIZE, (chipID % chipX[i] + 1) * MAP_CONST.MAP_CHIP_SIZE, (chipID / chipX[i] + 1) * MAP_CONST.MAP_CHIP_SIZE, null);
	}

}
