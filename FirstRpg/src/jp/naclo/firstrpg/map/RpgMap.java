package jp.naclo.firstrpg.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import jp.naclo.firstrpg.ShareInfo;

public class RpgMap {
	private MapBox boxs[][];
	private MapChip myMapChip;
	private MapPlayer myPlayer;
	public RpgMap(String mapName){
		myMapChip = new MapChip(mapName);
		BufferedReader ibr = null;

		try {
			ibr = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResource("media/map/" + mapName + "/map.csv").openStream()));
			String line = ibr.readLine();
			String datas[] = line.split(",", 0);
			boxs = new MapBox[Integer.parseInt(datas[0])][Integer.parseInt(datas[1])];
			//マップファイルに含むべき
			MapBox.setLayerNum(2);
			for(int i = 0; i < boxs.length; i++){
				line = ibr.readLine();
				datas = line.split(",", boxs[i].length);
				for(int j = 0; j < boxs[i].length; j++){
					boxs[i][j] = new MapBox(0, Integer.parseInt(datas[j]));
					//マップファイルに含むべき
					if(j == 0){
						boxs[i][j] = new MapBox(1, 12);
					}
					if(j == 24){
						boxs[i][j] = new MapBox(1, 12);
					}
					if(i == 0){
						boxs[i][j] = new MapBox(1, 12);
					}
					if(i == 24){
						boxs[i][j] = new MapBox(1, 12);
					}
				}
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "エラー");
			System.exit(0);
		}
		myPlayer = new MapPlayer(10,10, "player", 1, this);	//向きもマップデータに含むべき
	}
	
	public void update(ShareInfo sinfo){	//マップ更新
		myPlayer.move(sinfo);
	}
	
	public void draw(ShareInfo sinfo){		//マップ描画
		int x, y;			//右上端座標
		int dx = 0, dy = 0;			//自キャラ位置によるズレ
		x = myPlayer.box_x - 5;
		y = myPlayer.box_y - 5;
		int playerX = 0, playerY = 0;
		//マップの描画座標の計算
		if(myPlayer.point_x <= MAP_CONST.MAP_BOX_SIZE * 5){
			x = 0;
			playerX = -1;
		}else if(myPlayer.point_x >= MAP_CONST.MAP_BOX_SIZE *(boxs[0].length - 6)){
			x = (boxs[0].length - 11);
			playerX = x * MAP_CONST.MAP_BOX_SIZE;
		}else{
			dx = myPlayer.point_x - myPlayer.box_x * MAP_CONST.MAP_BOX_SIZE;
			playerX = myPlayer.point_x;
		}
		if(myPlayer.point_y <= MAP_CONST.MAP_BOX_SIZE * 5){
			y = 0;
			playerY = -1;
		}else if(myPlayer.point_y >= MAP_CONST.MAP_BOX_SIZE *(boxs.length - 6)){
			y = (boxs.length - 11);
			playerY = y * MAP_CONST.MAP_BOX_SIZE;
		}else{
			dy = myPlayer.point_y - myPlayer.box_y * MAP_CONST.MAP_BOX_SIZE;
			playerY = myPlayer.point_y;
		}
		
		//背景描画
		for(int i = -1; i < 12; i++){
			for(int j = -1; j < 12; j++){
				if(i + y < 0 || i + y >= boxs.length  || j + x < 0 || j + x >= boxs[0].length){
					continue;
				}
				boxs[i + y][j + x].draw(sinfo, MAP_CONST.MAP_BOX_SIZE * j - dx, MAP_CONST.MAP_BOX_SIZE * i - dy, myMapChip);
			}
		}
		
		//プレイヤー描画
		myPlayer.draw(sinfo, playerX , playerY);
	}

	public MapBox getBox(int x, int y){
		return boxs[y][x];
	}
}
