package jp.naclo.firstrpg.map;

import jp.naclo.firstrpg.ShareInfo;

public class MapBox {
	private static int layerNum = 0;
	private int box_state;
	private int box_mapchipID[];

	public MapBox(int state, int chipID){
		box_state = state;
		box_mapchipID = new int[layerNum];
		//仮
		box_mapchipID[0] = 0;
		box_mapchipID[1] = chipID;
	}

	public int getState() {
		return box_state;
	}

	public void draw(ShareInfo sinfo, int x, int y, MapChip myMapChip) {
		for(int i = 0; i < layerNum; i++){
			myMapChip.drawChip(sinfo, x, y, box_mapchipID[i]);
		}
	}
	
	public static void setLayerNum(int layer){
		layerNum = layer;
	}
}
