package ca.mcgill.mcb.pcingola.snpEffect.testCases;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ca.mcgill.mcb.pcingola.snpEffect.commandLine.SnpEff;
import ca.mcgill.mcb.pcingola.snpEffect.commandLine.SnpEffCmdEff;
import ca.mcgill.mcb.pcingola.snpEffect.testCases.unity.TestCasesBase;
import ca.mcgill.mcb.pcingola.util.Gpr;
import ca.mcgill.mcb.pcingola.vcf.VcfEffect;
import ca.mcgill.mcb.pcingola.vcf.VcfEntry;

/**
 * Test case
 */
public class TestCasesZzz extends TestCasesBase {

	public TestCasesZzz() {
		super();
	}

	/**
	 * Check that RAW alt fields are kept in 'Allele/Genotype'
	 */
	@Test
	public void test_01_VcfRawAlt() {
		Gpr.debug("Test");

		// Create command
		String args[] = { "testHg3775Chr1", "tests/z.vcf" };

		SnpEff cmd = new SnpEff(args);
		SnpEffCmdEff cmdEff = (SnpEffCmdEff) cmd.snpEffCmd();
		cmdEff.setVerbose(verbose);
		cmdEff.setSupressOutput(!verbose);

		// Run command
		List<VcfEntry> list = cmdEff.run(true);

		// Expected results
		Set<String> expected = new HashSet<String>();
		expected.add("");

		// Find AA change for a genotype
		for (VcfEntry vcfEntry : list) {
			if (debug) System.err.println(vcfEntry);
			for (VcfEffect eff : vcfEntry.parseEffects()) {
				System.err.println("\t" + eff + "\n\t\tAllele: " + eff.getAllele());
			}
		}
	}

}
