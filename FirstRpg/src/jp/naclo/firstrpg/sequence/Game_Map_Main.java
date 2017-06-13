package jp.naclo.firstrpg.sequence;

import jp.naclo.firstrpg.ShareInfo;

public class Game_Map_Main extends TherdLayerSequence{

	public Game_Map_Main(BaseSequence parent) {
		super(parent);
		mChild = null;
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		Game_Map gm = (Game_Map)getParent(CLASS_LAYER_NUM.GAME_MAP);
		gm.myMap.update(sinfo);
		gm.myMap.draw(sinfo);
		return this;
	}

}
