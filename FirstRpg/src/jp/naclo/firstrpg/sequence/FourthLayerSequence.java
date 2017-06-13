package jp.naclo.firstrpg.sequence;


public abstract class FourthLayerSequence extends BaseSequence {

	public FourthLayerSequence(BaseSequence parent) {
		super(parent);
	}

	@Override
	protected int myLayerNumber() {
		return 4;
	}

}
