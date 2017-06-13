package jp.naclo.firstrpg.sequence;

public abstract class SecondLayerSequence  extends BaseSequence{
	public SecondLayerSequence(BaseSequence parent) {
		super(parent);
	}

	@Override
	protected int myLayerNumber() {
		return 2;
	}
}
