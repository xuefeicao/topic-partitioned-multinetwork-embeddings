package experiments;

import java.io.IOException;

import mixedmembership.JointTextNetworkModel;
import util.LogRandoms;

/**
 * Run an experiment with the asymmetric Bernoulli model formulation presented
 * in Krafft et al. (2012).
 */
public class ConditionalStructureAsymmetricBernoulliExperiment extends
		Experiment {

	{
		options.getOption("num-latent-dims").setRequired(false);
	}

	public ConditionalStructureAsymmetricBernoulliExperiment(String[] args) {
		super(args);
	}

	public static void main(String[] args) throws java.io.IOException {
		main(args, null);
	}

	public static JointTextNetworkModel main(String[] args, LogRandoms rng)
			throws IOException {

		Experiment experiment = new ConditionalStructureAsymmetricBernoulliExperiment(
				args);
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
		return true;
	}

	@Override
	public boolean usingBernoulli() {
		return true;
	}

	@Override
	public boolean usingWordModel() {
		return true;
	}

	@Override
	public boolean usingMixtureModel() {
		return false;
	}

	@Override
	public boolean usingAsymmetric() {
		return true;
	}
}
