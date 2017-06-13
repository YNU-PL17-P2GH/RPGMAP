package jp.naclo.firstrpg.sequence;

public abstract class TherdLayerSequence   extends BaseSequence{
	public TherdLayerSequence(BaseSequence parent) {
		super(parent);
	}

	@Override
	protected int myLayerNumber() {
		return 3;
	}
}