package jp.naclo.firstrpg.sequence;

import jp.naclo.firstrpg.ShareInfo;

public class Title extends FirstLayerSequence {

	public Title(BaseSequence parent) {
		super(parent);
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
