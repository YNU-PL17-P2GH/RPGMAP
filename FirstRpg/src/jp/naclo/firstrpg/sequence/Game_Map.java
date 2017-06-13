package jp.naclo.firstrpg.sequence;

import jp.naclo.firstrpg.ShareInfo;
import jp.naclo.firstrpg.map.RpgMap;

public class Game_Map extends SecondLayerSequence{
	protected RpgMap myMap;
	public Game_Map(BaseSequence parent) {
		super(parent);
		mChild = new Game_Map_Main(this);
		myMap = new RpgMap("a");
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		BaseSequence next;
		next = mChild.show(sinfo);
		//階層間移動
		if((this.myLayerNumber()+1) != next.myLayerNumber()){
			return next;
		}

		//階層内移動
		if(next != mChild){
			mChild = next;
		}

		return this;
	}

}
