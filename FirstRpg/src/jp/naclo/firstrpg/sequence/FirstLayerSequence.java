package jp.naclo.firstrpg.sequence;

public abstract class FirstLayerSequence extends BaseSequence {

	public FirstLayerSequence(BaseSequence parent) {
		super(parent);
	}

	@Override
	protected int myLayerNumber() {
		return 1;
	}
}
