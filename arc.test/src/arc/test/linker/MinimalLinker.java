package arc.test.linker;

import java.io.IOException;
import java.net.URL;
import java.util.SortedSet;

import com.google.common.base.Charsets;
import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.linker.AbstractLinker;
import com.google.gwt.core.ext.linker.ArtifactSet;
import com.google.gwt.core.ext.linker.CompilationResult;
import com.google.gwt.core.ext.linker.LinkerOrder;
import com.google.gwt.thirdparty.guava.common.io.Resources;

@LinkerOrder(LinkerOrder.Order.PRIMARY)
public class MinimalLinker extends AbstractLinker {

	@Override
	public String getDescription() {
		return "Minimal linker";
	}

	@Override
	public ArtifactSet link(final TreeLogger logger, final LinkerContext context, final ArtifactSet artifacts)
			throws UnableToCompleteException {
		final URL url = Resources.getResource(MinimalLinker.class, "Minimal.html");
		try {
			final String text = Resources.toString(url, Charsets.UTF_8);
			final SortedSet<CompilationResult> compilations = artifacts.find(CompilationResult.class);
			final ArtifactSet newSet = new ArtifactSet(super.link(logger, context, artifacts));

			for (final CompilationResult r : compilations) {
				final String res =
						"var $stats;\nvar $wnd = window;\nvar $doc = $wnd.document;" + r.getJavaScript()[0] + "$wnd.addEventListener('load', gwtOnLoad, true);";
				//
				newSet.add(emitString(logger, text.replace("$$$MINIMAL_SCRIPT$$$", res), context.getModuleName()+ ".html"));
			}

			return newSet;
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
}
