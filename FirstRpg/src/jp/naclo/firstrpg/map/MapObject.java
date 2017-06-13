package jp.naclo.firstrpg.map;

import jp.naclo.firstrpg.ShareInfo;

public abstract class MapObject {
	protected int box_x, box_y;
	protected RpgMap myMap;

	public abstract void draw(ShareInfo sinfo, int map_x, int map_y);

	public int getBox_x() {
		return box_x;
	}

	public int getBox_y() {
		return box_y;
	}
}
