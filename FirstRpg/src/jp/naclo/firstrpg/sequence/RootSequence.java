package jp.naclo.firstrpg.sequence;

import jp.naclo.firstrpg.ShareInfo;

public class RootSequence extends BaseSequence {

	public RootSequence(BaseSequence parent) {
		super(parent);
		mChild = new Game(this);
	}

	@Override
	public BaseSequence show(ShareInfo sinfo) {
		BaseSequence next;
		next = mChild.show(sinfo);
		if(next != mChild){
			mChild = next;
		}
		return null;
	}

	@Override
	protected int myLayerNumber() {return 0;}

}
