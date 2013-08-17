package experiments;

import java.io.IOException;

import mixedmembership.JointTextNetworkModel;
import util.LogRandoms;

/**
 * Run an experiment with a mixture of unigram word models using a collapsed
 * Gibbs sampler.
 */
public class TextMixtureExperiment extends Experiment {

	{
		options.getOption("edge-matrix").setRequired(false);
		options.getOption("num-actors").setRequired(false);
		options.getOption("num-latent-dims").setRequired(false);
		options.getOption("gamma").setRequired(false);
	}

	public TextMixtureExperiment(String[] args) {
		super(args);
	}

	public static void main(String[] args) throws java.io.IOException {
		main(args, null);
	}

	public static JointTextNetworkModel main(String[] args, LogRandoms rng)
			throws IOException {

		Experiment experiment = new TextMixtureExperiment(args);
		JointTextNetworkModel model = experiment.estimateModel(rng);

		return model;
	}

	@Override
	public boolean usingMarginalizedAssignments() {
		return false;
	}

	@Override
	public boolean usingExchangeableJointStructure() {
		return false;
	}

	@Override
	public boolean usingErosheva() {
		return false;
	}

	@Override
	public boolean usingEdgeModel() {
		return false;
	}

	@Override
	public boolean usingBernoulli() {
		return false;
	}

	@Override
	public boolean usingWordModel() {
		return true;
	}

	@Override
	public boolean usingMixtureModel() {
		return true;
	}

	@Override
	public boolean usingAsymmetric() {
		return false;
	}
}
